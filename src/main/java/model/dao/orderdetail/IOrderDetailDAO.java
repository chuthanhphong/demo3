package model.dao.orderdetail;

import model.entities.Order;
import model.entities.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDetailDAO {
    public boolean createOrderDetail(OrderDetail orderDetail) throws SQLException;

    public List<OrderDetail> searchOrderDetail(int id);

    public List<OrderDetail> getAllOrderDetail();

    public boolean deleteOrderDetail(int id1,int id2) throws SQLException;

}
