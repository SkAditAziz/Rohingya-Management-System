/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

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
            System.out.println("aaaaa");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("bbb");
            con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/orcl","ROHINGYA","adit");
            System.out.println("Connection on = " + !con.isClosed());
            return con;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
            return null;
        }
    }
}
