/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;

import java.sql.ResultSet;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zhangtian
 */
public class Session extends HttpServlet {

    private static ResultSet rs1 = null, rs2 = null;

    public static JSONObject getAllInSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String[] info = {session.getAttribute("current_user_name").toString(),
            session.getAttribute("current_user_fname").toString(),
            session.getAttribute("current_user_lname").toString(),
            session.getAttribute("current_user_gender").toString(),
            session.getAttribute("current_user_email").toString(),
            session.getAttribute("current_user_address").toString()};

        JSONObject jb = new JSONObject();
        try {
            jb.put("username", info[0]);
            jb.put("fname", info[1]);
            jb.put("lname", info[2]);
            jb.put("gender", info[3]);
            jb.put("email", info[4]);
            jb.put("address", info[5]);
        } catch (JSONException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jb;

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
        getAllInSession(request, response);
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
        getAllInSession(request, response);
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
