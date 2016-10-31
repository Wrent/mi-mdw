package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Database;
import persistence.Trip;
import weblogic.servlet.annotation.WLServlet;

/**
 * Servlet implementation class ProcessingServlet
 */
@WLServlet (
        name = "ProcessingServlet", mapping = {"/processingServlet"}
)
public class ProcessingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String name = request.getParameter("trip");
        String capacity = request.getParameter("capacity");
        Random rn = new Random();
        Trip trip = new Trip(rn.nextInt(), Integer.parseInt(capacity), name);
        Database db = Database.getInstance();
        
        db.addObject(trip);
        response.sendRedirect("index.jsp");
    }

}
