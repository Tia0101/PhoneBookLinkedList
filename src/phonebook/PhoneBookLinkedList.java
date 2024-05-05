package phonebook;

public class PhoneBookLinkedList {
    protected PhoneBookNode first;

    public boolean checkName(String firstName,String lastName) {
        PhoneBookNode current = first;

        while(current != null) {
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName) ) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void add(String firstName,String lastName,String streetAddress,String city,String phoneNum) {
        PhoneBookNode newNode = new PhoneBookNode(firstName, lastName, streetAddress, city, phoneNum);

        if(first == null || lastName.compareToIgnoreCase(first.getLastName()) < 0 ){
            newNode.next = first;
            first = newNode;
        } else {
            PhoneBookNode prevNode = first;
            PhoneBookNode current = first.next;
            while (current != null && lastName.compareToIgnoreCase(current.getLastName()) > 0) {
                prevNode = current;
                current = current.next;
            }
            prevNode.next = newNode;
            newNode.next = current;
        }
    }
    
    public void editName(String oldFirstName, String oldLastName, String newFirstName, String newLastName) {
        PhoneBookNode current = first;

        if (first == null){
            System.out.println("There are no contacts in the phone book.");
        }
        
        boolean contactFound = false;

        while(current != null){
            if(current.getFirstName().equalsIgnoreCase(oldFirstName) && current.getLastName().equalsIgnoreCase(oldLastName)){
                current.setFirstName(newFirstName);
                current.setLastName(newLastName);
                contactFound = true;
                break;
            }
            current = current.next;
        }
        if(!contactFound){
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }

    public void editAddress(String firstName, String lastName, String newStreetAddress, String newCity) {
        PhoneBookNode current = first;

        if (first == null){
            System.out.println("There are no contacts in the phone book.");
        }
        
        boolean contactFound = false;

        while(current != null){
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)){
                current.setStreetAddress(newStreetAddress);
                current.setCity(newCity);
                contactFound = true;
                break;
            }
            current = current.next;
        }
        if(!contactFound){
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }

    public void editPhoneNum(String firstName, String lastName, String newPhonehum) {
        PhoneBookNode current = first;

        if (first == null){
            System.out.println("There are no contacts in the phone book.");
        }
        
        boolean contactFound = false;

        while(current != null){
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)){
                current.setPhoneNum(newPhonehum);
                contactFound = true;
                break;
            }
            current = current.next;
        }
        if(!contactFound){
            System.out.println("Contact not found!");
        } else {
            System.out.println("Contact updated successfully!");
        }
    }

    public void delete(String firstName, String lastName) {
        if (first == null) {
            System.out.println("There are no contacts to delete.");
            return;
        }
        if (first.getFirstName().equalsIgnoreCase(firstName) && first.getLastName().equalsIgnoreCase(lastName)) {
            first = first.next;
            System.out.println("Contact deleted successfully!");
            return;
        }
    
        PhoneBookNode prev = first;
        PhoneBookNode current = first.next;
    
        while (current != null) {
            if (current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)) {
                prev.next = current.next;
                System.out.println("Contact deleted successfully!");
                return;
            }
            prev = current;
            current = current.next;
        }
    
        // Contact not found if the loop completes without returning
        System.out.println("Contact not found.");
    }

    public void printPhoneBook() {
        PhoneBookNode current = first;
        System.out.printf("%n%s%n%n","Whatcom County Phone Book:");

        if (current == null) {
            System.out.printf("%s%n","There are no contacts currently in the phone book.");
        } else {
            while (current != null) {
            System.out.println(current.toString());
            current = current.next;
            }
        }
    }
}
        

    