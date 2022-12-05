/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;

public class accessDB {

    private static final String CLASS_FOR_NAME = "org.apache.derby.jdbc.ClientDriver";//for specific DB connection, here I use the netBeans derby database(easy but seldomly use)
    private static final String PATH = "jdbc:derby://localhost:1527/shoppingcart";//Path of the DB
    private static final String USER = "jack";//userName
    private static final String PWD = "jack";//password for the db

    public static Connection getConnection() {

        Connection con = null; //initialize the Connection Object

        try {
            Class.forName(CLASS_FOR_NAME);
            con = DriverManager.getConnection(PATH, USER, PWD);//in order to connection, the method make us to provide(url,user,password)

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(accessDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;

    }

}
