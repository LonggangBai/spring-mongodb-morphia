/**
 * 
 */
package com.easyway.morphia.mongodb.model;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Reference;
/**
 * Mongodb 的ORM框架 Morphia 之 使用容器(Using Lists, Sets, and Maps) .
 * 集合的使用：
 *    Morphia 支持容器(List, Set, Map) 和数组(Integer)
 *        Morphia 将使用一下实现(默认)来创建容器：
 *		• java.util.ArrayList for List 
 *		•java.util.HashSet for Set 
 *		•java.util.hashMap for Map                
 *		        如果你想使用其他的实现， 你可以在注解中重写他们 
 *    @Property(concreteClass = java.util.TreeSet.class)  
 *    private Set<String> tags;  
 *  
 *    @Embedded(concreteClass = java.util.TreeMap.class)  
 *     private Map<String,Translation> translations;  
 *  
 *    @Reference(concreteClass = java.util.Vector.class)  
 *     private List<Article> relatedArticles;  
 *     
 *    //是否延时加载相关的关联应用对象
 *    @Property("userCollection")
 *	  @Reference(concreteClass = java.util.Vector.class,lazy=true)
 *	  private List<UserCollection> userCollectionList; //拥有该角色的团队
 * 
 * 角色模型类
 * @Title: 
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-1
 * @author 
 * @version 1.0
 */
@Entity("Role")
public class Role extends BaseEntry {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;   //角色的名称
	private String desc;  //角色的描述
	@Property("acl")
	@Reference(concreteClass = Vector.class)
	private List<ACL> priviligeList;  //角色拥有的权限的引用对象
	
	@Property("userCollection")
	@Reference(concreteClass = java.util.Vector.class,lazy=true)
	private List<UserCollection> userCollectionList; //拥有该角色的团队
	
	@Property("member")
	@Reference(concreteClass =java.util.TreeSet.class,lazy=false)
	private Set<User> userList; //拥有该角色的用户的信息
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<ACL> getPriviligeList() {
		return priviligeList;
	}
	public void setPriviligeList(List<ACL> priviligeList) {
		this.priviligeList = priviligeList;
	}
	public List<UserCollection> getUserCollectionList() {
		return userCollectionList;
	}
	public void setUserCollectionList(List<UserCollection> userCollectionList) {
		this.userCollectionList = userCollectionList;
	}
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
}