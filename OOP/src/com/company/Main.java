package com.company;
import java.util.*;



public class Main{




    public static void main(String[] args)  throws InterruptedException {

        int idNum;

        Info c = new Info();
        c.firstName = "Chaz";
        c.lastName = "Jenkins";
        c.passWord = "abc123";
        c.phoneNumber = 2101231234;
        c.userName = "Chaz";
        c.idNum = 0;

        Info j = new Info();
        j.firstName = "Jaylen";
        j.lastName = "Harris";
        j.passWord = "abc123";
        j.phoneNumber = 2101231234;
        j.userName = "Jaylen";
        j.idNum = 1;

        Info[] users = new Info[]{c, j};
        Scanner sc = new Scanner(System.in);
        System.out.print("ID #: ");
        idNum = sc.nextInt();


        //Login
        Info.Login(users, idNum);
        Info.Menu(users[idNum]);



    }












}
