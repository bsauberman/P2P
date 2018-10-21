/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pfitnessfunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bensauberman
 */
public class P2PFitnessFunction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        //createLenderSales();
        Lender lender = new Lender();
        Borrower[] borrowers = new Borrower[100];
        for(int i = 0; i < 100; i++) {
            borrowers[i] = new Borrower();
        }
        importLendersPast("/Users/bensauberman/Desktop/P2P/lendersPastSales.txt", lender);
        importCurrentBorrowers("/Users/bensauberman/Desktop/P2P/borrowerData.txt", borrowers);     
        printBorrowers(borrowers);
        
        sortBorrowers(lender, borrowers);
        System.out.println("--------------------\n--------------------");
        printBorrowers(borrowers);        
    }
    
    public static void importCurrentBorrowers(String fileDirectory, Borrower[] borrowers) throws FileNotFoundException {
        File f = new File(fileDirectory);
        Scanner fr = new Scanner(f).useDelimiter(",");
        int id = 0;
        while (fr.hasNextLine()) {
                String empStr = fr.next();
                int empNum = Integer.parseInt(empStr);
                String locationStr = fr.next();           
                int locationNum = Integer.parseInt(locationStr);
                String categoryStr = fr.next();
                int categoryNum = Integer.parseInt(categoryStr);
                String moneyRangeStr = fr.next();
                int moneyRangeNum = Integer.parseInt(moneyRangeStr);
                borrowers[id].setAll(empNum, locationNum, categoryNum, moneyRangeNum, id);
                fr.nextLine();
                id++;
        }
    }
    
    
    public static void printBorrowers(Borrower[] borrowers) {
        String[] employment = { "Fully Employed", "Part-Time", "Unemployed", "Discouraged", "Student"}; //0-4
        String[] location = {"United States", "International"};//0-1
        String[] categories= {"Sports / Fitness", "Medical", "Food / Groceries", "Educational", "Transportation", "Other"};//0-6
        String[] moneyRange = {"$1.00 - $9.99", "$10.00 - $99.99", "$100 - $499.99", "$500.00 - $1000.00"}; //0-3
        for(int i = 0; i < borrowers.length; i++) {
            System.out.println("Borrower " + borrowers[i].getID() + ":      ");
            if(borrowers[i].getLenderVal() != 0) {
                System.out.println("     Compatibility With Lender: " + borrowers[i].getLenderVal());
            }
            System.out.println("     Employment: " + employment[borrowers[i].getEmployment()]);
            System.out.println("     Location: " + location[borrowers[i].getLocation()]);
            System.out.println("     Category: " + categories[borrowers[i].getCategory()]);
            System.out.println("     Money Range: " + moneyRange[borrowers[i].getMoneyRange()]);        
        }
    }
    public static void importLendersPast(String fileDirectory, Lender lender) throws FileNotFoundException {       
        File f = new File(fileDirectory);
        Scanner fr = new Scanner(f).useDelimiter(",");
        while (fr.hasNextLine()) {
                String empStr = fr.next();
                int empNum = Integer.parseInt(empStr);
                lender.incEmployment(empNum);
                
                String locationStr = fr.next();           
                int locationNum = Integer.parseInt(locationStr);
                lender.incLocation(locationNum);
                
                String categoryStr = fr.next();
                int categoryNum = Integer.parseInt(categoryStr);
                lender.incCategory(categoryNum);
                
                String moneyRangeStr = fr.next();
                int moneyRangeNum = Integer.parseInt(moneyRangeStr);
                lender.incMoneyRange(moneyRangeNum);
                /*System.out.println(employmentOptions[empNum] + " ");
                System.out.println(location[locationNum] + " ");
                System.out.println(categories[categoryNum] + " ");
                System.out.println(moneyRange[moneyRangeNum] + " ");*/
                fr.nextLine();
        }
    }
    
    public static void createLenderSales() {
        //CREATING FAKE DATA WHICH WILL REPRESENT LENDER'S SALES
        Random rand = new Random();
        Borrower[] borrowers = new Borrower[100];        
        for(int i = 0; i < 100; i++) {
            int emp = rand.nextInt(5);
            int loc = rand.nextInt(2);
            int cat = rand.nextInt(6);
            int mon = rand.nextInt(4);
            System.out.println(emp +"," + loc +"," + cat + "," + mon +",");
            /*Borrower borrower = new Borrower(emp, loc, cat, mon);
            borrowers[i] = borrower;*/
        }       
    }
    
    public static void sortBorrowers(Lender lender, Borrower[] borrowers) {        
        for(int i = 0; i < borrowers.length; i++) {
            int empVal = lender.getEmployment(borrowers[i].getEmployment());
            int locVal = lender.getLocation(borrowers[i].getLocation());
            int catVal = lender.getCategory(borrowers[i].getCategory());
            int monVal = lender.getMoneyRange(borrowers[i].getMoneyRange());
            borrowers[i].setLenderVal(empVal + locVal + catVal + monVal);
        }
        
        for(int i = 0; i < borrowers.length-1; i++) {
            for(int j = i+1; j < borrowers.length; j++) {
                if(borrowers[i].getLenderVal() < borrowers[j].getLenderVal()) {
                   Borrower temp =  borrowers[j];
                   borrowers[j]= borrowers[i];
                   borrowers[i] = temp;            
                }
            }
        }
    }


    
}
          

    

