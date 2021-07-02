package model.entities;

public class Order {
    private int orderID;
    private int customerID;
    private String orderDate;
    private boolean isShipped;

    public Order() {
    }

    public Order(int orderID, int customerID, String orderDate, boolean isShipped) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.isShipped = isShipped;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isShipped() {
        return isShipped;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate='" + orderDate + '\'' +
                ", isShipped=" + isShipped +
                '}';
    }
}
