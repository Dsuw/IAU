
package com.mycompany.bakerysystem;


public class User {

    private String name;
    private int phoneNumber;
    static int billNumber = 1000;
    
    //Constructors
    public User(){}

    public User(String name, int phone){
        this.name = name;
        this.phoneNumber = phone;
        billNumber++;
    }
    
    // Getter and setter methods for name
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    // Getter and setter methods for phoneNumber
    public int getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(int phoneNumber){ this.phoneNumber = phoneNumber; }

    // Getter method for billNumber
    public int getBillNumber(){ return billNumber; }
} //End of User Super class

//Start of Sub classes

class Customer extends User {

    static int customerNumber;

    // Constructor
    public Customer(String name, int phone){
        super(name, phone);
        customerNumber++;
    }

    // Getter and setter methods for customerNumber
    public static int getCustomerNumber() { return customerNumber; }
    public static void setCustomerNumber(int customerNumber) { Customer.customerNumber = customerNumber; }

    @Override
    public String toString(){
        return "\nCustomer Name is: " + getName() +
               "\nPhone Number is: " + getPhoneNumber() +
               "\nBill Number is: " + getBillNumber() +
               "\nCustomer Number is: " + getCustomerNumber();
    }
}


class Employee extends User {

    private int idNumber;
    public int commission;

    // Empty Constructor
    public Employee(){}

    // Constructor
    public Employee(String name, int phone, int id){
        super(name, phone); // Bill number is not applicable for employees
        this.idNumber = id;      
        commission=0;
    }

    // Getter and setter methods for idNumber
    public int getIdNumber(){ return idNumber; }
    public void setIdNumber(int idNumber) { this.idNumber = idNumber; }

    @Override
    public String toString(){
        return  "\n Employee Name is: " + getName() +
                "\n ID Number is: " + getIdNumber() +
                "\n Phone Number is: " + getPhoneNumber(); 
    }
}
