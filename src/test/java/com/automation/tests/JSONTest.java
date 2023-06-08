package com.automation.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {
	
	
	@Test(dataProvider="getData")
	public void testJSONData (Map <String, Object> map) {
		for (Map.Entry<String, Object> m: map.entrySet())
		{
			System.out.println(m.getKey() + " : "+ m.getValue());
		}
		
	}
	
	
	@DataProvider
	public Object [] getData() throws StreamReadException, DatabindException, IOException
	{
		HashMap<String, Object> map = new ObjectMapper().readValue(new File(System.getProperty("user.dir")+ "/src/test/resources/jsondata/dummy.json"), 
				new TypeReference<HashMap<String, Object>>() {
				});
		return new Object[] {map};
		
	}

}
