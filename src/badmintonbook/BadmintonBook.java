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
    private static String mainMenu = "\n####Counter####\n\n1.Book as Guest\n2.Book as Member\n3.Register\n4.Checkout\n5.Check courts status\n6.Check Members\n7.History\n\n0.Exit";
    private static String startProg = "Do you want to started program?(Yes or No) : ";
    private static int start;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Counter ct = new Counter(10000);

        System.out.print("Do you want to started program? (Yes[1] or No[0]) : ");
        start = sc.nextInt();

            switch (start) {
                case 1:
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
                            case 6:
                                System.out.print(ct.showMembers());
                                break;
                            case 7:
                                System.out.println(ct.getHistory());
                        }

                    } while (selectMenu != 0);
            }
    }
}
