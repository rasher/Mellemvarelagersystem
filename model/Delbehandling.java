package model;
import javax.persistence.*;

@Entity
@Table(name="Delbehandling")
@NamedQuery(name="findDelbehandlinger", query="Select db from Delbehandling db")
public class Delbehandling {
	@Id
	@GeneratedValue
	int id;
	@Column(length=128)
	private String navn;
	@Column(length=128)
	private String behandlingsSted;
	@Column(length=4)
	private int minimumTørringsTid;
	@Column(length=4)
	private int optimalTørringsTid;
	@Column(length=4)
	private int maksimumTørringsTid;
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getBehandlingsSted() {
		return behandlingsSted;
	}
	
	public void setBehandlingsSted(String behandlingsSted) {
		this.behandlingsSted = behandlingsSted;
	}
	
	public int getMinimumTørringsTid() {
		return minimumTørringsTid;
	}
	
	public void setMinimumTørringsTid(int minimumTørringsTid) {
		this.minimumTørringsTid = minimumTørringsTid;
	}
	
	public int getOptimalTørringsTid() {
		return optimalTørringsTid;
	}
	
	public void setOptimalTørringsTid(int optimalTørringsTid) {
		this.optimalTørringsTid = optimalTørringsTid;
	}
	
	public int getMaksimumTørringsTid() {
		return maksimumTørringsTid;
	}
	
	public void setMaksimumTørringsTid(int maksimumTørringsTid) {
		this.maksimumTørringsTid = maksimumTørringsTid;
	}
	
	/* (non-Javadoc)
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
