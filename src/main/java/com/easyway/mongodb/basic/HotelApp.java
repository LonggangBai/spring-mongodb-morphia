/**
 * 
 */
package com.easyway.mongodb.basic;

import java.util.Date;

/**
 * 
 * @Title: TODO
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author
 * @version 1.0
 */
public class HotelApp {
    public static void main(String[] args) {
	HotelDAO hotelDAO = new HotelDAO();

	Hotel borg = Hotel.createHotel();
	borg.setName("Hotel Borg");
	borg.setStars(4);
	borg.setTakesCreditCards(true);
	borg.setStartDate(new Date());
	borg.setType(Hotel.Type.LEISURE);
	Address borgAddr = new Address();
	borgAddr.setStreet("Posthusstraeti 11");
	borgAddr.setPostCode("101");
	borg.setAddress(borgAddr);
	hotelDAO.save(borg);

	long count = hotelDAO.countHotel();
	System.out.println("count=" + count);

    }

}