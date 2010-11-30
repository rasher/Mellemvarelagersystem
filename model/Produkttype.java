package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * En Produkttype består af et navn og en tilknyttet Behandling.
 * @author Peter Runge Christensen
 */
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
	
	/**
	 * @return Mellemvarer af denne Produkttype
	 */
	public List<Mellemvare> getMellemvarer() {
		return mellemvarer;
	}
	
	/**
	 * Tilføj en mellemvare af denne Produkttype
	 * @param mellemvare Mellemvaren der skal tilføjes
	 */
	public void addMellemvare(Mellemvare mellemvare)
	{
		this.mellemvarer.add(mellemvare);
	}
	
	/**
	 * Fjern en mellemvare af denne Produkttype
	 * @param mellemvare Mellemvaren der skal fjernes
	 */
	public void removeMellemvare(Mellemvare mellemvare)
	{
		this.mellemvarer.remove(mellemvare);
	}

	/**
	 * @return Produkttypens navn
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Sæt navn for Produkttypen
	 * @param navn Produkttypens nye navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * @return Behandlingen som bruges til denne Produkttype
	 */
	public Behandling getBehandling() {
		return behandling;
	}

	/**
	 * Sæt en behandling der skal bruges til denne Produkttype
	 * @param behandling
	 */
	public void setBehandling(Behandling behandling) {
		this.behandling = behandling;
	}
	
	/**
	 * @return En liste af delbehandlinger som bruges til denne Produkttypes Behandling
	 */
	public List<Delbehandling> getDelbehandlinger()
	{
		ArrayList<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
		for(BehandlingDelbehandlingRelation bdr : behandling.getBehandlingDelbehandlingRelationer())
		{
			delbehandlinger.add(bdr.getDelbehandling());
		}
		return delbehandlinger;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return navn;
	}
}
