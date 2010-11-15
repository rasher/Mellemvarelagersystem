package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Behandling")
public class Behandling {
	@Id
	@GeneratedValue
	private int nr;
	@Column(length=20)
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
}
