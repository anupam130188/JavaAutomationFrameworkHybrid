package com.framework.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.framework.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

	
	public String[] author() default "";
	//public String[] category() default ""; //changed from String to CategoryType enum to ensure user selects only from the specified list of enum values.
	public CategoryType[] category();
}
