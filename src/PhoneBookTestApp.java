import java.util.Scanner;

import phonebook.PhoneBookLinkedList;

public class PhoneBookTestApp {
    

    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        PhoneBookLinkedList whatcom = new PhoneBookLinkedList();
        boolean quit = false;

        System.out.printf("%n%s%n","Welcome to the Whatcom county phone book program");

        do {
            System.out.println("\nPlease enter: add, view, update, delete or quit to interact with Whatcom county phone book.");
            String selection = input.nextLine().toLowerCase();
            quit = false;
            switch (selection) {
                case "add":
                    addContact(input, whatcom);
                break;

                case "edit":
                    editContact(input, whatcom);
                break;

                case "view":
                    whatcom.printPhoneBook();
                break;

                case "delete":
                    deleteContact(input, whatcom);
                break;

                case "quit":
                    System.out.printf("%n%s%n", "Thank you have a nice day!");
                    quit = true;
                break;

                default: System.out.println("Invalid entry please try again");
                
            }
        } while(!quit);
        
    }// End Main method

    private static void addContact(Scanner input,PhoneBookLinkedList whatcom) {
        boolean exit = false;

        do {
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

            System.out.println("Do you want to add another contact? (yes/no)");
            String choice = input.nextLine().toLowerCase();
            exit = choice.equals("no"); // Update exit based on user's choice
        } while(!exit);

    }

    private static void editContact(Scanner input,PhoneBookLinkedList whatcom) {
        boolean exit = false;

        do {
            System.out.println("Please enter the first name of the contact you want to update");
            String firstName = input.nextLine();
            System.out.println("Please enter the last name of the contact you want to update");
            String lastName = input.nextLine();
            if(whatcom.checkName(firstName, lastName)) {

                System.out.println("What would do you want to update? Enter 1 for Name. Enter 2 Address. Enter 3 Phone NUmber");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Please enter contacts first name");
                        String newFirstName = input.nextLine();
                        System.out.println("Please enter contacts last name");
                        String newLastName = input.nextLine();
                
                        whatcom.editName(firstName,lastName,newFirstName,newLastName);
                    break;

                    case 2:
                        System.out.println("Please enter street address (5555 Main St)");
                        String newStreetAddress = input.nextLine();
                        System.out.println("Please enter city");
                        String newCity = input.nextLine();
                
                        whatcom.editAddress(firstName,lastName,newStreetAddress,newCity);
                    break;

                    case 3:
                        System.out.println("Please enter new phone number");
                        String newPhoneNum = input.nextLine();
                        whatcom.editPhoneNum(firstName, lastName, newPhoneNum);
                    break;

                    default:System.out.println("Invalid Entry please try again");
                        break;
                }
            } else {
                System.out.println("Update not successful");
            }
            System.out.println("Do you want to update another contact (yes/no)");
            String leave = input.next().toLowerCase();
            if (leave.equals("yes")){
                exit = true;
            }
        }while(!exit);
    }

    private static void deleteContact(Scanner input, PhoneBookLinkedList whatcom) {
        boolean exit = false;

        do {
            System.out.println("Please enter contact's first name.");
            String firstName = input.nextLine();
            System.out.println("Please enter contact's last name.");
            String lastName = input.nextLine();
            whatcom.delete(firstName, lastName);

            System.out.println("Do you want to add another contact? (yes/no)");
            String choice = input.nextLine().toLowerCase();
            exit = choice.equals("no"); // Update exit based on user's choice
        } while(!exit);

    }

}