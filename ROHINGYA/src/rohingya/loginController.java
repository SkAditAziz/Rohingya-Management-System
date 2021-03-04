/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class loginController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button loginButton;
    @FXML
    private TextField userid;
    @FXML
    private PasswordField password;
            
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
      String userID=userid.getText().toString().trim();
      String passWard=password.getText().toString();
      if("a".equals(userID)&& "1".equals(passWard))
      {
          try {
              Parent pnewentry=FXMLLoader.load(getClass().getResource("Selection.fxml"));
              Scene nscene=new Scene(pnewentry);
               Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               adminStage.hide();
                            adminStage.setScene(nscene);
                            adminStage.setTitle("Admin Panel");
                            adminStage.show();
                     
          } catch (IOException ex) {
              Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
