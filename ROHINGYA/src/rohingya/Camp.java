/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rohingya;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author USER
 */
public class Camp {
    private final SimpleIntegerProperty CAMP_ID;
    private final SimpleStringProperty C_NAME;
    private final SimpleStringProperty C_LOCATION;
    private final SimpleIntegerProperty C_CAPACITY;
    private final SimpleIntegerProperty C_MANAGER_ID;
    public  Camp(Integer CAMP_ID,String C_NAME,String C_LOCATION,Integer C_CAPACITY,Integer C_MANAGER_ID)
    {
        this.CAMP_ID=new SimpleIntegerProperty(CAMP_ID);
        this.C_NAME=new SimpleStringProperty(C_NAME);
        this.C_LOCATION=new SimpleStringProperty(C_LOCATION);
        this.C_CAPACITY=new SimpleIntegerProperty(C_CAPACITY);
        this.C_MANAGER_ID=new SimpleIntegerProperty(C_MANAGER_ID);
        System.out.println("f");   
    }
//    public Integer getCAMP_ID()
//    {
//        System.out.println("d");
//        return CAMP_ID.getValue();
//    }
//    public  String getC_NAME()
//    {
//        return C_NAME.getValue();
//    }
//    public String getC_LOCATION()
//    {
//        return C_LOCATION.getValue();
//    }
//    public Integer getC_CAPACITY()
//    {
//        return C_CAPACITY.getValue();
//    }
//    public Integer getC_MANAGER_ID()
//    {
//        System.out.println("w   w");
//        return C_MANAGER_ID.getValue();
//    }

    public Integer getCAMP_ID() {
        return CAMP_ID.getValue();
    }

    public String getC_NAME() {
        return C_NAME.getValue();
    }

    public String getC_LOCATION() {
        return C_LOCATION.getValue();
    }

    public Integer getC_CAPACITY() {
        return C_CAPACITY.getValue();
    }

    public Integer getC_MANAGER_ID() {
        return C_MANAGER_ID.getValue();
    }
}
