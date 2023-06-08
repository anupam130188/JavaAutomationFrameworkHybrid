package com.framework.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils()
	{
		
	}
	
	public static String getDynamicXpath (String source, String target)
	{
		//return source.replaceFirst("%replace%", target);
		return String.format(source, target);
	}
	
	public static String getDynamicXpath(String source, String target1, String target2)
	{
		//return source.replaceFirst("%replace%", target);
		return String.format(source, target1,target2);
	}
	
}
