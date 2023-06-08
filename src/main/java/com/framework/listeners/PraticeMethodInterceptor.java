package com.framework.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class PraticeMethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		//result.add(methods.get(0)); or we can get the list of TCs from an excel file to decide which all to be executed as below
		
		Map <String, String> testcase1= new HashMap<>();
		testcase1.put("name", "test1");
		testcase1.put("count", "2");
		Map <String, String> testcase2= new HashMap<>();
		testcase2.put("name", "test2");
		testcase2.put("count", "2");
		
		List<Map<String, String>> TcList = new ArrayList<>();
		TcList.add(testcase1);
		TcList.add(testcase2);
		
		//Compare and decide which method list to be considered on true false decision
		for (int i=0; i<methods.size();i++ )
		{
			for (int j=0; j<TcList.size();j++ )
			{
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(TcList.get(j).get("name")))
				{
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(TcList.get(j).get("count")));//using this logic we can list out TCs
					//as well as change invocation or description during runtime for the filtered TCs
					result.add(methods.get(i));
				}
			}
		}
		
		return result;
	}

}
