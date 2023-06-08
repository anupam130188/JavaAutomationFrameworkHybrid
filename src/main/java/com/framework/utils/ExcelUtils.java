package com.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.framework.constants.FrameworkConstants;
import com.framework.exceptions.FrameworkException;
import com.framework.exceptions.InvalidFilePathException;

public final class ExcelUtils {

	private ExcelUtils()
	{
		
	}
	
	public static List<Map<String,String>> getData(String fileName)
	{
		
		//FileInputStream fis = null;
		List<Map<String,String>> list=null;
		Map<String,String> map = null;
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {
		//	fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(fileName);
			
			DataFormatter formatter = new DataFormatter();
			list= new ArrayList<>();
			int lastRowNum= sheet.getLastRowNum();
			int lastColumnNum= sheet.getRow(0).getLastCellNum();
			for (int i=1;i<=lastRowNum;i++)
			{
				map = new HashMap<>();
				for (int j=0;j<lastColumnNum ;j++)
				{
					//String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
				String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));	
				String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				map.put(key, value);
				//System.out.println(map);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			new InvalidFilePathException("Excel file you are trying to read is not found");
		} catch (IOException e) {
			new FrameworkException("IO Exception happened");
			// Finally block is not required as have used try with resources at line no 32, which will auto close the fileinput stream after completion
			 /* 
			 * } finally { if(Objects.nonNull(fis)) { try { fis.close(); } catch
			 * (IOException e) { e.printStackTrace(); } }
			 */
		}
		
		return list;
		
	}
	
	
	
	
	
	
}
