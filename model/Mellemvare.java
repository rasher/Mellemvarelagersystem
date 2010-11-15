package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Mellemvare")
public class Mellemvare {
	@Id
	@GeneratedValue
	private int batchNummer;
	@Column(length = 20)
	private Calendar minimumTørringNået;
	@Column(length = 20)
	private Calendar optimalTørringNået;
	@Column(length = 20)
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
