package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Lockpicker lockpicker;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Padlock> listOfPadlocks;

	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListDetails(int id, String listName, Lockpicker lockpicker, List<Padlock> listOfPadlocks) {
		super();
		this.id = id;
		this.listName = listName;
		this.lockpicker = lockpicker;
		this.listOfPadlocks = listOfPadlocks;
	}

	public ListDetails(String listName, Lockpicker lockpicker, List<Padlock> listOfPadlocks) {
		super();
		this.listName = listName;
		this.lockpicker = lockpicker;
		this.listOfPadlocks = listOfPadlocks;
	}

	public ListDetails(String listName, Lockpicker lockpicker) {
		super();
		this.listName = listName;
		this.lockpicker = lockpicker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Lockpicker getLockpicker() {
		return lockpicker;
	}

	public void setLockpicker(Lockpicker lockpicker) {
		this.lockpicker = lockpicker;
	}

	public List<Padlock> getListOfPadlocks() {
		return listOfPadlocks;
	}

	public void setListOfPadlocks(List<Padlock> listOfPadlocks) {
		this.listOfPadlocks = listOfPadlocks;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", lockpicker=" + lockpicker + ", listOfPadlocks="
				+ listOfPadlocks + "]";
	}
}
