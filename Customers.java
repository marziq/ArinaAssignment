package Arina;

public class Customers extends Persons{
    private double totalPurchase = 0;
    private static int customersCount = 0;

    Customers(){
    }
    Customers(String name, String contactNumber, String address){
        setName(name);
        setContactNumber(contactNumber);
        setAddress(address);
        customersCount++;
    }
    public void updateTotalPurchase(double amount){
        totalPurchase += amount;
    }
    public static int getCustomersCount(){
        return customersCount;
    }
    public double getTotalPurchase(){
        return totalPurchase;
    }
}
