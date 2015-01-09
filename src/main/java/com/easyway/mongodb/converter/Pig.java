/**
 * 
 */
package com.easyway.mongodb.converter;


import java.util.LinkedList;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;

/**
 * 
 * @Title: TODO
 * @Description: 实现TODO
 * @Copyright:Copyright (c) 2011
 * @Company:易程科技股份有限公司
 * @Date:2012-3-4
 * @author 
 * @version 1.0
 */
@Entity(noClassnameStored=false,value="animail")
public class Pig  extends Animail{
	private static final long serialVersionUID = 1L;
	@Embedded
	public List<Foo> foo = new LinkedList<Foo>();
	
}
