package model.dao.category;

import model.entities.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    public boolean createCategory(Category category) throws SQLException;

    public Category searchCategory(int id);

    public List<Category> getAllCategory();

    public boolean deleteCategory(int id) throws SQLException;

    public boolean updateCategory(Category category) throws SQLException;
}
