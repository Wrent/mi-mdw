package servlets;

import model.State;
import model.State.StateType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
public class TripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int sessionManagement = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		State state = null;

		if (request.getParameter("confirm") != null) {
			state = (State) session.getAttribute("state");
			if (state != null) {
				state.confirm();
			}
		} else if (request.getParameter("pay") != null) {
			state = (State) session.getAttribute("state");
			if (state != null) {
				state.pay();
			}

		}

		if (state == null) {
			state = new State(sessionManagement++);
		}
		session.setAttribute("state", state);

		if (state.getState() == StateType.COMPLETED) {
			session.invalidate();
		}

		String status = "";
		String message = "";
		switch (state.getState()) {
		case NEW:
			status = "NEW";
			message = "To confirm, click <a href=\"?confirm\">here</a> or send GET param confirm.";
			break;
		case WAITING:
			status = "WAITING";
			message = "To pay, click <a href=\"?pay\">here</a> or send GET param pay.";
			break;
		case COMPLETED:
			status = "COMPLETED";
			message = "Thank you for your payment.";
			break;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Your status is " + status);
		out.println(message);
	}

}
