/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.tbl_mobile.tbl_MobileDAO;

/**
 *
 * @author Ngo Nhat Do
 */
@WebServlet(name = "UpdateMobileServlet", urlPatterns = {"/UpdateMobileServlet"})
public class UpdateMobileServlet extends HttpServlet {

    private final String updateErr = "updateErr.html";

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
        String urlRewriting = updateErr;
        try {
            String mobileId = request.getParameter("txtUsername");
            String description = request.getParameter("txtDescription");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            String chkNotSale = request.getParameter("chkNotSale");
            String lastSearchValue = request.getParameter("lastSearchValue");
            String lastTypeSearchValue = request.getParameter("lastTypeSearchValue");
            boolean notSale = false;
            if (chkNotSale != null) {
                notSale = true;
            }
            tbl_MobileDAO dao = new tbl_MobileDAO();
            boolean result = dao.updateMobile(mobileId, description, price, quantity, notSale);
            if (result) {
                urlRewriting = "searchByStaff?"
                        + "&txtSearchValue=" + lastSearchValue
                        + "&typeSearch=" + lastTypeSearchValue;
            }

        } catch (NamingException ex) {
            log("UpdateMobileServlet_Naming: " + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateMobileServlet_SQL: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            log("UpdateMobileServlet_NumberFormat: " + ex.getMessage());
        } finally {
            response.sendRedirect(urlRewriting);
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
