package model;

import javax.persistence.*;

/**
 * En Delbehandling repræsenterer et enkelt trin i produktionsprocessen. Trinnet
 * har et navn og et behandlingssted. Derudover har den tilknyttet tider for
 * hvor lang tid produktet skal tørre. Der angives minimum, optimal og maksimal
 * tørringstid.
 * 
 * @author Peter Runge Christensen
 * 
 */
@Entity
@Table(name = "Delbehandling")
@NamedQuery(name = "findDelbehandlinger", query = "Select db from Delbehandling db")
public class Delbehandling {
	@Id
	@GeneratedValue
	int id;
	@Column(length = 128)
	private String navn;
	@Column(length = 128)
	private String behandlingsSted;
	@Column(length = 4)
	private int minimumTørringsTid;
	@Column(length = 4)
	private int optimalTørringsTid;
	@Column(length = 4)
	private int maksimumTørringsTid;

	/**
	 * @return Delbehandlingens navn
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * Sæt Delbehandlingens navn
	 * 
	 * @param navn
	 *            Delbehandlingens nye navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * @return Delbehandlingens behandlingssted
	 */
	public String getBehandlingsSted() {
		return behandlingsSted;
	}

	/**
	 * Sæt Delbehandlingens behandlingssted
	 * 
	 * @param behandlingsSted
	 *            Delbehandlingens nye behandlingssted
	 */
	public void setBehandlingsSted(String behandlingsSted) {
		this.behandlingsSted = behandlingsSted;
	}

	/**
	 * @return Delbehandlingens minimums tørringstid i timer
	 */
	public int getMinimumTørringsTid() {
		return minimumTørringsTid;
	}

	/**
	 * Sæt Delbehandlingens minimum tørringstid
	 * 
	 * @param minimumTørringsTid
	 *            Delbehandlingens minimum tørringstid
	 */
	public void setMinimumTørringsTid(int minimumTørringsTid) {
		this.minimumTørringsTid = minimumTørringsTid;
	}

	/**
	 * @return Delbehandlingens optimale tørringstid i timer
	 */
	public int getOptimalTørringsTid() {
		return optimalTørringsTid;
	}

	/**
	 * Sæt Delbehandlingens optimale tørringstid
	 * 
	 * @param optimalTørringsTid
	 *            Delbehandlingens optimale tørringstid
	 */
	public void setOptimalTørringsTid(int optimalTørringsTid) {
		this.optimalTørringsTid = optimalTørringsTid;
	}

	/**
	 * @return Delbehandlingens maksimale tørringstid i timer
	 */
	public int getMaksimumTørringsTid() {
		return maksimumTørringsTid;
	}

	/**
	 * Sæt Delbehandlingens maksimale tørringstid
	 * 
	 * @param maksimumTørringsTid
	 *            Delbehandlingens maksimale tørringstid
	 */
	public void setMaksimumTørringsTid(int maksimumTørringsTid) {
		this.maksimumTørringsTid = maksimumTørringsTid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format(
						"Delbehandling [navn=%s, id=%s, behandlingsSted=%s, maksimumTørringsTid=%s, minimumTørringsTid=%s, optimalTørringsTid=%s]",
						navn, id, behandlingsSted, maksimumTørringsTid,
						minimumTørringsTid, optimalTørringsTid);
	}
}
