/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NewEntry;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author USER
 */
public class newentrytable {

    static void add(newentrytable newentrytable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private final SimpleStringProperty newentrytablerid;
    private final SimpleStringProperty newentrytablecid;
    private final SimpleStringProperty newentrytablefname;
    private final SimpleStringProperty newentrytablelname;
    private final SimpleStringProperty newentrytableage;
    private final SimpleStringProperty newentrytableadd;
    private final SimpleStringProperty newentrytableguard;
    private final SimpleStringProperty newentrytabledate;
    private final SimpleStringProperty newentrytableemp;
    private final SimpleStringProperty newentrytablegen;
    
    public newentrytable(String newentrytablerid,String newentrytablecid,String newentrytablefname,String newentrytablelname,
            String newentrytableage,String newentrytableadd,String newentrytableguard,String newentrytabledate,String newentrytableemp,String newentrytablegen){
    this.newentrytablerid= new SimpleStringProperty (newentrytablerid);
    this.newentrytablecid= new SimpleStringProperty (newentrytablecid);
    this.newentrytablefname= new SimpleStringProperty (newentrytablefname);
    this.newentrytablelname= new SimpleStringProperty (newentrytablelname);
    this.newentrytableage= new SimpleStringProperty (newentrytableage);
    this.newentrytableadd= new SimpleStringProperty (newentrytableadd);
    this.newentrytableguard= new SimpleStringProperty (newentrytableguard);
    this.newentrytabledate= new SimpleStringProperty (newentrytabledate);
    this.newentrytableemp= new SimpleStringProperty (newentrytableemp);
    this.newentrytablegen= new SimpleStringProperty (newentrytablegen);
        
    }

    newentrytable(String string, String string0, int aInt, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public SimpleStringProperty NewentrytableridP() {
        return newentrytablerid;
    }

    public SimpleStringProperty NewentrytablecidP() {
        return newentrytablecid;
    }

    public SimpleStringProperty NewentrytablefnameP() {
        return newentrytablefname;
    }

    public SimpleStringProperty NewentrytablelnameP() {
        return newentrytablelname;
    }

    public SimpleStringProperty NewentrytableageP() {
        return newentrytableage;
    }

    public SimpleStringProperty NewentrytableaddP() {
        return newentrytableadd;
    }

    public SimpleStringProperty NewentrytableguardP() {
        return newentrytableguard;
    }

    public SimpleStringProperty NewentrytabledateP() {
        return newentrytabledate;
    }

    public SimpleStringProperty NewentrytableempP() {
        return newentrytableemp;
    }

    public SimpleStringProperty NewentrytablegenP() {
        return newentrytablegen;
    }
    
    public String getNewentrytablerid() {
        return newentrytablerid.get();
    }

    public String getNewentrytablecid() {
        return newentrytablecid.get();
    }

    public String getNewentrytablefname() {
        return newentrytablefname.get();
    }

    public String getNewentrytablelname() {
        return newentrytablelname.get();
    }

    public String getNewentrytableage() {
        return newentrytableage.get();
    }

    public String getNewentrytableadd() {
        return newentrytableadd.get();
    }

    public String getNewentrytableguard() {
        return newentrytableguard.get();
    }

    public String getNewentrytabledate() {
        return newentrytabledate.get();
    }

    public String getNewentrytableemp() {
        return newentrytableemp.get();
    }

    public String getNewentrytablegen() {
        return newentrytablegen.get();
    }

    
    
    
    public void setNewentrytablerid(String newentrytablerid) {
        this.newentrytablerid.set(newentrytablerid);
    }

    public void setNewentrytablecid(String newentrytablecid) {
        this.newentrytablecid.set(newentrytablecid);
    }

    public void setNewentrytablefname(String newentrytablefname) {
        this.newentrytablefname.set(newentrytablefname);
    }

    public void setNewentrytablelname(String newentrytablelname) {
        this.newentrytablelname.set(newentrytablelname);
    }

    public void setNewentrytableage(String newentrytableage) {
        this.newentrytableage.set(newentrytableage);
    }

    public void setNewentrytableadd(String newentrytableadd) {
        this.newentrytableadd.set(newentrytableadd);
    }

    public void setNewentrytableguard(String newentrytableguard) {
        this.newentrytableguard.set(newentrytableguard);
    }

    public void setNewentrytabledate(String newentrytabledate) {
        this.newentrytabledate.set(newentrytabledate);
    }

    public void setNewentrytableemp(String newentrytableemp) {
        this.newentrytableemp.set(newentrytableemp);
    }

    public void setNewentrytablegen(String newentrytablegen) {
        this.newentrytablegen.set(newentrytablegen);
    }
}
