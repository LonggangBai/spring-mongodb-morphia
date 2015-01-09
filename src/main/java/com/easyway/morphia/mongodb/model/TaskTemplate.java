/**
 * 
 */
package com.easyway.morphia.mongodb.model;

import com.google.code.morphia.annotations.Entity;

/**
 * Mongodb 的ORM框架 Morphia 注解一 —— @Entity . 定义实体 1、@Entity
 * 如果你想通过Morphia把你的对象保存到Mongo中，你首先要做的是使用@Entity注解你的类：
 * 
 * A、名称和构造方法 你可以为你的MongoDB DBConllection设置名称。必须有一个无参的默认构造方法。
 * 注意：你的默认构造方法不一定是public，也可以是protected或private。 B、在文档中的类名和怎样废弃使用类名
 * 在@Entity注解中提供了一个可选的参数用来标识是否在文档中保存类名。 默认会在文档中保存类名。
 * 为什么要使用他哪？保存类名的主要目的是，当你在同一个链接中保存不同的实体对象，但是你想 作为他们的基类或超类来读取。 如：
 * 
 * @Entity("animals") abstract class Animal { String name; }
 * @Entity("animals") Cat extends Animal { ... }
 * @Entity("animals") Dog extends Animal { ... }
 * 
 *                    查询如下： List<Animal> animals =
 *                    ds.createQuery(Animal.class).asList();
 *                    正如你看到的，如果不在文档中保存类名，Morphia将不能正确的识别创建那个类。
 *                    如果你在一个链接中只保存唯一的实体类型并且你还关心你的数据库大小，在你的@Entity注解上加
 *                    上noClassnameStored=true 参数将会是安全的。
 * 
 * @Title:
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-1
 * @author
 * @version 1.0
 */
@Entity("taskTemplate")
public class TaskTemplate extends BaseEntry {
    private static final long serialVersionUID = 1L;
    private String name;
    private Boolean hasHeader;
    private String positions;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getHasHeader() {
	return hasHeader;
    }

    public void setHasHeader(Boolean hasHeader) {
	this.hasHeader = hasHeader;
    }

    public String getPositions() {
	return positions;
    }

    public void setPositions(String positions) {
	this.positions = positions;
    }

}