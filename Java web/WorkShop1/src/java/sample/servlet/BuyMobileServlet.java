/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.Cart;
import sample.tbl_cart.tbl_CartDAO;

/**
 *
 * @author Ngo Nhat Do
 */
@WebServlet(name = "BuyMobileServlet", urlPatterns = {"/BuyMobileServlet"})
public class BuyMobileServlet extends HttpServlet {

    private final String searchPage = "searchByUser.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = searchPage;
        String button = request.getParameter("btAction");
        try {
            if (button.equals("Buy Mobile")) {
                HttpSession session = request.getSession(false);
                if (session != null) {
                    String userId = (String) session.getAttribute("USERNAME");
                    Cart cart = (Cart) session.getAttribute("CART");
                    tbl_CartDAO dao = new tbl_CartDAO();
                    if (cart != null) {
                        Map<String, Integer> items = cart.getMobiles();
                        if (items != null) {
                            for (Map.Entry<String, Integer> item : items.entrySet()) {
                                boolean result = dao.buyMobile(userId, item.getKey(), item.getValue());
                            }
                        }
                    }
                    cart.empty();
                }
            }
        } catch (NamingException ex) {
            log("BuyMobileServlet_Naming: " + ex.getMessage());
        } catch (SQLException ex) {
            log("BuyMobileServlet_SQL: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
