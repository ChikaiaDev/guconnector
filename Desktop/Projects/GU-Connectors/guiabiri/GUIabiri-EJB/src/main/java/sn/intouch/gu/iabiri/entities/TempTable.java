package sn.intouch.gu.iabiri.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temp_starter_table")
public class TempTable implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String token;
	private String statusTr;
	private String service;
	private String codePda;
	private String idPartner;
	private String destinataire;
	private String groupeReseau;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "token")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "service")
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Column(name = "status")
	public String getStatusTr() {
		return statusTr;
	}

	public void setStatusTr(String statusTr) {
		this.statusTr = statusTr;
	}

	@Column(name = "code_pda")
	public String getCodePda() {
		return codePda;
	}

	public void setCodePda(String codePda) {
		this.codePda = codePda;
	}

	@Column(name = "id_partner")
	public String getIdPartner() {
		return idPartner;
	}

	public void setIdPartner(String idPartner) {
		this.idPartner = idPartner;
	}

	@Column(name = "destinataire")
	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	@Column(name = "groupe_reseau")
	public String getGroupeReseau() {
		return groupeReseau;
	}

	public void setGroupeReseau(String groupeReseau) {
		this.groupeReseau = groupeReseau;
	}

}
