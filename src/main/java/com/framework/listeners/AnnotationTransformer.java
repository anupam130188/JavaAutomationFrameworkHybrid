package com.framework.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {
//Annotation Transformer is called each time during execution to check test method. Annotation is enabled or disbaled status for a test which can be decided
	//along with other things like DataProvider, Depends on Groups etc.
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		/* One example
		 * if (testMethod.getName().equalsIgnoreCase("test3"))
		 * 
		 * { annotation.setEnabled(false); }
		 */	
		//Another example using Excel
		
		Map <String, Object> testcase1= new HashMap<>();//used Object instead of String to handle boolean data
		testcase1.put("name", "test1");
		testcase1.put("count", "1");
		testcase1.put("enabled", "false");
		Map <String, Object> testcase2= new HashMap<>();
		testcase2.put("name", "test2");
		testcase2.put("count", "1");
		testcase2.put("enabled", "true");
		
		List<Map<String, Object>> TcList = new ArrayList<>();
		TcList.add(testcase1);
		TcList.add(testcase2);
		
		for (int j=0; j<TcList.size();j++ )
		{
			if (testMethod.getName().equalsIgnoreCase(String.valueOf(TcList.get(j).get("name"))))
			{
				if(TcList.get(j).get("enabled").equals(false))
				{
				System.out.println("abc");
						annotation.setEnabled(false);
				}
				else
				{
					//annotation.setInvocationCount(Integer.parseInt((String)TcList.get(j).get("count")));
					System.out.println("bcd");
					annotation.setRetryAnalyzer(RetryAnalyzer.class);
				}
			}
		}
	}}
