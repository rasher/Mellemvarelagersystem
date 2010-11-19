package model;
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
		return behandling.getDelbehandlinger();
	}
	
	public String toString(){
		return navn;
	}
}
