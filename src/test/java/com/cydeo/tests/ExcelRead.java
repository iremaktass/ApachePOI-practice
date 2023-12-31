package com.cydeo.tests;

import com.cydeo.utilities.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    /*
    in this method we learn how to read from Excel file step by step
     */

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook>sheet>row>cell

        // <1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // <2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");


        //<3> Select row and cell
        //Print out Mary's cell
        //Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        //print Developer
        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        //print Linda
        System.out.println("sheet.getRow(4).getCell(0) = " + sheet.getRow(4).getCell(0));

        // Return the count of used cells only
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("Used rows "+usedRows);

        /*
        Returns the number from top cell to bottom cell
        it does not care if the cell is empty or not
        Starts counting from 0
         */
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        //TODO: 1 Create a logic to print Vinod's name DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println("Apache POI found you! Name is " +sheet.getRow(rowNum).getCell(0) );
            }
        }

        //TODO: 2 - CREATE A LOGIC TO PRINT OUT Mansoor Khan'S JOB_ID
        // CHECK IF NAME IS Mansoor --> PRINT OUT JOB_ID

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Mansoor")){
                System.out.println("Steven's JOB_ID is " + sheet.getRow(rowNum).getCell(2));
            }
        }


//        ExcelUtil excelUtil = new ExcelUtil(path,"Employees");
//        System.out.println("excelUtil.getCellData(1,0) = " + excelUtil.getCellData(1, 0));

    }


}
