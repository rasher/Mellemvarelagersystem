package model;
import javax.persistence.*;
@Entity
@Table(name="Behandling_Delbehandling")
public class BehandlingDelbehandlingRelation {
@Id
@GeneratedValue
private int ID;
@ManyToOne
private Behandling behandling;
@ManyToOne
private Delbehandling delbehandling;
private int rækkeFølge;
public int getRækkeFølge() {
	return rækkeFølge;
}
public void setRækkeFølge(int rækkeFølge) {
	this.rækkeFølge = rækkeFølge;
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

}
