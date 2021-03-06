import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @CsvBindByPosition(position = 3)
    private String firstName;
    @CsvBindByPosition(position = 4)
    private String lastName;
    @CsvBindByPosition(position = 1)
    private String city;
    @CsvBindByPosition(position = 6)
    private String state;
    @CsvBindByPosition(position = 7)
    private String zipcode;
    @CsvBindByPosition(position = 5)
    private String phNo;
    @CsvBindByPosition(position = 0)
    private String address;
    @CsvBindByPosition(position = 2)
    private String email;
    private String type;
    private String cid;
    private String date;

    public Contact(String cid, String firstName, String lastName, String phNo, String email, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phNo = phNo;
        this.email = email;
        this.cid = cid;
        this.date = date;
    }
    public Contact(String cid, String firstName, String lastName, String phNo, String email, String date,String address, String city, String state, String zipcode,String type){
        this(cid,firstName,lastName,phNo,email,date);
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.type = type;
    }

    public Contact(String firstName, String lastName, String address, String city, String state, String zipcode, String phNo,
                   String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phNo = phNo;
        this.address = address;
        this.email = email;
    }

    public Contact(String firstName, String lastName, String address,String city, String state, String zipcode, String phNo, String email, String type) {
        this(firstName,lastName,address,city,state,zipcode,phNo,email);
        this.type = type;
    }

    public Contact() {
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getPhNo() {
        return phNo;
    }
    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getCid() { return cid; }
    public void setCid(String cid) { this.cid = cid; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        Contact contact = (Contact) o;
        if((this.firstName.compareToIgnoreCase(contact.getFirstName()) == 0) && (this.lastName.compareToIgnoreCase(contact.getLastName()) == 0))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " | " + this.address + " | " + this.city + " | " + this.state + " | " + this.zipcode
                + " | " + this.phNo + " | " + this.email;
    }
}
