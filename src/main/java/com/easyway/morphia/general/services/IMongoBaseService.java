package com.easyway.morphia.general.services;


import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;


/**
 * 
 * @Title: TODO
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-10
 * @author 
 * @version 1.0
 */
public interface IMongoBaseService<T, K>
{
	public long count();
	public long count(Query<T> q);
	public long	count(String key, Object value) ;
 
	public  void	delete(T entity) ;	
	public  void	deleteById(K id);
	public  void	deleteByQuery(Query<T> q) ;

	public  boolean	exists(Query<T> q);
	public 	 boolean	exists(String key, Object value) ;
	public  QueryResults<T>	find() ;
	public  QueryResults<T>	find(Query<T> q) ;

	public  T	 findOne(Query<T> q) ;
	public 	 T	findOne(String key, Object value) ;

	public  Key<T>	save(T entity) ;
	
          public Datastore	getDatastore();
          
          public T	get(K id) ;
          public Query<T>	 createQuery() ;

}