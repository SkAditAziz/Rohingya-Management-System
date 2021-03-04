/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginmainController implements Initializable {

    ObservableList<String>loginas=FXCollections.observableArrayList("ADMIN","USER");
    
    @FXML
    private TextField loginid;
    @FXML
    private PasswordField loginpassword;
    @FXML
    private Button loginbutton;
    @FXML
    private ChoiceBox loginchoice;

    /**
     * Initializes the controller class.
     */
   

    @FXML
    private void loginButtonClick(ActionEvent event) {
        
        String userName = loginid.getText().trim();
        String password = loginpassword.getText();
        String userType = loginchoice.getValue().toString().trim();
        
        switch (userType){
            case "ADMIN":
                if("a".equals(userName) && "1".equals(password)){
                    try {
                        Parent adminParent = FXMLLoader.load(getClass().getResource("/selecion/selection.fxml"));
                        Scene adminScene = new Scene(adminParent);
                        Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        adminStage.hide();
                        adminStage.setScene(adminScene);
                        adminStage.setTitle("NEW DATA");
                        adminStage.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
                break;
            case "USER":
                if("u".equals(userName) && "1".equals(password)){
                    try {
                        Parent userParent = FXMLLoader.load(getClass().getResource("/user/userpage.fxml"));
                        Scene userScene = new Scene(userParent);
                        Stage userStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        userStage.hide();
                        userStage.setScene(userScene);
                        userStage.setTitle("USER PAGE");
                        userStage.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loginchoice.setItems(loginas);
        loginchoice.getSelectionModel().selectFirst();
    } 
    
}
