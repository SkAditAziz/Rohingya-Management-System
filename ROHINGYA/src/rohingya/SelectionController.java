/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javax.print.DocFlavor;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author HP
 */
public class SelectionController implements Initializable {
    ObservableList<String>tableList=FXCollections.observableArrayList("NEW ENTRY","DISEASE","PGREGNANCY");
    ObservableList<String>showList=FXCollections.observableArrayList("CAMP");
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Button selectbutton;
    @FXML
    private ChoiceBox showbox;
    @FXML
    private Button showbutton;
    
    //choiceBox.setItems(tableList);
    
    @FXML
    private void selectbuttonaction(ActionEvent event) throws IOException {
        String s;
        Stage stage;
        s=(String) choiceBox.getSelectionModel().getSelectedItem();
        System.out.println(s);
        if("NEW ENTRY".equals(s)){
         Parent pnewentry=FXMLLoader.load(getClass().getResource("NewEntry.fxml"));
              Scene nscene=new Scene(pnewentry);
               Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               adminStage.hide();
                            adminStage.setScene(nscene);
                            adminStage.show();
        }
        if("DISEASE".equals(s)){
            Parent pdisease=FXMLLoader.load(getClass().getResource("Disease.fxml"));
              Scene nscene=new Scene(pdisease);
               Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               adminStage.hide();
                            adminStage.setScene(nscene);
                            adminStage.show();
        }
        if("PREGNANCY".equals(s)){
            Parent ppreg=FXMLLoader.load(getClass().getResource("Pregnancy.fxml"));
               Scene nscene=new Scene(ppreg);
               Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               adminStage.hide();
                            adminStage.setScene(nscene);
                            adminStage.show();
        }
    }
    
    @FXML
    private void showbuttonaction(ActionEvent event) throws IOException {
        String k;
        Stage stage;
        k =(String) showbox.getSelectionModel().getSelectedItem();
        System.out.println(k);
        if("CAMP".equals(k)){
        Parent pcamp=FXMLLoader.load(getClass().getResource("CAMP.fxml"));
               Scene nscene=new Scene(pcamp);
               Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               adminStage.hide();
                            adminStage.setScene(nscene);
                            adminStage.show();
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceBox.setItems(tableList);
        showbox.setItems(showList);
    }    
    
}
