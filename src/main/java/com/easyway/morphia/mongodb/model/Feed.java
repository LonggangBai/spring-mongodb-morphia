/**
 * 
 */
package com.easyway.morphia.mongodb.model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * @author longgangbai
 * 2015-1-9  下午1:58:59
 */
@Entity("feed")
public class Feed {

    @Id
    private ObjectId oid;
    private String feedName;
    private String feedDescription;
    public ObjectId getOid() {
        return oid;
    }
    public void setOid(ObjectId oid) {
        this.oid = oid;
    }
    public String getFeedName() {
        return feedName;
    }
    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }
    public String getFeedDescription() {
        return feedDescription;
    }
    public void setFeedDescription(String feedDescription) {
        this.feedDescription = feedDescription;
    }

}
