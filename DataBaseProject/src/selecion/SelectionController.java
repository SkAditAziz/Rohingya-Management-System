/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecion;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SelectionController implements Initializable {

    @FXML
    private Button selectbutton;
    @FXML
    private Button go;
    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private RadioButton register;
    @FXML
    private ToggleGroup selection;
    @FXML
    private RadioButton manager;
    @FXML
    private RadioButton doctor;
    @FXML
    private Button logout;
    
    private String selected;
    
    ObservableList<String> managerList = FXCollections.observableArrayList("CAMP", "EMPLOYEE", "NEW RELIEF ITEM", "RELIEF STORAGE");
    ObservableList<String> registerList = FXCollections.observableArrayList("NEW ENTRY", "DEATH", "RELIEF");
    ObservableList<String> doctorList = FXCollections.observableArrayList("DISEASE DETECTION", "PREGNANCY", "NEW BORN");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //choiceBox.setItems(registerList);
    }    

    @FXML
    private void selectbuttonaction(ActionEvent event) throws IOException {
    Stage stage;
        
        //System.out.println("1111ddd");
        String s = (String) choiceBox.getSelectionModel().getSelectedItem();
        
        //System.out.println("1111");
        
        if ("NEW ENTRY".equals(s)) {
            //System.out.println("22222");
            Parent pnewentry = FXMLLoader.load(getClass().getResource("/NewEntry/NewEntry.fxml"));
            //System.out.println("33333");
            Scene nscene = new Scene(pnewentry);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(nscene);
            adminStage.show();
        } else if ("DISEASE DETECTION".equals(s)) {
            //System.out.println("444444");
            Parent pdisease = FXMLLoader.load(getClass().getResource("/disease/diseasedetection.fxml"));
            //System.out.println("5555");
            Scene diseasescene = new Scene(pdisease);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(diseasescene);
            adminStage.show();
        }
        else if ("EMPLOYEE".equals(s)) {
            //System.out.println("666");
            Parent pdisease = FXMLLoader.load(getClass().getResource("/employee/Employee.fxml"));
            //System.out.println("77777");
            Scene diseasescene = new Scene(pdisease);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(diseasescene);
            adminStage.show();
        }
        else if ("PREGNANCY".equals(s)) {
            //System.out.println("666");
            Parent ppreg = FXMLLoader.load(getClass().getResource("/pregnancy/pregnancy.fxml"));
            //System.out.println("77777");
            Scene pregscene = new Scene(ppreg);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(pregscene);
            adminStage.show();
        }
        else if ("NEW BORN".equals(s)) {
            //System.out.println("666");
            Parent pnew = FXMLLoader.load(getClass().getResource("/newborn/newborn.fxml"));
            //System.out.println("77777");
            Scene newscene = new Scene(pnew);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(newscene);
            adminStage.show();
        }
        else if ("CAMP".equals(s)) {
            //System.out.println("666");
            Parent pc = FXMLLoader.load(getClass().getResource("/camp/camp.fxml"));
            //System.out.println("77777");
            Scene cs = new Scene(pc);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(cs);
            adminStage.show();
        }
        else if ("RELIEF".equals(s)) {
            //System.out.println("666");
            Parent prelief = FXMLLoader.load(getClass().getResource("/relief/relief.fxml"));
            //System.out.println("77777");
            Scene reliefs = new Scene(prelief);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(reliefs);
            adminStage.show();
        }
        else if ("DEATH".equals(s)) {
            //System.out.println("666");
            Parent pc = FXMLLoader.load(getClass().getResource("/death/death.fxml"));
            //System.out.println("77777");
            Scene cs = new Scene(pc);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(cs);
            adminStage.show();
        }
    }

    @FXML
    private void choiceboxaction(MouseEvent event) {
    }

    @FXML
    private void handleReg(ActionEvent event) {
        selected = register.getText();
    }

    @FXML
    private void handleM(ActionEvent event) {
        selected = manager.getText();
    }

    @FXML
    private void handleD(ActionEvent event) {
        selected = doctor.getText();
    }

    @FXML
    private void handlelogout(ActionEvent event) throws IOException {
            Parent p = FXMLLoader.load(getClass().getResource("/login/loginmain.fxml"));
            Scene s = new Scene(p);
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(s);
            adminStage.show();
    }
    
    @FXML
    private void handlego(ActionEvent event) throws IOException {
        if (null != selected)switch (selected) {
            case "Manager":
                choiceBox.setItems(managerList);
                choiceBox.getSelectionModel().selectFirst();
                break;
            case "Register":
                choiceBox.setItems(registerList);
                choiceBox.getSelectionModel().selectFirst();
                break;
            case "Doctor":
                choiceBox.setItems(doctorList);
                choiceBox.getSelectionModel().selectFirst();
                break;
            default:
                break;
        }
    }
    
}
