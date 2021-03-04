/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package NewEntry;

import connection.DBcon;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class NewEntryController implements Initializable {

    @FXML
    private TextField textR_ID;
    @FXML
    private TextField textR_fname;
    @FXML
    private TextField textR_lname;
    @FXML
    private TextField textR_age;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton female;
    @FXML
    private TextField textR_adress;
    @FXML
    private TextField textR_guardianID;
    @FXML
    private TextField textC_ID;
    @FXML
    private TextField textR_employeeID;
    @FXML
    private DatePicker Enter_date;
    @FXML
    private Button button_confirm;
    
    private String GENDER;
    @FXML
    private ToggleGroup gender;
    
    @FXML
    private TableView<newentrytable> newentryTableView;
    @FXML
    private TableColumn<newentrytable, String> ridcol;
    @FXML
    private TableColumn<newentrytable, String> cidcol;
    @FXML
    private TableColumn<newentrytable, String> fnamecol;
    @FXML
    private TableColumn<newentrytable, String> lnamecol;
    @FXML
    private TableColumn<newentrytable, String> agecol;
    @FXML
    private TableColumn<newentrytable, String> addcol;
    @FXML
    private TableColumn<newentrytable, String> guardcol;
    @FXML
    private TableColumn<newentrytable, String> enteringdatecol;
    @FXML
    private TableColumn<newentrytable, String> enteredbycol;
    @FXML
    private TableColumn<newentrytable, String> gendercol;

    @FXML
    private void handlemale (ActionEvent event){
        GENDER = male.getText();
    }

    @FXML
    private void handlefemale (ActionEvent event){
        GENDER = female.getText();
    }
    
    //private DBcon database = new DBcon();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet,resultSet1;
    
    //String query = "SELECT * FROM ROHINGYA";
    
    private ObservableList getDataFromNewEntryToObservableList(String query){
        ObservableList<newentrytable> NewEntryTableData = FXCollections.observableArrayList();
        try {
            System.out.println("1111111");
            Connection con = new DBcon().connect();
            System.out.println("222222");
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);//"SELECT * FROM cource;"
            while(resultSet.next()){
                NewEntryTableData.add(new newentrytable(
                        resultSet.getString("ROHINGYA_ID"),
                        resultSet.getString("CAMP_ID"),
                        resultSet.getString("R_FNAME"),
                        resultSet.getString("R_LNAME"),
                        resultSet.getString("R_AGE"),
                        resultSet.getString("R_ADDRESS"),
                        resultSet.getString("R_GUARDIAN_ID"),
                        resultSet.getString("R_ENTERING_DATE"),
                        resultSet.getString("R_EMPLOYEE_ID"),
                        resultSet.getString("R_GENDER")

                ));
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return NewEntryTableData;
    }
    
    @FXML
    private void handlenewEntryButtonAction(ActionEvent event) {

        Date parse = Date.valueOf(Enter_date.getValue());
        SimpleDateFormat sdfdest = new SimpleDateFormat("dd-MMM-yyyy");
        String date = sdfdest.format(parse);
      
      
     try
        {
            Connection con = new DBcon().connect();
            String sql = "insert into ROHINGYA (ROHINGYA_ID, CAMP_ID, R_FNAME, R_LNAME, R_AGE, R_ADDRESS, R_GUARDIAN_ID,R_ENTERING_DATE,R_EMPLOYEE_ID,R_GENDER) values(?,?,?,?,?,?,?,?,?,?)" ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(textR_ID.getText()));
            pst.setInt(2, Integer.parseInt(textC_ID.getText()));
            pst.setString(3, textR_fname.getText().trim());
            pst.setString(4, textR_lname.getText().trim());
            pst.setInt(5, Integer.parseInt(textR_age.getText()));
            pst.setString(6, textR_adress.getText().trim());
            //pst.setInt(7,Integer.parseInt(textR_guardianID.getText()));
            pst.setObject(7, Integer.parseInt(textR_guardianID.getText()), Types.INTEGER);
            pst.setString(8, date);
            pst.setInt(9, Integer.parseInt(textR_employeeID.getText()));
            pst.setString(10, GENDER);
            pst.executeUpdate();
            pst.close();
            con.close();
        }
          
        catch (SQLException e)
        {
//            System.out.println("Connection Failed! Check it from console");
//            e.printStackTrace();
            System.out.println(e);
        }
   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        newentryTableView.setItems(getDataFromNewEntryToObservableList("SELECT * FROM ROHINGYA"));
    }    
    
}
