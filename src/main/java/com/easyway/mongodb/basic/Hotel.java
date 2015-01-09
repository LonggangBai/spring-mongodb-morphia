/**
 * 
 */
package com.easyway.mongodb.basic;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Transient;

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
@Entity("hotels")
public class Hotel extends BasicEntry {
    private static final long serialVersionUID = 1L;

    public enum Type {
	BUSINESS, LEISURE
    }

    private String name;
    private Date startDate;
    private Date endDate;

    private int stars;
    private boolean takesCreditCards;
    private Type type;
    private Set<String> tags;

    public static Hotel createHotel() {
	return new Hotel();
    }

    @Transient
    private String temp;

    @Embedded
    private Address address;

    @Embedded(concreteClass = Vector.class)
    private List<PhoneNumber> phoneNumbers;

    private Hotel() {
	super();
	tags = new HashSet<String>();
	phoneNumbers = new Vector<PhoneNumber>();
    }

    public Date getEndDate() {
	return endDate;
    }

    public void setEndDate(Date endDate) {
	this.endDate = endDate;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getStars() {
	return stars;
    }

    public void setStars(int stars) {
	this.stars = stars;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public boolean isTakesCreditCards() {
	return takesCreditCards;
    }

    public void setTakesCreditCards(boolean takesCreditCards) {
	this.takesCreditCards = takesCreditCards;
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public Set<String> getTags() {
	return tags;
    }

    public void setTags(Set<String> tags) {
	this.tags = tags;
    }

    public List<PhoneNumber> getPhoneNumbers() {
	return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
	this.phoneNumbers = phoneNumbers;
    }

    public String getTemp() {
	return temp;
    }

    public void setTemp(String temp) {
	this.temp = temp;
    }
}