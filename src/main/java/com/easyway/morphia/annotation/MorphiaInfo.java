/**
 * 
 */
package com.easyway.morphia.annotation;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
/**
 * 用于存储MorphiaInfo的信息
 * @Title: 
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-2
 * @author 
 * @version 1.0
 */
@Entity
public class MorphiaInfo {
	private @Id String id;
	//自定义注释的使用
	@Lowercase
	private String morphiaName;
	private String version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMorphiaName() {
		return morphiaName;
	}
	public void setMorphiaName(String morphiaName) {
		this.morphiaName = morphiaName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}