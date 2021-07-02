package model.entities;

public class Product {
    private int productID;
    private String productName;
    private String provide;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private String productImage;
    private int categoryId;

    public Product() {
    }

    public Product(int productID, String productName, String provide, double productPrice, int productQuantity, String productImage, int categoryId) {
        this.productID = productID;
        this.productName = productName;
        this.provide = provide;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
        this.categoryId = categoryId;
    }

    public Product(int productID, String productName, String provide, String productDescription, double productPrice, int productQuantity, String productImage, int categoryId) {
        this.productID = productID;
        this.productName = productName;
        this.provide = provide;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImage = productImage;
        this.categoryId = categoryId;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProvide() {
        return provide;
    }

    public void setProvide(String provide) {
        this.provide = provide;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", provide='" + provide + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productImage='" + productImage + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
