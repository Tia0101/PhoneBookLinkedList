import java.util.Scanner;

import phonebook.PhoneBookLinkedList;

public class PhoneBookTestApp {
    

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        PhoneBookLinkedList test = new PhoneBookLinkedList();
        boolean quit;

        do {
            System.out.println("Would you like to add, view, edit or delete contacts from the Whatcom county phone book?");
            String selection = input.nextLine().toLowerCase();
            switch (selection) {
                case "add":
                test.add("Tia","VanderYacht","9999 main st","ferndale","WA","999-999-9999");
                test.add("Tia","VanderYacht","9999 main st","ferndale","WA","999-999-9999");
                    break;
                case "edit":
                    //placeholder
                break;
                case "view":
                test.printPhoneBook();
                break;
                case "delete":
                    //placeholder
                break;
    
                default://place holder
                
            }
            System.out.println("Do you want to exit the program?");
            String exit = input.nextLine();
   
            if (exit.equalsIgnoreCase("yes")){
               quit = true;
            } else {
               quit = false;
            }
        } while(!quit);
        
    }

}