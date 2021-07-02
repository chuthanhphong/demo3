package controller;

import com.mysql.cj.Session;
import model.dao.customer.CustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private CustomerDAO daoC = new CustomerDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isValid = daoC.checkLogin(username, password);
        HttpSession session = request.getSession();
        if (isValid) {
//            request.setAttribute("tendangnhap", username);
            RequestDispatcher dispatcher;
            if (username.equals("admin") && password.equals("admin")) {
                dispatcher = request.getRequestDispatcher("/admin.jsp");
                dispatcher.forward(request,response);
            }else {
//                Session session =
                int id = daoC.getCustomerId(username);
//                request.setAttribute("customerID",id);
                session.setAttribute("customerID", id);

                response.sendRedirect("/customer");
            }

        }else {
            request.setAttribute("message", "DANG NHAP KHONG THANH CONG MOI DANG NHAP LAI");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request,response);
    }
}
