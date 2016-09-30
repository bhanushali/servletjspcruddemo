/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.servlet;

import com.niit.dao.EmployeeDAO;
import com.niit.dao.EmployeeDAOImpl;
import com.niit.entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MRuser
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeController.do"})
public class EmployeeController extends HttpServlet {
    
    private static final String LIST_VIEW = "employeeList.jsp";
    private static final String FORM_VIEW = "employeeForm.jsp";
    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String forward = "";
        try (PrintWriter out = response.getWriter()) {
            String operation = request.getParameter("operation");
            if(operation.equalsIgnoreCase("list")) {                
                request.setAttribute("employees", employeeDAO.getAll());
                forward = LIST_VIEW;
            }
            else if(operation.equalsIgnoreCase("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                // fetch the employee using the id                                                
                Employee employee = employeeDAO.get(id);
                // using your daoimpl call the update method                                 
                // what to view next
                request.setAttribute("employee", employee);
                forward = FORM_VIEW;
            
            }
            else if(operation.equalsIgnoreCase("save")) {
                
                
                
                
            }    
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            
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
