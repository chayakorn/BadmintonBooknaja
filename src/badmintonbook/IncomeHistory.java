/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

/**
 * This class is History of income.
 * @author Student
 */
public class IncomeHistory {
    private final Income[] history;
    private int count=0;
    
    /**
     * Create history of income with size. if size equal 0 will set history size equal 50.
     * @param size Size of history income.
     */
    public IncomeHistory(int size){
        history = new Income[size>0 ? size:50];
        
    }

    /**
     * Receive income and keep in history.
     * @param earning Income of customer.
     * @return History with earning.
     */
    public IncomeHistory append(Income earning){
        if(count<history.length){
            history[count]=earning;
            count++;
            return this;
        }
        return null;
    }

    /**
     * Get all income.
     * @return All income.
     */
    public double getAllincome(){
        double allIncome = 0;
        for(int i = 0 ;i<count;i++){
            allIncome+=history[i].getIncome();
        }
        return allIncome;
    }

    @Override
    public String toString() {
        String p ="###List of Income###\n";
        for(int i = 0;i<count;i++){
            p+="\n"+history[i];
        }
        return p+"\n\nTotal Earning: " + getAllincome();
    }
    
}
