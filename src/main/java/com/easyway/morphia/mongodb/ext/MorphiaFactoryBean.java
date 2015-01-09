package com.easyway.morphia.mongodb.ext;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.google.code.morphia.Morphia;
/**
 * 
 * @Title: 通过继承  AbstractFactoryBean<Morphia> 用来创建 Morphia的工厂bean
 * 
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-3
 * @author 
 * @version 1.0
 */
public class MorphiaFactoryBean extends AbstractFactoryBean<Morphia> {

	private String[] mapPackages;
	private String[] mapClasses;
	private boolean ignoreInvalidClasses;

	@Override
	public Class<?> getObjectType() {
		return Morphia.class;
	}

	@Override
	protected Morphia createInstance() throws Exception {
		Morphia m = new Morphia();
		if (mapPackages != null) {
			for (String packageName : mapPackages) {
				m.mapPackage(packageName, ignoreInvalidClasses);
			}
		}
		if (mapClasses != null) {
			for (String entityClass : mapClasses) {
				m.map(Class.forName(entityClass));
			}
		}
		return m;
	}

	public void setMapPackages(String[] mapPackages) {
		this.mapPackages = mapPackages;
	}

	public void setMapClasses(String[] mapClasses) {
		this.mapClasses = mapClasses;
	}

	public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
		this.ignoreInvalidClasses = ignoreInvalidClasses;
	}


}
