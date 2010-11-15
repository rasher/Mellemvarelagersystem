package model;
import java.util.Calendar;

import javax.persistence.*;
@Entity
@Table(name="BehandlingsTrin")

public class BehandlingsTrin {
	@Id
	@GeneratedValue
	int ID;
	@Column(length=20)
	private Calendar start;
	@Column(length=20)
	private Calendar slut;
	@Column(length=20)
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
	
	
	

}
