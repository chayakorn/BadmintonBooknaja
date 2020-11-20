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

    /**
     *
     * @param name
     * @param telnum
     */
    public Member(String name, String telnum) {
        this.name = name;
        this.telnum = telnum;

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getTelnum() {
        return telnum;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param hr
     */
    public void addPoints(int hr){
        if(hr>2){
            points+=hr*5;
        }
    }

    /**
     *
     * @return
     */
    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
       return "Memberstatus { Name: " + name + ", Telephone number: " + telnum + ", Points: "+ points;
    }

}
