package servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.Database;
import persistence.Trip;
import weblogic.servlet.annotation.WLServlet;

/**
 * Servlet implementation class ReservingServlet
 */
@WLServlet (
        name = "ProcessingServlet", mapping = {"/reservingServlet"}
)
public class ReservingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // reading the user input
        String name = request.getParameter("name");
        String id = request.getParameter("id");
     
        Database db = Database.getInstance();
        Trip trip = db.getObject(Integer.parseInt(id));
        trip.addReservation(name);
        
        response.sendRedirect("index.jsp");
	}

}
