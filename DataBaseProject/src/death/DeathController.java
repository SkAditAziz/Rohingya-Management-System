/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package death;

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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DeathController implements Initializable {

    @FXML
    private TextField rid;
    @FXML
    private TextField enterid;
    @FXML
    private DatePicker dod;
    @FXML
    private Button bye;
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
    private void handlebye(ActionEvent event) {
        Date parse = Date.valueOf(dod.getValue());
        SimpleDateFormat sdfdest = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdfdest.format(parse);
        
        try {
            Connection con = new DBcon().connect();
            String sql = "insert into DEATH (ROHINGYA_ID, DATE_OF_DEATH, ENTRIED_ID) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(rid.getText()));
            pst.setString(2, date);
            pst.setInt(3, Integer.parseInt(enterid.getText()));
            
            
            pst.executeUpdate();
            pst.close();
            
            con.close();

        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
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
