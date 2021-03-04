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
public class NewEntryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label label;
    @FXML
    private TextField textR_ID;
    @FXML
    private TextField textR_fname;
    @FXML
    private TextField textR_lname;
    @FXML
    private TextField textR_age;
    @FXML
    private TextField textR_adress;
    @FXML
    private TextField textR_guardianID;
    @FXML
    private TextField textC_ID;
    @FXML
    private TextField textR_employeeID;
    @FXML
    private TextField textR_enterdate;
    @FXML
    private Button button_confirm;
    
    @FXML
     private void handlenewEntryButtonAction(ActionEvent event) {
      int R_ID = Integer.parseInt(textR_ID.getText());
      String FNAME =textR_fname.getText().toString().trim();
      String LNAME =textR_lname.getText().toString().trim();
      int AGE = Integer.parseInt(textR_age.getText());
      String ADD =textR_adress.getText().toString().trim();
      int GID = Integer.parseInt(textR_guardianID.getText());
      int CID = Integer.parseInt(textC_ID.getText());
      int EMPID = Integer.parseInt(textR_employeeID.getText());
      String ENTERDATE =  textR_enterdate.getText().toString().trim();
        //System.out.println("515654889+894494894");
      
     try
        {
            System.out.println("515654889+894494894");
            Connection con = new DBcon().connect();
            System.out.println("515654889+894494894");
            String sql = "insert into ROHINGYA (ROHINGYA_ID, CAMP_ID, R_FNAME, R_LNAME, R_AGE, R_ADRESS, R_GUARDIAN_ID,R_ENTERING_DATE,R_EMPLOYEE_ID,R_GENDER) values(?,?,?,?,?,?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, R_ID);
            pst.setInt(2, CID);
            pst.setString(3, FNAME);
            pst.setString(4, LNAME);
            pst.setInt(5, AGE);
            pst.setString(6, ADD);
            pst.setInt(7,GID);
            pst.setString(8, ENTERDATE);
            pst.setInt(9, EMPID);
            pst.setString(10,"Male");
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
