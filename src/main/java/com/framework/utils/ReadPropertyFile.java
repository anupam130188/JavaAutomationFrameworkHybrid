package com.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import com.framework.constants.FrameworkConstants;
import com.framework.constants.WaitStrategy;
import com.framework.enums.ConfigProperties;
import com.framework.exceptions.InvalidFilePathException;
import com.framework.exceptions.ReadPropertyFileException;

public final class ReadPropertyFile {

	private static Properties prop = new Properties();
	private ReadPropertyFile()
	{
		
	}
	static //Static block code executes only once during the class loading. The static blocks always execute first before the main() method 
	//in Java because the compiler stores them in memory at the time of class loading and before the object creation. because of this 
	//even after getting the Config file issue in Fileinput stream the complier didn't stop and it tried to run @Beforetest where it hit another exception/
	//to overcome this, we have to use system.exit(0).it method terminates the current JVM running on the system which results in 
	//termination of code being executed currently. so that jvm should not try to run before test after getting failure in static block
	// and tries to run 	
	{
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
		//FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fis);
		} catch (IOException e) {	
			//throw new InvalidFilePathException("Please provide the correct Config file path"); // instead of handling exception use the system.exit to stop the running of code
			System.exit(0);
		}
	}
	
	public static String getValue(String key)
	{
		key=key.toLowerCase();
		//System.out.println("Value is "+ key);
		if (Objects.isNull(key) || Objects.isNull(prop.getProperty(key)))
		{
			//throw new Exception("Property name "+ key + " is not passed correctly, please check"); instead of using generic exception. it is better to use
			//runtime exception as it captures the error message with more clarity and it stops scripts if an exception is encountered.
			
			// --> Instead of runtime exception, it is good to create custom exception and create all the calling constructor methods in that as below, replacement for runtime
			//throw new RuntimeException("Property name "+ key + " is not passed correctly, please check");
			throw new ReadPropertyFileException("Property name "+ key + " is not passed correctly, please check");
		
		}
		return prop.getProperty(key);
	}
	
}
