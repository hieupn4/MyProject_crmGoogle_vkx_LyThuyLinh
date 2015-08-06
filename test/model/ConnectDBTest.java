/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import Object.Employer;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class ConnectDBTest {
    
    public ConnectDBTest() {
    }

    //@Test
    public void testConnectDB_0args() throws Exception {
        System.out.println("connectDB");
        ConnectDB instance = new ConnectDB();
        instance.connectDB();
        fail("The test case is a prototype.");
    }

   // @Test
    public void testCloseDB() throws Exception {
        System.out.println("closeDB");
        ConnectDB instance = new ConnectDB();
        instance.closeDB();
        fail("The test case is a prototype.");
    }

   // @Test
    public void testInsertCommand() throws Exception {
        System.out.println("insertCommand");
        String query = "";
        ConnectDB instance = new ConnectDB();
        instance.insertCommand(query);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testInserArraylistToDB() throws Exception {
        System.out.println("inserArraylistToDB");
        ArrayList<Employer> customer = null;
        ConnectDB instance = new ConnectDB();
        instance.inserArraylistToDB(customer);
        fail("The test case is a prototype.");
    }

   // @Test
    public void testSelectCommand() throws Exception {
        System.out.println("selectCommand");
        String query = "select * from infomation where crime ='"+2+"'";
        ConnectDB instance = new ConnectDB();
        instance.connectDB();
        ArrayList expResult = null;
        expResult = instance.selectCommand(query);
        System.out.println(expResult.get(0).toString());
    }

    @Test
    public void testExportAdressFromPhonenumber() throws Exception {
        System.out.println("exportAdressFromPhonenumber");
        String phonenumber = "";
        ConnectDB instance = new ConnectDB();
        String[] expResult = null;
        String[] result = instance.exportAdressFromPhonenumber("017888888889");
        System.out.println(result.length);  
    }

   // @Test
    public void testExportEmployerFromPhonenumber() throws Exception {
        System.out.println("exportEmployerFromPhonenumber");
        String phonenumber = "";
        ConnectDB instance = new ConnectDB();
        Employer[] expResult = null;
        Employer[] result = instance.exportEmployerFromPhonenumber(phonenumber);
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }    
}
