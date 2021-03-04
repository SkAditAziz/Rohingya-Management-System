/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import printdata.PrintdataController;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class UserpageController implements Initializable {

    @FXML
    private CheckBox rbox;
    @FXML
    private CheckBox bbox;
    @FXML
    private CheckBox cbox;
    @FXML
    private CheckBox dbox;
    @FXML
    private CheckBox reliefbox;
    @FXML
    private Label rlabel;
    @FXML
    private TextField textrid;
    @FXML
    private ComboBox birthbox;
    @FXML
    private ComboBox deathBox;
    @FXML
    private RadioButton totaldiseasebutton;
    @FXML
    private ToggleGroup disease;
    @FXML
    private RadioButton particularcampbutton;
    @FXML
    private ComboBox diseasecamp;
    @FXML
    private ComboBox reliefcombo;
    @FXML
    private Button Rokbutton;
    @FXML
    private Button Bokbutton;
    @FXML
    private Button Cok;
    @FXML
    private Button Dok;
    @FXML
    private Button Relliefbutton;
    @FXML
    private Button totalscenebutton;
    @FXML
    private Text selectreiefitem;
    @FXML
    private Text nowyousee;
    @FXML
    private Text printbirthrate;
    @FXML
    private Text printdeathrate;
    @FXML
    private Button logoutbutton;    
    
//    private Label welcomelabel;
//    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    
    String diseasetypeselection;
    
    final ObservableList campname = FXCollections.observableArrayList();
    
    private void fillcampname () throws SQLException{
        String q1 = "SELECT C_NAME FROM CAMP";
        Connection con = new connection.DBcon().connect();
        PreparedStatement pst = con.prepareStatement(q1);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            campname.add(rs.getString("C_NAME"));
        }
        
    }
    
    final ObservableList itemname = FXCollections.observableArrayList();
    
    private void fillitemname () throws SQLException{
        String q1 = "SELECT ITEM_NAME FROM RELIEF_ITEM";
        Connection con = new connection.DBcon().connect();
        PreparedStatement pst = con.prepareStatement(q1);
        ResultSet rs = pst.executeQuery(q1);
        
        while(rs.next()){
            itemname.add(rs.getString("ITEM_NAME"));
        }
        
    }
    
    private void nonselection(){
            rlabel.setVisible(false);
            textrid.setVisible(false);
            Rokbutton.setVisible(false);
            
            birthbox.setVisible(false);
            Bokbutton.setVisible(false);
            
            deathBox.setVisible(false);
            Cok.setVisible(false);
            
            totaldiseasebutton.setVisible(false);
            particularcampbutton.setVisible(false);
            diseasecamp.setVisible(false);
            Dok.setVisible(false);
            
            reliefcombo.setVisible(false);
            Relliefbutton.setVisible(false);
            
            totalscenebutton.setVisible(false);
            selectreiefitem.setVisible(false);
            nowyousee.setVisible(false);
            
            printbirthrate.setVisible(false);
            printdeathrate.setVisible(false);
    }
    
    
//    private void setnonvisible(){
//        welcomelabel.setVisible(false);
//        imageView.setVisible(false);
//    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nonselection();
        // TODO
