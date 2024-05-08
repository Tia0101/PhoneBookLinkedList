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
    public void add(String firstName, String lastName, String streetAddress, String city, String phoneNum) {
        // Create a new node with the user input
        PhoneBookNode newNode = new PhoneBookNode(firstName, lastName, streetAddress, city, phoneNum);
        // If the list is empty, set the new node as the first node
        if(first == null) {
            first = newNode;
        } else {
            // Find the last node
            PhoneBookNode current = first;
            while(current.next != null) {
                current = current.next;
            }
            // Add the new node to the end of the list
            current.next = newNode;
        }
        System.out.println("Contact added successfully!");
    }// End add method
    
    public void sort() {
        // Initialize sorted linked list
        PhoneBookNode sorted = null;
        PhoneBookNode current = first;
    
        while (current != null) {
            // Store next for next iteration
            PhoneBookNode next = current.next;
    
            // Insert current in sorted linked list
            if (sorted == null || sorted.getLastName().compareTo(current.getLastName()) >= 0) {
                current.next = sorted;
                sorted = current;
            } else {
                // Locate the node before the point of insertion
                PhoneBookNode currentSorted = sorted;
                while (currentSorted.next != null && currentSorted.next.getLastName().compareTo(current.getLastName()) < 0) {
                    currentSorted = currentSorted.next;
                }
                // Insert current in sorted linked list
                current.next = currentSorted.next;
                currentSorted.next = current;
            }
    
            // Update current
            current = next;
        }
    
        // Update head to point to sorted linked list
        first = sorted;
    }// End sort method

    //Method to edit a contact's name
    public void editName(String oldFirstName, String oldLastName, String newFirstName, String newLastName) {
        PhoneBookNode current = first;//Start at the first node
        
        //If the list is empty print message
        if (current == null) {
            System.out.println("There are no contacts in the phone book.");
        }
        //Loop through the linked list to find the contact
        while(current != null) {
            if(current.getFirstName().equalsIgnoreCase(oldFirstName) && current.getLastName().equalsIgnoreCase(oldLastName)) {
                //If the contact is found update the name
                current.setFirstName(newFirstName);
                current.setLastName(newLastName);
                System.out.println("Contact updated successfully!");
                break;
            }
            //Move to the next node
            current = current.next;
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
        //Initialize the previous and current nodes
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


