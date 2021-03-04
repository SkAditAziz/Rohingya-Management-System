/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disease;

import java.sql.*;
import connection.DBcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DiseasedetectionController implements Initializable {

    @FXML
    private TextField diseaseID;
    @FXML
    private TextField doctorID;
    @FXML
    private TextField rID;
    @FXML
    private DatePicker detectiondate;
    @FXML
    private Button confirm;
    @FXML
    private Button show;
    @FXML
    private Button home;


    public void clearfields() {
        diseaseID.clear();
        doctorID.clear();
        rID.clear();
        detectiondate.getEditor().clear();
    }

    @FXML
    private void confirmDisease(ActionEvent event) throws SQLException {

        //SimpleDateFormat sdfsource = new SimpleDateFormat("dd/MM/yy"); 
        Date parse = Date.valueOf(detectiondate.getValue());
        SimpleDateFormat sdfdest = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdfdest.format(parse);
        try {
            Connection con = new DBcon().connect();
            String sql = "insert into DISEASE_DETECTION (dISEASE_ID, DOCTORS_ID, ROHINGYA_ID, DATE_OF_DETECTION) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(diseaseID.getText()));
            pst.setInt(2, Integer.parseInt(doctorID.getText()));
            pst.setInt(3, Integer.parseInt(rID.getText()));
            pst.setString(4, date);

//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Info");
//            alert.setHeaderText(null);
//            alert.setContentText("Successfull!!");
//            alert.showAndWait();

            printSuccessAlert();

            pst.executeUpdate();
            pst.close();
            con.close();
            clearfields();
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void loadDiseaseTable(ActionEvent event) {
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
