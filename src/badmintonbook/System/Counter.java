/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook.System;

import badmintonbook.component.BadmintonCourt;
import badmintonbook.component.Member;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * This class is counter service.
 * @author Chayakorn
 */
public class Counter {

    private double MoneyInCounter;
    private int countCustomer = 0;
    private final int CourtCost = 100;
    private final IncomeHistory history;
    private final Scanner input = new Scanner(System.in);
    private final BadmintonCourt[] court = {new BadmintonCourt("1"), new BadmintonCourt("2"), new BadmintonCourt("3"), new BadmintonCourt("4"), new BadmintonCourt("5"), new BadmintonCourt("6"), new BadmintonCourt("7"), new BadmintonCourt("8"), new BadmintonCourt("9"), new BadmintonCourt("10"), new BadmintonCourt("11"), new BadmintonCourt("12")};
    private static Member[] member = new Member[1];
    private int count, hrCustomer,points;
    private String nameCustomer, telCustomer;
    private LocalDateTime timeout;

    /**
     * Create a new Counter with the given money in this counter and set history of income as 0. 
     * @param MoneyInCounter will be money in this counter.
     */
    public Counter(double MoneyInCounter) {
        this.MoneyInCounter = MoneyInCounter;
        this.history = new IncomeHistory(0);

    }

    /**
     * This method will add money in counter.
     * @param money This money will plus old money in counter.
     */
    public void addMoney(double money) {
        MoneyInCounter += money;
    }

    /**
     * This method will ask user for hour to use badminton court and ask for money from customer. If price more than money from customer cancel this queue. Else if money from customer more or equal price this method will book court and give change and create income history .Else cancel queue.
     * @param input This will ask for hour and money from customer.
     */
    public void calculate(Scanner input) {
        System.out.print("Input Customer Hours : ");
        hrCustomer = input.nextInt();
        System.out.print("Input Customer Money : ");
        double moneyFromCustomer = input.nextDouble();
        double price = hrCustomer * CourtCost;
        if (price > moneyFromCustomer) {
            System.out.print("Your Money not Enough.");
        } else if (moneyFromCustomer >= price) {
            double change = moneyFromCustomer - price;
            if (MoneyInCounter > change) {
                book();
                countCustomer++;
                Income income = new Income(price, hrCustomer, nameCustomer, telCustomer);
                history.append(income);
                System.out.println("Change:" + change);
                System.out.println(getCourtStat());
            } else {
                System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
            }
        }
    }

    /**
     * This method will active after login member and will ask user for hour to use badminton court and ask for money from customer. If price more than money from customer cancel this queue. Else if money from customer more or equal price this method will book court for member and give change and create income history and give points to customer.Else cancel queue.
     * @param input This will ask for hour and money from customer.
     */
    public void calculateForMember(Scanner input) {
        System.out.print("Input Customer Hours : ");
        hrCustomer = input.nextInt();
        System.out.print("Input Customer Money : ");
        double moneyFromCustomer = input.nextDouble();
        double price = hrCustomer * CourtCost;
        if (price > moneyFromCustomer) {
            System.out.print("Your Money not Enough.");
        } else if (moneyFromCustomer >= price) {
            double change = moneyFromCustomer - price;
            if (MoneyInCounter > change) {
                bookMember();
                countCustomer++;
                Income income = new Income(price, hrCustomer, nameCustomer, telCustomer);
//                income.setNameTel(nameCustomer, telCustomer);
                history.append(income);
                for(int i  =0;i<member.length;i++){
                    if(telCustomer.equals(member[i].getTelnum())){
                        member[i].addPoints(hrCustomer);
                        break;
                    }
                        }
                
                System.out.println("Change:" + change);
                System.out.println(getCourtStat());

            } else {
                System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
            }
        }
    }

    /**
     * Get money in counter.
     * @return
     */
    public double getMoneyInCounter() {
        return MoneyInCounter;
    }

