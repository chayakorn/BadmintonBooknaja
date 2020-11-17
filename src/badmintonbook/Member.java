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

    private String name;
    private String telnum;
    private int points;

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

    public void setName(String name) {
        this.name = name;
    }
    public void addPoints(int hr){
        if(hr>2){
            points+=hr*5;
        }
    }
    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Memberstatus { Name: " + name + ", Telephone number: " + telnum +"}";
    }

}
