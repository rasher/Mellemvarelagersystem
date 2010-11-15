package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Mellemvare")
@NamedQuery(name="findAlleMellemvarer", query="Select mv from Mellemvare mv")
public class Mellemvare {
	@Id
	@GeneratedValue
	private int batchNummer;
	@Temporal(value = TemporalType.DATE)
	private Calendar minimumTørringNået;
	@Temporal(value = TemporalType.DATE)
	private Calendar optimalTørringNået;
	@Temporal(value = TemporalType.DATE)
	private Calendar maksimumTørringNået;
	@ManyToOne
	private BehandlingsTrin aktuelBehandlingsTrin;
	@OneToMany
	private List<BehandlingsTrin> behandlingsTrin = new ArrayList<BehandlingsTrin>();
	@ManyToOne
	private Produkttype produkttype;
	
	public Produkttype getProdukttype() {
		return produkttype;
	}

	public void setProdukttype(Produkttype produkttype) {
		this.produkttype = produkttype;
	}

	/**
	 * Start næste delbehandling. Den aktuelle delbehandling afsluttes.
	 * @throws Exception 
	 */
	public void startDelbehandling() throws Exception {
		aktuelBehandlingsTrin.setSlut(new GregorianCalendar());
		for (BehandlingsTrin b: behandlingsTrin) {
			if (b.getStart() == null) {
				b.setStart(new GregorianCalendar());
				aktuelBehandlingsTrin = b;
				return;
			}
		}
		throw new Exception("Ingen uafsluttet delbehandling");
	}
	
	public void startTørring()
	{
		
	}
	
	public void sendTilPakning()
	{
		
	}
	
	private void beregnTørringsTider()
	{
		
	}
	
	public void addBehandlingsTrin(BehandlingsTrin behandlingsTrin)
	{
		this.behandlingsTrin.add(behandlingsTrin);
	}
	
	public void removeBehandlingsTrin(BehandlingsTrin behandlingsTrin)
	{
		this.behandlingsTrin.remove(behandlingsTrin);
	}
	
	public List<BehandlingsTrin> getBehandlingsTrin()
	{
		return behandlingsTrin;
	}
}