    /**
     * Get quantity of customer.
     * @return
     */
    public int getCountCustomer() {
        return countCustomer;
    }

    /**
     * Get income history.
     * @return
     */
    public IncomeHistory getHistory() {
        return history;
    }

    /**
     * This method will check every badminton court if court is available will set court booked and set name&tel customer to this court and turn on light and set time out with time now plus hour customer.
     */
    public void book() {
        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourt();
                nameCustomer = court[i].getCustomerName();
                telCustomer = court[i].getTelCustomer();
                court[i].toggleLight();
                timeout = LocalDateTime.now();
                court[i].setTimeout(timeout.plusHours(hrCustomer));
                break;

            }
        }
    }

    /**
     * This method will check e very badminton court if court is available will set court booked and set name%tel customer from member list to this court and turn on light and set time out with time now plus hour customer.
     */
    public void bookMember() {
        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourtmember(nameCustomer, telCustomer);
                court[i].toggleLight();
                timeout = LocalDateTime.now();
                court[i].setTimeout(timeout.plusHours(hrCustomer));
                break;
            }
        }
    }

    /**
     * This method will ask for name%tel Customer use to check court if name%tel equal as court this method will checkout court and turn off the light and show status of every court. 
     */
    public void checkOut() {
        String name = getNameFromKeyboard(input);
        String tel = getTelNumberFromKeyboard(input);

        for (int i = 0; i < court.length; i++) {
            if (name.equals(court[i].getCustomerName()) && tel.equals(court[i].getTelCustomer())) {
                court[i].checkOutCourt();
                court[i].toggleLight();
                System.out.println(getCourtStat());
                break;
            }

        }
    }

    /**
     * Get customer name from keyboard.
     * @param input This will ask for customer name.
     * @return Customer name.
     */
    public String getNameFromKeyboard(Scanner input) {
        System.out.print("input Customer name : ");
        return input.next();
    }

    /**
     * Get Name of customer from keyboard.
     * @param input This input will get customer name from keyboard.
     * @return Customer tel.
     */
    public String getTelNumberFromKeyboard(Scanner input) {
        String ans;
        do{
        System.out.print("input Customer Telephone number : ");
        ans = input.next();
        if(ans.length()!=10)
                System.out.println("Please Try again..");}
        while(ans.length()!=10);
        return ans;
    }

    /**
     * Get every court status.
     * @return Status of every court.
     */
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

    /**
     * login member if tel number equal member.
     * @return Status login.
     */
    public boolean login() {
        System.out.print("Telephone number: ");
        telCustomer = input.next();
        for (int i = 0; i < member.length; i++) {
            if (member[0] == null) {
                break;
            }
            else if (telCustomer.equals(member[i].getTelnum())) {
                nameCustomer = member[i].getName();
                telCustomer = member[i].getTelnum();
                return true;
            }

        }
        return false;
    }

    /**
     * This method will get name&tel from customer to create a new member.if member list full this method will use expand member list and create a new member.
     */
    public void register() {

        if (count < member.length) {
            member[count++] = new Member(getNameFromKeyboard(input), getTelNumberFromKeyboard(input));
        } else {
            expandMember();
        }
        if (count < member.length) {
            member[count++] = new Member(getNameFromKeyboard(input), getTelNumberFromKeyboard(input));
        }
    }

    /**
     * Expand member list.
     */
    public void expandMember() {
        Member[] neoMember = new Member[member.length + 1];
        for (int i = 0; i < member.length; i++) {
            neoMember[i] = member[i];
        }
        member = neoMember;
    }

    /**
     * Show every member.
     * @return
     */
    public String showMembers() {

        String sm = "###Show members###";
        for (int i = 0; i < member.length; i++) {
            sm += "\n" + member[i];
        }
        return sm;
    }

    @Override
    public String toString() {
        return "Counter{" + "MoneyInCounter=" + MoneyInCounter + ", countCustomer=" + countCustomer + ", input=" + input + '}';
    }

}
