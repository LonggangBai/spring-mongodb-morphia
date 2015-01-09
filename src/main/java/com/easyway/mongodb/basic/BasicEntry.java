/**
 * 
 */
package com.easyway.mongodb.basic;


import java.io.Serializable;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;
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
public abstract class BasicEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	/** The id for this instance */
	@Id 
	protected String id = new ObjectId().toString();

    public BasicEntry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}