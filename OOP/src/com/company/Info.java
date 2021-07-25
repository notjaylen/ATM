package com.company;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Info {

    int idNum;
    String firstName;
    String lastName;
    int phoneNumber;
    String userName;
    String passWord;
    int Balance = 100000;



    //Login Verification

    public static void Login(Info[] users, int userNum) throws InterruptedException
    {

        String userNameEntered;
        String passwordEntered;
        boolean u = false;
        boolean pw = false;
        Scanner sc = new Scanner(System.in);

        while ((!u) || (!pw)) {
            System.out.println("Login ");
            System.out.print("Username: ");
            userNameEntered = sc.next();
            System.out.print("Password: ");
            passwordEntered = sc.next();

            u = users[userNum].checkUser(userNameEntered);
            pw = users[userNum].checkPassWord(passwordEntered);
            Loading();


            if ((!u) || (!pw)) {
                System.out.println("Username and/or Password incorrect. Try Again.");
            }
        }
    }

    public boolean checkUser(String entered)
    {

        return entered.equals(userName);


    }



    public boolean checkPassWord(String entered)
    {

        return entered.equals(passWord);


    }

    ///__________________________________________________________________________

    public static void Loading() throws InterruptedException {
        System.out.println("Loading...");
        TimeUnit.SECONDS.sleep(2);
    }



    public boolean balanceCheck(int num)
    {

        return Balance >= num;
    }


    public static void Menu(Info user) throws InterruptedException {
        int menuChoice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, " + user.firstName + " " + user.lastName);



        do {
            System.out.print("Menu\n1: Info\n" + "2: View Balance\n" + "3: Withdraw\n" + "4: Deposit\n" + "0: Exit\n");
            System.out.print("Enter Number: ");
            menuChoice = sc.nextInt();


            switch (menuChoice) {
                case 0:
                    System.out.print("Exiting.");
                    System.exit(0);
                    break;

                case 1:
                    showInfo(user);
                    break;

                case 2:
                    Loading();
                    System.out.println("Balance: " + user.getBalance());
                    break;

                case 3:
                    user.withdraw(user);
                    break;

                case 4:
                    user.deposit(user);
                    break;

                default:

            }

            System.out.print("*\n*\n*\n");
        } while(menuChoice != 0);

    }


    public void withdraw(Info user) throws InterruptedException {
        int withdrawAmount;
        Scanner sc = new Scanner(System.in);
        System.out.print("Balance: " + user.getBalance() + "\nWithdraw Amount: ");
        withdrawAmount = sc.nextInt();
        Loading();
        boolean check = user.balanceCheck(withdrawAmount);
        if(check)
        {
            System.out.println("Transaction Successful!");
            Balance = Balance - withdrawAmount;
            System.out.println("New Amount: " + user.getBalance());
        }
        else
            System.out.println("Insufficient Funds. Try Again.");

    }

    public void deposit(Info user) throws InterruptedException {
        int depositAmount;
        Scanner sc = new Scanner(System.in);
        System.out.print("Balance: " + user.getBalance() + "\nDeposit Amount: ");
        depositAmount = sc.nextInt();
        Loading();
        System.out.println("Transaction Successful!");
        Balance = Balance + depositAmount;
        System.out.println("New Amount: " + user.getBalance());

    }


    public static void showInfo(Info user)
    {
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Username: " + user.getUserName());
        System.out.println("Password: " + user.getPassWord());


    }



    //Getters and Setters


    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public int getBalance() { return Balance; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String user) { userName = user; }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public void setBalance(int balance) { Balance = balance; }
}
