package controller.quanly;

import model.dao.orderdetail.OrderDetailDAO;
import model.entities.OrderDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderdetailServlet",urlPatterns = "/orderdetail")
public class OrderdetailServlet extends HttpServlet {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderID = Integer.parseInt(request.getParameter("id"));
        System.out.println(orderID);
        List<OrderDetail> orderDetailList = orderDetailDAO.searchOrderDetail(orderID);

        request.setAttribute("orderDetailList",orderDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/quanly/orderdetail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
