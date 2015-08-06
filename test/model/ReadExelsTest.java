/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ReadExelsTest {
    
    public ReadExelsTest() {
    }

    @Test
    public void testImportArrayList() throws Exception {
        System.out.println("importArrayList");
        ReadExels instance = new ReadExels("C:\\Users\\Administrator\\Desktop\\vkx.xlsx");
        ArrayList expResult = null;
        ArrayList result = instance.importArrayList();
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i).toString());
        
    }

   // @Test
    public void testReturnStringValue() {
        System.out.println("returnStringValue");
        Cell c = null;
        ReadExels instance = null;
        String expResult = "";
        String result = instance.returnStringValue(c);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
