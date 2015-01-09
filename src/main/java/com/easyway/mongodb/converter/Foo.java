/**
 * 
 */
package com.easyway.mongodb.converter;

import net.sf.json.JSONObject;
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
public  class Foo {
	private String name;
	private String email;
	
	Foo(){}
	public Foo(String name,String email) {
		this.name = name;
		this.email=email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}