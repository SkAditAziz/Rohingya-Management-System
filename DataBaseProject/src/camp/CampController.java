/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camp;

import connection.DBcon;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CampController implements Initializable {

    @FXML
    private TextField cid;
    @FXML
    private TextField cname;
    @FXML
    private TextField ccap;
    @FXML
    private TextField cman;
    @FXML
    private TextField cloc;
    @FXML
    private Button okbutton;
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
    private void handleokbutton(ActionEvent event) {
        try {
            Connection con = new DBcon().connect();
            String sql = "insert into CAMP (CAMP_ID, C_NAME, C_LOCATION, C_CAPACITY, C_MANAGER_ID) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(cid.getText()));
            pst.setString(2, cname.getText().trim());
            pst.setString(2, cloc.getText().trim());
            pst.setInt(1, Integer.parseInt(ccap.getText()));
            pst.setInt(1, Integer.parseInt(cman.getText()));

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
