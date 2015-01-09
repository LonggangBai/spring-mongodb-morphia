/**
 * 
 */
package com.easyway.mongodb.converter;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
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
@Entity(noClassnameStored=false,value="animail")
public class Animail {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

}