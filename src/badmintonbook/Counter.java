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

    public Counter(double MoneyInCounter) {
        this.MoneyInCounter = MoneyInCounter;
    }

    public void addMoney(double money) {
        MoneyInCounter += money;
    }

    public void calculate(Scanner input) {
        System.out.print("Input Customer Hr : ");
        int hrCustomer = input.nextInt();
        System.out.print("Input Customer Money :");
        double moneyFromCustomer = input.nextDouble();
        double price = hrCustomer * CourtCost;
        if (price > moneyFromCustomer) {
            System.out.print("Your Money not Enough");
        } else if (moneyFromCustomer >= price) {
            double change = moneyFromCustomer - price;
            if (MoneyInCounter > change) {
                book();
                countCustomer++;
                allIncome += price;
                System.out.println("Change:" + change);
                System.out.println(getCourtStat());
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
        System.out.print("input Customer name : ");
        return input.nextLine();
    }

    public String getTelNumberFromKeyboard(Scanner input) {
        System.out.print("input Customer Telephone Number : ");
        return input.nextLine();
    }

    public String getCourtStat() {
        return "\nCourt 1:" + court[0].toString()
                + " \nCourt 2:" + court[1].toString()
                + " \nCourt 3:" + court[2].toString()
                + " \nCourt 4:" + court[3].toString()
                + " \nCourt 5:" + court[4].toString()
                + " \nCourt 6:" + court[5].toString()
                + " \nCourt 7:" + court[6].toString()
                + " \nCourt 8:" + court[7].toString()
                + " \nCourt 9:" + court[8].toString()
                + " \nCourt 10:" + court[9].toString()
                + " \nCourt 11:" + court[10].toString()
                + " \nCourt 12:" + court[11].toString();
    }

    @Override
    public String toString() {
        return "Counter{" + "MoneyInCounter=" + MoneyInCounter + ", countCustomer=" + countCustomer + ", allIncome=" + allIncome + ", input=" + input + '}';
    }

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Counter n = new Counter(300);
        n.addMoney(5000);
        System.out.println(n);
        n.calculate(a);

        System.out.println(n.getCourtStat());
        n.checkOut();
        System.out.println(n.getCourtStat());
        
    }

}
