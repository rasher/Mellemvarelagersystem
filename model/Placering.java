/**
 * 
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jonas Häggqvist (10dm10v1)
 *
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
	 * @return the række
	 */
	public int getRække() {
		return række;
	}
	/**
	 * @param række the række to set
	 */
	public void setRække(int række) {
		this.række = række;
	}
	/**
	 * @return the pladsIRække
	 */
	public int getPladsIRække() {
		return pladsIRække;
	}
	/**
	 * @param pladsIRække the pladsIRække to set
	 */
	public void setPladsIRække(int pladsIRække) {
		this.pladsIRække = pladsIRække;
	}
	/**
	 * @return the pladsId
	 */
	public int getPladsId() {
		return pladsId;
	}
}