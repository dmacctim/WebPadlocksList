package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Lockpicker;
import model.Padlock;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PadlockHelper ph = new PadlockHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		String lockpickerName = request.getParameter("lockpickerName");
		String[] selectedPadlocks = request.getParameterValues("allPadlocksToAdd");
		List<Padlock> selectedPadlocksInList = new ArrayList<Padlock>();
		
		if (selectedPadlocks != null && selectedPadlocks.length > 0) {
			for (int i = 0; i < selectedPadlocks.length; i++) {
				System.out.println(selectedPadlocks[i]);
				Padlock p = ph.searchForPadlockById(Integer.parseInt(selectedPadlocks[i]));
				selectedPadlocksInList.add(p);
			}
		}
		
		Lockpicker lockpicker = new Lockpicker(lockpickerName);
		ListDetails pld = new ListDetails(listName, lockpicker);
		pld.setListOfPadlocks(selectedPadlocksInList);
		ListDetailsHelper plh = new ListDetailsHelper();
		plh.insertNewListDetails(pld);
		System.out.println("Success!");
		System.out.println(pld.toString());
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
