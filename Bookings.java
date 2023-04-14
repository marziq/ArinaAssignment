package Arina;

public class Bookings {
    private String customerName;
    private int productCode;
    private int quantity;

    Bookings(){
    }
    Bookings(String customerName, int productCode, int quantity){
        this.customerName = customerName;
        this.productCode = productCode;
        this.quantity = quantity;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getProductCode(){
        return productCode;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setProductCode(int productCode){
        this.productCode = productCode;
    }
}
