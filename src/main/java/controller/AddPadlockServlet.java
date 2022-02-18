package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Padlock;

/**
 * Servlet implementation class AddPadlockServlet
 */
@WebServlet("/addPadlockServlet")
public class AddPadlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPadlockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String numPins = request.getParameter("pins");
		String hasSecurityPins = request.getParameter("securitypins");
		
		Padlock padlock = new Padlock(brand, model, Integer.parseInt(numPins), Boolean.parseBoolean(hasSecurityPins));
		PadlockHelper plh = new PadlockHelper();
		plh.insertPadlock(padlock);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
