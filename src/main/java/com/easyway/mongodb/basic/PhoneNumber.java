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
public class PhoneNumber {

    public enum Type { PHONE, FAX }

    @Property
    private int countryCode;
    @Property
    private int localExtension;
    @Property
    private Type type;

    public PhoneNumber() {
        this.type = Type.PHONE;
    }

    public PhoneNumber( int countryCode, int localExtension, Type type ) {
        this.countryCode = countryCode;
        this.localExtension = localExtension;
        this.type = type;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getLocalExtension() {
        return localExtension;
    }

    public void setLocalExtension(int localExtension) {
        this.localExtension = localExtension;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhoneNumber other = (PhoneNumber) obj;
        if (this.countryCode != other.countryCode) {
            return false;
        }
        if (this.localExtension != other.localExtension) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.countryCode;
        hash = 43 * hash + this.localExtension;
        hash = 43 * hash + this.type.hashCode();
        return hash;
    }

}