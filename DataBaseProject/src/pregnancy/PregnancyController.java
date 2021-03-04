/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregnancy;

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
public class PregnancyController implements Initializable {

    @FXML
    private TextField pid;
    @FXML
    private TextField docid;
    @FXML
    private DatePicker psdate;
    @FXML
    private Button pok;
    @FXML
    private Button pshow;
    @FXML
    private Button home;

    
    private void clearfields (){
        pid.clear();
        docid.clear();
        psdate.getEditor().clear();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlepok(ActionEvent event) {
        
        Date parse = Date.valueOf(psdate.getValue());
        SimpleDateFormat sdfdest = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdfdest.format(parse);
        
        try {
            System.out.println("33333");
            Connection con = new DBcon().connect();
            System.out.println("44444444");
            String sql = "insert into PREGNANCY (ROHINGYA_ID,PREG_START_DATE, DOCTORS_ID) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(pid.getText()));
            pst.setString(2, date);
            pst.setInt(3, Integer.parseInt(docid.getText()));
            
            printSuccessAlert();

            pst.executeUpdate();
            pst.close();
            con.close();
            clearfields();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void handlepshow(ActionEvent event) {
    }
    
    private void printSuccessAlert() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Successfull!!");
            alert.showAndWait();
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
