package model.dao.orderdetail;

import model.dao.connection.ConnectionDataBase;
import model.entities.Order;
import model.entities.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO implements IOrderDetailDAO {

    protected Connection getConnection() {
        return ConnectionDataBase.getConnection();
    }
    @Override
    public boolean createOrderDetail(OrderDetail orderDetail)  {
        boolean isCreate = false;
        String query = "{CALL create_orderdetail(?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,orderDetail.getOrderId());
            callableStatement.setInt(2,orderDetail.getProductId());
            callableStatement.setInt(3,orderDetail.getQuantityOder());
            callableStatement.setDouble(4,orderDetail.getPayAmount());

            isCreate = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isCreate;

    }

    @Override
    public List<OrderDetail> searchOrderDetail(int id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "{CALL get_orderdetail_by_id(?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();

            while(rs.next()){
                int productId = rs.getInt(2);
                int quantity = rs.getInt(3);
                double payment = rs.getDouble(4);

                OrderDetail orderDetail = new OrderDetail(id,productId,quantity,payment);

                orderDetails.add(orderDetail);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "{CALL get_all_orderdetail()}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                int productId = rs.getInt(2);
                int quantity = rs.getInt(3);
                double payment = rs.getDouble(4);

                OrderDetail orderDetail = new OrderDetail(id,productId,quantity,payment);

                orderDetails.add(orderDetail);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderDetails;
    }

    @Override
    public boolean deleteOrderDetail(int id1,int id2) {
        boolean isDelete = false;
        String query = "{CALL delete_orderdetail(?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id1);
            callableStatement.setInt(2,id2);
            isDelete = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isDelete;
    }


}
