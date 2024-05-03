
package phonebook;


public class PhoneBookNode {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String phoneNum;
    
    protected PhoneBookNode next;

    public PhoneBookNode(String firstName,String lastName,String streetAddress,String city,String phoneNum ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.phoneNum = phoneNum;
        this.next = null;
    }

    public void setFristName() {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName() {
        this.lastName = lastName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setStreetAddress() {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setCity() {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPhoneNum() {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
    public String toString() {
        
        return String.format("Name: %s %s%nAddress: %s, %s%nPhone Number: %s%n%s", getFirstName(),getLastName(),getStreetAddress(),getCity(),
        getPhoneNum(),"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
