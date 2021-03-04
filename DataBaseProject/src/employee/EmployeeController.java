/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EmployeeController implements Initializable {

    @FXML
    private TextField fname;
    @FXML
    private TextField cno;
    @FXML
    private TextField lname;
    @FXML
    private TextField jid;
    @FXML
    private TextField sal;
    @FXML
    private TextField cid;
    @FXML
    private TextField eid;
    @FXML
    private Button confirm;
    @FXML
    private Button show;
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
    private void confirmbuttonaction(ActionEvent event) {
        try {
            Connection con = new DBcon().connect();
            String sql = "insert into EMPLOYEES (EMPLOYEE_ID, CAMP_ID, E_FNAME, E_LNAME, E_CONTACT_NO, E_SALARY, E_JOB_ID) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(eid.getText()));
            pst.setInt(2, Integer.parseInt(cid.getText()));
            pst.setString(3, fname.getText().trim());
            pst.setString(4, lname.getText().trim());
            pst.setInt(5, Integer.parseInt(cno.getText()));
            pst.setInt(6, Integer.parseInt(sal.getText()));
            pst.setString(7, jid.getText().trim());

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
    private void showbuttonaction(ActionEvent event) {

    }

    private void printSuccessAlert() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText("Successfull!!");
        alert.showAndWait();
    }

    public void clearfields() {
        eid.clear();
        jid.clear();
        cid.clear();
        fname.clear();
        lname.clear();
        cno.clear();
        sal.clear();
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
