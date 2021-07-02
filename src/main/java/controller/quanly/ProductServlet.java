package controller.quanly;

import model.dao.category.CategoryDAO;
import model.dao.product.ProductDAO;
import model.entities.Category;
import model.entities.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createProduct(request, response);
                    break;
                case "edit":
                    updateProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("productName");

        String provide = request.getParameter("provide");

        String productDescription = request.getParameter("productDescription");

        double productPrice = Double.parseDouble(request.getParameter("productPrice"));

        int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));

        String productImage = request.getParameter("productImage");

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        Product updateProduct = new Product(id,name, provide, productDescription,productPrice,productQuantity,productImage,categoryId);

        productDAO.updateProduct(updateProduct);

        listProduct(request,response);
    }
    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("productName");
        String provide = request.getParameter("provide");
        String productDescription = request.getParameter("productDescription");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        int productQuantity =Integer.parseInt(request.getParameter("productQuantity"));
        String productImage = request.getParameter("productImage");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        //int productID, String productName, String provide, String productDescription, double productPrice, int productQuantity, String productImage, int categoryId)
        Product newProduct = new Product(1,name, provide, productDescription,productPrice,productQuantity,productImage,categoryId);
        productDAO.createProduct(newProduct);
        listProduct(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        try {
            listProduct(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productDAO.searchProduct(id);

        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categoryList = categoryDAO.getAllCategory();
        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Product> list = productDAO.getAllProduct();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/product.jsp");
        dispatcher.forward(request, response);
    }
}
