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
    	
    private boolean light; //variable status of light
    private boolean bookStatus; //variable status of courtstatusbook
    private String name,CustomerName,TelCustomer; // variable courtname,Customrename,numbercustomer
    private Scanner input= new Scanner(System.in);
    private LocalDateTime timeout;
    private Clock clock;

    /**
     * Creates a new BadmintonCourt with the given name.
     * @param name
     */
    public BadmintonCourt(String name) {
        this.name = name;
    }

    /**
     * Get the StatusCourt.
     * @return
     */
    public boolean getBookStatus(){
        return bookStatus;
    }

    /**
     * Get the name of Customer.
     * @return
     */
    public String getCustomerName(){
        return CustomerName;
    }

    /**
     * Get the Customer Telnumber.
     * @return
     */
    public String getTelCustomer(){
        return TelCustomer;
    }

    /**
     * Changes the Status of court 
     * @param status This new Status Should include the old status.
     */
    public void setBookStatus(boolean status){
        this.bookStatus = status;
    }

    /**
     * Get Status of the court.
     * @return
     */
    public boolean isBookStatusFull(){
        return bookStatus;
    }

    /**
     * This method use to Switch light On/Off.
     */
    public void toggleLight() {
        String on = "On";
        String off= "Off";
        light = !light;
        if(!light){;
        }
    }

    /**
     * If this court available. This method will change status of court to booked and set Customer name&tel as input from keyboard else this method will print This court is booked.
     */
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

    /**
     *
     * @param name
     * @param tel
     */
    public void bookCourtmember(String name, String tel){
        if(!bookStatus){
            bookStatus = true;
            setName(name);
            setTel(tel);
        }
    }
    
    /**
     *
     */
    public void checkOutCourt(){
        if(bookStatus){
//            timer.stop();
            bookStatus = false;
            CustomerName = null;
            TelCustomer = null;
            timeout = null;
            
        }else {
            System.out.println("This Court is Checked out.");
        }
        
    }

    /**
     *
     * @param input
     * @return
     */
    public String getNameFromKeyboard(Scanner input) {
        System.out.print("input Customer name : ");
        return input.nextLine();
    }

    /**
     *
     * @param input
     * @return
     */
    public String getTelNumberFromKeyboard(Scanner input) {
        String ans;
        do{
        System.out.print("input Customer Telephone number : ");
        ans = input.next();
        if(ans.length()!=10)
                System.out.println("Please Try again.");}
        while(ans.length()!=10);
        return ans;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.CustomerName = name;
    }
    
    /**
     *
     * @param tel
     */
    public void setTel(String tel) {
        this.TelCustomer = tel;
    }

    /**
     *
     * @param t
     */
    public void setTimeout(LocalDateTime t){
        this.timeout = t;
    }

    @Override
    public String toString() {
        if (CustomerName == null) {
                return "Light:" + "Off" + ", Booked:" + "No" + ", CustomerName:" + "none" + ", TelCustomer:" + "none" + ", Timeout: " + "none";

            } else {
                return "Light:" + "On" + ", Booked:" + "Yes" + ", CustomerName:" + CustomerName + ", TelCustomer:" + TelCustomer + ", Timeout: " + timeout;

            }
    }
    
}
