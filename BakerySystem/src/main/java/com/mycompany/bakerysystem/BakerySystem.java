
package com.mycompany.bakerysystem;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BakerySystem {
    
    //STATIC varibles and objects
    
    static String Main_menu="\n\n*** Welcome to Bakery System ***\n"+
            "1- Employee Subsystem\n" +
            "2- Customer Subsystem\n" +
            "3- Exit \n"+
            "Your Choice: " ;
           
    static String Customer_menu="\n\n\t*** Welcome to Customer Subsystem ***\n"+
            "\t1- Menu \n" +
            "\t2- Add Product  \n" +
            "\t3- Edit Basket  \n" +      
            "\t4- Show Basket\n"+
            "\t5- Show Bill\n"+
            "\t6- Exit \n"+
            "\tYour Choice: " ;
           
    static String Employee_menu="\n\n\t*** Welcome to Employee Subsystem ***\n"+
            "\t1- Show Employee Information  \n" +
            "\t2- Edit Employee Information \n" +
            "\t3- Check Employee of The Day Status \n"+
            "\t4- Exit \n"+
            "\tYour Choice: " ;

    static Scanner in=new Scanner(System.in);   
    static ArrayList <Product> basket=new ArrayList<>();
    static ArrayList <Double> prices=new ArrayList<>();
    static ArrayList <Employee> employees=new ArrayList<>();
    static Accounting a=new Accounting();  
    static Salary b=new Salary();

    // Start of Main
    public static void main(String[] args){

        employees.add(new Employee("Sarah", 124, 987654123));
        employees.add(new Employee("Shahad", 125, 987234321));
        employees.add(new Employee("Nouf", 123, 987981321));
        
        int choice;       
        do{
            try {
            System.out.print(Main_menu);
            choice=in.nextInt();
            
            switch (choice){
                case 1:
                    Employee_System();
                    break;
                case 2:
                    Customer_System();  
                    break;
                case 3:
                    break;
                default:
                    System.out.print("Wrong Entry. Please enter a valid option.");
                } 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                 in.next(); choice = -1;
            }
            
        } while (choice!=3);
    } // End of main

    //METHODS
        
    static void Customer_System(){
        int choice;
        do{
            try{
           System.out.print(Customer_menu);
           choice=in.nextInt();
          
           switch (choice){
                case 1:
                    menu();
                    break;
                case 2:
                    addProduct();                   
                    break;
                case 3:
                    editBasket();
                    break;
                case 4:                  
                    showBasket();                  
                    break;
                case 5:
                    ShowBill();
                    break;
                case 6: 
                {
                    System.out.println("order cancelled!"); 
                    basket.clear();
                    break;
                }            
                default:
                    System.out.print("Wrong Entry. Please enter a valid option.");  
            }  
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                 in.next(); choice = -1;
            }         
        }while (choice!=6);
    }
    
    static void Employee_System(){     
        int choice;
        do{
            try{
           System.out.print(Employee_menu);
           choice=in.nextInt();
                  
           switch (choice){

                case 1:
                    showEmployeeInformation();
                    break;
                case 2:
                    editEmployeeInformation();
                    break;
                case 3:
                    System.out.println(employeeOfDay(employees)); 
                    break;
                case 4: 
                    break;
                default:
                    System.out.print("Wrong Entry. Please enter a valid option.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                 in.next(); choice = -1;
            }

        } while (choice != 4);
    } 
    
    static void menu(){       
        Cake cake=new Cake();
        Drinks drink=new Drinks();
        Pastries pastry=new Pastries();
        System.out.println("\n\t*****Our Menu Is:****\t\n"); 
        cake.getMenu(); 
        pastry.getMenu(); 
        drink.getMenu();
    }
    
    static void addProduct(){       
        int order; 
        boolean added=true;

        do{
            try{
        menu();      
        System.out.println("\nwhat do you like to add?"+"\n enter 10 to exit");  order=in.nextInt();

        switch(order){            
            case 1:
                basket.add(new Cake ("Vanilla",50.0));
                prices.add(50.0);
                break;
            case 2:
                basket.add(new Cake("Chocolate",60.0));
                prices.add(60.0);
                break;
            case 3:
                basket.add(new Cake("Strawberry",65.0));
                prices.add(65.0);
                break;
            case 4:
                basket.add(new Pastries("cheese",6.0));
                prices.add(6.0);
                break;
            case 5:
                basket.add(new Pastries("jam",4.0));
                prices.add(4.0);
                break;
            case 6:
                basket.add(new Pastries("Zattar",5.0));
                prices.add(5.0);
                break;
            case 7:
            {
                char s;
                System.out.println("What size: S-small M-medium L-large"); s=in.next().charAt(0);
                basket.add(new Drinks("Latte",10.0,s));
                prices.add(10.0);
                break;
            }
            case 8:
            {
                char s;
                System.out.println("What size: S-small M-medium L-large"); s=in.next().charAt(0);
                basket.add(new Drinks("Tea",2.0,s));
                prices.add(2.0);
                break;   
            }
            case 9:
            {   
                char s;
                System.out.println("What size: S-small M-medium L-large"); s=in.next().charAt(0);
                basket.add(new Drinks("Orange Juice",7.0,s));
                prices.add(7.0);
                break; 
            }
            case 10: 
                added=false;
                break;
            default:
            { 
                System.out.println("worng entery!"); added=false; 
            }             
        }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer."); added=false;
                 in.next(); order = -1;
            }      
        if(added){ 
            System.out.println("\n\t item added!");
            System.out.println("Would you like to add any other items? Enter 0 for No"); order=in.nextInt();
        }
        } while(order!=10&&order!=0);
    }
    
    static void showBasket(){        
        if(basket.isEmpty())
        {System.out.println("there is no items!"); return;}
        else
        System.out.println("\nItems in Basket:");
        for (int i=0;i<basket.size();i++){
        System.out.println((i+1)+"."+ basket.get(i).toString());
    }    
    double totalBill=a.Bill(basket, prices);
    System.out.println("\nThe cost of the items is: "+ totalBill + "SAR");
    }
    
    static boolean offer(){
        if(basket.size() > 5)
        return true;
        else return false;        
    }

    static void editBasket(){
    if (basket.isEmpty()){ System.out.println("there is no items in the Basket!"); return;}
     
    int choice;    
    do{
        try{
        System.out.println("\nEdit Basket Menu:\n" +
                "1. Remove Product\n" +
                "2. Clear Basket\n" +
                "3. Back to Customer Menu\n" +
                "Your Choice: ");
        choice=in.nextInt();

        switch(choice){
            case 1:
                removeProduct();
                break;
            case 2:
                clearBasket();
                break;
            case 3:
                System.out.println("Going back to Customer Menu");
                break;
            default:
                System.out.println("Invalid choice, Please try again.");
        }
        }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                 in.next(); choice = -1;
            }
    } while (choice != 3);
}

static void removeProduct(){    
    showBasket();
    
    System.out.println("Enter the number of the product you want to remove from the basket:");
    int number=in.nextInt(); 
    boolean found=false;
    
    int index=number-1;
    if ( index >= 0 && index < basket.size()) {    
        Product removedProduct = basket.remove(index); prices.remove(index);   
        System.out.println("Product removed: " + removedProduct .toString());
        found = true; }

    if (!found) {
        System.out.println("Product not found in the basket.");
    }
}

static void clearBasket(){
    basket.clear();
    System.out.println("Basket cleared.");
}

static void showEmployeeInformation(){
    System.out.println("\n****Password is Required to Access Employee Information***");   
    System.out.print("Enter Password:");
    int pass=in.nextInt();
    if(pass==1122){
        System.out.println("\nEmployee Information:");
        for (Employee employee : employees){
        System.out.println("Name: " + employee.getName());
        System.out.println("ID: " + employee.getIdNumber());
        System.out.println("Phone Number: " + employee.getPhoneNumber());
        System.out.print("Salary: ");  showSalary(employee);
        System.out.println("-------------------------"); }
    }
    else System.out.println("\nWrong Password Entry!"); 
}

static void editEmployeeInformation(){
   System.out.println("\nEmployee Information:");
   System.out.print("Enter the ID of the employee you want to edit: ");
   int employeeId=in.nextInt();
    
    for (Employee employee : employees){
        if (employee.getIdNumber() == employeeId){
            // Allow the user to edit employee details
            System.out.println("Editing employee: " + employee.getName());
            System.out.print("Enter the new phone number: ");
            int newPhoneNumber=in.nextInt();
            employee.setPhoneNumber(newPhoneNumber);
            System.out.println("Employee details updated successfully.");
            return;  // Exit the loop once the employee is found and edited
        }
    }    
    System.out.println("Employee with ID " + employeeId + " not found.");
}

static void showSalary(Employee employee){   
    int commisions= employee.commission;       
    if(commisions < 0){
        System.out.println("Invalid input. Please enter a non-negative number of Commissions.");
    }
    else if(commisions==0)
  	System.out.println(b.calculateSalary()+"SAR");	
    else
    System.out.println(b.calculateSalary(commisions)+"SAR");	          
    }
   
    static void ShowBill(){
        if (basket.isEmpty()){ System.out.println("there is no items in the Basket!"); return;}
        System.out.println("Enter Customer Name: ");
        String customerName = in.next();
        
        System.out.println("Enter Customer Phone Number: ");
        int customerPhone = in.nextInt(); in.nextLine();
        
        Random random = new Random();
        int randomIndex = random.nextInt(employees.size());
        String randomEmployeeName = employees.get(randomIndex).getName();
        
        Customer customer = new Customer(customerName, customerPhone);
        double totalBill = a.Bill(basket, prices);
        
    	System.out.println("\nCustomer Bill: "+ totalBill + " SAR");
        if (offer()){
        double discount = 0.1 * totalBill; // 
        System.out.println("Congratulations! You qualify for a 10% discount.");
        System.out.println("Discount Applied: " + discount + " SAR");
        totalBill -= discount;
        System.out.println("Discounted Bill: " + totalBill + " SAR");
        }
    
        System.out.println(customer.toString());
        System.out.print("Served by: " + randomEmployeeName);
        basket.clear(); prices.clear();
        UpdateComissionByName(randomEmployeeName);
    }
     
    public static void UpdateComissionByName(String targetName){
        for(Employee employee : employees){
            if(employee.getName().equals(targetName)){
                employee.commission+=1;
            }
        }
    }

    static String employeeOfDay(ArrayList<Employee> employees){
        if(employees.isEmpty()){
            return "Not Determined Yet.";
        }
        int highestCommissions=0;
        String highEmployee="";
        for(Employee employee : employees){
            if(employee.commission > highestCommissions){
                highestCommissions=(int)employee.commission;
                highEmployee=(String)employee.getName();
            }
        }
        if(highestCommissions==0 || highEmployee.equals("")) return"Not Determined Yet.";
        return "The Employee Of The Day is "+ highEmployee +" Who Had a Number of "+ highestCommissions +" Commissions!";      
    }
}