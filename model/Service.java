package model;

import java.util.List;
import javax.persistence.*;

public class Service {
	public Mellemvare createMellemvare(Produkttype produkttype)
	{
		Mellemvare nyMellemvare = new Mellemvare();
		nyMellemvare.setProdukttype(produkttype);
		return null;
	}
	public Produkttype createProdukttype(Behandling behandling)
	{
		return null;
	}
	public Behandling createBehandling()
	{
		return null;
	}
	public Delbehandling createDelbehandling()
	{
		return null;
	}
	public List<Mellemvare> getKlar()
	{
		return null;
	}
	public List<Mellemvare> getNærOverskredet()
	{
		return null;
	}

}
