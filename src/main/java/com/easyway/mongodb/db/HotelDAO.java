/**
 * 
 */
package com.easyway.mongodb.db;


import java.util.List;

import com.easyway.mongodb.basic.Hotel;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.UpdateOperations;
import com.mongodb.Mongo;
/**
 * 数据访问层类的使用
 * @Title: TODO
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author 
 * @version 1.0
 */
public class HotelDAO  extends BasicDAO<Hotel, String> {
	 public HotelDAO(Morphia morphia, Mongo mongo, String dbName) {
		super(mongo, morphia, dbName);
	 }
	/**
	 * 统计四星级以上酒店数量
	 * @return
	 */
	 public long countHotel(){
	    	return count(createQuery().field("stars").greaterThanOrEq(4));
	 }
	 /**
	  * 查询酒店
	  * @return
	  */
	 public List<Hotel> queryHotelPhone(){
		 return createQuery().field("phoneNumbers").sizeEq(1).asList();
	 }
	 
	 
	 /**
	  * 查询酒店
	  * @param hotel
	  */
	 public List<Hotel> queryHotel(Hotel hotel){
		 return find(createQuery().filter("stars", 4).order("address.address_street")).asList();
		 
	 }
	 /**
	  * 修改酒店信息
	  * @param hotel
	  */
	 public void batchUpdateHotel(){
		    UpdateOperations<Hotel> mods = createUpdateOperations().inc("stars", 1);
	        update(createQuery().filter("stars", 4), mods);
	 }

}