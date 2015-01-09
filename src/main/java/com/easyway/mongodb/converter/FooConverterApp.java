/**
 * 
 */
package com.easyway.mongodb.converter;

import java.net.UnknownHostException;

import com.easyway.mongodb.converter.Animail;
import com.easyway.mongodb.converter.Dog;
import com.easyway.mongodb.converter.Foo;
import com.easyway.mongodb.converter.FooConverter;
import com.easyway.mongodb.converter.Pig;
import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * 
 * @Title: TODO
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-4
 * @author
 * @version 1.0
 */
public class FooConverterApp {

    public static void main(String[] args) throws UnknownHostException, MongoException {

	Morphia morphia = new Morphia();
	Mongo mongo = new Mongo("192.168.70.105", 27017);
	DB db = mongo.getDB("morphia_test");
	Datastore ds = morphia.createDatastore(mongo, db.getName());
	AdvancedDatastore ads = (AdvancedDatastore) ds;
	morphia.map(Pig.class).map(Dog.class).map(Animail.class);
	FooConverter fc = new FooConverter();

	// morphia.getMapper().getConverters().addConverter(fc);
	Dog e = new Dog();
	e.foo.put("bar", new Foo("bar", " a bar"));
	e.foo.put("big", new Foo("dog", "a dog"));
	ds.save(e);
	System.out.println(e.foo.get("bar").toString());
	Pig pig = new Pig();
	pig.foo.add(new Foo("a", "b"));
	pig.foo.add(new Foo("b", "c"));
	ds.save(pig);

    }

}