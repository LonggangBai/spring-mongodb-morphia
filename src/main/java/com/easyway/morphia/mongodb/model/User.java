/**
 * 
 */
package com.easyway.morphia.mongodb.model;


import java.util.List;
import java.util.Vector;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.annotations.Property;
import com.google.code.morphia.annotations.Reference;
import com.google.code.morphia.utils.IndexDirection;
/**
 * 索引的使用：
 * @Indexed
 *     此注解是为某个字段申请一个索引。 当datastore.ensureIndexes() 方法被调用时 这些索引就会被申请.. 
 *     @Indexed(value=IndexDirection.ASC, name="upc", unique=true, dropDups=true)
 *      private String upcSymbol;
 *    参数说明如下：
         	value: 表名这个索引的方向； IndexDirection.ASC(升序)，IndexDirection.DESC(降序), IndexDirection.BOTH(两者)
                                   默认为 升序；
   			name： 被创建的索引的 名称； mongodb默认创建的索引名的格式为(key1_1/-1_key2_1)
   			unique： 创建一个唯一索引，当创建唯一索引后，当在此字段插入相同的值时将会报错。true:为唯一索引；false：不是唯一索引。
                 	默认为：false
   			dropDups：此参数表明，当为某个字段创建唯一索引时，删除其他相同值的记录。只保留第一条记录。true:删除重复，
                      false:不删除重复（当有重复值时唯一索引创建失败）；默认为false.
         		向MongoDB申请创建索引 Datastore.ensureIndexes()需要被调用。这个方法应该在你已经使用Morphia注册了你的实体类后
   			被调用。他将会异步创建你的所有索引。 这个动作也许会在你每次启动你的应用时都被执行。
     		注意：当在一个存在的系统上，创建已经存在的索引时，将不会花费任何事件(也不会做任何事情)。
			        Morphia m = .....
			        Datastore ds = ....
			      m.map(Product.class);
			      ds.ensureIndexes();  //为被@Indexed注解的所有字段创建索引。
			     你可以在 http://www.mongodb.org/display/DOCS/Indexes 了解更多关于MongoDB索引的信息。
 * 
 * 
 * @Title: 在Mongo数据库中User表的数据结构
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-2-25
 * @author 
 * @version 1.0
 */
@Entity("User")
public class User extends BaseEntry {
	private static final long serialVersionUID = 1L;
	@Property
	private String email;//邮箱
	
	private String address;//地址
	@Property
	@Indexed(value=IndexDirection.ASC, name="idx_user_userCode", unique=true, dropDups=true)
	private String userCode;//用户编码
	
	@Property("myTaskId")
	@Reference(concreteClass = Vector.class)
	private List<Task> privateTaskList; 
	
	private String name;
	private String cardInfo;
	
	@Property
	@Indexed(value=IndexDirection.ASC, name="idx_user_telphone", unique=true, dropDups=true)
	private String telphone;
	
	@Property("role")
	@Reference(concreteClass = Vector.class)
	private List<Role> roleList;
	
	private String firstAlphabet;
	private String langType;
	
	@Property("userCollection")
	@Reference(concreteClass = Vector.class)
	private List<UserCollection> userCollectionList;

	private String avatarURLKey;

	@Property("feeds")
	@Reference(concreteClass = Vector.class)
	private List<Feed> feedList;    //用户相关的动态集合
	
	
	@Property("taskId")
	@Reference(concreteClass = Vector.class)
	private List<Task> publicTaskList; //用户的相关的公开的业务集合
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Task> getPrivateTaskList() {
		return privateTaskList;
	}
	public void setPrivateTaskList(List<Task> privateTaskList) {
		this.privateTaskList = privateTaskList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public String getFirstAlphabet() {
		return firstAlphabet;
	}
	public void setFirstAlphabet(String firstAlphabet) {
		this.firstAlphabet = firstAlphabet;
	}
	public String getLangType() {
		return langType;
	}
	public void setLangType(String langType) {
		this.langType = langType;
	}
	public List<UserCollection> getUserCollectionList() {
		return userCollectionList;
	}
	public void setUserCollectionList(List<UserCollection> userCollectionList) {
		this.userCollectionList = userCollectionList;
	}
	public String getAvatarURLKey() {
		return avatarURLKey;
	}
	public void setAvatarURLKey(String avatarURLKey) {
		this.avatarURLKey = avatarURLKey;
	}
	public List<Feed> getFeedList() {
		return feedList;
	}
	public void setFeedList(List<Feed> feedList) {
		this.feedList = feedList;
	}
	public List<Task> getPublicTaskList() {
		return publicTaskList;
	}
	public void setPublicTaskList(List<Task> publicTaskList) {
		this.publicTaskList = publicTaskList;
	}
}