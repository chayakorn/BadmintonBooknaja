/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.util.Scanner;

/**
 *
 * @author Chayakorn
 */
public class BadmintonCourt {
    	
    private boolean light;
    private boolean bookStatus;
    private static String name,CustomerName,TelCustomer = null;
    private Scanner input= new Scanner(System.in);


    public BadmintonCourt(String name) {
        this.name = name;
    }
    public boolean getBookStatus(){
        return bookStatus;
    }
    public String getCustomerName(){
        return CustomerName;
    }
    public String getTelCustomer(){
        return TelCustomer;
    }
    public void setCustomerTel_Name(String telCustomer,String customerName){
        this.CustomerName = customerName;
        this.TelCustomer = telCustomer;
    }
    public void setBookStatus(boolean status){
        this.bookStatus = status;
    }
    public boolean isBookStatusFull(){
        return bookStatus;
    }
    public void toggleLight() {
        light = !light;
    }

    public void bookCourt() {
        if (!bookStatus) {
            bookStatus = true;
            CustomerName= getNameFromKeyboard(input);
            TelCustomer = getTelNumberFromKeyboard(input);
            
        } else {
            System.out.println("This Court is Booked.");
        }

    }
    
    public void checkOutCourt(){
        if(bookStatus){
            bookStatus = false;
            CustomerName = null;
            TelCustomer = null;
        }else {
            System.out.println("This Court is Checked out.");
        }
        
    }

    public String getNameFromKeyboard(Scanner input) {
        System.out.print("input Customer name : ");
        return input.nextLine();
    }

    public String getTelNumberFromKeyboard(Scanner input) {
        System.out.print("input Customer Telephone Number : ");
        return input.nextLine();
    }

    @Override
    public String toString() {
        return "BadmintonCourt:" + "light:" + light + ", bookStatus:" + bookStatus + ", name:" + name + ", CustomerName:" + CustomerName + ", TelCustomer:" + TelCustomer ;
    }
    
}
