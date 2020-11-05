
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chayakorn
 */
public class adsfffdd {
    import java.util.Scanner;

 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Student
 */
public class BankApplication {

 

    public static void main(String[] args) {
        Account account1 = null, account2 = null, account3 = null;
        String menuStr = "1. add account \n"
                + "2. edit account \n"
                + "3. show all account \n"
                + "0. exit";
 

        Scanner scn = new Scanner(System.in);
        int select;
        int count = 0;

        
 

        do {
            System.out.println(menuStr);
            System.out.print("Select menu: ");
            select = scn.nextInt();
            //System.out.println(select);
            scn.nextLine();
            switch (select) {
                case 1:
//----------------------------------------------------------------

 

                    switch (count) {
                        case 0:
                            count++;
                            account1 = new Account(getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));

 

                            break;
                        case 1:
                            count++;
                            account2 = new Account(getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));

 

                            break;
                        case 2:
                            count++;
                            account3 = new Account(getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));

 

                            break;
                    }
                    break;

 

//---------------------------------------------------------------------------                    
                case 2:
                    if(account1!=null)
                        account1 = new Account(getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));
                    if(account2!=null)
                        account2 = new Account(getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));
                    if(account3!=null)
                        account3 = new Account (getNameFromKeyboad(scn), getBalanceFromKeyboad(scn));

 

                    break;

 

                case 3:
                    if (account1 != null) {
                        System.out.println(account1);
                    }
                    if (account2 != null) {
                        System.out.println(account2);
                    }
                    if (account3 != null) {
                        System.out.println(account3);
                    }

 

                    break;
            }
        } while (select != 0);
    }

 

    public static String getNameFromKeyboad(Scanner input) {
        System.out.println("Input account name");
        return input.nextLine();
    }

 

    public static double getBalanceFromKeyboad(Scanner input) {
        System.out.println("Input balance");
        return input.nextDouble();
    }

 

}
}
