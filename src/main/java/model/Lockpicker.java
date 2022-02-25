package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 23, 2022  
*/
@Entity
@Table(name="lockpicker")

public class Lockpicker {
	@Id
	@GeneratedValue
	private int id;
	private String lockpickerName;

	public Lockpicker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lockpicker(int id, String lockpickerName) {
		super();
		this.id = id;
		this.lockpickerName = lockpickerName;
	}

	public Lockpicker(String lockpickerName) {
		super();
		this.lockpickerName = lockpickerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLockpickerName() {
		return lockpickerName;
	}

	public void setLockpickerName(String lockpickerName) {
		this.lockpickerName = lockpickerName;
	}

	@Override
	public String toString() {
		return "Lockpicker [id=" + id + ", lockpickerName=" + lockpickerName + "]";
	}
}
