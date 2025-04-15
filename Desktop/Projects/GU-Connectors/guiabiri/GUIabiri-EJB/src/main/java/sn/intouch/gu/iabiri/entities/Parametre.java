package sn.intouch.gu.iabiri.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parametre")
public class Parametre implements Serializable {
	private int prmId, prmValue = 1;
	private String prmCode;
	private String prmStringValue = "";
	private int prmStatut = 1;
	private NetworkGroup networkGroup;
	private String prmLabel;

	@Id
	@Column(name = "prm_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPrmId() {
		return prmId;
	}

	public void setPrmId(int prmId) {
		this.prmId = prmId;
	}

	@Column(name = "prm_code")
	public String getPrmCode() {
		return prmCode;
	}

	public void setPrmCode(String prmCode) {
		this.prmCode = prmCode;
	}

	@Column(name = "prm_value")
	public int getPrmValue() {
		return prmValue;
	}

	public void setPrmValue(int prmValue) {
		this.prmValue = prmValue;
	}

	@Column(name = "prm_stringvalue")
	public String getPrmStringValue() {
		return prmStringValue;
	}

	public void setPrmStringValue(String prmStringValue) {
		this.prmStringValue = prmStringValue;
	}

	@Column(name = "prm_statut")
	public int getPrmStatut() {
		return prmStatut;
	}

	public void setPrmStatut(int prmStatut) {
		this.prmStatut = prmStatut;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "network_group_id")
	public NetworkGroup getNetworkGroup() {
		return networkGroup;
	}

	public void setNetworkGroup(NetworkGroup networkGroup) {
		this.networkGroup = networkGroup;
	}

	@Column(name = "prm_label")
	public String getPrmLabel() {
		return prmLabel;
	}

	public void setPrmLabel(String prmLabel) {
		this.prmLabel = prmLabel;
	}

	@Override
	public String toString() {
		return "Parametre [prmId=" + prmId + ", prmValue=" + prmValue + ", prmCode=" + prmCode + ", prmStringValue="
				+ prmStringValue + ", prmStatut=" + prmStatut + ", networkGroup=" + networkGroup + ", prmLabel="
				+ prmLabel + "]";
	}
}
