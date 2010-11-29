package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.*;

/**
 * En mellemvare i systemet. Mellemvaren har en Produkttype og en liste af
 * BehandlingsTrin der skal udføres før den er færdig.
 */
@Entity
@Table(name = "Mellemvare")

@NamedQueries({
	@NamedQuery(name = "findAlleMellemvarer", query = "Select mv from Mellemvare mv"),
	@NamedQuery(name = "findMinimumstidOpnået", query = "Select mv from Mellemvare mv where mv.aktuelBehandlingsTrin is not null and mv.minimumTørringNået < CURRENT_TIMESTAMP order by mv.maksimumTørringNået desc"),
	@NamedQuery(name = "søgMellemvareFraBatchNummer", query = "Select mv from Mellemvare mv where mv.batchNummer = :batchNummer"),
	@NamedQuery(name = "findVarerIRække", query = "Select mv from Mellemvare mv where mv.Placering.række = :række Order by mv.Placering.pladsIRække")
})

public class Mellemvare {
	@Id
	@GeneratedValue
	private int batchNummer;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar minimumTørringNået;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar optimalTørringNået;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar maksimumTørringNået;
	@ManyToOne
	@OrderBy(value="trinNr ASC")
	private BehandlingsTrin aktuelBehandlingsTrin;
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	private List<BehandlingsTrin> behandlingsTrin = new ArrayList<BehandlingsTrin>();
	@ManyToOne(cascade = CascadeType.DETACH)
	private Produkttype produkttype;
	private Placering placering;

	/**
	 * Få varens produkttype
	 * 
	 * @return varens produkttype
	 */
	public Produkttype getProdukttype() {
		return produkttype;
	}

	/**
	 * Sæt varens produkttype
	 * 
	 * @param produkttype
	 *            produkttypen der skal sættes
	 */
	public void setProdukttype(Produkttype produkttype) {
		if(this.produkttype != null)
			this.produkttype.removeMellemvare(this);
		this.produkttype = produkttype;
		produkttype.addMellemvare(this);
	}

	/**
	 * Start næste delbehandling. Den aktuelle delbehandling afsluttes og den
	 * næste sættes igang.
	 * 
	 * @throws Exception
	 */
	public void startDelbehandling() throws Exception {
		if (aktuelBehandlingsTrin != null) {
			aktuelBehandlingsTrin.setSlut(new GregorianCalendar());
		}
		for (BehandlingsTrin b : behandlingsTrin) {
			if (b.getStart() == null) {
				b.setStart(new GregorianCalendar());
				aktuelBehandlingsTrin = b;
				minimumTørringNået = null;
				optimalTørringNået = null;
				maksimumTørringNået = null;
				return;
			}
		}
		throw new Exception("Ingen uafsluttet delbehandling");
	}

	/**
	 * Påbegynd tørring for den nuværende delbehandling.
	 */
	public void startTørring() {
		aktuelBehandlingsTrin.setTørringStart(new GregorianCalendar());
		beregnTørringsTider();
	}

	/**
	 * Send til pakning. Den nuværende delbehandling afsluttes.
	 */
	public void sendTilPakning() {
		if (aktuelBehandlingsTrin != null) {
			aktuelBehandlingsTrin.setSlut(new GregorianCalendar());
			minimumTørringNået = null;
			optimalTørringNået = null;
			maksimumTørringNået = null;
			aktuelBehandlingsTrin = null;
		}
	}

	/**
	 * Opdater tidspunkter hvor tørring vil have nået hhv minimum, optimal og
	 * maksimal tørringstid.
	 */
	private void beregnTørringsTider() {
		if (aktuelBehandlingsTrin != null) {
			minimumTørringNået = (Calendar) aktuelBehandlingsTrin.getTørringStart().clone();
			minimumTørringNået.add(GregorianCalendar.HOUR,
					aktuelBehandlingsTrin.getMinimumTørringstid());
			optimalTørringNået = (Calendar) aktuelBehandlingsTrin.getTørringStart().clone();
			optimalTørringNået.add(GregorianCalendar.HOUR,
					aktuelBehandlingsTrin.getOptimalTørringstid());
			maksimumTørringNået = (Calendar) aktuelBehandlingsTrin.getTørringStart().clone();
			maksimumTørringNået.add(GregorianCalendar.HOUR,
					aktuelBehandlingsTrin.getMaksimumTørringstid());

		}
	}

	/**
	 * Tilføj et behandlingstrin
	 * 
	 * @param behandlingsTrin
	 *            behandlingstrinnet der skal tilføjes
	 */
	public void addBehandlingsTrin(BehandlingsTrin behandlingsTrin) {
		this.behandlingsTrin.add(behandlingsTrin);
	}

	/**
	 * Fjern et behandlingstrin
	 * 
	 * @param behandlingsTrin
	 *            behandlingstrinnet der skal fjernes
	 */
	public void removeBehandlingsTrin(BehandlingsTrin behandlingsTrin) {
		this.behandlingsTrin.remove(behandlingsTrin);
	}

	/**
	 * Returner hele listen af behandlingstrin
	 * 
	 * @return litsen af behandlingstrin
	 */
	public List<BehandlingsTrin> getBehandlingsTrin() {
		return behandlingsTrin;
	}

	/**
	 * @return Mellemvarens batchnummer
	 */
	public int getBatchNummer() {
		return batchNummer;
	}

	/**
	 * @return the minimumTørringNået
	 */
	public Calendar getMinimumTørringNået() {
		return minimumTørringNået;
	}

	/**
	 * @return the optimalTørringNået
	 */
	public Calendar getOptimalTørringNået() {
		return optimalTørringNået;
	}

	/**
	 * @return the maksimumTørringNået
	 */
	public Calendar getMaksimumTørringNået() {
		return maksimumTørringNået;
	}
	
	public BehandlingsTrin getAktueltBehandlingTrin()
	{
		return aktuelBehandlingsTrin;
	}
	
	/**
	 * @return the placering
	 */
	public Placering getPlacering() {
		return placering;
	}

	/**
	 * @param placering the placering to set
	 */
	public void setPlacering(Placering placering) {
		this.placering = placering;
	}

	public String toString(){
		return produkttype + " (" + batchNummer + ")";
	}
}
