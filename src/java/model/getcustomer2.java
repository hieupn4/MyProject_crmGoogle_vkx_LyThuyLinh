/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Object.Employer;
import conttroler.writeFile;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class getcustomer2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getcustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>xã thuận an " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList custo = new ArrayList();
        String sql = "SELECT * FROM infomation WHERE numberphone=";
        sql = sql + "'" + request.getParameter("q") + "'";
        ConnectDB con = new ConnectDB();
        try {
            con.connectDB();
        } catch (SQLException ex) {
            Logger.getLogger(getcustomer2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getcustomer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            custo = con.selectCommand(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(getcustomer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter out = response.getWriter();
        if(custo.size()==0)
        {
            out.println("<p>has not record in DB</p>");
        }
        else
        {
            
           response.setContentType("text/html;charset=UTF-8");
            out.println("<table border=\"1\">");
            out.println("<tr><td>" + "Name" +"</td>"); 
            out.println("<td>" + "Adress" +"</td>"); 
            out.println("<td>" + "Crime "+"</td></tr>");
            for (int i=0;i<custo.size();i++)
            {
            out.println("<tr><td>" + ((Employer)custo.get(i)).getName()+"</td>"); 
            out.println("<td>" + ((Employer)custo.get(i)).getAdress()+"</td>"); 
            out.println("<td>" + ((Employer)custo.get(i)).getCrime()+"</td></tr>"); 
            }
              out.println("</table>");
              
            
             
              
        }
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
