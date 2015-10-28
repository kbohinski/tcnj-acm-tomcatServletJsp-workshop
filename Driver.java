import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Driver
 */

/* What urls does this work on? */
@WebServlet("/")
public class Driver extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Driver() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter page = response.getWriter();
		Map<String, String[]> params = request.getParameterMap();
		URL fileUrl = new URL(
				"https://raw.githubusercontent.com/kbohinski/Michael-Scott-API/master/QuoteData.txt");
		if (params.containsKey("name")) {
			page.print("Hello " + params.get("name")[0].toString());
		} else {
			Random rng = new Random();
			ArrayList<String> quotes = new ArrayList<String>();
			for (Scanner in = new Scanner(fileUrl.openStream()); in
					.hasNext();) {
				quotes.add(in.nextLine());
			}
			int r = rng.nextInt(quotes.size());
			page.print("{ \"quote\": \"\"" + quotes.get(r)
					+ "\" - Michael Scott\" }");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
