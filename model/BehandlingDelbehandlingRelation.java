package model;
import javax.persistence.*;
@Entity
@Table(name="Behandling_Delbehandling")
public class BehandlingDelbehandlingRelation {
@Id
@GeneratedValue
private int iD;
@ManyToOne
private Behandling behandling;
@ManyToOne
private Delbehandling delbehandling;
private int rækkefølge;
public int getRækkefølge() {
	return rækkefølge;
}
public void setRækkefølge(int rækkefølge) {
	this.rækkefølge = rækkefølge;
}
public Behandling getBehandling() {
	return behandling;
}
public void setBehandling(Behandling behandling) {
	this.behandling = behandling;
}
public Delbehandling getDelbehandling() {
	return delbehandling;
}
public void setDelbehandling(Delbehandling delbehandling) {
	this.delbehandling = delbehandling;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return String
			.format(
					"BehandlingDelbehandlingRelation [ID=%s, rækkefølge=%s, delbehandling=%s]",
					iD, rækkefølge, delbehandling);
}

}
