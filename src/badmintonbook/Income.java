/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

/**
 * This class is income from customer.
 * @author Student
 */
public class Income {
    private double income;
    private int hr;
    private String name;
    private String tel;

    /**
     * Create a new Income history with income customer name&tel and hour customer book.
     * @param income Income from customer.
     * @param hr Hour customer book.
     * @param name Name of customer.
     * @param tel Tel of customer.
     */
    public Income(double income,int hr,String name,String tel){
        this.income = income;
        this.hr = hr;
        this.name=name;
        this.tel=tel;
    }

    /**
     * Get the income.
     * @return
     */
    public double getIncome(){
        return income;
    }

    /**
     * Get hour of customer book.
     * @return
     */
    public int getHr(){
        return hr;
    }

    @Override
    public String toString() {
        return "Contract: { Name: "+name+", Telephone number: "+tel+", Money: "+income+" Bath."+", Times: "+hr+" Hours. }";
    }
    
}
