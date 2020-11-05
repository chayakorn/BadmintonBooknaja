/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badmintonbook;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Chayakorn
 */
public class Counter {

    private double MoneyInCounter;
    private int countCustomer = 0;
    private final int CourtCost = 100;
    private IncomeHistory history;
    private Scanner input = new Scanner(System.in);
    private StopWatch timer = new StopWatch();
    private BadmintonCourt[] court = {new BadmintonCourt("1"), new BadmintonCourt("2"), new BadmintonCourt("3"), new BadmintonCourt("4"), new BadmintonCourt("5"), new BadmintonCourt("6"), new BadmintonCourt("7"), new BadmintonCourt("8"), new BadmintonCourt("9"), new BadmintonCourt("10"), new BadmintonCourt("11"), new BadmintonCourt("12")};
    private LocalTime time = LocalTime.now();
    private static Member[] member = new Member[1];
    private String menuMem = "1.Book\n2.Checkout";
//<<<<<<< HEAD
////<<<<<<< HEAD
////    private Member[] members;
////=======
////>>>>>>> d2b4a4fc42365b5cf7ae78cb549eaac32cc4ba8f
//=======
//>>>>>>> fc4462349236a69ff72046d382286f59d31aa5f9
    private int count;
    private String nameCustomer;
    private String telCustomer;


