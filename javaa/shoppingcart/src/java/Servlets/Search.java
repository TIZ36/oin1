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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zhangtian
 */
public class Search extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        JSONArray jy = new JSONArray();
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        String key = request.getParameter("key");
        String sql = "select * from products where productname like '%"+key+"%'";
        Connection con = accessDB.getConnection();

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int col = metaData.getColumnCount();
            while (rs.next()) {

                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i < col; i++) {
                    map.put(metaData.getColumnName(i), rs.getObject(i));

                }
                data.add(map);   
            }
            jy = Search.toJsonArray(data);
            

            out.print(jy);
            out.flush();
            out.close();
            rs.close();
            st.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Laptop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static JSONArray toJsonArray(List<Map<String, Object>> data) {

        JSONArray array = new JSONArray();
        for (Map<String, Object> item : data) {

            JSONObject json = new JSONObject();
            for (Map.Entry<String, Object> entry : item.entrySet()) {

                try {
                    json.put(entry.getKey(), entry.getValue());
                } catch (JSONException ex) {
                    Logger.getLogger(Laptop.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            array.put(json);

        }
        return array;
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
