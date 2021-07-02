package model.dao.customer;

import model.dao.connection.ConnectionDataBase;
import model.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{

    protected Connection getConnection() {
        return ConnectionDataBase.getConnection();
    }
    @Override
    public boolean createCustomer(Customer customer) {
        boolean isCreated = false;
        String query = "{CALL create_customer(?,?,?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,customer.getCustomerName());
            callableStatement.setInt(2,customer.getCustomerPhone());
            callableStatement.setString(3, customer.getCustomerEmail());
            callableStatement.setString(4, customer.getCustomerAddress());
            callableStatement.setString(5, customer.getUserName());
            callableStatement.setString(6, customer.getPassword());

            isCreated = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public Customer searchCustomer(int id) {
        Customer customer = null;
        String query = "{CALL get_customer_by_id(?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString(2);
                int phone = rs.getInt(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String userName = rs.getString(6);
                String password = rs.getString(7);

                customer = new Customer(id,name,phone,email,address,userName,password);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;

    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        String query = "{CALL get_all_customer()}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int phone = rs.getInt(3);
                String email = rs.getString(4);
                String address = rs.getString(5);
                String userName = rs.getString(6);
                String password = rs.getString(7);

                Customer customer = new Customer(id,name,phone,email,address,userName,password);
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean isDelete = false;
        String query = "{CALL delete_customer(?)}";
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
    public boolean updateCustomer(Customer customer) {
        boolean isUpdate = false;
        String query = "{CALL update_customer(?,?,?,?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);

            callableStatement.setInt(1,customer.getCustomerId());
            callableStatement.setString(2,customer.getCustomerName());
            callableStatement.setInt(3,customer.getCustomerPhone());
            callableStatement.setString(4, customer.getCustomerEmail());
            callableStatement.setString(5, customer.getCustomerAddress());
            callableStatement.setString(6, customer.getUserName());
            callableStatement.setString(7, customer.getPassword());

            isUpdate = callableStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }

    public boolean checkLogin(String username, String password) {
        boolean isValid = false;
        try {
            Connection connection = getConnection();
            String sql = "select * from customers where userName = ? and password = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                isValid = true;
            }else {
                isValid = false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isValid;
    }
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        Connection connection = getConnection();
        try {
            String query = "select * from customer where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                duplicate = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return duplicate;
    }
    public boolean checkExistPhone(int phone) {
        boolean duplicate = false;
        Connection connection = getConnection();
        try {
            String query = "select * from customer where customerPhone = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                duplicate = true;
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        }
        return duplicate;
    }

    public int getCustomerId(String userName){
        Connection connection = getConnection();
        int result = 0;
        try{
            String query = "select customerID from customers where userName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
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
