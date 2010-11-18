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
	@OneToMany
	private List<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public void addDelbehandling(Delbehandling delbehandling)
	{
		delbehandlinger.add(delbehandling);
	}
	
	public void removeDelbehandling(Delbehandling delbehandling)
	{
		delbehandlinger.remove(delbehandling);
	}
	
	public List<Delbehandling> getDelbehandlinger()
	{
		return delbehandlinger;
	}
	/**
	 * @param arrayList
	 */
	public void setDelbehandlinger(List<Delbehandling> delbehandlinger) {
		this.delbehandlinger = delbehandlinger;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Behandling [navn=%s, nr=%s, delbehandlinger=%s]",
				navn, nr, delbehandlinger);
	}
}
