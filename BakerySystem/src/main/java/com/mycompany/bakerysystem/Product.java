
package com.mycompany.bakerysystem;


import java.time.LocalDate;

public class Product {
    
    private String Name;
    private LocalDate DateCreated;
    private LocalDate expireDate;
    private double Price;
    private static int Quantity;
   
    //Constructers
    Product(){
        DateCreated= LocalDate.now();
    }

    public Product(String Name, double Price){
        this.Name = Name;
        this.Price = Price;
        DateCreated= LocalDate.now();
        ++Quantity;
    } 
    
    //Methods    
    public String getName(){ return this.Name; }
    public double getPrice(){ return this.Price; }
    public void setPrice(double Price){ this.Price = Price; }
    public int getQuantity(){ return Product.Quantity; }
    public LocalDate getDateCreated(){ return this.DateCreated; }
    public void setExpireDate(LocalDate expireDate){ this.expireDate=expireDate; }
    public LocalDate getExpireDate(){ return expireDate; }
    public double priceAfterTax(double price){ price+=(price*(0.15)); return price; }

    public boolean offer(int i){
        if(i>=5)
        return true;  
        else return false;
    }
} //End of Super class (Product)


//Start of Sub classes

class Drinks extends Product {
    
    public final String []TYPE={"Latte","Tea","Oranje juice"};
    public final String []Prices={"10 SAR","2 SAR","7 SAR"};
    private String size;
  
    //Constructers
    Drinks(){}
    
    public Drinks(String Name, double Price, char s){
        super(Name, Price);
        dSize(s); 
        setdateExpires(super.getDateCreated());
    }
     
    //Methods  
    public void setdateExpires(LocalDate DateCreated){
        setExpireDate(DateCreated.plusDays(3));
        System.out.println("*NOTE:it will expire at "+ super.getExpireDate()+"*");      
    }
    
    public void getMenu(){  
        for(int i=0; i<TYPE.length;i++)
        System.out.println((i+7)+"- "+TYPE[i]+"...."+ Prices[i]);
        System.out.print("*for Drink large size add 3 SAR, for meduim add 2 SAR.*");
    }
    
    public void dSize(char s){
        if (Character.toUpperCase(s)=='L')
        {setPrice(getPrice()+3); size="Large";}
        if (Character.toUpperCase(s)=='M')
        { setPrice(getPrice()+2);size="Medium";}
        if (Character.toUpperCase(s)=='S')
        {setPrice(getPrice()); size="Small";}
    }
    
    @Override
    public String toString(){
        return ("product:"+ super.getName()+" drink "+size+" size "+"it's cost after tax "+ priceAfterTax(getPrice())+" SR");        
    }
} //End of Drinks class


class Pastries extends Product {

    public final String []FLAVOR={"cheese","Jam","Zattar"};
    public final String []Prices={"6 SAR","4 SAR","5 SAR"};
     
//Constructers
    Pastries(){}
    Pastries(String Name, double Price){
        super(Name, Price);
        setdateExpires(super.getDateCreated());
    }
   
    //Methods  
    public void getMenu(){
        for(int i=0; i<FLAVOR.length;i++)
        System.out.println((i+4)+"- "+FLAVOR[i]+" Pastry"+"...."+ Prices[i]);
    }
     
    public void setdateExpires(LocalDate DateCreated){
        setExpireDate(DateCreated.plusDays(2));
        System.out.println("*NOTE:it will expire at "+ super.getExpireDate()+"*");      
    }
     
    @Override
    public String toString(){
        return ("product:"+ super.getName()+" flavord pastry "+"it's cost after tax "+ priceAfterTax(getPrice())+" SR");        
    }
} //End of Pastries class


class Cake extends Product {

    public final String []FROASTING={"Vanilla","Chocolate","Strawberry"};
    public final String []Prices={"50 SAR","60 SAR","65 SAR"};
    
    public void getMenu(){
        for(int i=0; i<FROASTING.length;i++)
        System.out.println((i+1)+"- "+ FROASTING[i]+" cake"+"...."+ Prices[i]);
    }
    //Constructers
    Cake(){}
    
    Cake(String Name, double Price){
        super(Name, Price);
        setdateExpires(super.getDateCreated());
    }
     
    //Methods  
    public void setdateExpires(LocalDate DateCreated){
        setExpireDate(DateCreated.plusDays(5));
        System.out.println("*NOTE:it will expire at "+ super.getExpireDate()+"*");      
    }
    
    @Override
    public String toString(){
        return ("product:"+ super.getName()+" Cake "+"it's cost after tax "+ priceAfterTax(getPrice())+" SR");
    }
}  //End of Cake class
