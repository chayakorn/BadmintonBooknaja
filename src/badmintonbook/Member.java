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
<<<<<<< HEAD
    private  String name;
    private  String telnum;
    private  int points;
=======
>>>>>>> c350a747c68b4b35f3a19ca75853c3a8c60a9db2


    private String name;
    private String telnum;

    public Member(String name, String telnum) {
        this.name = name;
        this.telnum = telnum;


    }

    public String getName() {
        return name;
    }

    public String getTelnum() {
        return telnum;
    }
<<<<<<< HEAD
    public int getPoints(){
        return points;
    }
    public void register0(Scanner input){
        System.out.println("Input your Name: ");
        name = input.next();
        System.out.println("Input your Telnumber: ");
        telnum = input.next();
    }
    public void addPoints(int hr){
        points+=hr*5;
    }

    @Override
    public String toString() {
        return "Member: " + name + ", Telnumber: " + telnum + ", Points:" + points;
    }

    
    
=======



    @Override
    public String toString() {
        return "Memberstatus { Name: " + name + ", Tel: " + telnum +"}";
    }

>>>>>>> c350a747c68b4b35f3a19ca75853c3a8c60a9db2
}
