package model.entities;

public class OrderDetail {
    private int orderId;
    private int productId;
    private int quantityOder;
    private double payAmount;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int productId, int quantityOder, double payAmount) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantityOder = quantityOder;
        this.payAmount = payAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantityOder() {
        return quantityOder;
    }

    public void setQuantityOder(int quantityOder) {
        this.quantityOder = quantityOder;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", quantityOder=" + quantityOder +
                ", payAmount=" + payAmount +
                '}';
    }
}
