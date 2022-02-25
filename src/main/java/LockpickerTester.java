import java.util.List;

import controller.LockpickerHelper;
import model.Lockpicker;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
public class LockpickerTester {

	public static void main(String[] args) {
		Lockpicker jim = new Lockpicker("Jim");
		Lockpicker bob = new Lockpicker("Bob");
		LockpickerHelper lh = new LockpickerHelper();
		lh.insertLockpicker(jim);
		lh.insertLockpicker(bob);
		List<Lockpicker> allLockpickers = lh.showAllLockpickers();
		
		for (Lockpicker l : allLockpickers) {
			System.out.println(l.toString());
		}
	}

}
