package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Behandling;
import model.Delbehandling;
import model.Mellemvare;
import model.Produkttype;
import model.Service;

import org.junit.Test;

public class JUnitTestService {
	
	@Test
	public void testCreateMellemvareTC1(){
		
		Produkttype produkttype = null;
		
		assertNull(Service.getInstance().createMellemvare(produkttype));
	}
	
	@Test
	public void testCreateMellemvareTC2(){
		Produkttype produkttype = new Produkttype();
		Behandling behandling = new Behandling();
		produkttype.setBehandling(behandling);
		
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertNotNull(aktuel);
		assertEquals(produkttype, aktuel.getProdukttype());
		assertEquals(behandling, aktuel.getProdukttype().getBehandling());
	}
	
	@Test
	public void testCreateMellemvareTC3(){
		Produkttype produkttype = new Produkttype();
		Behandling behandling = new Behandling();
		Delbehandling delbehandling = new Delbehandling();
		List<Delbehandling> delbehandlinger = new ArrayList<Delbehandling>();
		delbehandlinger.add(delbehandling);
		produkttype.setBehandling(behandling);
		behandling.setDelbehandlinger(delbehandlinger);
		
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertNotNull(aktuel);
		assertEquals(produkttype, aktuel.getProdukttype());
		assertEquals(behandling, aktuel.getProdukttype().getBehandling());
		assertEquals(delbehandling, aktuel.getBehandlingsTrin().get(0).getDelbehandling());
	}

}
