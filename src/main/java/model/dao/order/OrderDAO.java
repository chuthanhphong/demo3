package model.dao.order;


import model.dao.connection.ConnectionDataBase;
import model.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    protected Connection getConnection() {
        return ConnectionDataBase.getConnection();
    }
    @Override
    public boolean createOrder(Order order){
        boolean isCreated = false;
        String query = "{CALL create_order(?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,order.getCustomerID());
            callableStatement.setString(2,order.getOrderDate());
            callableStatement.setBoolean(3,order.isShipped());

            isCreated = callableStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public Order searchOrder(int id) {
        Order order = null;
        String query = "{CALL get_order_by_id(?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();

            System.out.println(callableStatement);

            while(rs.next()){
                int CusId = rs.getInt(2);
                String date = rs.getString(3);
                boolean isShipped = rs.getBoolean(4);

                order = new Order(id,CusId,date,isShipped);
                System.out.println(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = new ArrayList<>();
        String query = "{CALL get_all_order()}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                int CusId = rs.getInt(2);
                String date = rs.getString(3);
                boolean isShipped = rs.getBoolean(4);

                Order order = new Order(id,CusId,date,isShipped);
                orders.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean deleteOrder(int id) {
        boolean isDelete = false;
        String query = "{CALL delete_order(?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            isDelete = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }

        return isDelete;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean isUpdate = false;
        String query = "{CALL update_order(?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,order.getOrderID());
            callableStatement.setInt(2,order.getCustomerID());
            callableStatement.setString(3,order.getOrderDate());
            callableStatement.setBoolean(4,order.isShipped());

            isUpdate = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }
    public int searchOrderId(int customerId){
        Connection connection = getConnection();
        int result = 0;
        try{
            String query = "select orderID from orders where customerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,customerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                result = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
