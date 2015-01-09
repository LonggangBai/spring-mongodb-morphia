package com.easyway.morphia.mongodb.ext;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.StringUtils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
/**
 * 
 * @Title: 通过扩展AbstractFactoryBean创建  DataStore的FactoryBean类
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-3
 * @author 
 * @version 1.0
 */
public class DataStoreFactoryBean extends AbstractFactoryBean<Datastore> {

	private Morphia morphia;
	private Mongo mongo;
	private String dbName;
	private String user;
	private String password;

	@Override
	public Class<?> getObjectType() {
		return Datastore.class;
	}

	@Override
	protected Datastore createInstance() throws Exception {
		if (StringUtils.hasText(user)) {
			return morphia.createDatastore(mongo, dbName, user, password.toCharArray());
		}
		return morphia.createDatastore(mongo, dbName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		if (mongo == null) {
			throw new IllegalStateException("mongo is not set");
		}
		if (morphia == null) {
			throw new IllegalStateException("morphia is not set");
		}
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
