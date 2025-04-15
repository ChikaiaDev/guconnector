package sn.intouch.gu.iabiri.ws.models.gucore;

public class Utilisateur {

	private String login;
	private String password;
	private String telephone;
	private String profil;
	private String prenom;
	private String nom;
	private int userHasConnected;
	private String position;
	private int id;
	private long pmPrecedent;
	private long cashoutPrecedent;
	private long encaissementPrecedent;
	private long pm;
	private long cashout;
	private long encaissement;
	private long datemaj;
	private Double dmaAgent;
	private Double curseurDmaAgent;
	private Long dateLastTransaction;
	//auth online
	private Boolean twoFactorAuth;
	private Long dateDerniereConnexion;
	private String welcomeBookmark;
	private String langue;
	private Long dateLastChangePassword;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(int id, String profil, String telephone, String prenom, String nom, String login,
                       String password, int userHasConnected, String position) {
		super();
		this.id = id;
		this.login = login;
		if (password != null)
			this.password = password;
		this.profil = profil;
		this.prenom = prenom;
		this.nom = nom;
		this.setTelephone(telephone);
		this.userHasConnected = userHasConnected;
		this.position = position;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getUserHasConnected() {
		return userHasConnected;
	}

	public void setUserHasConnected(int userHasConnected) {
		this.userHasConnected = userHasConnected;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public long getPmPrecedent() {
		return pmPrecedent;
	}

	public void setPmPrecedent(Long pmPrecedent) {
		this.pmPrecedent = pmPrecedent!= null ? pmPrecedent : 0;
	}

	public long getCashoutPrecedent() {
		return cashoutPrecedent;
	}

	public void setCashoutPrecedent(Long cashoutPrecedent) {
		this.cashoutPrecedent = cashoutPrecedent!= null ? cashoutPrecedent : 0;
	}

	public long getEncaissementPrecedent() {
		return encaissementPrecedent;
	}

	public void setEncaissementPrecedent(Long encaissementPrecedent) {
		this.encaissementPrecedent = encaissementPrecedent!= null ? encaissementPrecedent : 0;
	}

	public long getPm() {
		return pm;
	}

	public void setPm(Long pm) {
		this.pm = pm!= null ? pm : 0;
	}

	public long getCashout() {
		return cashout;
	}

	public void setCashout(Long cashout) {
		this.cashout = cashout!= null ? cashout : 0;
	}

	public long getEncaissement() {
		return encaissement;
	}

	public void setEncaissement(Long encaissement) {
		this.encaissement = encaissement != null ? encaissement : 0;
	}

	public long getDatemaj() {
		return datemaj;
	}

	public void setDatemaj(Long datemaj) {
		this.datemaj = datemaj != null ? datemaj : 0;
	}
	/*
	 * 
	 * public long getCreatevoucher() { return createvoucher; }
	 * 
	 * public void setCreatevoucher(long createvoucher) { this.createvoucher =
	 * createvoucher; }
	 * 
	 * public long getRedeemvoucher() { return redeemvoucher; }
	 * 
	 * public void setRedeemvoucher(long redeemvoucher) { this.redeemvoucher =
	 * redeemvoucher; }
	 * 
	 */

	public Double getDmaAgent() {
		return dmaAgent;
	}

	public void setDmaAgent(Double dmaAgent) {
		this.dmaAgent = dmaAgent;
	}

	public Double getCurseurDmaAgent() {
		return curseurDmaAgent;
	}

	public void setCurseurDmaAgent(Double curseurDmaAgent) {
		this.curseurDmaAgent = curseurDmaAgent;
	}

	public Long getDateLastTransaction() {
		return dateLastTransaction;
	}

	public void setDateLastTransaction(Long dateLastTransaction) {
		this.dateLastTransaction = dateLastTransaction;
	}

	public Boolean getTwoFactorAuth() {
		return twoFactorAuth;
	}

	public void setTwoFactorAuth(Boolean twoFactorAuth) {
		this.twoFactorAuth = twoFactorAuth;
	}

	public Long getDateDerniereConnexion() {
		return dateDerniereConnexion;
	}

	public void setDateDerniereConnexion(Long dateDerniereConnexion) {
		this.dateDerniereConnexion = dateDerniereConnexion;
	}

	public String getWelcomeBookmark() {
		return welcomeBookmark;
	}

	public void setWelcomeBookmark(String welcomeBookmark) {
		this.welcomeBookmark = welcomeBookmark;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public Long getDateLastChangePassword() {
		return dateLastChangePassword;
	}

	public void setDateLastChangePassword(Long dateLastChangePassword) {
		this.dateLastChangePassword = dateLastChangePassword;
	}
}
