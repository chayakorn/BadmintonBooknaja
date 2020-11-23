/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook.component;

import java.util.Scanner;

/**
 * This class is Member.
 * @author Student
 */
public class Member {

    private String name;
    private String telnum;
    private int points;

    /**
     * Create a member with name&telnumber.
     * @param name
     * @param telnum
     */
    public Member(String name, String telnum) {
        this.name = name;
        this.telnum = telnum;

    }

    /**
     * Get name of member.
     * @return Name of member.
     */
    public String getName() {
        return name;
    }

    /**
     * Get tel number of member.
     * @return Tel number of member.
     */
    public String getTelnum() {
        return telnum;
    }

    /**
     * Change name of member.
     * @param name This will include old name member.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method will add points for member.
     * @param hr Hour of member booked.
     */
    public void addPoints(int hr){
        if(hr>2){
            points+=hr*5;
        }
    }

    /**
     * Get points of member.
     * @return Points of member.
     */
    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
       return "Memberstatus { Name: " + name + ", Telephone number: " + telnum + ", Points: "+ points;
    }

}
