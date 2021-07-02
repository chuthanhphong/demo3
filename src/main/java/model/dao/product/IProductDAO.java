package model.dao.product;



import model.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public boolean createProduct(Product product) throws SQLException;

    public Product searchProduct(int id);

    public List<Product> getAllProduct();

    public boolean deleteProduct(int id) throws SQLException;

    public boolean updateProduct(Product product) throws SQLException;
}
