/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printdata;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PrintdataController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private Text titletext;
    
    public void settitle(String title){
        titletext.setText(title);
    }
    
    public void setlabel (String labelstring){
        label1.setText(labelstring);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
