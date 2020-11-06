/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Chayakorn
 */
public class Counter {

    private double MoneyInCounter;
    private int countCustomer = 0;
    private int CourtCost = 100;
    private IncomeHistory history;
    private Scanner input = new Scanner(System.in);
    private BadmintonCourt[] court = {new BadmintonCourt("1"), new BadmintonCourt("2"), new BadmintonCourt("3"), new BadmintonCourt("4"), new BadmintonCourt("5"), new BadmintonCourt("6"), new BadmintonCourt("7"), new BadmintonCourt("8"), new BadmintonCourt("9"), new BadmintonCourt("10"), new BadmintonCourt("11"), new BadmintonCourt("12")};
    private LocalTime time = LocalTime.now();
    private static Member[] member = new Member[1];
    private String menuMem = "1.Book\n2.Checkout";
    private int count;
    private String nameCustomer;
    private String telCustomer;
    private String nameCourt;
    private String telCourt;

    public Counter(double MoneyInCounter) {
        this.MoneyInCounter = MoneyInCounter;
        this.history = new IncomeHistory(0);

    }

    public void addMoney(double money) {
        MoneyInCounter += money;
    }

    public void calculate(Scanner input) {
        System.out.print("Input Customer Hr : ");
        int hrCustomer = input.nextInt();
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
                Income income = new Income(price, hrCustomer,nameCourt,telCourt);
//                income.setNameTel(nameCustomer, telCustomer);
                history.append(income);
                System.out.println("Change:" + change);
                System.out.println(getCourtStat());
            } else {
                System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
            }
        }
    }

    public void calculateForMember(Scanner input) {
        System.out.print("Input Customer Hr : ");
        int hrCustomer = input.nextInt();
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
                Income income = new Income(price, hrCustomer,nameCustomer,telCustomer);
//                income.setNameTel(nameCustomer, telCustomer);
                history.append(income);
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
        return history.getAllincome();

    }

    public int getCountCustomer() {
        return countCustomer;
    }

    public IncomeHistory getHistory() {
        return history;
    }

    public void book() {
        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourt();
                court[i].toggleLight();
                nameCourt = court[i].getCustomerName();
                telCourt = court[i].getTelCustomer();
                break;

            }
        }
    }

    public void bookMember() {
        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourtmember(nameCustomer, telCustomer);
                court[i].toggleLight();
                break;
            }
        }
    }

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

    public String getNameFromKeyboard(Scanner input) {
        System.out.print("input Customer name : ");
        return input.next();
    }

    public String getTelNumberFromKeyboard(Scanner input) {
        System.out.print("input Customer Telephone Number : ");
        return input.next();
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

    public boolean login() {
        System.out.print("Tel: ");
        telCustomer = input.next();
        for (int i = 0; i < member.length; i++) {
            if (member[0] == null) {
                System.out.println("Didn't register.");
                break;
            }
            if (telCustomer.equals(member[i].getTelnum())) {
                nameCustomer = member[i].getName();
                telCustomer = member[i].getTelnum();
                return true;
            } else {
                System.out.println("Tel Incorrect or didn't register.");
            }
        }
        return false;
    }

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

    public void expandMember() {
        Member[] neoMember = new Member[member.length + 1];
        for (int i = 0; i < member.length; i++) {
            neoMember[i] = member[i];
        }
        member = neoMember;
    }

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
