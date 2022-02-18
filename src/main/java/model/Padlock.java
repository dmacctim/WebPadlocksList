package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* @author Tim Ancona - tsancona  
* CIS175 - Spring 2022
* Feb 2, 2022  
*/
@Entity
@Table(name="padlocks")
public class Padlock {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="MODEL")
	private String model;
	@Column(name="PINS")
	private int numPins;
	@Column(name="HAS_SEC_PINS")
	private boolean hasSecurityPins;

	public Padlock() {
		super();
	}

	public Padlock(String brand, String model, int numPins, boolean hasSecurityPins) {
		super();
		this.brand = brand;
		this.model = model;
		this.numPins = numPins;
		this.hasSecurityPins = hasSecurityPins;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumPins() {
		return numPins;
	}

	public void setNumPins(int numPins) {
		this.numPins = numPins;
	}

	public boolean isHasSecurityPins() {
		return hasSecurityPins;
	}

	public void setHasSecurityPins(boolean hasSecurityPins) {
		this.hasSecurityPins = hasSecurityPins;
	}
	
	public String returnPadlockDetails() {
		return this.brand + " " + this.model + " Pins: " + this.numPins + " Has security pins: " + this.hasSecurityPins;
	}
}
