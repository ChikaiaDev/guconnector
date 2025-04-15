package sn.intouch.gu.iabiri.ws.entities;

import java.util.Date;

public class SMS {

	private String _id;
	private String _adresse;
	private String body;
	private String destinataireOM;
	private float montantTransaction;
	private String idTransaction;
	private Date date;
	private String trType;
	private float frais;
	private float commission;
	private float montantDebite;
	private float montantcredite;
	private float solde;

	public SMS() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTrType() {
		return trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_adresse() {
		return _adresse;
	}

	public void set_adresse(String _adresse) {
		this._adresse = _adresse;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDestinataireOM() {
		return destinataireOM;
	}

	public void setDestinataireOM(String destinataireOM) {
		this.destinataireOM = destinataireOM;
	}

	public float getMontantTransaction() {
		return montantTransaction;
	}

	public void setMontantTransaction(float montantTransaction) {
		this.montantTransaction = montantTransaction;
	}

	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public float getFrais() {
		return frais;
	}

	public void setFrais(float frais) {
		this.frais = frais;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getMontantDebite() {
		return montantDebite;
	}

	public void setMontantDebite(float montantDebite) {
		this.montantDebite = montantDebite;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public float getMontantcredite() {
		return montantcredite;
	}

	public void setMontantcredite(float montantcredite) {
		this.montantcredite = montantcredite;
	}
}
