package Csci232Program3;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Hash theFunc = new Hash ();

        String[] elementsToAdd = {"1", "5", "15", "21", "23", "26"};

        int choice = 0;
        while (choice!=-1){
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to insert new value");
            System.out.println("Press 2 to print array");
            System.out.println("Press -1 to exit");
            Scanner reader = new Scanner(System.in);
            choice = reader.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Please insert a value to enter");
                    int newvalue = reader.nextInt();
                    theFunc.setKey(newvalue);
                    break;
                case 2:
                    theFunc.displayStack();
                    break;
                case -1:
                    System.out.println("exit");
            }
        }

        //theFunc.displayStack();
    }
}
