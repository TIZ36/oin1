/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.accessDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author zhangtian
 */
public class Login extends HttpServlet {

    public String username = null;
    private String pwd = null;
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null, rs1 = null, rs2 = null;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        username = request.getParameter("username");
        pwd = request.getParameter("password");
        String sql = new String("select password from login where username = '" + username + "'");
        String sql1 = new String("select * from login where username = '" + username + "'");
        String sql2 = new String("select * from USER_INFORMATION where username = '" + username + "'");
        int valid = 0;
        try {
            HttpSession session = request.getSession();
            con = accessDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()) {
                if (rs.getString("password").equals(pwd)) {
                    valid = 1;
                } else {
                    out.write("worry password");
                }
            }else{
                out.print("no such username");
            }
            rs.close();

            if (valid == 1) {
                rs1 = st.executeQuery(sql1);

                while (rs1.next()) {
                    session.setAttribute("current_user_name", rs1.getString("username"));
                }
                rs1.close();

                rs2 = st.executeQuery(sql2);
                while (rs2.next()) {
                    session.setAttribute("current_user_fname", rs2.getString("firstname"));
                    session.setAttribute("current_user_lname", rs2.getString("lastname"));
                    session.setAttribute("current_user_gender", rs2.getString("gender"));
                    session.setAttribute("current_user_email", rs2.getString("email"));
                    session.setAttribute("current_user_address", rs2.getString("address"));
                }
                rs2.close();
                
                //JSONObject jb = Session.getAllInSession(request, response);
                out.print("success");
            }
            
            st.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
