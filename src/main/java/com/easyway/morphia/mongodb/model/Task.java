/**
 * 
 */
package com.easyway.morphia.mongodb.model;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * @author longgangbai 2015-1-9 下午1:56:42
 */
@Entity("task")
public class Task {

    @Id
    private ObjectId oid;
    private String taskName;
    private String taskDescription;

    public ObjectId getOid() {
	return oid;
    }

    public void setOid(ObjectId oid) {
	this.oid = oid;
    }

    public String getTaskName() {
	return taskName;
    }

    public void setTaskName(String taskName) {
	this.taskName = taskName;
    }

    public String getTaskDescription() {
	return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
	this.taskDescription = taskDescription;
    }

}
