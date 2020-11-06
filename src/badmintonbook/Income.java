/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

/**
 *
 * @author Student
 */
public class Income {
    private double income;
    private int hr;
    private String name;
    private String tel;
    public Income(double income,int hr,String name,String tel){
        this.income = income;
        this.hr = hr;
//<<<<<<< HEAD
//        this.name = name;
//=======
        this.name=name;
//>>>>>>> cfe8d017522243694af9ff9f9d415fe7f56f936c
        this.tel=tel;
    }
    public double getIncome(){
        return income;
    }
    public int getHr(){
        return hr;
    }

    @Override
    public String toString() {
        return "Contract: {Name: "+name+",Tel: "+tel+",Money: "+income+",Hr: "+hr;
    }
    
}
