package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * En Placering på lageret
 * @author Jonas Häggqvist (10dm10v1)
 */
@Entity
@Table(name = "Placering")
public class Placering {
	@Id
	@GeneratedValue
	private int pladsId; 
	private int række;
	private int pladsIRække;

	/**
	 * @return Rækken
	 */
	public int getRække() {
		return række;
	}
	
	/**
	 * Sæt en ny række for Placeringen
	 * @param række Den nye række
	 */
	public void setRække(int række) {
		this.række = række;
	}
	
	/**
	 * @return Placeringens plads i rækken
	 */
	public int getPladsIRække() {
		return pladsIRække;
	}
	
	/**
	 * Sæt en ny plads i rækken for Placeringen
	 * @param pladsIRække Den nye plads i rækken
	 */
	public void setPladsIRække(int pladsIRække) {
		this.pladsIRække = pladsIRække;
	}
	
	/**
	 * @return Pladsens id-nummer
	 */
	public int getPladsId() {
		return pladsId;
	}
}