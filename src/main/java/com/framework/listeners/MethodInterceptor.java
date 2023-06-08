package com.framework.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.framework.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String,String>> list  = ExcelUtils.getData("RUNMANAGER");
		
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		
		//Compare and decide which method list to be considered on true false decision
		//System.out.println("methods "+ methods);
				for (int i=0; i<methods.size();i++ )
				{
					for (int j=0; j<list.size();j++ )
					{
						if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))
						
							&& list.get(j).get("execute").equalsIgnoreCase("yes"))
							{
							methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));//using this logic we can list out TCs
							methods.get(i).getMethod().setDescription(list.get(j).get("description"));
							//as well as change invocation or description during runtime for the filtered TCs
							methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
							result.add(methods.get(i));
						}
					}
				}
				
		return result;
	}
}

