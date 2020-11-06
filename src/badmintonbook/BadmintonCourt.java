/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.util.Scanner;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 *
 * @author Chayakorn
 */
public class BadmintonCourt {
    	
    private boolean light;
    private boolean bookStatus;
    private String name,CustomerName,TelCustomer;
    private Scanner input= new Scanner(System.in);
    private LocalDateTime time;
    private Clock clock;
//    private StopWatch timer = new StopWatch();


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
    public void bookCourtmember(String name, String tel){
        if(!bookStatus){
            bookStatus = true;
            setName(name);
            setTel(tel);
            
        }
    }
    
    public void checkOutCourt(){
        if(bookStatus){
//            timer.stop();
            bookStatus = false;
            CustomerName = null;
            TelCustomer = null;
            
        }else {
            System.out.println("This Court is Checked out.");
        }
        
    }
//    public String getRemainingtime(int hr){
//        long t = timer.getElapsedTimeSecs();
//        if(t/60/60<hr){
//            long i =hr-t/60/60;
//        return "Your Ramainingtime:" + i;
//    }
//        return "Time out";
//    }

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
        return "Light:" + light + ", bookStatus:" + bookStatus  + ", CustomerName:" + CustomerName + ", TelCustomer:" + TelCustomer ;
    }
    
}
