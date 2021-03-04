/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author USER
 */
public class CampController implements Initializable {
    
    @FXML private TableView<Camp> table;
    @FXML private TableColumn<Camp,Integer> CAMP_ID;
    @FXML private TableColumn<Camp,String> C_NAME;
    @FXML private TableColumn<Camp,String> C_LOCATION;
    @FXML private TableColumn<Camp,Integer> C_CAPACITY;
    @FXML private TableColumn<Camp,Integer> C_MANAGER_ID;
    
    public ObservableList<Camp>list=FXCollections.observableArrayList(
            new Camp(1,"sdfsf1","dfsf1",21,31),
            new Camp(1,"sdfsf2","dfsf2",22,32),
            new Camp(1,"sdfsf3","dfsf3",23,33),
            new Camp(1,"sdfsf4","dfsf4",24,34)
            );
    
//    @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
//    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        CAMP_ID.setCellValueFactory(new PropertyValueFactory<Camp,Integer> ("CAMP_ID"));
        C_NAME.setCellValueFactory(new PropertyValueFactory<Camp,String>("C_NAME"));
        C_LOCATION.setCellValueFactory(new PropertyValueFactory<Camp,String>("C_LOCATION"));
        C_CAPACITY.setCellValueFactory(new PropertyValueFactory<Camp,Integer>("C_CAPACITY"));
        C_MANAGER_ID.setCellValueFactory(new PropertyValueFactory<Camp,Integer>("C_MANAGER_ID"));
         table.setItems(list);
    }    
    
}
