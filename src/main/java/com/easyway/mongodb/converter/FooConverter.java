/**
 * 
 */
package com.easyway.mongodb.converter;

import net.sf.json.JSONObject;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;
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
public  class FooConverter extends TypeConverter implements SimpleValueConverter  {
	
	public boolean done;
	
	public FooConverter() {
		super(Foo.class);
	}
	
	/**
	 * 
	 */
	@Override
	public Object decode(Class targetClass, Object fromDBObject, MappedField mf)
			throws MappingException {
		if(fromDBObject==null){
			return null;
		}
		JSONObject jsonObject=JSONObject.fromObject(fromDBObject);
		return JSONObject.toBean(jsonObject, targetClass);
	}
	
	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		done = true;
		return JSONObject.fromObject(value).toString();
	}
	
	public boolean didConversion() {
		return done;
	}
}