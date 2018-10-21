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
public class Lender {
    private double totalSales;
            
    private int fullyEmployed;
    private int partTime;
    private int unemployed;
    private int discouraged;
    private int student;
    
    private int US;
    private int international;
    
    private int sports;
    private int medical;
    private int food;
    private int educational;
    private int transportation;
    private int other;
    
    private int range1;
    private int range2;
    private int range3;
    private int range4;

    public Lender() {
        this.totalSales = 0;
        this.educational = 0;
        this.food = 0;
        this.medical = 0;
        this.sports = 0;
        this.international = 0;
        this.US = 0;
        this.fullyEmployed = 0;
        this.partTime = 0;
        this.unemployed = 0;
        this.discouraged = 0;
        this.student = 0;
        this.US = 0;
        this.international = 0;
        this.sports = 0;
        this.medical = 0;
        this.food = 0;
        this.educational = 0;
        this.transportation = 0;
        this.other = 0;
        this.range1 = 0;
        this.range2 = 0;
        this.range3 = 0;
        this.range4 = 0;
    }

    public int getEmployment(int n) {
        switch(n) {
            case 0: return fullyEmployed;
            case 1: return partTime;
            case 2: return unemployed;
            case 3: return discouraged;
            case 4: return student;         
        }  
        return 0;
    }
    
    public int getLocation(int n) {
        switch(n) {
            case 0: return US;
            case 1: return international;    
        }  
        return 0;
    }

    public int getCategory(int n) {
        switch(n) {
            case 0: return sports;
            case 1: return medical;
            case 2: return food;
            case 3: return educational;
            case 4: return transportation;  
            case 5: return other;
        }  
        return 0;
    }
    
    public int getMoneyRange(int n) {
        switch(n) {
            case 0: return range1;
            case 1: return range2;
            case 2: return range3;
            case 3: return range4;
        }  
        return 0;
    }
    
    public void incEmployment(int n) {
        switch(n) {
            case 0: fullyEmployed +=1; break;
            case 1: partTime +=1; break;
            case 2: unemployed +=1; break;
            case 3: discouraged +=1; break;
            case 4: student +=1; break;
        }
    }   
    
        
    public void incLocation(int n) {
        switch(n) {
            case 0: US +=1; break;
            case 1: international +=1; break;
        }
    }   
    
    public void incCategory(int n) {
        switch(n) {
            case 0: sports +=1; break;
            case 1: medical +=1; break;
            case 2: sports +=1; break;
            case 3: food +=1; break;
            case 4: educational +=1; break;
            case 5: transportation +=1; break;
            case 6: other +=1; break;
        }
    }
    
    public void incMoneyRange(int n) {
        switch(n) {
            case 0: range1 +=1; break;
            case 1: range2 +=1; break;
            case 2: range3 +=1; break;
            case 3: range4 +=1; break;
        }
    }
    
    
}


