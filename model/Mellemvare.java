package model;
import java.util.ArrayList;
import java.util.Calendar;
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

	public void startDelbehandling()
	{
		
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
