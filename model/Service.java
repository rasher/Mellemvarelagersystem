package model;

import java.util.List;
import javax.persistence.*;

public class Service {
	public Mellemvare createMellemvare(Produkttype produkttype)
	{
		Mellemvare nyMellemvare = new Mellemvare();
		nyMellemvare.setProdukttype(produkttype);
		for(Delbehandling delbehandling : produkttype.getDelbehandlinger())
		{
			BehandlingsTrin nytBehandlingsTrin = new BehandlingsTrin();
			nytBehandlingsTrin.setDelbehandling(delbehandling);
			nyMellemvare.addBehandlingsTrin(nytBehandlingsTrin);
		}
		return nyMellemvare;
	}
	public Produkttype createProdukttype(Behandling behandling)
	{
		Produkttype nyProdukttype = new Produkttype();
		nyProdukttype.setBehandling(behandling);
		return nyProdukttype;
	}
	public Behandling createBehandling()
	{
		return new Behandling();
	}
	public Delbehandling createDelbehandling()
	{
		return new Delbehandling();
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