    public Counter(double MoneyInCounter) {
        this.MoneyInCounter = MoneyInCounter;
        this.history=new IncomeHistory(0);
        
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
                Income income = new Income(price,hrCustomer);
                income.setNameTel(nameCustomer, telCustomer);
                history.append(income);
                System.out.println("Change:" + change);
                System.out.println(getCourtStat());
            } else {
                System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
            }
        }
    }
    public void calculate4Member(Scanner input) {
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
                Income income = new Income(price,hrCustomer);
                income.setNameTel(nameCustomer, telCustomer);
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

    public void book() {

        for (int i = 0; i < court.length; i++) {
            if (court[i].getBookStatus() == false) {
                court[i].bookCourt();
                court[i].toggleLight();
                court[i].setCustomerName(nameCustomer);
                court[i].setCustomerTel(telCustomer);
//                nameCustomer = court[i].getCustomerName();
//                telCustomer = court[i].getTelCustomer();
                break;

            }

        }
    }
    public void bookMember(){
        for (int i = 0; i< court.length;i++){
            if(court[i].getBookStatus()==false){
                court[i].setBookStatus(true);
                court[i].toggleLight();
                court[i].setCustomerName(nameCustomer);
                court[i].setCustomerTel(telCustomer);
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

//<<<<<<< HEAD
//    public void login() {
//        System.out.print("name :");
//        String name = input.next();
//        System.out.print("tel :");
//        String tel = input.next();
//        for (int i = 0; i < member.length; i++) {
//            if (name.equals(member[i].getName()) && tel.equals(member[i].getTelnum())) {
//                System.out.println(menuMem);
//            }
//            System.out.println("Select menu : ");
//            int menu = input.nextInt();
//
//            switch (menu) {
//                case 1:
//                    System.out.print("Input Customer Hr : ");
//                    int hrCustomer = input.nextInt();
//                    System.out.print("Input Customer Money : ");
//                    double moneyFromCustomer = input.nextDouble();
//                    double price = hrCustomer * CourtCost;
//                    if (price > moneyFromCustomer) {
//                        System.out.print("Your Money not Enough.");
//                    } else if (moneyFromCustomer >= price) {
//                        double change = moneyFromCustomer - price;
//                        if (MoneyInCounter > change) {
//                            book();
//                            countCustomer++;
//                            allIncome += price;
//                            System.out.println("Change:" + change);
//                            System.out.println(getCourtStat());
//                        } else {
//                            System.out.println("Sorry We don't have enough change 💪( ͡❛ 👅 ͡❛҂)");
//                        }
//                    }
//                    break;
//            }
//=======
//    public boolean login() {
//        System.out.println("name :");
//        nameCustomer = input.next();
//        System.out.println("tel :");
//        telCustomer=input.next();
//        for(int i = 0;i<member.length;i++){
//            if(nameCustomer.equals(member[i].getName()) && telCustomer.equals(member[i].getTelnum()))
//                return true;
//>>>>>>> 35637f83a56fc49966392172991a8bac7750d145
//        }
//        return false;
//    }

    public void register() {
//<<<<<<< HEAD
//<<<<<<< HEAD
////<<<<<<< HEAD
////        if(count<members.length){
////            members[count++] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
////        }else {
////            Member[] neoMember = new Member[members.length+100];
////            for (int i = 0;i<members.length;i++){
////                neoMember[i]=members[i];
////                members=neoMember;
////                members[count++] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
////            }
////        }
////        
////=======
//=======
//
//>>>>>>> fc4462349236a69ff72046d382286f59d31aa5f9
        if (count < member.length) {
            member[count++] = new Member(getNameFromKeyboard(input), getTelNumberFromKeyboard(input));
        } else {
            expandMember();
        }
        if (count < member.length) {
            member[count++] = new Member(getNameFromKeyboard(input), getTelNumberFromKeyboard(input));
        }

//        for(int i = 0;i<member.length;i++){
//            if (member[i] == null){
//                member[i] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
//                break;
//            }
//        
//        else{
//                expandMember();
//                member[i+ 1] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
//                break;
//                }
//        for (int i = 0; i < member.length; i++) {
//            if (member[i] == null) {
//                member[i] = new Member();
//                member[i].register0(input);
//                break;
//            } else {
//                expandMember();
//                member[i + 1] = new Member();
//                member[i + 1].register0(input);
//                break;
//            }
//<<<<<<< HEAD
//            if (member[i] != null) {
//                Member[] member1 = new Member[i + 1];
//                for (int j = 0; j < member1.length; i++) {
//                    member1[i] = member[i];
//
//                }
////                member1[i + 1].register0(input);
////                member = member1;
//
//            }
//=======
//<<<<<<< HEAD
////>>>>>>> d2b4a4fc42365b5cf7ae78cb549eaac32cc4ba8f
//=======
//
//>>>>>>> fc4462349236a69ff72046d382286f59d31aa5f9
//        for (int i = 0; i < member.length; i++) {
//            if (member[i] == null) {
//                member[i] = new Member();
//                member[i].register(input);
//                break;
//            } else {
//                expandMember();
//                member[i + 1] = new Member();
//                member[i + 1].register(input);
//                break;
//            }
//<<<<<<< HEAD
////<<<<<<< HEAD
//=======
//
//>>>>>>> fc4462349236a69ff72046d382286f59d31aa5f9
////<<<<<<< HEAD
////            if (member[i] != null) {
////                Member[] member1 = new Member[i + 1];
////                for (int j = 0; j < member1.length; i++) {
////                    member1[i] = member[i];
////
////                }
//////                member1[i + 1].register0(input);
//////                member = member1;
////
////            }
////=======
//
////            if(member[i]!=null){
//////                Member [] member1 = new Member[member.length+1];
//////                for(int j = 0;j<member1.length;i++){
//////                    member[i]=member1[i];
//////                    break;
//////                    
//////                }
//////                member[i].register0(input);
////                
////                
////            }
////>>>>>>> c83d74a0afa53026efca7b149f016e5635567c5d
//<<<<<<< HEAD
////=======
////>>>>>>> c83d74a0afa53026efca7b149f016e5635567c5d
////>>>>>>> d2b4a4fc42365b5cf7ae78cb549eaac32cc4ba8f
//=======
//
////>>>>>>> c83d74a0afa53026efca7b149f016e5635567c5d
//
//>>>>>>> fc4462349236a69ff72046d382286f59d31aa5f9
////        }
//=======

        if(count<member.length){
            member[count++] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
        }else expandMember();
        if(count<member.length){
            member[count++] = new Member(getNameFromKeyboard(input),getTelNumberFromKeyboard(input));
        }    
//>>>>>>> 19051724224771505ccd3d5f5f4aed43fa49275f
    }

    public void expandMember() {
        Member[] neoMember = new Member[member.length + 1];
        for (int i = 0; i < member.length; i++) {
            neoMember[i] = member[i];
        }
        member = neoMember;
    }
//<<<<<<< HEAD
//        Member[] m = new Member[member.length + 1];
//        for (int i = 0; i < member.length; i++) {
//            m[i] = member[i];
//            
//        }
//        member = m;
//    }

//    public String showMembers() {
//=======
    
    public String showMembers(){
//>>>>>>> 19051724224771505ccd3d5f5f4aed43fa49275f
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

    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Counter n = new Counter(300);
        n.addMoney(5000);
        System.out.println(n);
        n.calculate(a);

        System.out.println(n.getCourtStat());
        n.checkOut();
        System.out.println(n.getCourtStat());

//        n.addMoney(5000);
        System.out.println(n);
        n.calculate(a);

        System.out.println(n.getCourtStat());
        n.calculate(a);

        System.out.println(n.getCourtStat());
        n.calculate(a);

        System.out.println(n.getCourtStat());


    }
}
