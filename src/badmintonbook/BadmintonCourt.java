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
    private String name,CustomerName,TelCustomer;
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
//    public void setCustomerName(String customerName){
//        this.CustomerName = customerName;
//    }
//    public void setCustomerTel(String customerTel){
//        this.TelCustomer = customerTel;
//    } 
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
            String name = getNameFromKeyboard(input);
            String tel = getTelNumberFromKeyboard(input);
            setName(name);
            setTel(tel);
        } else {
            System.out.println("This Court is Booked.");
        }

    }
    public void bookCourtmember(){
        if(!bookStatus){
            bookStatus = true;
            
            
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
    
    public void setName(String name) {
        this.CustomerName = name;
    }
    
    public void setTel(String tel) {
        this.TelCustomer = tel;
    }

    @Override
    public String toString() {
        return "BadmintonCourt:" + "light:" + light + ", bookStatus:" + bookStatus  + ", CustomerName:" + CustomerName + ", TelCustomer:" + TelCustomer ;
    }
    
}
