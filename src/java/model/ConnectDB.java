/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import Object.Employer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ConnectDB {
    private String JDBC_DRIVER;  
    private String DB_URL;
    private String USER;
    private String PASS ;
    Connection conn =  null;
    public ConnectDB() 
    {
        this.JDBC_DRIVER = null;
        this.DB_URL = null;
        this.USER = null;
        this.PASS = null;
    }

    public void connectDB() throws SQLException, ClassNotFoundException
    {
         JDBC_DRIVER = "org.postgresql.Driver";
         DB_URL = "jdbc:postgresql://localhost:5433/customers";
         USER = "postgres";
         PASS = "kieuoanh";
         Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(DB_URL,USER,PASS);    
         System.out.println("ket noi thanh cong");
    }
    public void closeDB() throws SQLException
    {
        conn.close();
    }
    public void insertCommand(String query) throws SQLException
    {
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }
    public void inserArraylistToDB(ArrayList<Employer> customer) throws SQLException, ClassNotFoundException
    {
        connectDB();
        for(int i=0;i<customer.size();i++)
        {
            String name = customer.get(i).getName();
            String age = customer.get(i).getAge();
            String numberphone = customer.get(i).getNumberPhone();
            String adress = customer.get(i).getAdress();
            String crime = customer.get(i).getCrime();
            String query = "insert into infomation values('"+name+"','"+age+"','"+numberphone+"','"+adress+"','"+crime+"')";
            insertCommand(query); 
        }
        closeDB();
    }
    public ArrayList selectCommand(String query) throws SQLException
    {
        ArrayList store = new ArrayList();
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next())
         {
            Employer simple = new Employer();
            simple.setName(rs.getString("name"));
            simple.setAge(rs.getString("age"));
            simple.setNumberPhone(rs.getString("numberphone"));
            simple.setAdress(rs.getString("adress"));
            simple.setCrime(rs.getString("crime"));
            store.add(simple);          
         }
        return store;
    }
    /**
     * phương thức này trả về một mảng chuỗi bao gồm các địa chỉ của một số điện thoại gọi đén
     * ở đây coi như là cùng một số điện thoại nhưng có thể đăng ký ở hai nơi khác nhau
     * @param phonenumber : số điện thoại của khách hàng
     * @return : mảng chuỗi bao gồm các địa chỉ của số điện thoại
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public String[] exportAdressFromPhonenumber(String phonenumber) throws SQLException, ClassNotFoundException
    {
        connectDB();
        String query = "select * from infomation where numberphone ='"+phonenumber+"'";
        ArrayList store = selectCommand(query);       
        String[] adress = new String[store.size()];
        for(int i=0;i<store.size();i++)
                 adress[i]=((Employer)store.get(0)).getAdress();
        return adress;
    }
    /**
     * phương thúc này trả về danh sách những người mà có chung số điện thoại
     * thực tế thì trường hợp này khó xảy ra nhưng chúng ta cũng coi như là nó có thể xảy ra
     * @param phonenumber
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Employer[] exportEmployerFromPhonenumber(String phonenumber) throws SQLException, ClassNotFoundException
    {
        connectDB();
        String query = "select * from infomation where numberphone ='"+phonenumber+"'";
        ArrayList store = selectCommand(query);
        Employer[] x = new Employer[store.size()];
        for(int i=0;i<store.size();i++)
        {
            x[i]=(Employer) store.get(i);
        }
        return x;
    }

    
    
}
