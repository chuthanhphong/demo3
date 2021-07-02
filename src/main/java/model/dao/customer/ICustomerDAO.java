package model.dao.customer;

import model.entities.Category;
import model.entities.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public boolean createCustomer(Customer customer) throws SQLException;

    public Customer searchCustomer(int id);

    public List<Customer> getAllCustomer();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
}
