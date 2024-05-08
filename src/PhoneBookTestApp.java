// Name: Tia Vanderyacht
//Date: 05/07/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 4 pay roll modification.
// Purpose: Interface for user to interact with the phone book linked list.
// Citation: This program references chapter 21 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

// Extra Credit Not sure there is any here. I made the methods outside of main to handle the user input, but I don't think that is extra credit.


import java.util.Scanner;

//custom package import
import phonebook.PhoneBookLinkedList;

//Test class for the phone book linked list
public class PhoneBookTestApp {
    //Main method
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        //New phone book object created
        PhoneBookLinkedList whatcom = new PhoneBookLinkedList();
        boolean quit = false;

        System.out.printf("%n%s%n","Welcome to the Whatcom county phone book program");
        //Do while loop to interact with the phone book
        do {
            System.out.println("\nPlease enter: add, view, update, delete or quit to interact with Whatcom county phone book.");
            String selection = input.nextLine().toLowerCase();
            quit = false;
            switch (selection) {
                case "add":
                    addContact(input, whatcom);//Method to add a contact scanner and ojbect passed as arguments
                break;

                case "update":
                    updateContact(input, whatcom);//updateContact method called
                break;

                case "view":
                    whatcom.printPhoneBook();//printPhoneBook method called
                break;

                case "delete":
                    deleteContact(input, whatcom);//deleteContact method called
                break;

                case "quit":
                    System.out.printf("%n%s%n", "Thank you have a nice day!");
                    quit = true;
                break;

                default: System.out.println("Invalid entry please try again");
                
            }
        } while(!quit);
        
    }// End Main method
    
    //Method to add a contact
    private static void addContact(Scanner input,PhoneBookLinkedList whatcom) {
        boolean exit = false;
        //Do while loop to add a contact
        do {
            //Prompt user for contact information
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
            
            //Add the contact to the phone book
            whatcom.add(firstName,lastName, streetAddress,city, phoneNum);

            System.out.println("Do you want to add another contact? (yes/no)");
            String choice = input.nextLine().toLowerCase();
            exit = choice.equals("no"); // Update exit based on user's choice
        } while(!exit);
    }// End addContact method

    //Method to update a contact
    private static void updateContact(Scanner input,PhoneBookLinkedList whatcom) {
        boolean exit = false;

        do {//Do while loop to update a contact
            System.out.println("Please enter the first name of the contact you want to update");
            String firstName = input.nextLine();
            System.out.println("Please enter the last name of the contact you want to update");
            String lastName = input.nextLine();
            //Checks if the contact exists
            if(whatcom.doesContactExist(firstName, lastName)) {

                System.out.println("What would do you want to update? Enter 1 for Name. Enter 2 Address. Enter 3 Phone Number");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Please enter contact's first name");
                        String newFirstName = input.nextLine();
                        System.out.println("Please enter contact's last name");
                        String newLastName = input.nextLine();
                        //Edit the contact's name in phone linked list
                        whatcom.editName(firstName,lastName,newFirstName,newLastName);
                    break;

                    case 2:
                        System.out.println("Please enter street address (5555 Main St)");
                        String newStreetAddress = input.nextLine();
                        System.out.println("Please enter city");
                        String newCity = input.nextLine();
                        //Edit the contact's address in phone book linked list
                        whatcom.editAddress(firstName,lastName,newStreetAddress,newCity);
                    break;

                    case 3:
                        System.out.println("Please enter new phone number");
                        String newPhoneNum = input.nextLine();
                        //Edit the contact's phone number in phone book linked list
                        whatcom.editPhoneNum(firstName, lastName, newPhoneNum);
                    break;

                    default:System.out.println("Invalid Entry please try again");
                        break;
                }
            } else {
                System.out.println("Contact not found!");
            }
            System.out.println("Do you want to update another contact (yes/no)");
            String leave = input.nextLine().toLowerCase();
            if (leave.equals("no")){
                exit = true;
            }
        }while(!exit);
    }// End updateContact method

    //Method to delete a contact
    private static void deleteContact(Scanner input, PhoneBookLinkedList whatcom) {
        boolean exit = false;
        //Do while loop to delete a contact
        do {
            //Prompt user for contact information
            System.out.println("Please enter contact's first name.");
            String firstName = input.nextLine();
            System.out.println("Please enter contact's last name.");
            String lastName = input.nextLine();
            //Delete the contact from the phone book linked list
            whatcom.delete(firstName, lastName);

            System.out.println("Do you want to add another contact? (yes/no)");
            String choice = input.nextLine().toLowerCase();
            exit = choice.equals("no"); // Update exit based on user's choice
        } while(!exit);

    }// End deleteContact method

}// End PhoneBookTestApp class