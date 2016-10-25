package hogm.hnapi.servlet;

import hogm.hnapi.dao.LuckyNumberDAO;
import hogm.hnapi.pojo.LuckyNumberEntity;
import hogm.hnapi.pojo.LuckyNumberPojo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This servlet calls the persist() method for storing a random number into a
 * MongoDB collection
 *
 */
@WebServlet(name = "LuckyNumberServlet", urlPatterns = {"/LuckyNumberServlet"})
public class LuckyNumberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            LuckyNumberDAO luckyNumberDAO = new LuckyNumberDAO();
            //LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
            //luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));

            //luckyNumberDAO.persist_cs_without_cfg(luckyNumberEntity);
            //luckyNumberDAO.persist_os_without_cfg(luckyNumberEntity);
            
            LuckyNumberPojo luckyNumberPojo = new LuckyNumberPojo();
            luckyNumberPojo.setLuckynumber(new Random().nextInt(1000000));

            luckyNumberDAO.persist_cs_with_cfg(luckyNumberPojo);
            //luckyNumberDAO.persist_os_with_cfg(luckyNumberPojo);
            
            response.sendRedirect("/HOGMviaHNAPI_JDBC_Tomcat7/index.jsp");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LuckyNumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LuckyNumberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
