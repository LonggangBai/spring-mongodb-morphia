/**
 * 
 */
package com.easyway.mongodb.basic;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * 针对morphia的封装的DAO层
 * 
 * @Title:
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author
 * @version 1.0
 */
public class BaseDAO<BasicEntry, String> extends BasicDAO<BasicEntry, String> {

    protected static Datastore ds = null;
    protected static AdvancedDatastore ads;
    private static final Properties properties = new Properties();
    /**
     * 静态语句用于加载mongo 相关的配置文件
     */
    static {
	try {
	    properties.load(BaseDAO.class.getResourceAsStream("/mongodb.properties"));
	    initDAO();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public BaseDAO() {
	super(ds);
    }

    /**
     * 用于初始化Mongodb 数据库的数据访问层的方法
     * 
     * @throws UnknownHostException
     * @throws NumberFormatException
     * 
     */
    @SuppressWarnings("deprecation")
    protected static void initDAO() throws NumberFormatException, UnknownHostException {
	ServerAddress sa = new ServerAddress(properties.getProperty("mongo.db.host"), Integer.parseInt(properties.getProperty("mongo.db.port")));
	MongoOptions options = new MongoOptions();
	options.connectionsPerHost = Integer.parseInt(properties.getProperty("mongo.db.connectionsPerHost"));// pool
													     // size(驱动的链接池大小).
													     // /*
													     // mongod
													     // --dbpath
													     // ..\db
													     // --maxConns
													     // 20(并发数)
													     // */
													     // 默认都为10
	Mongo mongo = new Mongo(sa, options);
	DB db = mongo.getDB(properties.getProperty("mongo.db.databaseName"));
	Morphia morphia = new Morphia();
	ds = morphia.createDatastore(mongo, db.getName());
	ads = (AdvancedDatastore) ds;
    }
}
