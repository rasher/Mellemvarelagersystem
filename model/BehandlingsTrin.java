package model;
import java.util.Calendar;

import javax.persistence.*;
@Entity
@Table(name="BehandlingsTrin")

public class BehandlingsTrin {
	@Id
	@GeneratedValue
	int ID;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar start;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar slut;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar tørringStart;
	@ManyToOne
	private Delbehandling delbehandling;
	public Calendar getStart() {
		return start;
	}
	public void setStart(Calendar start) {
		this.start = start;
	}
	public Calendar getSlut() {
		return slut;
	}
	public void setSlut(Calendar slut) {
		this.slut = slut;
	}
	public Calendar getTørringStart() {
		System.out.println("hej hej "+ tørringStart);
		return tørringStart;
	}
	public void setTørringStart(Calendar tørringStart) {
		this.tørringStart = tørringStart;
		
	}
	public Delbehandling getDelbehandling() {
		return delbehandling;
	}
	public void setDelbehandling(Delbehandling delbehandling) {
		this.delbehandling = delbehandling;
	}
	/**
	 * @return Delbehandlingens minimale tørringstid i hele timer
	 */
	public int getMinimumTørringstid() {
		return delbehandling.getMinimumTørringsTid();
	}
	/**
	 * @return Delbehandlingens minimale tørringstid i hele timer
	 */
	public int getOptimalTørringstid() {
		return delbehandling.getOptimalTørringsTid();
	}
	/**
	 * @return Delbehandlingens minimale tørringstid i hele timer
	 */
	public int getMaksimumTørringstid() {
		return delbehandling.getMaksimumTørringsTid();
	}
	
	
	

}
