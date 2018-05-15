package com.mrp.motorhomes.form;

import com.mrp.motorhomes.model.Customer;

public class CustomerForm implements Form {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String ssn;
    
    @Override
    public boolean validate(){
        boolean firstName 	= this.firstName != null && this.firstName.length() > 0;
        boolean lastName 	= this.lastName != null && this.lastName.length() > 0;
        boolean email 		= checkEmail(this.email);
        boolean address 	= this.address != null && this.address.length() > 0;
        boolean phone 		= this.phone != null && this.phone.length() == 8 && this.phone.matches("[0-9]+");
        boolean ssn 		= this.ssn != null && this.ssn.length() == 10 && this.ssn.matches("[0-9]+");
        return firstName && lastName && email && address && phone && ssn;
    }
    
    public Customer toCustomer() {
        return new Customer(-1, firstName, lastName, email, address, phone, ssn);
    }
    
    @Override
    public String toString() {
        return "CustomerForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
    
    private static boolean checkEmail(String email){
        return email != null && email.length() > 0 && email.contains ("@") && (email.contains(".com")
            || email.contains(".dk"));
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getSsn() {
        return ssn;
    }
    
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
