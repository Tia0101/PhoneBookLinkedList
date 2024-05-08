// Name: Tia Vanderyacht
//Date:05/07/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 5 PhoneBook Linked List.
// Purpose: Manager class for the phone book linked list.
// Citation: This program references chapter 21 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

// Extra Credit see line 10 created a constom package.


//custom package created for the phone book linked list
package phonebook;

//Manager class for the phone book linked list
public class PhoneBookLinkedList {
    //First node in the linked list
    protected PhoneBookNode first;

    //Method to check if a contact exists
    public boolean doesContactExist(String firstName,String lastName) {
        PhoneBookNode current = first;

        //Loop through the linked list to check if the contact exists
        while(current != null) {

            //If the contact exists return true
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName) ) {
                return true;
            }
            //Move to the next node
            current = current.next;
        }
        //If the contact does not exist return false
        return false;
    }// End doesContactExist method

    //Method to add a contact to the linked list
    public void add(String firstName,String lastName,String streetAddress,String city,String phoneNum) {
        //Creata a new node with the user input
        PhoneBookNode newNode = new PhoneBookNode(firstName, lastName, streetAddress, city, phoneNum);
        // If the list is empty or the new last name comes before the first node's last name alphabetically
        if(first == null || lastName.compareToIgnoreCase(first.getLastName()) < 0 ) {
            //Set the new node's next to the first node
            newNode.next = first;
            //Set the new node as the first node
            first = newNode;
        } else {
            //Find the correct position to insert the new node
            PhoneBookNode prevNode = first;
            PhoneBookNode current = first.next;//Start at the second node
            while (current != null && lastName.compareToIgnoreCase(current.getLastName()) > 0) {
                //Move to the next node
                prevNode = current;
                current = current.next;
            }
            //Insert the new node at the correct position
            prevNode.next = newNode;
            newNode.next = current;
        }
    }// End add method
    
    //Method to edit a contact's name
    public void editName(String oldFirstName, String oldLastName, String newFirstName, String newLastName) {
        PhoneBookNode current = first;//Start at the first node
        PhoneBookNode prev = null;

        //If the list is empty print message
        if (current == null) {
            System.out.println("There are no contacts in the phone book.");
        }
        //flag for printing message if contact is not found
        boolean contactNotFound = true;
        
        //Loop through the linked list to find the contact
        while(current != null) {
            if(current.getFirstName().equalsIgnoreCase(oldFirstName) && current.getLastName().equalsIgnoreCase(oldLastName)) {
                //If the contact is found update the name
                if(prev == null) {
                    first =  current.next;
                } else {
                    prev.next = current.next;// Skips the current node and removes it from the linked list
                }
                //New name set
                current.setFirstName(newFirstName);
                current.setLastName(newLastName);
                contactNotFound = false;
                //Edited node added to the linked list
                add(newFirstName, newLastName, current.getStreetAddress(), current.getCity(), current.getPhoneNum());
                break;
            }
            //Move to the next node
            current = current.next;
        }

        if(contactNotFound) {
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }

    //Method to edit a contact's address
    public void editAddress(String firstName, String lastName, String newStreetAddress, String newCity) {
        PhoneBookNode current = first;//Start at the first node

        //If the list is empty print message
        if (current == null) {
            System.out.println("There are no contacts in the phone book.");
        }
        
        boolean contactNotFound = true;

        //Loop through the linked list to find the contact
        while(current != null) {
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)){
                current.setStreetAddress(newStreetAddress);//Update the street address
                current.setCity(newCity);//Update the city
                contactNotFound = false;
                break;
            }
            current = current.next;//Move to the next node
        }

        if(contactNotFound) {
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }// End editAddress method

    //Method to edit a contact's phone number
    public void editPhoneNum(String firstName, String lastName, String newPhonehum) {
        PhoneBookNode current = first;

        //If the list is empty print message
        if (current == null) {
            System.out.println("There are no contacts in the phone book.");
        }
        
        boolean contactNotFound = true;
        //Loop through the linked list to find the contact
        while(current != null) {
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)){
                current.setPhoneNum(newPhonehum);//Update the phone number
                contactNotFound = false;
                break;
            }
            current = current.next;//Move to the next node
        }

        if(contactNotFound) {
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }// End editPhoneNum method

    //Method to delete a contact
    public void delete(String firstName, String lastName) {
        //If the list is empty print message
        if (first == null) {
            System.out.println("There are no contacts to delete.");
            return;
        }
        //If the first node is the contact to delete
        if (first.getFirstName().equalsIgnoreCase(firstName) && first.getLastName().equalsIgnoreCase(lastName)) {
            first = first.next;
            System.out.println("Contact deleted successfully!");
            return;
        }
        //Start at the first node
        PhoneBookNode prev = first;
        PhoneBookNode current = first.next;
        
        //Loop through the linked list to find the contact
        while (current != null) {
            if (current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)) {
                prev.next = current.next;//Skips the current node and removes it from the linked list
                System.out.println("Contact deleted successfully!");
                return;
            }
            //Move to the next node
            prev = current;
            current = current.next;
        }
    
        // Contact not found if the loop completes without returning
        System.out.println("Contact not found.");
    }// End delete method

    //Method to print the phone book
    public void printPhoneBook() {
        PhoneBookNode current = first;//Start at the first node
        System.out.printf("%n%s%n%n","Whatcom County Phone Book:");
        //If the list is empty print message
        if (current == null) {
            System.out.printf("%s%n","There are no contacts currently in the phone book.");
        } else {
            //Loop through the linked list and print each contact
            while (current != null) {
            System.out.println(current.toString());
            current = current.next;
            }
        }
    }// End printPhoneBook method
}// End PhoneBookLinkedList class


