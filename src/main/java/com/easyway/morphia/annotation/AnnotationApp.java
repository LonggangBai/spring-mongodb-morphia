/**
 * 
 */
package com.easyway.morphia.annotation;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.MappedField;
import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * 
 * @Title: 简单的测试类
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author
 * @version 1.0
 */
public class AnnotationApp {
    public static void main(String[] args) {
	try {
	    String dbName = "test";
	    // 创建一个Mongo对象
	    Mongo mongo = new Mongo("192.168.70.105:27017");
	    // 获取Mongo的数据库对象
	    DB db = mongo.getDB(dbName);
	    // 创建一个Morphia对象
	    Morphia morphia = new Morphia();
	    // 创建一个Datastore对象用于操作数据
	    Datastore ds = morphia.createDatastore(mongo, db.getName());
	    AdvancedDatastore ads = (AdvancedDatastore) ds;
	    // 映射字段添加对应的自定义注释的注册
	    MappedField.interestingAnnotations.add(Lowercase.class);
	    // 映射mapper中添加相关的拦截器
	    morphia.getMapper().addInterceptor(new ToLowercaseHelper());
	    // 设置映射的类
	    morphia.map(MorphiaInfo.class);

	    // 保存一个mongo对象
	    MorphiaInfo u = new MorphiaInfo();
	    u.setVersion("Morphia V1.0");
	    u.setMorphiaName("MorphiaName");
	    ds.save(u);

	    // 查找一个mongo对象
	    MorphiaInfo uScott = ds.find(MorphiaInfo.class).disableValidation().filter("morphiaName_lowercase", u.getMorphiaName().toLowerCase())
		    .get();
	    System.out.println("uScott=" + uScott.getMorphiaName());

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}