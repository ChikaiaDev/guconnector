package sn.intouch.gu.iabiri.ws.models;

public class StatusExchange {

	private String guTransactionId;
	private String partnerTransactionId;
	private String status;
	private String message;
	private String destinataire;
	private String groupeReseau;
	private String codePda;

	public StatusExchange() {
		super();
	}

	public String getGuTransactionId() {
		return guTransactionId;
	}

	public void setGuTransactionId(String guTransactionId) {
		this.guTransactionId = guTransactionId;
	}

	public String getPartnerTransactionId() {
		return partnerTransactionId;
	}

	public void setPartnerTransactionId(String partnerTransactionId) {
		this.partnerTransactionId = partnerTransactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getGroupeReseau() {
		return groupeReseau;
	}

	public void setGroupeReseau(String groupeReseau) {
		this.groupeReseau = groupeReseau;
	}

	public String getCodePda() {
		return codePda;
	}

	public void setCodePda(String codePda) {
		this.codePda = codePda;
	}

}
