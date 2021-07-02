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

@WebServlet(name = "signUpServlet",urlPatterns = "/register")
public class SignUpServlet extends HttpServlet {
    private CustomerDAO dao = new CustomerDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        if (dao.checkExistUsername(username) || dao.checkExistPhone(phone)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/register.jsp");
            request.setAttribute("message", "UserName or Phone already exist!");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Customer customer = new Customer();

            customer.setCustomerName(name);
            customer.setCustomerPhone(phone);
            customer.setCustomerAddress(address);
            customer.setCustomerEmail(email);
            customer.setPassword(password);
            customer.setUserName(username);

            dao.createCustomer(customer);
            response.sendRedirect("/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sighup.jsp");
        dispatcher.forward(request,response);
    }
}
