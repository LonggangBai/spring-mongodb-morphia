/**
 * 
 */
package com.easyway.morphia.mongodb.services;


import org.bson.types.ObjectId;

import com.easyway.morphia.general.services.MongoBaseServiceImpl;
import com.easyway.morphia.mongodb.dao.IHotelDAO;
import com.easyway.morphia.mongodb.model.Hotel;

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
public class HotelServiceImpl extends MongoBaseServiceImpl<Hotel, ObjectId> implements IHotelService
{
	private IHotelDAO hotelDAO;

	public IHotelDAO getHotelDAO() {
		return hotelDAO;
	}

	public void setHotelDAO(IHotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
		super.setBaseDao(hotelDAO);
	}

	
}
