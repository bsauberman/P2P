/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pfitnessfunction;

/**
 *
 * @author bensauberman
 */
public class Borrower {
    private int employment = 0;
    private int location = 0;
    private int category = 0;
    private int moneyRange = 0;
    private int lenderVal;
    private int id;
    
    Borrower() {
        this.moneyRange = 0;
        this.employment = 0;
        this.location = 0;
        this.category = 0;
        this.moneyRange = 0;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public void setEmployment(int e) {
        employment = e;
    }    
    public void setAll(int e, int l, int c, int m, int id) {
        employment = e;
        location = l;
        category = c;
        moneyRange = m;
        this.id = id;
    }
    
    public int getEmployment() {
        return employment;
    }
    
    public int getLocation() {
        return location;
    }
    
    public int getCategory() {
        return category;
    }
    
    public int getMoneyRange() {
        return moneyRange;
    }
    
    public void setLenderVal(int lv) {
        lenderVal = lv;
    }
    
    public int getLenderVal() {
        return lenderVal;
    }
}
