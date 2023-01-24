package com.company;

import java.util.Scanner;

public class Main
{
    public static int Input(int bound) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > bound || input < 1) {
                    System.out.println("Select the number between 1 to " + bound);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter Integer Values Only");
                flag = false;
            }
        }
        return input;
    }
    public static void main (String [] args)
    {
        System.out.println("\n\t\tWecome\n");
        System.out.println("1. Register\n2. Exit\n");
        System.out.println("Enter Your Choice : ");
        int ch = Input(2);
        if(ch==1)
        {
            ATM ob = new ATM();
            ob.Register();
            while (true)
            {
                System.out.println("1. Login\n2. Exit\n");
                System.out.println("Enter Your Choice : ");
                int choice = Input(2);
                if(choice ==1)
                {
                    if(ob.Login()){
                        System.out.println("Wekcome Back "+ob.name+"\n");
                        boolean isFinished = false;
                        while(!isFinished)
                        {
                            System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Transaction History\n5.Check Balance\n6 Exit\n");
                            System.out.println("Enter Your Choice : ");
                            int c = Input(6);
                            switch (c){
                                case 1:
                                    ob.deposit();
                                    break;
                                case 2:
                                    ob.withdraw();
                                    break;
                                case 3:
                                    ob.transfer();
                                    break;
                                case 4:
                                    ob.transHistory();
                                    break;
                                case 5:
                                    ob.checkBalance();
                                    break;
                                case 6:
                                    isFinished=true;
                                    break;
                                default:
                                    System.out.println("\n Invalid Choice");
                            }
                        }
                    }
                }else
                    System.exit(0);
            }
        }
    }
}
