package jUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import model.Behandling;
import model.BehandlingsTrin;
import model.Delbehandling;
import model.Mellemvare;
import model.Produkttype;

import org.junit.Test;

public class JUnitTestMellemvare {
	/**
	 * Test method for {@link model.Mellemvare#beregnTørringsTider()}.
	 */
	@Test
	public void testberegnMinimumTørringsTidTC1() {
		Delbehandling d;
		Behandling b;
		Produkttype p;
		Mellemvare m;
		
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
		try {
			m.startDelbehandling();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
