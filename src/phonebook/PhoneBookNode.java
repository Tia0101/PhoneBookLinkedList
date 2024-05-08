// Name: Tia Vanderyacht
//Date: 05/07/2024
// Class: CS 145 9:30am face to face
// Assignment: Lab 5 PhoneBook Linked List.
// Purpose: Object class for the phone book linked list.
// Citation: This program references chapter 21 of the Deitel/Deitel-11th edition(Early Objects), w3schools.com,and youtube

// Extra Credit see line 11 created a constom package.

//custom package created for the phone book linked list
package phonebook;

//Object class for the phone book linked list
public class PhoneBookNode {
    //Instance variables
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String phoneNum;
    
    protected PhoneBookNode next;//Reference to the next node in the linked list
    //Constructor
    public PhoneBookNode(String firstName,String lastName,String streetAddress,String city,String phoneNum ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.phoneNum = phoneNum;
        this.next = null;
    }
    //accessor and mutator methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //return the first name
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }
    //return the last name
    public String getLastName() {
        return lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    //return the street address
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //return the city
    public String getCity() {
        return city;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    //return the phone number
    public String getPhoneNum() {
        return phoneNum;
    }
    //toString method
    @Override
    public String toString() {
        
        return String.format("Name: %s %s%nAddress: %s, %s%nPhone Number: %s%n%s", getFirstName(),getLastName(),getStreetAddress(),getCity(),
        getPhoneNum(),"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
