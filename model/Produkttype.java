package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Produkttype")
@NamedQuery(name="findProdukttyper", query="Select p from Produkttype p")
public class Produkttype {
	@SuppressWarnings("unused")
	@Id
	@GeneratedValue
	private int id;
	@Column(length=128)
	private String navn;
	@ManyToOne
	private Behandling behandling;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Mellemvare> mellemvarer = new ArrayList<Mellemvare>();
	
	public List<Mellemvare> getMellemvarer() {
		return mellemvarer;
	}

	public void setMellemvarer(List<Mellemvare> mellemvarer) {
		this.mellemvarer = mellemvarer;
	}
	
	public void addMellemvare(Mellemvare mellemvare)
	{
		this.mellemvarer.add(mellemvare);
	}
	
	public void removeMellemvare(Mellemvare mellemvare)
	{
		this.mellemvarer.remove(mellemvare);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Behandling getBehandling() {
		return behandling;
	}

	public void setBehandling(Behandling behandling) {
		this.behandling = behandling;
	}
	
	public List<Delbehandling> getDelbehandlinger()
	{
		ArrayList<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
		for(BehandlingDelbehandlingRelation bdr : behandling.getBehandlingDelbehandlingRelation())
		{
			delbehandlinger.add(bdr.getDelbehandling());
		}
		return delbehandlinger;
	}
	
	public String toString(){
		return navn;
	}
}
