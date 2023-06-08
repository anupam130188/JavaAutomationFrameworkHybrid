package com.framework.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {
	
	private static List<Map<String,String>> dataList= new ArrayList<>();
	
	@DataProvider(parallel = true)
	public static Object[] getDataFromExcel(Method m)
	{
		String testName = m.getName();
	
		
		  if (dataList.isEmpty()) 
		  { 
			  dataList = ExcelUtils.getData("DATA");
		//	  System.out.println("Data List is "); System.out.println(dataList); 
		  }
		 
		List<Map<String,String>> executionList = new ArrayList<>();
		for (int i =0; i<dataList.size();i++ )
		{
			if(dataList.get(i).get("testname").equalsIgnoreCase(testName)
			
				&& dataList.get(i).get("execute").equalsIgnoreCase("yes"))
				{
					executionList.add(dataList.get(i));
				}
				
			}
			
		
		//System.out.println("dataList "+ dataList);
		//dataList.removeAll(executionList); -> not a goo approch as we are reducing the code optimization as already array traversing using index is fastest way
		//so no need to remove elements to optimize it more. as it is already optimized.
		
		
		return executionList.toArray();
		
	}

}
