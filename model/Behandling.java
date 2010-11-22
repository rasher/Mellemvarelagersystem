package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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
	private List<BehandlingDelbehandlingRelation> behandlingDelbehandlingRelationer = 
		new ArrayList<BehandlingDelbehandlingRelation>();
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	
	public void addBehandlingDelbehandlingRelation(BehandlingDelbehandlingRelation bdr)
	{
		this.behandlingDelbehandlingRelationer.add(bdr);
	}
	public List<BehandlingDelbehandlingRelation> getBehandlingDelbehandlingRelationer() {
		return behandlingDelbehandlingRelationer;
	}
	public void setBehandlingDelbehandlingRelationer(
			List<BehandlingDelbehandlingRelation> behandlingDelbehandlingRelation) {
		this.behandlingDelbehandlingRelationer = behandlingDelbehandlingRelation;
	}
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
