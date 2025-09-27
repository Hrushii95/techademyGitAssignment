package com.comprehensiveAssignment.sdet_comprehensive_assignment;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataExample {
    public static void main(String[] args) throws IOException {
    	FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\sdet-comprehensive-assignment\\Files\\EmployeeDetails.xlsx");
    	Workbook workbook = new XSSFWorkbook(fis);
    	Sheet sheet = workbook.getSheetAt(0);

    	for (Row row : sheet) {
    	    for (Cell cell : row) {
    	        System.out.print(cell.toString() + "\t");
    	    }
    	    System.out.println();
    	}
    	workbook.close();
    	fis.close();
	}
}
