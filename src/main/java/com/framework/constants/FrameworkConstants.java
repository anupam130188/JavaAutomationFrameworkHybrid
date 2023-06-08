package com.framework.constants;

import com.framework.enums.ConfigProperties;
import com.framework.utils.ReadPropertyFile;

public final class FrameworkConstants {

	
	private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources/";
	private static final String EXCELFILEPATH=System.getProperty("user.dir")+"/src/test/resources/excel/testdata.xlsx";
	private static final String CHROMEPATH= RESOURCEPATH+"executables/chromedriver.exe";
	private static final String FIREFOXPATH= RESOURCEPATH+"executables/geckodriver.exe";
	private static final String CONFIGFILEPATH= RESOURCEPATH+"config/project.properties";
	private static final int EXPLICITWAIT= 10;
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-reports/";
	private static  String EXTENTREPORTFILEPATH="";
	
	//private static final String EXTENTREPORTNAME="index.html";

	private FrameworkConstants()
	{
		
	}
	
	public static String getExtentreportfilepath() {
		if(EXTENTREPORTFILEPATH.isEmpty())
		{
		return	EXTENTREPORTFILEPATH=createExtentReportPath();	
		}
		return EXTENTREPORTFILEPATH;
	}
	public static String createExtentReportPath() {
		//System.out.println(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORT.toString()) + " value is ");
			if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORT.toString()).equalsIgnoreCase("no"))
			{
			//	System.out.println("OVERRIDEREPORT Match");
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"_index.html";
		} 
	else
			{
		return EXTENTREPORTFOLDERPATH+"/index.html";	
			}
	}
	
	public static String getChromePath() {
		return CHROMEPATH;
	}

	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static String getResourcePath() {
		return RESOURCEPATH;
	}
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}
	

	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}
	

	public static String getExtentreportfolderpath() {
		return EXTENTREPORTFOLDERPATH;
	}
	
	public static String getFirefoxPath() {
		return FIREFOXPATH;
	}
	
}