//        imageView.setVisible(true);
//        nonselection();
//        FadeTransition fade = new FadeTransition(Duration.millis(5000), welcomelabel);
//        FadeTransition fadeimage;
//        fadeimage = new FadeTransition(Duration.millis(5000), imageView);
//        fade.setFromValue(1.0);
//        fade.setToValue(0.0);
//        fade.setCycleCount(1);
//        fade.setAutoReverse(false);
//        fade.play();
//       
//        fadeimage.setFromValue(1.0);
//        fadeimage.setToValue(0.0);
//        fadeimage.setCycleCount(1);
//        fadeimage.setAutoReverse(false);
//        fadeimage.play();
//        
//        //imageView.setVisible(false);
//        setnonvisible();
//        
    }    

    @FXML
    private void handleRbox(ActionEvent event) {
        if (rbox.isSelected()){
            rlabel.setVisible(true);
            textrid.setVisible(true);
            Rokbutton.setVisible(true);
            totalscenebutton.setVisible(true);
        }
        if (!rbox.isSelected()){
            rlabel.setVisible(false);
            textrid.setVisible(false);
            Rokbutton.setVisible(false);
            totalscenebutton.setVisible(true);
        } 
    }

    @FXML
    private void handleBbox(ActionEvent event) throws SQLException {
        if (bbox.isSelected()){
            birthbox.setVisible(true);
            Bokbutton.setVisible(true);
            fillcampname();
            birthbox.setItems(campname);
        }
        if (!bbox.isSelected()){
            birthbox.setVisible(false);
            Bokbutton.setVisible(false);
        }
    }

    @FXML
    private void handleCbox(ActionEvent event) throws SQLException {
        if (cbox.isSelected()){
            deathBox.setVisible(true);
            Cok.setVisible(true);
            fillcampname();
            deathBox.setItems(campname);
        }
        if (!cbox.isSelected()){
            deathBox.setVisible(false);
            Cok.setVisible(false);
        }
    }

    @FXML
    private void handleDbox(ActionEvent event) {
        if (dbox.isSelected()){
            totaldiseasebutton.setVisible(true);
            particularcampbutton.setVisible(true);
            Dok.setVisible(true);
        }
        if (!dbox.isSelected()){
            totaldiseasebutton.setVisible(false);
            particularcampbutton.setVisible(false);
            diseasecamp.setVisible(false);
            Dok.setVisible(false);
        }
    }

    @FXML
    private void handleReliefbox(ActionEvent event) throws SQLException {
        if (reliefbox.isSelected()){
            reliefcombo.setVisible(true);
            Relliefbutton.setVisible(true);
            fillitemname();
            reliefcombo.setItems(itemname);
            nowyousee.setVisible(true);
            selectreiefitem.setVisible(true);
        }
        if (!reliefbox.isSelected()){
            reliefcombo.setVisible(false);
            Relliefbutton.setVisible(false);
            nowyousee.setVisible(true);
            selectreiefitem.setVisible(true);
        }
    }

    @FXML
    private void handleintotal(ActionEvent event) {
        diseasetypeselection = totaldiseasebutton.getText();
    }

    @FXML
    private void handlediseasecamp(ActionEvent event) throws SQLException {
        if(particularcampbutton.isSelected() && dbox.isSelected() && !totaldiseasebutton.isSelected()){
            diseasecamp.setVisible(true);
            fillitemname();
            diseasecamp.setItems(campname);
            diseasetypeselection = particularcampbutton.getText();
        }
        else
            diseasecamp.setVisible(false);
    }

    @FXML
    private void handleRok(ActionEvent event) {
        
    }

    @FXML
    private void handleBok(ActionEvent event) throws SQLException {
        printbirthrate.setVisible(true);
        String nameofcamp = birthbox.getValue().toString().trim();
        Integer campid = getcampid(nameofcamp);
        String q = "{? = call GET_BIRTH_RATE(?)}";        
        Connection con = new connection.DBcon().connect();
        CallableStatement statement = con.prepareCall(q);
        statement.registerOutParameter (1, Types.FLOAT);
        statement.setInt(2, campid);
        statement.executeQuery();
        float birthrate = statement.getFloat(1);
        printbirthrate.setText("The birth rate of " + nameofcamp + " is : " + birthrate + " (per thousand)");
        statement.close();
        con.close();
    }

    @FXML
    private void handleCok(ActionEvent event) throws SQLException {
        printdeathrate.setVisible(true);
        String nameofcamp = birthbox.getValue().toString().trim();
        Integer campid = getcampid(nameofcamp);
        String q = "{? = call GET_DEATH_RATE(?)}";        
        Connection con = new connection.DBcon().connect();
        CallableStatement statement = con.prepareCall(q);
        statement.registerOutParameter (1, Types.FLOAT);
        statement.setInt(2, campid);
        statement.executeQuery();
        float deathrate = statement.getFloat(1);
        printdeathrate.setText("The death rate of " + nameofcamp + " is : " + deathrate + " (per thousand)");
        statement.close();
        con.close();
    }

    private String getDatafromDisease() throws SQLException{
     
     String q = null;
     if(diseasetypeselection.equals("IN TOTAL")){
         q = "{ call GET_DISEASE_AFFECTED}";
     }
     else if (diseasetypeselection.equals("IN PARTICULAR CAMP")){
         q = "{call GET_DISEASE_AFFECTED_CAMP(?)}";
     }
        Connection con = new connection.DBcon().connect();
        CallableStatement statement = con.prepareCall(q);
     
    String result;    
    if(diseasetypeselection.equals("IN TOTAL"))
    {
        statement.setString(1,diseasecamp.getValue().toString().trim());
        statement.executeQuery();    
        result = statement.getString(1);
    }
    else{
        statement.executeQuery();
        result = statement.getString(1);
    }
        
        return result;
    }
    
    @FXML
    private void handleDok(ActionEvent event) throws IOException, SQLException {
        String title = null;
        if(diseasetypeselection.equals("IN TOTAL")){
            title = "PERCENTAGE OF PEOPLE WHO ARE AFFECTED IN SEVERAL DESEASES";
        }
        else{
            title = "PERCENTAGE OF PEOPLE WHO ARE AFFECTED IN SEVERAL DESEASES IN"+ diseasecamp.getValue().toString().trim() +"CAMP";
        }
            Parent p = FXMLLoader.load(getClass().getResource("/printdata/printdata.fxml"));
            Scene s = new Scene(p);
            PrintdataController printdatacontroller = new PrintdataController();
            printdatacontroller.settitle(title);
            printdatacontroller.setlabel(getDatafromDisease());
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(s);
            adminStage.show();
    }

    private String getDatafromdbms () throws SQLException{
        String q = "{ call GET_RELIEF_PERCENTAGE_CAMP(?)}";        
        Connection con = new connection.DBcon().connect();
        CallableStatement statement = con.prepareCall(q);
        
        statement.setString(1,reliefcombo.getValue().toString().trim());
        statement.executeQuery();
        String result = statement.getString(1);
        
        return result;
    }
    
    @FXML
    private void handlereliefbutton(ActionEvent event) throws IOException, SQLException {
            String title = "PERCENTAGE OF PEOPLE WHO HAVEN'T GOT THIS RELIEF ITEM IN CAMPS";
            Parent p = FXMLLoader.load(getClass().getResource("/printdata/printdata.fxml"));
            Scene s = new Scene(p);
            PrintdataController printdatacontroller = new PrintdataController();
            printdatacontroller.settitle(title);
            printdatacontroller.setlabel(getDatafromdbms());
            Stage adminStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            adminStage.hide();
            adminStage.setScene(s);
            adminStage.show();
    }

    @FXML
    private void handletotalscene(ActionEvent event) {
        
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

    private Integer getcampid(String nameofcamp) throws SQLException {
        
        String qcamp = "SELECT CAMP_ID FROM CAMP WHERE C_NAME = '" + nameofcamp + "'";
        Connection con = new connection.DBcon().connect();
        PreparedStatement pst = con.prepareStatement(qcamp);
        ResultSet rs = pst.executeQuery();
        Integer id = 0;
        while(rs.next()){
            id = rs.getInt("CAMP_ID");
        }
       return id;
    }
    
   
}
