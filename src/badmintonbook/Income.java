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
    public Income(double income,int hr){
        this.income = income;
        this.hr = hr;
    }
    public double getIncome(){
        return income;
    }
    public int getHr(){
        return hr;
    }
    public void setNameTel(String name,String tel){
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Contract/n"+name+"/n"+tel+"/nMoney: "+income+" : "+hr+" hr";
    }
    
}
