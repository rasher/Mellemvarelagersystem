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
		Behandling behandling = Service.getInstance().createBehandling();
		Service.getInstance().gemIDatabase(behandling);
		
		Produkttype produkttype = Service.getInstance().createProdukttype(behandling);
		Service.getInstance().gemIDatabase(produkttype);

		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertNotNull(aktuel);
		assertEquals(produkttype, aktuel.getProdukttype());
		assertEquals(behandling, aktuel.getProdukttype().getBehandling());
		
		Service.getInstance().fjernFraDatabase(aktuel);
		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(behandling);
	}
	
	@Test
	public void testCreateMellemvareTC3(){
		
		Delbehandling delbehandling = Service.getInstance().createDelbehandling();
		Service.getInstance().gemIDatabase(delbehandling);
		
		Behandling behandling = Service.getInstance().createBehandling();
		behandling.addDelbehandling(delbehandling);
		Service.getInstance().gemIDatabase(behandling);
		
		Produkttype produkttype = Service.getInstance().createProdukttype(behandling);
		produkttype.setBehandling(behandling);
		Service.getInstance().gemIDatabase(produkttype);
	
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertNotNull(aktuel);
		assertEquals(produkttype, aktuel.getProdukttype());
		assertEquals(behandling, aktuel.getProdukttype().getBehandling());
		assertEquals(delbehandling, aktuel.getBehandlingsTrin().get(0).getDelbehandling());
		
		Service.getInstance().fjernFraDatabase(aktuel);
		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(behandling);
		Service.getInstance().fjernFraDatabase(delbehandling);
	}
	
	@Test
	public void søgMellemvareTC1(){
		Behandling behandling = Service.getInstance().createBehandling();
		Service.getInstance().gemIDatabase(behandling);
		Produkttype produkttype = Service.getInstance().createProdukttype(behandling);
		Service.getInstance().gemIDatabase(produkttype);
		
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertEquals(aktuel, Service.getInstance().søgMellemvare(aktuel.getBatchNummer()));
		
		Service.getInstance().fjernFraDatabase(aktuel);
		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(behandling);
	}
	
	@Test
	public void søgMellemvareTC2(){
		assertNull(Service.getInstance().søgMellemvare(-1));
	}

}
