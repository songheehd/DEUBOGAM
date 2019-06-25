/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project19;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;


/**
 *
 * @author admin
 */
public class MyQuery {

    public Connection getConnection() {
        
         Connection con = null;
        
        try{
            con = DriverManager.getConnection("jdbc::mysql://localhost/test_db","root","");  // db에따라 수정
        }catch(SQLException ex){
            Logger.getLogger(JComboTutorial.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return con;
    }

    ArrayList<Product> getData(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
