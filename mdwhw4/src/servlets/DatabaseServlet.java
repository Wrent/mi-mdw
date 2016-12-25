package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DatabaseServlet
 */
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource ds;
	private Connection conn;

	/**
	 * @throws NamingException
	 * @throws SQLException
	 * @see HttpServlet#HttpServlet()
	 */
	public DatabaseServlet() throws NamingException, SQLException {
		super();
		InitialContext ctx = new InitialContext();
		ds = (DataSource) ctx.lookup("travel");
		conn = ds.getConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.append("<h1>Records</h1>");
		out.append("<table border=1>");
		out.append(
				"<tr><th>id</th><th>type</th><th>location</th><th>capacity</th><th>occupied</th><th>trip</th><th>person</th></tr>");
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM records";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				out.append("<tr>");
				out.append("<td>" + Integer.toString(rs.getInt("id")) + "</td>");
				out.append("<td>" + rs.getString("type") + "</td>");
				out.append("<td>" + rs.getString("location") + "</td>");
				out.append("<td>" + Integer.toString(rs.getInt("capacity")) + "</td>");
				out.append("<td>" + Integer.toString(rs.getInt("occupied")) + "</td>");
				out.append("<td>" + Integer.toString(rs.getInt("trip")) + "</td>");
				out.append("<td>" + rs.getString("person") + "</td>");
				out.append("</tr>");
			}

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.append("</table>");
	}

}
