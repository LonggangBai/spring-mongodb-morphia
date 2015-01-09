package com.easyway.spring.mongodb.morphia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.easyway.morphia.mongodb.model.Hotel;
import com.easyway.morphia.mongodb.services.IHotelService;
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
public class HotelApp {
	
	public static void main(String[] args) {
		
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
		IHotelService  hotelSrv=(IHotelService)ctx.getBean("trackService");
		Hotel  hotel=new Hotel();
		hotel.setAddress("Model168");
		hotel.setTrackName("跟踪地址");
		hotelSrv.save(hotel);
		boolean flag=hotelSrv.exists("address", "Model168");
		System.out.println("flag="+flag);
		QueryResults<Hotel> hotelist=hotelSrv.find();
		System.out.println("hotelist="+hotelist);
		
	}

}
