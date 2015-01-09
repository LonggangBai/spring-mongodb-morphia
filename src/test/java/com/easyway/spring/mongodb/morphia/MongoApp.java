/**
 * 
 */
package com.easyway.spring.mongodb.morphia;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * mongo的学习总结
 * 
 * @Title:
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-2-29
 * @author
 * @version 1.0
 */
public class MongoApp {

    private Mongo m;
    private DB db;

    public void init() {

	try {
	    // 创建一个Mongo对象
	    this.m = new Mongo("192.168.70.105",21017);
	    System.out.println(m.debugString());

	    // // select a DB
	    // // The database doesn't have to exist - if it doesn't, MongoDB
	    // will create it for you.
	    // 创建一个Mongo的db对象
	    this.db = m.getDB("test");
	    System.out.println("DB [" + db.getName() + "] Connected");
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	} catch (MongoException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 查询数据库和表的信息
     */
    public void queryDatabaseInfo() {
	System.out.println("mongodb version  " + m.getVersion());
	List<String> dbNameList = this.m.getDatabaseNames();
	for (String dbName : dbNameList) {
	    System.out.println(" " + dbName);
	    DB db = m.getDB(dbName);
	    Set<String> collectionList = db.getCollectionNames();
	    for (String collName : collectionList) {
		System.out.print(collName + "  ");
	    }
	}
    }

    private void createIndex() {
	insertRecords();
	// MongoDB supports indexes, and they are very easy to add on a
	// collection. To create an index, you just specify the field that
	// should be indexed, and specify if you want the index to be ascending
	// (1) or descending (-1). The following creates an ascending index on
	// the "i" field :
	DBCollection dbconn = db.getCollection("things");
	dbconn.createIndex(new BasicDBObject("case", -1)); // create index on
							   // "i",
							   // ascending

	Iterator<DBObject> iter = dbconn.getIndexInfo().iterator();
	while (iter.hasNext()) {
	    DBObject dbObject = (DBObject) iter.next();
	    System.out.println("Index Info:" + dbObject);
	    ;
	}
	removeAll();
    }

    private void insertAndQuery() {
	insertRecords();
	query();
	removeAll();
    }

    private void query() {
	System.out.println("start  query");
	DBCollection dbconn = db.getCollection("things");
	// looks like find by example
	BasicDBObject queryDb = new BasicDBObject();
	queryDb.append("case", 5);
	DBCursor dbc = dbconn.find(queryDb);
	while (dbc.hasNext()) {
	    DBObject dbObject = (DBObject) dbc.next();
	    System.out.println("result case=5:" + dbObject);
	}
	System.out.println("end  query");
	// find in range
	BasicDBObject query = new BasicDBObject();
	query.put("case", new BasicDBObject("$gt", 5)); // e.g. find all where
							// case > 5
	DBCursor cur = dbconn.find(query);
	while (cur.hasNext()) {
	    System.out.println("case >5:" + cur.next());
	}
    }

    private void insertFindOneRemove() {
	insertRecords();
	testFindOneInCollections();
	removeAll();

    }

    private void testFindOneInCollections() {
	System.out.println("Collections Find one:");
	DBCollection dbconn = db.getCollection("things");
	// declare that just one object is needed,null if none
	System.out.println(dbconn.findOne());
	System.out.println("Collections Find one end");
    }

    private void insertFindAllRemove() {
	insertRecords();
	testFindAllInCollections();
	removeAll();

    }

    // 删除所有的对象
    private void removeAll() {
	System.out.println("start remove all");
	DBCollection dbconn = db.getCollection("things");
	DBCursor c = dbconn.find();
	while (c.hasNext()) {
	    dbconn.remove(c.next());
	}
	System.out.println("done");
    }

    /**
     * 添加数据
     */
    public void insertRecords() {
	System.out.println("start insert :");
	DBCollection dbconn = db.getCollection("things");
	for (int i = 0; i < 10L; i++) {
	    // BasicDBObject basic=new BasicDBObject();
	    //
	    // basic.append("time",System.currentTimeMillis());
	    //
	    // basic.append("obj",i);
	    // dbconn.save(basic);
	    BasicDBObject doc = new BasicDBObject();
	    doc.put("case", i);
	    doc.put("name", "MongoDB");
	    doc.put("type", "database");
	    doc.put("count", 1);
	    BasicDBObject info = new BasicDBObject();
	    info.put("x", 203);
	    info.put("y", 102);
	    doc.put("info", info);
	    dbconn.insert(doc);
	}
	System.out.println("Insert End");
    }

    /**
     * 查询所有
     */
    public void testFindAllInCollections() {
	System.out.println("Data in 'things':");
	DBCollection coll = db.getCollection("things");

	DBCursor c = coll.find();
	while (c.hasNext()) {
	    System.out.println(c.next());

	}
    }

    public static void main(String[] args) {
	MongoApp test = new MongoApp();
	test.init();
	test.queryDatabaseInfo();

	test.insertFindAllRemove();
	test.insertFindOneRemove();
	test.insertAndQuery();
	test.createIndex();
    }
}
