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
    private static String menu = "\n####Menu####" + "\n1.Book\n2.Checkout\n\n0.Back";
    private static String mainMenu = "\n####Counter####\n\n1.Guest\n2.Member\n3.Register\n\4.Check courts status\n\n0.Exit";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Counter ct = new Counter(10000);
        Member m = new Member();
        do {
            System.out.println(mainMenu);
            System.out.print("\nSelect menu : ");
            selectMenu = sc.nextInt();

            switch (selectMenu) {
                case 1:
                    System.out.println(menu);
                    System.out.print("\nSelect menu : ");
                    selectGuest = sc.nextInt();

                    switch (selectGuest) {
                        case 1:
                            ct.calculate(sc);
                            break;

                        case 2:
                            ct.checkOut();
                            break;

                    }

                case 2:
                    break;
                    
                case 3:
                    ct.register();
                    break;
                    
                case 4:
                    System.out.print(ct.getCourtStat());
                    break;

            }
        } while (selectMenu != 0);

    }

}
