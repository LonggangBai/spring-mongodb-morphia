package com.easyway.morphia.general.services;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
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
public class MongoBaseServiceImpl<T, K> implements IMongoBaseService<T, K>
{

	private DAO<T, K>  baseDao;

	public long count()
	{
		return baseDao.count();
	}

	public long count(Query<T> q)
	{
		return baseDao.count(q);
	}

	public long count(String key, Object value)
	{
		return baseDao.count(key, value);
	}

	public void delete(T entity)
	{
		baseDao.delete(entity);
	}

	public void deleteById(K id)
	{
		baseDao.deleteById(id);
	}

	public void deleteByQuery(Query<T> q)
	{
		baseDao.deleteByQuery(q);
	}

	public boolean exists(Query<T> q)
	{
		return baseDao.exists(q);
	}

	public boolean exists(String key, Object value)
	{
		return baseDao.exists(key, value);
	}

	public QueryResults<T> find()
	{
		return baseDao.find();
	}

	public QueryResults<T> find(Query<T> q)
	{
		return baseDao.find(q);
	}

	public T findOne(Query<T> q)
	{
		return (T) baseDao.findOne(q);
	}

	public T findOne(String key, Object value)
	{
		return (T) baseDao.findOne(key, value);
	}

	public Key<T> save(T entity)
	{
		return baseDao.save(entity);
	}

	public DAO getBaseDao()
	{
		return baseDao;
	}

	public void setBaseDao(DAO baseDao)
	{
		this.baseDao = baseDao;
	}

	public Datastore getDatastore()
	{
		return baseDao.getDatastore();
	}

	public T get(K id)
	{
		return (T) baseDao.get(id);
	}

	public Query<T> createQuery()
	{
		return baseDao.createQuery();
	}
}