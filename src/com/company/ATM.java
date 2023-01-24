package com.company;

import java.util.Scanner;

public class ATM {

    String name, username, pw, accNo, history="";
    double bal = 200000;
    int transactions = 0;

    public void Register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name : ");
        this.name = sc.nextLine();
        System.out.print("\nUser Name : ");
        this.username = sc.nextLine();
        System.out.print("\nPassword : ");
        this.pw = sc.nextLine();
        System.out.print("\nAccount Number : ");
        this.accNo = sc.nextLine();
        System.out.print("Registration Completed Successfully!\n");
    }

    public boolean Login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("Username : ");
            String UserName = sc.nextLine();
            if (UserName.equals(username)) {
                while (!isLogin) {
                    System.out.print("\nPassword : ");
                    String PW = sc.nextLine();
                    if (PW.equals(pw)) {
                        System.out.println("Login Successful\n");
                        isLogin = true;
                    } else {
                        System.out.println("Incorrect Password\n");
                    }
                }
            } else {
                System.out.println("Invalid Username\n");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("Enter Amount To Be Withdrawn : ");
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextDouble();
        try {
            if (bal >= amt) {
                transactions++;
                bal -= amt;
                System.out.println("Withdrawal Successful\n");
                String str = "Rs " + amt + " Withdrawn\n";
                history = history + str;
            } else
                System.out.println("Insufficient Balance\n");
        } catch (Exception e) {

        }
    }

    public void deposit() {
        System.out.println("Enter Amount To Be Deposited : ");
        Scanner sc = new Scanner(System.in);
        double amt = sc.nextDouble();
        try {
            if (amt <= 100000.00) {
                transactions++;
                bal += amt;
                System.out.println("Deposit Successful\n");
                String str = "Rs " + amt + " Deposited\n";
                history += str;
            } else {
                System.out.println("Limit Exceeded\n");
            }
        } catch (Exception e) {
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Recipient Name : ");
        String recip = sc.nextLine();
        System.out.println("Enter Amount To Be Transferred : ");
        double amt = sc.nextDouble();
        try {
            if (bal >= amt) {
                if (amt <= 50000.00) {
                    transactions++;
                    bal -= amt;
                    System.out.println("Transfer Successful\n");
                    String str = "Rs " + amt + " Transfered to " + recip;
                    history += str;
                } else {
                    System.out.println("Limit Exceeded\n");
                }
            } else {
                System.out.println("Limit Exceeded\n");
            }
        } catch (Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("Rs " + bal);
    }

    public void transHistory() {
        if (transactions == 0)
            System.out.println("Empty\n");
        else
            System.out.println("\n" + history);
    }
}
