package Servlets;

import Beans.accessDB;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author spring
 * @version
 */
public class Servlet_for_DB extends HttpServlet {

    private Connection conn = null;
    private ResultSet rs = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userName, passWord, reminder, fname, lname, Gender, email, address;
        Statement st;

        userName = request.getParameter("username");
        passWord = request.getParameter("password");
        reminder = request.getParameter("reminder");
        fname = request.getParameter("fname");
        lname = request.getParameter("lname");
        Gender = request.getParameter("gender");
        email = request.getParameter("email");
        address = request.getParameter("address");

        try {
            conn = accessDB.getConnection();

            st = conn.createStatement();
            String sql1 = new String("INSERT INTO LOGIN (USERNAME, PASSWORD, REMINDER)"
                    + " VALUES ('" + userName + "','" + passWord + "','" + reminder + "')");
            String sql2 = new String("INSERT INTO USER_INFORMATION (EMAIL, ADDRESS,FIRSTNAME,LASTNAME,GENDER,USERNAME)"
                    + " VALUES ('" + email + "','" + address + "','" + fname + "','" + lname + "','" + Gender + "','" + userName + "')");
            String sql3 = new String("select * from login where username ='" + userName + "'");
            rs = st.executeQuery(sql3);

            if (rs.next()) {
                out.write("it seems that this username has already exsited! ");
            } else {

                st.execute(sql1);
                st.execute(sql2);    
                HttpSession session = request.getSession();
                session.setAttribute("current_user_name", userName);
                session.setAttribute("current_user_fname",fname);
                session.setAttribute("current_user_lname", lname);
                session.setAttribute("current_user_gender",Gender);
                session.setAttribute("current_user_email",email);
                session.setAttribute("current_user_address",address);
                out.write("success");
                
                
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Servlet_for_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
