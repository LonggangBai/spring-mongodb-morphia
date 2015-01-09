/**
 * 
 */
package com.easyway.mongodb.basic;


import java.util.Date;
import java.util.List;

import com.easyway.mongodb.basic.Hotel.Type;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

/**
 * 
 * @Title: mongo的框架morphia的学习
 * @Description: 
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-2-29
 * @author longgangbai
 * @version 1.0
 */
public class HotelDAO extends BaseDAO<Hotel, String> {

    public HotelDAO() {
    }
    /**
     * 
     */
    public void batchUpdate(int stars){
    	 Query<Hotel> query=createQuery().filter("stars", stars);
    	 UpdateOperations<Hotel> mods = createUpdateOperations().inc("stars", 1);
         update(query, mods);
    }
    /**
     * 条件查询
     * @param hotel
     */
    public List<Hotel> findHotelByCondition(int stars){
    	Query<Hotel> query=createQuery().filter("stars", stars).order("stars");
    	return find(query).asList();
    }
    /**
     * 保存的方法
     * @param hotel
     */
    public void updateHotel(Hotel hotel){
    }
    /**
     * 统计小于 stars<5 的hotel
     * @return
     */
    public Long countHotel(){
    	 Query<Hotel> query=this.createQuery().field("stars").lessThan(5);
    	 return this.count(query);
    }
    /**
     * 删除Hotel
     * @param hotelId
     */
    public void deleteHotelById(String hotelId){
    	this.deleteById(hotelId);
    }
    /**
     * 根据id查询Hotel
     * @param hotelId
     * @return
     */
    public Hotel getHotelById(String hotelId){
    	return this.get(hotelId);
    }
    
    /**
     * 批量删除hotel对象
     */
    public void deleteByQuery() {
    	Query<Hotel> query=createQuery();
    	query.filter("stars in", new Integer[]{3,4});
		this.deleteByQuery(query);
	}
    
    
    
    /**
     * 保存的方法
     * @param hotel
     */
    public void saveHotel(Hotel hotel){
    	super.save(hotel);
    }
    /**
     * 分页的方法
     * @param offset
     * @param limit
     * @param order
     * @return
     */
    public List<Hotel> pageQuery(int offset,int limit,String order){
    	return this.createQuery().limit(limit).offset(offset).order(order).asList();
    }
    
    /**
     * 查询是否存在特定类型的酒店
     * @param type
     * @return
     */
    public boolean queryBusinessHotelType(Type type){
    	return this.exists("type", type);
    }
    
    /**
     * 根据特定字段查询相关的Hotel
     * @param fieldName
     * @param fieldValue
     * @return
     */
    public Hotel findHotel(String fieldName,Object fieldValue){
    	return this.findOne(fieldName, fieldValue);
    }
	
    /**
	 * <p>Create a filter based on the specified condition and value.
	 * </p><p>
	 * <b>Note</b>: Property is in the form of "name op" ("age >").
	 * </p><p>
	 * Valid operators are ["=", "==","!=", "<>", ">", "<", ">=", "<=", "in", "nin", "all", "size", "exists"]
	 * </p>
	 * <p>Examples:</p>
	 * 
	 * <ul>
	 * <li>{@code filter("yearsOfOperation >", 5)}</li>
	 * <li>{@code filter("rooms.maxBeds >=", 2)}</li>
	 * <li>{@code filter("rooms.bathrooms exists", 1)}</li>
	 * <li>{@code filter("stars in", new Long[]{3,4}) //3 and 4 stars (midrange?)}</li>
	 * <li>{@code filter("age >=", age)}</li>
	 * <li>{@code filter("age =", age)}</li>
	 * <li>{@code filter("age", age)} (if no operator, = is assumed)</li>
	 * <li>{@code filter("age !=", age)}</li>
	 * <li>{@code filter("age in", ageList)}</li>
	 * <li>{@code filter("customers.loyaltyYears in", yearsList)}</li>
	 * </ul>
	 * 
	 * <p>You can filter on id properties <strong>if</strong> this query is
	 * restricted to a Class<T>.
	 * 时间重叠规律：
	 *     酒店入住时间的开始时间小于等于查询条件的结束时间，并且酒店入住时间的结束时间大于等于查询条件的开始时间
	 */
    public boolean queryHotelHasPerson(Date startDate,Date endDate,String name){
    	return this.createQuery()
    	       .filter("name=", name)
    	       .filter("startDate >=",endDate)
    	       .filter("endDate <=", startDate)
    	       .countAll()>0;
    }
    
}