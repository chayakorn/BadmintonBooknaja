/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.util.Scanner;

/**
 *
 * @author Chayakorn
 */
public class Counter {

    private double MoneyInCounter;
    private int countCustomer = 0;
    private int CourtCost = 100;
    private double allIncome;
    private double allIncomeever[] = new double[100];
    private Scanner input = new Scanner(System.in);
    private StopWatch timer = new StopWatch();
    private BadmintonCourt[] court = {new BadmintonCourt("1"), new BadmintonCourt("2"), new BadmintonCourt("3"), new BadmintonCourt("4"), new BadmintonCourt("5"), new BadmintonCourt("6"), new BadmintonCourt("7"), new BadmintonCourt("8"), new BadmintonCourt("9"), new BadmintonCourt("10"), new BadmintonCourt("11"), new BadmintonCourt("12")};
    private Member[] member = new Member[1];
    private Member a = new Member();
    
    public Counter(double MoneyInCounter) {
        this.MoneyInCounter = MoneyInCounter;
    }

    public void addMoney(double money) {
        MoneyInCounter += money;
    }

    public void calculate(Scanner input) {
        System.out.println("Intput Customer Hr: ");
        int hrCustomer = input.nextInt();
        System.out.println("Input Customer Money:");
        double moneyFromCustomer = input.nextDouble();
        double price = hrCustomer * CourtCost;
        if (price > moneyFromCustomer) {
            System.out.println("Your Money not Enough");
        } else if (moneyFromCustomer >= price) {
            double change = moneyFromCustomer - price;
            if (MoneyInCounter > change) {
                book();
                countCustomer++;
                allIncome += price;
                System.out.println("Change:" + change);
            } else {
                System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
            }
        }
    }

    public double getMoneyInCounter() {
        return MoneyInCounter;
    }

    public double getAllIncome() {
        return allIncome;

    }

    public int getCountCustomer() {
        return countCustomer;
    }

    public void Topoff() {
        double[] allIncomeeverV_2 = new double[allIncomeever.length + 100];
        for (int i = 0; i < allIncomeever.length; i++) {
            if (i > allIncomeever.length) {
                for (int k = 0; k < allIncomeeverV_2.length; k++) {
                    allIncomeeverV_2[k] = allIncomeever[k];
                }
                allIncomeever = allIncomeeverV_2;
            }

            allIncomeever[i] = allIncome;
        }
    }

    public void book() {

        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourt();
                court[i].toggleLight();
                break;

            }
            
        }
    }

    public void checkOut() {
        String name =getNameFromKeyboard(input);
        String tel = getTelNumberFromKeyboard(input);
//        for(int i = 0 ; i < court.length;i++){
//            if(court[i].getCustomerName()==name && court[i].getTelCustomer()==tel){
//                court[i].reset();
//                
//                break;
//            }
//        }
        for (int i = 0; i < court.length; i++) {
            if (name.equals(court[i].getCustomerName()) && tel.equals(court[i].getTelCustomer())) {
                court[i].checkOutCourt();
                court[i].toggleLight();
                break;

            }
            
        }
            
    }

    public String getNameFromKeyboard(Scanner input) {
        System.out.print("input Customer name:");
        return input.nextLine();
    }

    public String getTelNumberFromKeyboard(Scanner input) {
        System.out.print("input Customer Telephone Number:");
        return input.nextLine();
    }

    public String getCourtStat() {
        return "Court 1:" + court[0].toString()
                + " Court 2:" + court[1].toString()
                + " Court 3:" + court[2].toString()
                + " Court 4:" + court[3].toString()
                + " Court 5:" + court[4].toString()
                + " Court 6:" + court[5].toString()
                + " Court 7:" + court[6].toString()
                + " Court 8:" + court[7].toString()
                + " Court 9:" + court[8].toString()
                + " Court 10:" + court[9].toString()
                + " Court 11:" + court[10].toString()
                + " Court 12:" + court[11].toString();
    }
    public void login(){
        
    }
    public void register(){
        
        for(int i = 0;i<member.length;i++){
            if(member[i]==null){
                member[i] = new Member();
                member[i].register0(input);
                break;
            }
            if(member[i]!=null){
                Member [] member1 = new Member[i+1];
                for(int j = 0;j<member1.length;i++){
                    member1[i]=member[i];
                    
                }
                member1[i+1].register0(input);
                member=member1;
                
            }
        }
    }

    @Override
    public String toString() {
        return "Counter{" + "MoneyInCounter=" + MoneyInCounter + ", countCustomer=" + countCustomer + ", allIncome=" + allIncome + ", input=" + input + '}';
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Counter n = new Counter(300);
//        n.addMoney(5000);
//        System.out.println(n);
//        n.calculate(a);
//
//        System.out.println(n.getCourtStat());
//        n.checkOut();
//        System.out.println(n.getCourtStat());
        n.register();
        
    }

}
