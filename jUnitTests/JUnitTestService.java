package jUnitTests;

import static org.junit.Assert.*;

import model.Behandling;
import model.BehandlingDelbehandlingRelation;
import model.Delbehandling;
import model.Mellemvare;
import model.Produkttype;
import model.Service;

import org.junit.Test;

public class JUnitTestService {
	
	/**
	 * Johnny Sønderskov Sørensen
	 * 
	 * Tester på om createMellemvare i Service klassen returnerer null,
	 * hvis den køres med produkttype = null som parameter
	 * 
	 */
	@Test
	public void testCreateMellemvareTC1(){
		
		Produkttype produkttype = null;
		
		assertNull(Service.getInstance().createMellemvare(produkttype));
	}
	
	/**
	 * Johnny Sønderskov Sørensen
	 * 
	 * Tester på om createMellemvare i Service klassen opretter en ny mellemvare med tilknyttet produkttype og behandling,
	 * hvis den køres med en produkttype som parameter, og denne produkttype har en behandling tilknyttet
	 * 
	 */
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
		
		
		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(behandling);
		Service.getInstance().fjernFraDatabase(aktuel);
	}
	
	/**
	 * Johnny Sønderskov Sørensen
	 * 
	 * Tester på om createMellemvare i Service klassen opretter en ny mellemvare med tilknyttet produkttype, behandling og delbehandling,
	 * hvis den køres med en produkttype som parameter, og denne produkttype har en behandling tilknyttet og behandlingen har en delbehandling tilknyttet
	 * 
	 */
	@Test
	public void testCreateMellemvareTC3(){
		
		Delbehandling delbehandling = Service.getInstance().createDelbehandling();
		Service.getInstance().gemIDatabase(delbehandling);
		
		Behandling behandling = Service.getInstance().createBehandling();
		Service.getInstance().gemIDatabase(behandling);
		
		BehandlingDelbehandlingRelation bdr = new BehandlingDelbehandlingRelation();
		bdr.setRækkefølge(0);
		bdr.setDelbehandling(delbehandling);
		bdr.setBehandling(behandling);
		Service.getInstance().gemIDatabase(bdr);
		
		behandling.getBehandlingDelbehandlingRelationer().add(bdr);
		Service.getInstance().gemIDatabase(behandling);
		
		Produkttype produkttype = Service.getInstance().createProdukttype(behandling);
		produkttype.setBehandling(behandling);
		Service.getInstance().gemIDatabase(produkttype);
	
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertNotNull(aktuel);
		assertEquals(produkttype, aktuel.getProdukttype());
		assertEquals(behandling, aktuel.getProdukttype().getBehandling());
		assertEquals(delbehandling, aktuel.getBehandlingsTrin().get(0).getDelbehandling());

		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(aktuel);
		Service.getInstance().fjernFraDatabase(behandling);
		Service.getInstance().fjernFraDatabase(bdr);
		Service.getInstance().fjernFraDatabase(delbehandling);
	}
	
	/**
	 * Johnny Sønderskov Sørensen
	 * 
	 * Tester på om søgMellemvare i Service klassen returnerer den søgte mellemvare
	 * med det valgte batchnummer
	 * 
	 */
	@Test
	public void søgMellemvareTC1(){
		Behandling behandling = Service.getInstance().createBehandling();
		Service.getInstance().gemIDatabase(behandling);
		Produkttype produkttype = Service.getInstance().createProdukttype(behandling);
		Service.getInstance().gemIDatabase(produkttype);
		
		Mellemvare aktuel = Service.getInstance().createMellemvare(produkttype);
		
		assertEquals(aktuel, Service.getInstance().søgMellemvare(aktuel.getBatchNummer()));
		
		Service.getInstance().fjernFraDatabase(produkttype);
		Service.getInstance().fjernFraDatabase(aktuel);
		Service.getInstance().fjernFraDatabase(behandling);
	}
	
	/**
	 * Johnny Sønderskov Sørensen
	 * 
	 * Tester på om søgMellemvare i Service klassen returnerer null,
	 * hvis der søges på et batchnummer som ikke findes
	 * 
	 */
	@Test
	public void søgMellemvareTC2(){
		assertNull(Service.getInstance().søgMellemvare(-1));
	}

}
