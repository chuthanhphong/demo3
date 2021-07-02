package model.dao.product;

import model.dao.connection.ConnectionDataBase;
import model.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{

    protected Connection getConnection() {
        return ConnectionDataBase.getConnection();
    }

    @Override
    public boolean createProduct(Product product) throws SQLException {
        boolean isCreated = false;
        String query = "{CALL create_product(?,?,?,?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,product.getProductName());
            callableStatement.setString(2,product.getProvide());
            callableStatement.setString(3,product.getProductDescription());
            callableStatement.setDouble(4,product.getProductPrice());
            callableStatement.setInt(5,product.getProductQuantity());
            callableStatement.setString(6,product.getProductImage());
            callableStatement.setInt(7,product.getCategoryId());
            isCreated = callableStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public Product searchProduct(int id) {
        Product product = null;
        String query = "{CALL get_product_by_id(?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString(2);
                String provide = rs.getString(3);
                String description = rs.getString(4);
                double price = rs.getDouble(5);
                int quantity = rs.getInt(6);
                String image = rs.getString(7);
                int categoryId = rs.getInt(8);

                product = new Product(id,name,provide,description,price,quantity,image,categoryId);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String query = "{CALL get_all_product()}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String provide = rs.getString(3);
                String description = rs.getString(4);
                double price = rs.getDouble(5);
                int quantity = rs.getInt(6);
                String image = rs.getString(7);
                int categoryId = rs.getInt(8);

                Product product = new Product(id,name,provide,description,price,quantity,image,categoryId);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean isDelete = false;
        String query = "{CALL delete_product(?)}";
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
    public boolean updateProduct(Product product) throws SQLException {
        boolean isUpdate = false;
        String query = "{CALL update_product(?,?,?,?,?,?,?,?)}";
        try{
            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,product.getProductID());
            callableStatement.setString(2,product.getProductName());
            callableStatement.setString(3,product.getProvide());
            callableStatement.setString(4,product.getProductDescription());
            callableStatement.setDouble(5,product.getProductPrice());
            callableStatement.setInt(6,product.getProductQuantity());
            callableStatement.setString(7,product.getProductImage());
            callableStatement.setInt(8,product.getCategoryId());

            isUpdate = callableStatement.execute();
            System.out.println(query);
            System.out.println(callableStatement);

        }catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }
}
