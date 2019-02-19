package com.company;

import java.util.Stack;
import java.util.Scanner;

public class PartA {
    private static Stack<String> history = new Stack<String>();

    public static Boolean isBrowsingHistoryEmpty() {
        return history.isEmpty();//Method returns true if browsing history is empty
    }

    public static String mostRecentlyVisitedSite() {
        return history.peek();//Method returns the url of the  most recently visited website
    }

    public static void addSiteToHistory(String url) {
        history.push(url);//Method to add the website with given url to browsing history
    }

    public static void goBackInTime(int n) {
        if(!isBrowsingHistoryEmpty()) {//Method to traverse back in browsing history by n times such that 1<=n<=m where m is the number of urls stored in history
            while(n>0) {
                history.pop();
                n--;
            }
        }
    }

    public static void printBrowsingHistory() {
        if(history.isEmpty()){//Method to print browsing history as applicable
            System.out.println("No Browsing History");
        }
        else{
            System.out.println(history);
        }
    }

    public static void menu() {//Presents a menu of choices to user
        Scanner input=new Scanner(System.in);
        while (true) {
            int menuIndex = 0;

            System.out.println(++menuIndex + " Like to visit a website ");
            System.out.println(++menuIndex + " Check if browsing history is empty ");
            System.out.println(++menuIndex + " Print recently visited website ");
            System.out.println(++menuIndex + " Select choice to traverse back the browsing history by 'n' times ");
            System.out.println(++menuIndex + " Print Browsing History");
            System.out.println(++menuIndex + " Exit");
            System.out.println("\n Enter your choice");
            try {//Try catch block to handle NumberFormatException
                if (!classifyMenuChoice(Integer.parseInt(input.next())))
                    break;
            } catch (NumberFormatException e1) {
                System.out.println("Please enter a valid integer as choice");
            }
        }
    }

    public static boolean classifyMenuChoice(int choice) {
        Scanner input=new Scanner(System.in);
        while (true) {//Calls respective method depending on user choice
            switch (choice) {
                case 1:
                    System.out.println("\n Enter the url of the website you wish to visit");
                    String url=input.next();
                    addSiteToHistory(url);
                    return true;
                case 2:
                    System.out.println(isBrowsingHistoryEmpty());
                    return true;
                case 3:
                    System.out.println(mostRecentlyVisitedSite());
                    return true;
                case 4:
                    int m=history.size();//Informs user to enter n such that n is a valid choice
                    System.out.println("\n Enter the value for 'n' such that 1<= n <= "+m);
                    int n=input.nextInt();
                    goBackInTime(n);
                    return true;
                case 5:
                    printBrowsingHistory();
                    return true;
                case 6:
                    return false;
                default:
                    System.out.println("Wrong choice. Try again");//Prints message if user enters a choice other than 1 to 6
            }
            System.out.println("\n Enter your choice");
            choice = Integer.parseInt(input.next());
        }
    }

    public static void main(String[] args) {
        menu();//calling the menu method to display a menu of choices to user
    }
}

