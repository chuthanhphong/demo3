package model.dao.order;

import model.entities.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDAO {
    public boolean createOrder(Order order) throws SQLException;

    public Order searchOrder(int id);

    public List<Order> getAllOrder();

    public boolean deleteOrder(int id) throws SQLException;

    public boolean updateOrder(Order order) throws SQLException;
}
