/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import Object.Employer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static jdk.nashorn.internal.objects.NativeFunction.call;
//import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Administrator
 */
public class ReadExels {
    FileInputStream fis;

    public ReadExels(String x) throws FileNotFoundException {
        this.fis = new FileInputStream(x);
    }
    public ArrayList importArrayList() throws IOException
    {
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);  
        ArrayList store = new ArrayList();
        int rowNum = sheet.getLastRowNum() + 1;
        int colNum = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNum][colNum];
        for (int i = 0 ; i < rowNum ; i++) {
           Employer simple = new Employer();
           XSSFRow row = sheet.getRow(i);
           int k=1;
            for (int j = 0 ; j < colNum ; j++) {
                XSSFCell cell = row.getCell(j);
                String value = returnStringValue(cell);
                       if(k==1)
                           simple.setName(value); 
                       if(k==2)
                           simple.setAge(value);    
                       if(k==3)
                           simple.setNumberPhone(value);
                       if(k==4)
                           simple.setAdress(value);
                       if(k==5)
                           simple.setCrime(value);
                       k++;
            }
            store.add(simple);
        }
        store.remove(0);
        return store;
    }
    public String returnStringValue(Cell c)
    {
       if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) 
          {
               return "     ";
          } 
       else
           return c.getStringCellValue();
    }
 
}
