package phonebook;

public class PhoneBookLinkedList {
    private PhoneBookNode first;

    public void add(String firstName,String lastName,String streetAddress,String city,String state,String phoneNum) {
        PhoneBookNode newNode = new PhoneBookNode(firstName, lastName, streetAddress, city, state, phoneNum);

        if(first == null){
            first = newNode;
        } else {
            PhoneBookNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new PhoneBookNode(firstName, lastName, streetAddress, city, state, phoneNum);
        }
        
    }
    

    public void printPhoneBook() {
        PhoneBookNode current = first;
        System.out.printf("%n%s%n%n","Bellingham's Phone Book:");
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }

}
        

    