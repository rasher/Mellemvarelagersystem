package jUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Behandling;
import model.BehandlingsTrin;
import model.Delbehandling;
import model.Mellemvare;
import model.Produkttype;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestMellemvare {
	Delbehandling d;
	Behandling b;
	Produkttype p;
	Mellemvare m;
	
	@Before
	public void setUp() {
		d = new Delbehandling();
		d.setNavn("Test");
		d.setMinimumTørringsTid(1);
		d.setOptimalTørringsTid(1);
		d.setMaksimumTørringsTid(1);
		
		b = new Behandling();
		b.setNavn("Test");
		b.addDelbehandling(d);
		
		p = new Produkttype();
		p.setNavn("Test");
		p.setBehandling(b);

		m = new Mellemvare();
		m.setProdukttype(p);
		for (Delbehandling delbehandling: p.getDelbehandlinger()) {
			BehandlingsTrin bht = new BehandlingsTrin();
			bht.setDelbehandling(delbehandling);
			m.addBehandlingsTrin(bht);
		}		
	}
	
	/**
	 * Test method for {@link model.Mellemvare#beregnTørringsTider()}.
	 * @throws Exception 
	 */
	@Test
	public void testberegnMinimumTørringsTidTC1() throws Exception {
		m.startDelbehandling();
		m.startTørring();
		
		GregorianCalendar forventet = new GregorianCalendar();
		forventet.add(GregorianCalendar.HOUR, 1);
		forventet.set(GregorianCalendar.MILLISECOND, 0);
		
		Calendar minimumOpnået = m.getMinimumTørringNået();
		minimumOpnået.set(Calendar.MILLISECOND, 0);
		
		Calendar optimalOpnået = m.getOptimalTørringNået();
		optimalOpnået.set(Calendar.MILLISECOND, 0);
		
		Calendar maksimumOpnået = m.getMinimumTørringNået();
		maksimumOpnået.set(Calendar.MILLISECOND, 0);
		
		assertEquals(forventet.getTimeInMillis(), minimumOpnået.getTimeInMillis());
		assertEquals(forventet.getTimeInMillis(), optimalOpnået.getTimeInMillis(), 2.0);
		assertEquals(forventet.getTimeInMillis(), maksimumOpnået.getTimeInMillis(), .0);
	}
	
	/**
	 * Test at der kastes en exception hvis der køres startDelbehandling uden
	 * at der er oprettet delbehandlinger
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testStartDelbehandlingTC2() throws Exception {
		Behandling b;
		Produkttype p;
		Mellemvare m;
				
		b = new Behandling();
		b.setNavn("Test");
		
		p = new Produkttype();
		p.setNavn("Test");
		p.setBehandling(b);

		m = new Mellemvare();
		m.setProdukttype(p);
		for (Delbehandling delbehandling: p.getDelbehandlinger()) {
			BehandlingsTrin bht = new BehandlingsTrin();
			bht.setDelbehandling(delbehandling);
			m.addBehandlingsTrin(bht);
		}		
		m.startDelbehandling();
	}

	/**
	 * Test at der kastes en exception hvis der køres startDelbehandling uden
     * at der findes en delbehandling der ikke er begyndt
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testStartDelbehandlingTC3() throws Exception {
		m.startDelbehandling();
		// Den egentlige test:
		m.startDelbehandling();
	}

	/**
	 * Test at der der returneres et behandlingstrin efter at en delbehandling
	 * er igangsat
	 * @throws Exception
	 */
	@Test
	public void testStartDelbehandlingTC4() throws Exception {
		m.startDelbehandling();
		assertNotNull(m.getAktueltBehandlingTrin());
		assertSame(m.getAktueltBehandlingTrin().getDelbehandling(), d);
	}
}
