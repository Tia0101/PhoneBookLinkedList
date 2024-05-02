import phonebook.PhoneBookLinkedList;
import phonebook.PhoneBookNode;

public class PhoneBookTestApp {
    

    public static void main (String [] args){
        PhoneBookNode test1 = new PhoneBookNode("Tia","VanderYacht","9999 main st","ferndale","WA","999-999-9999");
        PhoneBookLinkedList test = new PhoneBookLinkedList();

        test.add("Tia","VanderYacht","9999 main st","ferndale","WA","999-999-9999");
        test.add("Tia","VanderYacht","9999 main st","ferndale","WA","999-999-9999");
        test.printPhoneBook();
        
    }

}