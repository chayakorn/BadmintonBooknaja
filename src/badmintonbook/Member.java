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



    @Override
    public String toString() {
        return "Name : " + name + "\nTel : " + telnum;
    }

}
