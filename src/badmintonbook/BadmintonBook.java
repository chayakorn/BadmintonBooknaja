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
public class BadmintonBook {

    private static int selectGuest;
    private static int selectMenu;
    private static String memTel;
    private static String name;
    private static String menu = "\n####Menu####" + "\n1.Book\n\n0.Back";
    private static String mainMenu = "\n####Counter####\n\n1.Book as Guest\n2.Book as Member\n3.Register\n4.Checkout\n5.Check courts status\n6.Check Members\n\n0.Exit";
    private static String startProg = "Do you want to started program?(Yes or No) : ";
    private static String start;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Counter ct = new Counter(10000);

//        do {
//            System.out.println(startProg);
//            start = sc.next();

            do {
                System.out.println(mainMenu);
                System.out.print("\nSelect menu : ");
                selectMenu = sc.nextInt();

                switch (selectMenu) {
                    case 1:
                        ct.calculate(sc);
                        break;

                    case 2:
                        if (ct.login() == true) {
                            ct.calculateForMember(sc);
                        }
                        break;
                    case 3:
                        ct.register();
                        break;
                    case 4:
                        ct.checkOut();
                        break;
                    case 5:
                        System.out.print(ct.getCourtStat());
                        break;

//<<<<<<< HEAD
                    case 6:
                        System.out.print(ct.showMembers());
                        break;
                }

            } while (selectMenu != 0);
//=======
//                    
//                    }break;
//
//                case 2:
//                    if(ct.login()==true){
//                        ct.calculate4Member(sc);
//                    }else System.out.println("");
//                    break;
//                case 3:                    ct.register();
//                    break;
//                case 4:
//                    System.out.print(ct.getCourtStat());
//                    break;
//>>>>>>> 3da03fc1c322ae36a4c79a4c83dd77a714706343

//        } while (start != 0);

    }
}
