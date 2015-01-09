package com.easyway.morphia.mongodb.dao;

import org.bson.types.ObjectId;

import com.easyway.morphia.mongodb.model.Hotel;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;

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
public class HotelDAOImpl extends BasicDAO<Hotel, ObjectId> implements IHotelDAO
{
	protected HotelDAOImpl(Datastore ds)
	{
		super(ds);	
	}
	
}