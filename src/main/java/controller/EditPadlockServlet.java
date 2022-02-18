package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Padlock;

/**
 * Servlet implementation class EditPadlockServlet
 */
@WebServlet("/editPadlockServlet")
public class EditPadlockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPadlockServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PadlockHelper plh = new PadlockHelper();
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		int numPins = Integer.parseInt(request.getParameter("pins"));
		boolean hasSecurityPins = Boolean.parseBoolean(request.getParameter("securitypins"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Padlock padlockToUpdate = plh.searchForPadlockById(tempId);
		padlockToUpdate.setBrand(brand);
		padlockToUpdate.setModel(model);
		padlockToUpdate.setNumPins(numPins);
		padlockToUpdate.setHasSecurityPins(hasSecurityPins);
		
		plh.updatePadlock(padlockToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPadlocksServlet").forward(request, response);
	}

}
