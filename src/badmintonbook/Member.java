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
    private  String name;
    private  String telnum;
    private Member[] members;
    private int count;

    
    public Member(String name,String telnum){
        this.name=name;
        this.telnum=telnum;
        this.members=new Member[100];

    }
    public String getName(){
        return name;
    }
    public String getTelnum(){
        return telnum;
    }
//    public void register(Scanner input){
//        
//        if(count<members.length){
//            members[count++] = new Member(getNameFromKeyboard(input),getTelNumFromKeyboard(input));
//        }else {
//            Member[] neoMember = new Member[members.length+100];
//            for (int i = 0;i<members.length;i++){
//                neoMember[i]=members[i];
//                members=neoMember;
//                members[count++] = new Member(getNameFromKeyboard(input),getTelNumFromKeyboard(input));
//            }
//        }
//            
//            
//    }
    public Member[] getMembers() {
        return members;
    }
//    public String getNameFromKeyboard(Scanner input){
//        System.out.println("Input name: ");
//        return input.next();
//    }
//    public String getTelNumFromKeyboard(Scanner input){
//        System.out.println("Input Tel: ");
//        return input.next();
//    }

    @Override
    public String toString() {
        return "Name : " + name + "Tel : " + telnum +"\n";
    }
    
    
}
