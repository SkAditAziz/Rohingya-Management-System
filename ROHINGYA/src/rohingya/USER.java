/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static javafx.application.Application.launch;

/**
 *
 * @author USER
 */
public class USER {
    
 public static void entry() {
        System.out.println("1111");
        try
        {
            Connection con = new DBcon().connect();
            String sql = "insert into DISEASE (DISEASE_ID, D_NAME, D_TYPE, D_DEPARTMENT) values(?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "1319");
            pst.setString(2, "xyz");
            pst.setString(3, "abc");
            pst.setString(4, "z");
            pst.executeUpdate();
            pst.close();
            con.close();
        }catch (SQLException e)
        {
            System.out.println("Connection Failed! Check it from console");
            e.printStackTrace();
        }
              //  launch(args);

    }
        
}
