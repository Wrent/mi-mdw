package proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import balancer.LoadBalancer;
import balancer.Main;

/**
 * Servlet implementation class ProxyServlet
 */
public class ProxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProxyServlet() {
		super();
        (new Thread(new Main())).start();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// url
		LoadBalancer instance = LoadBalancer.getInstance();
		//instance.checkResourcesAvailability();
		String url = instance.getValidUrl();
		if (url != null) {
			final HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
			// HTTP method
			connection.setRequestMethod("GET");
			// copy headers
			((ArrayList) Collections.list(request.getHeaderNames())).forEach(new Consumer() {
				@Override
				public void accept(Object head) {
					connection.setRequestProperty((String) head, request.getHeader((String) head));
				}
			});
			// copy body
			BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			ServletOutputStream sout = response.getOutputStream();
			while ((inputLine = inputStream.readLine()) != null) {
				sout.write(inputLine.getBytes());
			}
			// close
			inputStream.close();
			sout.flush();
		} else {
			response.getWriter().write("No resource available in the pool.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
