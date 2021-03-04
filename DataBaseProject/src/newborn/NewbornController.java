/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newborn;

import connection.DBcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class NewbornController implements Initializable {

    @FXML
    private TextField nrid;
    @FXML
    private TextField nmid;
    @FXML
    private DatePicker ndob;
    @FXML
    private Button welcome;
    @FXML
    private Button show;
    @FXML
    private TextField did;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlewelcome(ActionEvent event) {
        Date parse = Date.valueOf(ndob.getValue());
        SimpleDateFormat sdfdest = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdfdest.format(parse);
        
        try {
            Connection con = new DBcon().connect();
            String sql = "insert into NEW_BORN (ROHINGYA_ID, MOTHER_ID, DATE_OF_BIRTH, DOCTORS_ID) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(nrid.getText()));
            pst.setInt(2, Integer.parseInt(nmid.getText()));
            pst.setString(3, date);
            pst.setInt(4, Integer.parseInt(did.getText()));
            
            pst.executeUpdate();
            pst.close();
            
            String sql2 = "DELETE FORM PREGNANCY WHERE ROHINGYA_ID = ?";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst.setInt(1,Integer.parseInt(nmid.getText()));
            
            pst.executeUpdate();
            pst.close();
            
            con.close();
            printSuccessAlert();
            clearfields();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void handleshow(ActionEvent event) {
    }
    
    private void printSuccessAlert() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Successfull!!");
            alert.showAndWait();
    }
    
    private void clearfields (){
        nrid.clear();
        nmid.clear();
        ndob.getEditor().clear();
    }

    @FXML
    private void handlehome(ActionEvent event) throws IOException {
                    Parent p = FXMLLoader.load(getClass().getResource("/selecion/selection.fxml"));
            Scene s = new Scene(p);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(s);
            adminStage.show();
    }
    
}
