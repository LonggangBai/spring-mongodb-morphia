/**
 * 
 */
package com.easyway.morphia.mongodb.model;


import java.util.List;
import java.util.Vector;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Reference;
/**
  *@Reference 的用法：
 *      //引用对象   Mongo在同一个数据库引用一个文档(对象)到另一个。
 *当使用引用时有很重要的一点我们必须提及：被引用的对像在被引用之前必须已经保存到了
 *MongoDB数据库中。
 *     //默认情况下，Morphia使用属性名作为在数据库中保存的值。当然这个可以在@Reference注解中指定。
 * 
 * 补充：注解使用的参数。
 *            concreteClass: 指定具体的实体类。
 *            ignoreMissing:  忽略任何不能解决的参考。
 *            lazy：             为参考创建一个代理，这个将在第一次调用时加载(类似Hibernate中的lazy属性)
 *            value:              指定在Mongo中存储的属性名。
 * @Title: 
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-1
 * @author 
 * @version 1.0
 */
@Entity("UserCollection")
public class UserCollection extends BaseEntry {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Property("member")
	@Reference(concreteClass = Vector.class)
	private List<User> memberList;
	private String name;
	private String owner;
	private String isOrganization;
	private String type;
	private String isOrganiztion;
	private String alphabet;
	private String firstAlphabet;
	private String tag;
	private String avatarURLKey;
	@Property("role")
	@Reference(concreteClass = Vector.class)
	private List<Role> roleList;
	private String desc;
	@Property("task")
	@Reference(concreteClass = Vector.class)
	private List<Task> privateTaskList;
	private String organizationVersion;
	private String organizationName;
	private String customerTable;
	public List<User> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<User> memberList) {
		this.memberList = memberList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getIsOrganization() {
		return isOrganization;
	}
	public void setIsOrganization(String isOrganization) {
		this.isOrganization = isOrganization;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIsOrganiztion() {
		return isOrganiztion;
	}
	public void setIsOrganiztion(String isOrganiztion) {
		this.isOrganiztion = isOrganiztion;
	}
	public String getAlphabet() {
		return alphabet;
	}
	public void setAlphabet(String alphabet) {
		this.alphabet = alphabet;
	}
	public String getFirstAlphabet() {
		return firstAlphabet;
	}
	public void setFirstAlphabet(String firstAlphabet) {
		this.firstAlphabet = firstAlphabet;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getAvatarURLKey() {
		return avatarURLKey;
	}
	public void setAvatarURLKey(String avatarURLKey) {
		this.avatarURLKey = avatarURLKey;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Task> getPrivateTaskList() {
		return privateTaskList;
	}
	public void setPrivateTaskList(List<Task> privateTaskList) {
		this.privateTaskList = privateTaskList;
	}
	public String getOrganizationVersion() {
		return organizationVersion;
	}
	public void setOrganizationVersion(String organizationVersion) {
		this.organizationVersion = organizationVersion;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getCustomerTable() {
		return customerTable;
	}
	public void setCustomerTable(String customerTable) {
		this.customerTable = customerTable;
	}
	

}