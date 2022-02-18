import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.PadlockHelper;
import model.Padlock;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 2, 2022  
*/
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static PadlockHelper ph = new PadlockHelper();

	private static void addAPadlock() {
		System.out.print("Enter a brand: ");
		String brand = in.nextLine();
		System.out.print("Enter a model: ");
		String model = in.nextLine();
		
		int numPins = 0;
		while (numPins <= 0) {
			try {
				System.out.print("Enter the number of pins: ");
				numPins = in.nextInt();
				
				if (numPins <= 0) {
					System.out.println("Must be greater than 0.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter a numerical value.");
				in.next();
			}
		}
		
		boolean hasSecurityPins = false;
		boolean validEntry = false;
		while (!validEntry) {
			try {
				System.out.print("Has security pins? (type true or false): ");
				hasSecurityPins = in.nextBoolean();
				validEntry = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid.");
				in.next();
			}
		}
		
		Padlock toAdd = new Padlock(brand, model, numPins, hasSecurityPins);
		ph.insertPadlock(toAdd);
	}
	
	private static void deleteAPadlock() {
		System.out.println("How would you like to search?");
		System.out.println("1: Search by Brand");
		System.out.println("2: Search by Model");
		System.out.println("3: Cancel");
		System.out.print("Selection: ");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Padlock> foundPadlocks = new ArrayList<>();
		
		if (searchBy == 1) {
			System.out.print("Enter the brand name: ");
			String brand = in.nextLine();
			foundPadlocks = ph.searchForPadlockByBrand(brand);
		} else if (searchBy == 2) {
			System.out.print("Enter the model name: ");
			String model = in.nextLine();
			foundPadlocks = ph.searchForPadlockByModel(model);
		} else if (searchBy == 3) {
			System.out.println("Deletion canceled.");
		} else {
			System.out.println("Invalid selection.");
		}
		
		if (!foundPadlocks.isEmpty()) {
			System.out.println("Found Results.");
			for (Padlock padlock : foundPadlocks) {
				System.out.println("ID " + padlock.getId() + ": " + padlock.returnPadlockDetails());
			}
			System.out.print("Which ID to delete: ");
			int id = in.nextInt();
			
			boolean validId = false;
			for (Padlock padlock : foundPadlocks) {
				if (padlock.getId() == id) {
					validId = true;
				}
			}
			
			if (validId) {
				Padlock toDelete = ph.searchForPadlockById(id);
				ph.deletePadlock(toDelete);
				System.out.println("Deleted.");
			} else {
				System.out.println("Invalid ID.");
			}
		} else if (foundPadlocks.isEmpty() && (searchBy == 1 || searchBy == 2)) {
			System.out.println("---- No results found");
		}
	}
	
	private static void editAPadlock() {
		System.out.println("How would you like to search?");
		System.out.println("1: Search by Brand");
		System.out.println("2: Search by Model");
		System.out.println("3: Cancel");
		System.out.print("Selection: ");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Padlock> foundPadlocks = new ArrayList<>();
		
		if (searchBy == 1) {
			System.out.print("Enter the brand name: ");
			String brand = in.nextLine();
			foundPadlocks = ph.searchForPadlockByBrand(brand);
		} else if (searchBy == 2) {
			System.out.print("Enter the model name: ");
			String model = in.nextLine();
			foundPadlocks = ph.searchForPadlockByModel(model);
		} else if (searchBy == 3) {
			System.out.println("Edit canceled.");
		} else {
			System.out.println("Invalid selection.");
		}
		
		if (!foundPadlocks.isEmpty()) {
			System.out.println("Found Results.");
			for (Padlock padlock : foundPadlocks) {
				System.out.println("ID " + padlock.getId() + ": " + padlock.returnPadlockDetails());
			}
			System.out.print("Which ID to edit: ");
			int id = in.nextInt();
			
			boolean validId = false;
			for (Padlock padlock : foundPadlocks) {
				if (padlock.getId() == id) {
					validId = true;
				}
			}
			
			if (validId) {
				Padlock toEdit = ph.searchForPadlockById(id);
				System.out.println("Retrieved " + toEdit.returnPadlockDetails());
				System.out.println("1: Update Brand");
				System.out.println("2: Update Model");
				System.out.println("3: Update number of pins");
				System.out.println("4: Update has security pins");
				System.out.print("Selection: ");
				int update = in.nextInt();
				in.nextLine();
	
				if (update == 1) {
					System.out.print("New Brand: ");
					String newBrand = in.nextLine();
					toEdit.setBrand(newBrand);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 3) {
					System.out.print("New number of pins: ");
					int newNumPins = in.nextInt();
					toEdit.setNumPins(newNumPins);
				} else if (update == 4) {
					System.out.print("New has security pins (true/false): ");
					boolean newHasSecurityPins = in.nextBoolean();
					toEdit.setHasSecurityPins(newHasSecurityPins);
				} else {
					System.out.println("Invalid selection.");
				}
	
				ph.updatePadlock(toEdit);
				System.out.println("Updated.");
			} else {
				System.out.println("Invalid ID.");
			}
		} else if (foundPadlocks.isEmpty() && (searchBy == 1 || searchBy == 2)){
			System.out.println("---- No results found");
		}
	}
	
	public static void runMenu() {
		boolean doneYet = false;
		final int MIN_SELECTION = 1;
		final int MAX_SELECTION = 5;
		System.out.println("--- Welcome to the padlock list program ---");
		
		while (!doneYet) {
			int selection = 0;
			while (selection < MIN_SELECTION || selection > MAX_SELECTION) {
				try {
					System.out.println("*  Select an item:");
					System.out.println("*  1 -- Add a padlock");
					System.out.println("*  2 -- Edit a padlock");
					System.out.println("*  3 -- Delete a padlock");
					System.out.println("*  4 -- View the list");
					System.out.println("*  5 -- Exit the program");
					System.out.print("*  Your selection: ");
					selection = in.nextInt();
					in.nextLine();
					
					if (selection == 1) {
						addAPadlock();
					} else if (selection == 2) {
						editAPadlock();
					} else if (selection == 3) {
						deleteAPadlock();
					} else if (selection == 4) {
						viewList();
					} else if (selection == 5) {
						ph.cleanUp();
						System.out.println("   Goodbye!   ");
						doneYet = true;
					} else {
						System.out.println("Invalid selection.");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid selection.");
					in.next();
				}
			}
		}
	}
	
	private static void viewList() {
		List<Padlock> allPadlocks = ph.showAllPadlocks();
		
		System.out.println("--------------------------------");
		for (Padlock padlock : allPadlocks) {
			System.out.println(padlock.returnPadlockDetails());
		}
		System.out.println("--------------------------------");
	}
	
	public static void main(String[] args) {
		runMenu();
	}

}
