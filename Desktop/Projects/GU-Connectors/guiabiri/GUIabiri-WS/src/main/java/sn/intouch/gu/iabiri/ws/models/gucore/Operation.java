package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Operation {

	/**
	 * 
	 */
	
	private long opeId;
	
	private Station opeStation;
	private List <Produit> opeProduit;
	
	private String opeTransactionId, opeTransactionStatus;
	private int opeTransactionAmount, opeCashInAmount;
	private Date opeDate;
	private String opeLogin;
	private String opeTelephone;
	private String numeroOM;
	private long lopeDate;
	private String opeAgtNom;
	private String opeTicket;
	private int opeDiscount;
	private String codeArticle;
	private Integer remiseArticle;
	private Integer quantiteArticle;
	private String libelleArticle;
	private double opeMontantHorsRemise;
	private Moyen opeMoyen;
	
	public long getOpeId() {
		return opeId;
	}
	public void setOpeId(long opeId) {
		this.opeId = opeId;
	}
	public Station getOpeStation() {
		return opeStation;
	}
	public void setOpeStation(Station opeStation) {
		this.opeStation = opeStation;
	}
	public String getOpeTransactionId() {
		return opeTransactionId;
	}
	public void setOpeTransactionId(String opeTransactionId) {
		this.opeTransactionId = opeTransactionId;
	}
	public String getOpeTransactionStatus() {
		return opeTransactionStatus;
	}
	public void setOpeTransactionStatus(String opeTransactionStatus) {
		this.opeTransactionStatus = opeTransactionStatus;
	}
	public int getOpeTransactionAmount() {
		return opeTransactionAmount;
	}
	public void setOpeTransactionAmount(int opeTransactionAmount) {
		this.opeTransactionAmount = opeTransactionAmount;
	}
	public Date getOpeDate() {
		return opeDate;
	}
	public void setOpeDate(Date opeDate) {
		this.opeDate = opeDate;
	}
	public String getOpeLogin() {
		return opeLogin;
	}
	public void setOpeLogin(String opeLogin) {
		this.opeLogin = opeLogin;
	}
	public String getOpeTelephone() {
		return opeTelephone;
	}
	public void setOpeTelephone(String opeTelephone) {
		this.opeTelephone = opeTelephone;
	}
	public String getNumeroOM() {
		return numeroOM;
	}
	public void setNumeroOM(String numeroOM) {
		this.numeroOM = numeroOM;
	}
	public Date getLopeDate() {
		return opeDate;
	}
	public void setLopeDate(long lopeDate) {
		this.lopeDate = lopeDate;
	}
	public String getOpeAgtNom() {
		return opeAgtNom;
	}
	public void setOpeAgtNom(String opeAgtNom) {
		this.opeAgtNom = opeAgtNom;
	}
	public String getOpeTicket() {
		return opeTicket;
	}
	public void setOpeTicket(String opeTicket) {
		this.opeTicket = opeTicket;
	}
	public int getOpeCashInAmount() {
		return opeCashInAmount;
	}
	public void setOpeCashInAmount(int opeCashInAmount) {
		this.opeCashInAmount = opeCashInAmount;
	}
	public int getOpeDiscount() {
		return opeDiscount;
	}
	public void setOpeDiscount(int opeDiscount) {
		this.opeDiscount = opeDiscount;
	}
	
	public String getCodeArticle() {
		return codeArticle;
	}
	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}
	public Integer getRemiseArticle() {
		return remiseArticle;
	}
	public void setRemiseArticle(Integer remiseArticle) {
		this.remiseArticle = remiseArticle;
	}
	public Integer getQuantiteArticle() {
		return quantiteArticle;
	}
	public void setQuantiteArticle(Integer quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}
	public String getLibelleArticle() {
		return libelleArticle;
	}
	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}
	public List<Produit> getOpeProduit() {
		return opeProduit;
	}
	public void setOpeProduit(List<Produit> opeProduit) {
		this.opeProduit = opeProduit;
	}
	public double getOpeMontantHorsRemise() {
		return opeMontantHorsRemise;
	}
	public void setOpeMontantHorsRemise(double opeMontantHorsRemise) {
		this.opeMontantHorsRemise = opeMontantHorsRemise;
	}
	public Moyen getOpeMoyen() {
		return opeMoyen;
	}
	public void setOpeMoyen(Moyen opeMoyen) {
		this.opeMoyen = opeMoyen;
	}
	
	
	
	
}
