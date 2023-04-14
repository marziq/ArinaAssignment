package Arina;

public class Products {
    private int productCode;
    private String productName;
    private double productPrice;
    private static int productCounts = 0;

    Products(){
        productCounts++;
    }
    Products(int productCode, String productName, double productPrice){
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        productCounts++;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setProductCode(int productCode){
        this.productCode = productCode;
    }

    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public int getProductCode(){
        return productCode;
    }
    public String getProductName(){
        return productName;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public static int getProductCounts(){
        return productCounts;
    }
}
