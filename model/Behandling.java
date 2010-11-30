package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
/**
 * En Behandling
 * 
 * @author Peter Runge Christensen
 *
 */
@Entity
@Table(name="Behandling")
@NamedQuery(name="findAlleBehandlinger", query="Select b from Behandling b")
public class Behandling {
	@Id
	@GeneratedValue
	private int nr;
	@Column(length=128)
	private String navn;
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@OrderBy(value="rækkefølge ASC")
	private List<BehandlingDelbehandlingRelation> behandlingDelbehandlingRelationer = 
		new ArrayList<BehandlingDelbehandlingRelation>();
	
	
	/**
	 * Returner Behandlingens navn
	 * @return Behandlingens navn
	 */
	public String getNavn() {
		return navn;
	}
	
	/**
	 * Sæt Behandlingens navn
	 * @param navn Det nye navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	/**
	 * tilføj en BehandlingDelbehandlingRelation
	 * @param bdr den nye BehandlingDelbehandlingRelation
	 */
	public void addBehandlingDelbehandlingRelation(BehandlingDelbehandlingRelation bdr)
	{
		this.behandlingDelbehandlingRelationer.add(bdr);
	}
	
	/**
	 * Returner listen af alle BehandlingDelbehandlingRelationer
	 * @return Listen af alle BehandlingDelbehandlingRelationer
	 */
	public List<BehandlingDelbehandlingRelation> getBehandlingDelbehandlingRelationer() {
		return behandlingDelbehandlingRelationer;
	}
	
	/**
	 * Sæt listen af alle BehandlingDelbehandlingRelation
	 * @param behandlingDelbehandlingRelation den nye liste af BehandlingDelbehandlingRelationer
	 */
	public void setBehandlingDelbehandlingRelationer(
			List<BehandlingDelbehandlingRelation> behandlingDelbehandlingRelation) {
		this.behandlingDelbehandlingRelationer = behandlingDelbehandlingRelation;
	}

	/**
	 * Fjern en BehandlingDelbehandlingRelation
	 * @param bdr BehandlingDelbehandlingRelationen der skal fjernes
	 */
	public void removeBehandlingDelbehandlingRelation(BehandlingDelbehandlingRelation bdr)
	{
		this.behandlingDelbehandlingRelationer.remove(bdr);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Behandling [navn=%s, nr=%s, delbehandlinger=%s]",
				navn, nr, behandlingDelbehandlingRelationer);
	}
}
