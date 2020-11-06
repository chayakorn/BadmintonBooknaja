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
public class IncomeHistory {
    private final Income[] history;
    private int count=0;
    
    public IncomeHistory(int size){
        history = new Income[size>0 ? size:50];
        
    }

    public IncomeHistory append(Income earning){
        if(count<history.length){
//<<<<<<< HEAD
//            
//            history[count] = earning;
//=======
            history[count]=earning;
//>>>>>>> cfe8d017522243694af9ff9f9d415fe7f56f936c
            count++;
            return this;
        }
        return null;
    }
    public double getAllincome(){
        double allIncome = 0;
        for(int i = 0 ;i<count;i++){
            allIncome+=history[i].getIncome();
        }
        return allIncome;
    }

    @Override
    public String toString() {
        String p ="List of Income";
        for(int i = 0;i<count;i++){
            p+="\n"+history[i];
        }
        return p+"\nTotal Earning: " + getAllincome();
    }
    
}
