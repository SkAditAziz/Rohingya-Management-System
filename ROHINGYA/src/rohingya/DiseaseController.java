/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DiseaseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;
    @FXML
    private TextField r_id;
    @FXML
    private TextField d_id;
    @FXML
    private TextField detectiondate;
    @FXML
    private TextField releasedate;
    @FXML
    private TextField detectedby;
    @FXML
    private Button OK;

    
    @FXML
    private void handleOKButtonAction(ActionEvent event) {
      int R_ID = Integer.parseInt(r_id.getText());
      int D_ID = Integer.parseInt(d_id.getText());
      int DOC_ID = Integer.parseInt(detectedby.getText());
      String d_date =detectiondate.getText().trim();
      String r_date =releasedate.getText().trim();

        //System.out.println("515654889+894494894");
      
     try
        {
            System.out.println("515654889+894494894");
            Connection con = new DBcon().connect();
            System.out.println("515654889+894494894");
            String sql = "insert into DISEASE_DETECTION (DISEASE_ID, DOCTORS_ID,ROHINGYA_ID,DATE_OF_DETECTION,DATE_OF_RELEASE) values(?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, R_ID);
            pst.setInt(2, D_ID);
            pst.setInt(3, DOC_ID);
            pst.setString(4, d_date);
            pst.setString(5, r_date);
     
            pst.executeUpdate();
            pst.close();
            con.close();

        }catch (Exception e)
        {
//            System.out.println("Connection Failed! Check it from console");
//            e.printStackTrace();
            System.out.println(e);
        }
   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

