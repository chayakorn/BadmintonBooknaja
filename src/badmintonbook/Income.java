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
        this.name=name;
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
        return "Contract: { Name: "+name+", Telephone number: "+tel+", Money: "+income+" Bath."+", Times: "+hr+" Hours. }";
    }
    
}
