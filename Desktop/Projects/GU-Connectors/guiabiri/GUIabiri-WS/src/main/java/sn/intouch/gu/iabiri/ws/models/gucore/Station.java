package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

	/**
	 * 
	 */
	
	private int staId, staStatut = 1;
	private String staCode, staLibelle, staType;
	private String agence;
	private String caissier;
	private String pixi;
	private String shortCode;
	private String shortCodeBoutique;
	
	private Utilisateur staGerant;

	public int getStaStatut() {
		return staStatut;
	}

	public void setStaStatut(int staStatut) {
		this.staStatut = staStatut;
	}

	public int getStaId() {
		return staId;
	}

	public void setStaId(int staId) {
		this.staId = staId;
	}

	public String getStaCode() {
		return staCode;
	}

	public void setStaCode(String staCode) {
		this.staCode = staCode;
	}

	public String getStaLibelle() {
		return staLibelle;
	}

	public void setStaLibelle(String staLibelle) {
		this.staLibelle = staLibelle;
	}

	public String getStaType() {
		return staType;
	}

	public void setStaType(String staType) {
		this.staType = staType;
	}

	public Utilisateur getStaGerant() {
		return staGerant;
	}

	public void setStaGerant(Utilisateur staGerant) {
		this.staGerant = staGerant;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public String getCaissier() {
		return caissier;
	}

	public void setCaissier(String caissier) {
		this.caissier = caissier;
	}

	public String getPixi() {
		return pixi;
	}

	public void setPixi(String pixi) {
		this.pixi = pixi;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getShortCodeBoutique() {
		return shortCodeBoutique;
	}

	public void setShortCodeBoutique(String shortCodeBoutique) {
		this.shortCodeBoutique = shortCodeBoutique;
	}
}
