/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class DBcon {
    private Connection con;
    public DBcon(){
        con=null;
    }

    public Connection connect(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:ORCL","ROHINGYA","adit");
            System.out.println("Connection on = " + !con.isClosed());
            return con;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
}
