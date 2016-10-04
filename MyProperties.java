package com.yc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.yc.utils.LogUtils;

public class MyProperties extends Properties{
	
	private static final long serialVersionUID = 573857812600573915L;
	private static MyProperties myproperties;
	private static String propertyFileNme ="db.properties";
	private MyProperties(){
		InputStream iis = MyProperties.class.getClassLoader().getResourceAsStream(propertyFileNme);
		try {
			load(iis);
		} catch (IOException e) {
			LogUtils.logger.error("error to read properties file",e);
			throw new RuntimeException(e);
		}
	}
	public synchronized static MyProperties getInstance(){
		if(myproperties == null){
			myproperties=new MyProperties();
		}
		return myproperties;
	}

}
