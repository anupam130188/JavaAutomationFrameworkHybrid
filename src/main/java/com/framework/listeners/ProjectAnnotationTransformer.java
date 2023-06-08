package com.framework.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.framework.utils.DataProviderUtils;


public class ProjectAnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setDataProvider("getDataFromExcel");
		annotation.setRetryAnalyzer(ProjectRetryAnalyzer.class);
	}


	
	
}
