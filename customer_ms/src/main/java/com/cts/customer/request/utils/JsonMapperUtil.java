package com.cts.customer.request.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Assert;

public interface JsonMapperUtil {
	
	public static final String ROOT_PATH = "";
	public static final String FILE_EXTENSION=".json";
	
	public static final String CUSTOMER_REQUEST_PATH = "/customerdata/";
	
	public String getFileURI() ;
		
	public default String getJsonString() {
		try {
			return StreamUtils.copyToString(getClass().getResourceAsStream(getFileURI()), Charset.defaultCharset());
		}catch(IOException e) {
			
		}
		
		return null;
	}
	
	
	public default <T> T  getAsObject(ObjectMapper mapper,Class<T> tClass){
		
		try {
			String jsonString = getJsonString();
			if(!StringUtils.isEmpty(jsonString)) {
				return mapper.readValue(jsonString, tClass);
			}
			
		}catch(IOException e) {
			
		}
		return null;
	}
	
public default <T> List<T>  getAsObjectList(ObjectMapper mapper,Class<T> tClass){
		
		try {
			String jsonString = getJsonString();
			if(!StringUtils.isEmpty(jsonString)) {
				return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, tClass));
			}
			
		}catch(IOException e) {
			
		}
		return null;
	}
	

}
