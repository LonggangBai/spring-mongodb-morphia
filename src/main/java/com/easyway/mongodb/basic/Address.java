/**
 * 
 */
package com.easyway.mongodb.basic;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;
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
@Embedded
public class Address {

    @Property("address_street")
    private String street;

    @Property
    private String postCode;

    public Address() {
        super();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}