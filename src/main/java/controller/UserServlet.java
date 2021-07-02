package controller;

import model.dao.customer.CustomerDAO;
import model.entities.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    CustomerDAO userDAO = new CustomerDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = userDAO.getAllCustomer();
        request.setAttribute("userList", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/customer.jsp");
        dispatcher.forward(request, response);
    }
}
