import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.LockpickerHelper;
import model.ListDetails;
import model.Lockpicker;
import model.Padlock;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
public class ListDetailsTester {

	public static void main(String[] args) {
		Lockpicker steve = new Lockpicker("Steve");
		Padlock abus5540 = new Padlock("Abus", "5540", 4, true);
		Padlock masterNo3 = new Padlock("Master Lock", "No. 3", 4, false);
		ListDetailsHelper ldh = new ListDetailsHelper();
		List<Padlock> stevesPadlocks = new ArrayList<Padlock>();
		stevesPadlocks.add(abus5540);
		stevesPadlocks.add(masterNo3);
		ListDetails stevesList = new ListDetails("Steve's List", steve);
		stevesList.setListOfPadlocks(stevesPadlocks);
		ldh.insertNewListDetails(stevesList);
		List<ListDetails> allLists = ldh.getLists();

		for (ListDetails ld : allLists) {
			System.out.println(ld.toString());
		}
	}

}
