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
    private static String name;
    private static String menuGuest = "Guest Menu" + "\n1.Book\n2.Checkout\n0.Exit";
    private static String menu = "Courter\n1.Guest\n2.Member\n3.Register\n0.Exit";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Counter ct = new Counter(10000);

        System.out.println(menu);
        System.out.print("Select menu : ");
        selectMenu = sc.nextInt();

        switch (selectMenu) {
            case 1:
                do {
                    System.out.println(menuGuest);
                    System.out.print("Select menu : ");
                    selectGuest = sc.nextInt();

                    switch (selectGuest) {
                        case 1:
                            ct.calculate(sc);
                            break;

                        case 2:
                            ct.checkOut();
                            System.out.println(ct.getCourtStat());
                    }
                } while (selectGuest != 0);
                break;

            case 2:;
        }
    }

}

