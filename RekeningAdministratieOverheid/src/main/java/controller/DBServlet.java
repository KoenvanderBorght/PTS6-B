/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CarTrackerDAO;
import dao.CarTrackerDAOImp;
import dao.NawDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.NawDAOImp;
import javax.servlet.RequestDispatcher;
import model.CarTracker;
import model.NAW;
import service.CarTrackerService;
import service.NAWService;

/**
 *
 * @author koenv
 */
@WebServlet(name = "CarTrackerAdm", urlPatterns = {"/CarTrackerAdm", "/CarTrackerList", "/NawList"})
public class DBServlet extends HttpServlet{
    @EJB
    NAWService ns;
    
    @EJB
    CarTrackerService cts;
    

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)  
 throws ServletException, IOException {  
            
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        String userPath = req.getServletPath();

        switch (userPath) {
            case "/CarTrackerAdm": {
                RequestDispatcher view = req.getRequestDispatcher("index.jsp");
                view.forward(req, res);
                break;
            }
            case "/Index": {
                RequestDispatcher view = req.getRequestDispatcher("index.jsp");
                view.forward(req, res);
                break;
            }
            case "/": {
                RequestDispatcher view = req.getRequestDispatcher("index.jsp");
                view.forward(req, res);
                break;
            }
            case "/CarTrackerList": {
                RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/pages/cartrackerlist.jsp");
                view.forward(req, res);
                break;
            }
            case "/NawList": {
                req.setAttribute("naws", ns.getAllNaws());
                RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/pages/NawList.jsp");
                view.forward(req, res);
                break;
            }
        }
        
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String userPath = req.getServletPath();
        if (userPath.equals("/CarTrackerAdm")) {

            String firstname = req.getParameter("firstname");
            String lastname = req.getParameter("lastname");
            String address = req.getParameter("address");
            String number = req.getParameter("number");
            String zipcode = req.getParameter("zipcode");
            String city = req.getParameter("city");
            String telephone = req.getParameter("telephone");
            NAW n = new NAW(firstname, lastname, address, number, zipcode, city, telephone);
            ns.createNAW(n);  
        }
    }
    
}
