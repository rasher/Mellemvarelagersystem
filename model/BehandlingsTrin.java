package model;
import java.util.Calendar;

import javax.persistence.*;
/**
 * Et BehandlingsTrin. BehandlingsTrin bruges på Mellemvare objekter.
 * 
 * @author Peter Runge Christensen
 *
 */
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
	private int rækkefølge;

	/**
	 * @return Tidspunktet hvor BehandlingsTrinnet startedes
	 */
	public Calendar getStart() {
		return start;
	}
	
	/**
	 * Sæt hvornår BehandlingsTrinnet startedes
	 * @param start Tidspunktet hvor BehandlingsTrinnet startedes
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}
	
	/**
	 * @return Tidspunktet hvor BehandlingsTrinnet blev afsluttet
	 */
	public Calendar getSlut() {
		return slut;
	}
	
	/**
	 * Sæt hvornår BehandlingsTrinnet blev afsluttet
	 * @param start Tidspunktet hvor BehandlingsTrinnet blev afsluttet
	 */
	public void setSlut(Calendar slut) {
		this.slut = slut;
	}
	
	/**
	 * @return Tidspunktet hvor BehandlingsTrinnet startede tørring
	 */
	public Calendar getTørringStart() {
		return tørringStart;
	}
	
	/**
	 * Sæt hvornår BehandlingsTrinnet startede tørring
	 * @param tørringStart Tidspunktet hvor BehandlingsTrinnet startede tørring
	 */
	public void setTørringStart(Calendar tørringStart) {
		this.tørringStart = tørringStart;
		
	}
	
	/**
	 * @return DelBehandlingen som BehandlingsTrinnet dækker over
	 */
	public Delbehandling getDelbehandling() {
		return delbehandling;
	}
	
	/**
	 * Sæt DelBehandlingen som BehandlingsTrinnet dækker over
	 * @param delbehandling DelBehandlingen som BehandlingsTrinnet dækker over
	 */
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
	
	/**
	 * 
	 * @return Rækkefølgen behandlingstrin står i på mellemvaren
	 */
	public int getRækkefølge() {
		return rækkefølge;
	}
	/**
	 * 
	 * @param index for rækkefølgen
	 */
	public void setRækkefølge(int rækkefølge) {
		this.rækkefølge = rækkefølge;
	}
}
