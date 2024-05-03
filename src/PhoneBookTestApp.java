import java.util.Scanner;

import phonebook.PhoneBookLinkedList;

public class PhoneBookTestApp {
    

    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        PhoneBookLinkedList whatcom = new PhoneBookLinkedList();
        boolean quit;
        
        System.out.printf("%n%s%n","Welcome to the Whatcom county phone book program");

        do {
            System.out.println("Please enter: add, view, edit, delete or quit to interact with Whatcom county phone book.");
            String selection = input.nextLine().toLowerCase();
            quit = false;
            switch (selection) {
                case "add":
                    System.out.println("Please enter contact's first name");
                    String firstName = input.nextLine();
                    System.out.println("Please enter contact's last name");
                    String lastName = input.nextLine();
                    System.out.println("Please enter contact's street address(ex:9999 Main st)");
                    String streetAddress = input.nextLine();
                    System.out.println("Please enter contact's city");
                    String city = input.nextLine();
                    System.out.println("Please enter contact's phone number");
                    String phoneNum = input.nextLine();
                    
                    whatcom.add(firstName,lastName, streetAddress,city, phoneNum);
                break;

                case "edit":
                    //placeholder
                break;

                case "view":
                    whatcom.printPhoneBook();
                break;

                case "delete":
                    System.out.println("Please enter contact's first name.");
                    firstName = input.nextLine();
                    System.out.println("Please enter contact's last name.");
                    lastName = input.nextLine();
                    whatcom.delete(firstName, lastName);
                break;
                
                case "quit":
                    System.out.printf("%n%s%n", "Thank you have a nice day!");
                    quit = true;
                break;

                default: System.out.println("Invalid entry please try again");
                
            }
        } while(!quit);
        
    }

}