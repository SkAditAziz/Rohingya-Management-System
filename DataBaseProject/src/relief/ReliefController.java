/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relief;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ReliefController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private TextField serialno;
    @FXML
    private TextField rid;
    @FXML
    private TextField eid;
    @FXML
    private DatePicker rdate;
    @FXML
    private ComboBox<?> typebox;
    @FXML
    private ComboBox<?> namebox;
    @FXML
    private TextField amaount;
    @FXML
    private Button confirm;
    @FXML
    private Button newitem;
    @FXML
    private Button home;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//         TODO
    }    

    @FXML
    private void handleconfirm(ActionEvent event) {
    }

    @FXML
    private void handlenewitem(ActionEvent event) {
    }

    @FXML
    private void handlehome(ActionEvent event) {
    }
    
}
