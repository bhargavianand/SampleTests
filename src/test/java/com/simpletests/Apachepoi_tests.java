package com.simpletests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Apachepoi_tests {
	
	public static void main(String[] args) throws IOException {
		
        File file = new File("Geeks.xlsx");         
         FileInputStream fip = new FileInputStream(file);
		
        XSSFWorkbook workbook = new XSSFWorkbook(fip); 
        	if(file.isFile() && file.exists()) {
        		System.out.println("Geeks exists and it's a file");
        	}
        	else
        		System.out.println("Geeks doesn't exist");
		
	}
	
}
