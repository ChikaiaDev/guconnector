package sn.intouch.gu.iabiri.ws.models.gucore;

public class Produit {

	private int pdtId, pdtStatut = 1;
	private String pdtCode, pdtLibelle;
	private Double pdtMontant;
	private String pdtBadgeRapido;
	private Service service;
	
	
	
	public int getPdtId() {
		return pdtId;
	}
	public void setPdtId(int pdtId) {
		this.pdtId = pdtId;
	}
	public int getPdtStatut() {
		return pdtStatut;
	}
	public void setPdtStatut(int pdtStatut) {
		this.pdtStatut = pdtStatut;
	}
	public String getPdtCode() {
		return pdtCode;
	}
	public void setPdtCode(String pdtCode) {
		this.pdtCode = pdtCode;
	}
	public String getPdtLibelle() {
		return pdtLibelle;
	}
	public void setPdtLibelle(String pdtLibelle) {
		this.pdtLibelle = pdtLibelle;
	}
	
	public Double getPdtMontant() {
		return pdtMontant;
	}
	public void setPdtMontant(Double pdtMontant) {
		this.pdtMontant = pdtMontant;
	}
	public String getPdtBadgeRapido() {
		return pdtBadgeRapido;
	}
	public void setPdtBadgeRapido(String pdtBadgeRapido) {
		this.pdtBadgeRapido = pdtBadgeRapido;
	}

	

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}	
}
