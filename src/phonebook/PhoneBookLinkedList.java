package phonebook;

public class PhoneBookLinkedList {
    private PhoneBookNode first;

    public void add(String firstName,String lastName,String streetAddress,String city,String phoneNum) {
        PhoneBookNode newNode = new PhoneBookNode(firstName, lastName, streetAddress, city, phoneNum);

        if(first == null){
            first = newNode;
        } else {
            PhoneBookNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new PhoneBookNode(firstName, lastName, streetAddress, city, phoneNum);
        }
        
    }
    
    /*public void edit(String firstName, String lastName, String streetAddress, String city, String phoneNum){
        PhoneBookNode current = first;
        
        if (first == null){
            System.out.println("There are no contacts in the phone book.");
            
        }

    }*/


    public void delete(String firstName, String lastName) {
        PhoneBookNode prev = first;
        PhoneBookNode current = first.next;
        
        if(first == null){
            System.out.println("There are no contact to delete.");
            //return;
        }
        if(first.getFirstName().equalsIgnoreCase(firstName) && first.getLastName().equalsIgnoreCase(lastName)){
            first = first.next;
            System.out.println("Contact deleted successfully!");
            //return;
        } 

        while(current!= null) {
            if(current.getFirstName().equalsIgnoreCase(firstName) && current.getLastName().equalsIgnoreCase(lastName)) {
                prev.next = current.next;
                System.out.println("Contact deleted successfully!");
            
            } 
            prev = current;
            current = current.next;
        
        }
        System.out.println("Contact not Found");

    }

    public void printPhoneBook() {
        PhoneBookNode current = first;
        System.out.printf("%n%s%n%n","Whatcom County Phone Book:");

        if (current == null) {
            System.out.printf("%s%n%n","There are no contacts currently in the phone book.");
        } else {
            while (current != null) {
            System.out.println(current.toString());
            current = current.next;
            }
        }
    }

}
        

    