package controller.quanly;

import model.dao.order.OrderDAO;
import model.dao.orderdetail.OrderDetailDAO;
import model.dao.product.ProductDAO;
import model.entities.Order;
import model.entities.OrderDetail;
import model.entities.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ProductDAO dao = new ProductDAO();
    private OrderDAO daoO = new OrderDAO();
    private OrderDetailDAO dao1 = new OrderDetailDAO();

    private List<Product> cart = new ArrayList<>();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "buy":
                buyProduct(request,response);
                break;
            case "xoa":
                deleteFromCart(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void deleteFromCart(HttpServletRequest request, HttpServletResponse response) {
        int productID = Integer.parseInt(request.getParameter("productID"));
        Product product = null;
        for (Product p:cart
        ) {
            if(p.getProductID()==productID){
                product = p;
            }
        }
        cart.remove(product);
        jumbToCart(request,response);
    }

    private void buyProduct(HttpServletRequest request, HttpServletResponse response){
        int customerID = Integer.parseInt(request.getParameter("customerID"));

        String date = LocalDate.now().toString();

        Order order = new Order(1,customerID,date,true);
        daoO.createOrder(order);

        int orderID = daoO.searchOrderId(customerID);
        for (Product p:cart
             ) {
            int id = p.getProductID();
            int soluongmua = p.getProductQuantity();
            int productId = p.getProductID();
            double amount = soluongmua*p.getProductPrice();



            OrderDetail od = new OrderDetail(orderID,productId,soluongmua,amount);
            dao1.createOrderDetail(od);

            Product product = dao.searchProduct(id);
            int n = product.getProductQuantity()-soluongmua;
            product.setProductQuantity(n);

            try {
                dao.updateProduct(product);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        cart = new ArrayList<>();

        try {
            response.sendRedirect("/DaMuaHang.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "jumbToCart":
                jumbToCart(request,response);
                break;
            case "them":
                addToCart(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }




    }

    private void jumbToCart(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = cart;
        double total = 0;
        for (Product p:cart
             ) {
            double price = p.getProductPrice();
            int quantity = p.getProductQuantity();
            total += price*quantity;
        }
        request.setAttribute("total",total);
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart/cart.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = dao.searchProduct(id);

        if(isOnCart(id)){
            Product p1 = getProductFromCart(id);
            int a = p1.getProductQuantity()+1;
            p1.setProductQuantity(a);
        }else{
            product.setProductQuantity(1);
            cart.add(product);
        }

        listProduct(request,response);

    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> list = dao.getAllProduct();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnCart(int id){
        for (Product p: cart
             ) {
            if(p.getProductID()==id){
                return true;
            }
        }
        return false;
    }

    private Product getProductFromCart(int id){
        for (Product p: cart
        ) {
            if(p.getProductID()==id){
                return p;
            }
        }
        return null;
    }
}
