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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
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
		ListDetailsHelper ldh = new ListDetailsHelper();
		PadlockHelper ph = new PadlockHelper();
		LockpickerHelper lh = new LockpickerHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String lockpickerName = request.getParameter("lockpickerName");
		Lockpicker newLockpicker = lh.findLockpicker(lockpickerName);
		
		try {
			String[] selectedPadlocks = request.getParameterValues("allPadlocksToAdd");
			List<Padlock> selectedPadlocksInList = new ArrayList<Padlock>();

			for (int i = 0; i < selectedPadlocks.length; i++) {
				System.out.println(selectedPadlocks[i]);
				Padlock p = ph.searchForPadlockById(Integer.parseInt(selectedPadlocks[i]));
				selectedPadlocksInList.add(p);
			}
			
			listToUpdate.setListOfPadlocks(selectedPadlocksInList);
		} catch (NullPointerException ex) {
			List<Padlock> selectedPadlocksInList = new ArrayList<Padlock>();
			listToUpdate.setListOfPadlocks(selectedPadlocksInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setLockpicker(newLockpicker);
		ldh.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
