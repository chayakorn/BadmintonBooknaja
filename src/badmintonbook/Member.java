/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Member {
    private static String name;
    private static String telnum;

    
    public Member(){
        
    }
    public String getName(){
        return name;
    }
    public String getTelnum(){
        return telnum;
    }
    public void register0(Scanner input){
        System.out.println("Input your Name: ");
        name = input.next();
        System.out.println("Input your Telnumber: ");
        telnum = input.next();
    }
    
    
}
