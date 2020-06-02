/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.tbl_mobile.tbl_MobileDAO;
import sample.tbl_mobile.tbl_MobileInsertErr;

/**
 *
 * @author Ngo Nhat Do
 */
@WebServlet(name = "InsertNewMobileServlet", urlPatterns = {"/InsertNewMobileServlet"})
public class InsertNewMobileServlet extends HttpServlet {

    private final String loginPage = "login.html";
    private final String insertErrPage = "insertNewMobile.jsp";

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
        String url = insertErrPage;
        String mobileId = request.getParameter("txtMobileId");
        String description = request.getParameter("txtDescription");
        String price = request.getParameter("txtPrice");
        String mobileName = request.getParameter("txtMobileName");
        String yearOfProduction = request.getParameter("txtYearOfProduction");
        String quantity = request.getParameter("txtQuantity");
        String chkNotSale = request.getParameter("chkNotSale");
        boolean notSale = false;
        int quantitys = 0;
        float prices = 0;
        int yearOfProductions = 0;
        boolean bErr = false;
        tbl_MobileInsertErr error = new tbl_MobileInsertErr();
        try {
            if (mobileId.trim().length() < 2 || mobileId.trim().length() > 10) {
                bErr = true;
                error.setMobileIdLengthErr("Mobile Id is required 2-10 chars!!");
            }
            if (description.trim().length() < 1) {
                bErr = true;
                error.setDescriptionEmptyErr("Description is not empty!!");
            }
            try {
                prices = Float.parseFloat(price);
                if (prices <= 0) {
                    bErr = true;
                    error.setPriceFormatErr("Price is posity!!");
                }
            } catch (NumberFormatException e) {
                bErr = true;
                error.setPriceFormatErr("Price is float!!");
            }
            if (mobileName.trim().length() < 2 || mobileId.trim().length() > 20) {
                bErr = true;
                error.setMobileNameLengthErr("Mobile name is required 2-20 chars");
            }
            try {
                yearOfProductions = Integer.parseInt(yearOfProduction);
                if (yearOfProductions <= 0) {
                    bErr = true;
                    error.setYearOfProductionFormatErr("Year Of Productions is posity!!");
                }
            } catch (NumberFormatException e) {
                bErr = true;
                error.setYearOfProductionFormatErr("Year Of Productions is Number!!");
            }
            try {
                quantitys = Integer.parseInt(quantity);
                if (quantitys <= 0) {
                    bErr = true;
                    error.setQuantityFormatErr("Quantity is posity");
                }
            } catch (NumberFormatException e) {
                bErr = true;
                error.setQuantityFormatErr("Quantity is number");
            }
            if (chkNotSale != null) {
                notSale = true;
            }

            if (bErr) {
                request.setAttribute("INSERTERR", error);
            } else {
                tbl_MobileDAO dao = new tbl_MobileDAO();
                System.out.println("asd");
                boolean result = dao.insertMobile(mobileId, description, prices,
                        mobileName, yearOfProductions, quantitys, notSale);
                if (result) {
                    url = loginPage;
                }
                System.out.println(result);
            }
        } catch (NamingException ex) {
            log("InsertNewMobileServlet_Naming: " + ex.getMessage());
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("InsertNewMobileServlet_SQL: " + msg);
            if (msg.contains("duplicate")) {
                error.setMobileIdIsExited(mobileId + " is existed");
                request.setAttribute("INSERTERR", error);
            }
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
