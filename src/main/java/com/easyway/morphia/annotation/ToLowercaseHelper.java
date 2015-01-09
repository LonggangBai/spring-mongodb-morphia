/**
 * 
 */
package com.easyway.morphia.annotation;


import java.util.List;

import com.google.code.morphia.EntityInterceptor;
import com.google.code.morphia.mapping.MappedClass;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.Mapper;
import com.mongodb.DBObject;
/**
 * 使用拦截器机制的使用用于特定的处理
 * 
 * @Title: 
 * @Description: 实现自定义注释的使用
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author 
 * @version 1.0
 */
public class ToLowercaseHelper implements EntityInterceptor {
	
	public void postLoad(Object ent, DBObject dbObj, Mapper mapr) {
	}

	
	public void postPersist(Object ent, DBObject dbObj, Mapper mapr) {}

	/**
	 * 保存的前的拦截
	 */
	public void preSave(Object ent, DBObject dbObj, Mapper mapr) {}

	/**
	 * 加载前的操作
	 */
	public void preLoad(Object ent, DBObject dbObj, Mapper mapr) {}

	/**
	 * 持久化前的处理
	 * (non-Javadoc)
	 * @see com.google.code.morphia.EntityInterceptor#prePersist(java.lang.Object, com.mongodb.DBObject, com.google.code.morphia.mapping.Mapper)
	 */
	public void prePersist(Object ent, DBObject dbObj, Mapper mapr) {
		//获取映射的类
		MappedClass mc = mapr.getMappedClass(ent);
		//获取映射的特定注释的类字段
		List<MappedField> toLowercase = mc.getFieldsAnnotatedWith(Lowercase.class);
		//针对映射特定的注释类的处理
		for (MappedField mf : toLowercase) {
			try {
				Object fieldValue = mf.getFieldValue(ent);
				dbObj.put(mf.getNameToStore() + "_lowercase", fieldValue.toString().toLowerCase());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}