/**
 * 
 */
package com.easyway.morphia.mongodb.model;

import com.google.code.morphia.annotations.Entity;

/**
 * @author longgangbai 2015-1-9 下午1:57:50
 */
@Entity("acl")
public class ACL extends BaseEntry {
    /**
    	 * 
    	 */
    private static final long serialVersionUID = 1L;
    private String name; // 权限的名称
    private String desc; // 权限的描述

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

}
