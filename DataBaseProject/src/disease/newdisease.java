/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disease;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class newdisease {
    private final int did;
    private final int docid;
    private final int rid;
    private final Date detdate;
    
    public newdisease (int ndid, int ndocid, int nrid, Date ndetdate){
        this.did = ndid;
        this.docid = ndocid;
        this.rid = nrid;
        this.detdate = ndetdate;
    }
    
    public int getdid (){
        return did;
    }

    public int getdocid (){
        return docid;
    }
    
    public int getrid (){
        return rid;
    }
    
    public Date getdetdate (){
        return detdate;
    }
    
}
