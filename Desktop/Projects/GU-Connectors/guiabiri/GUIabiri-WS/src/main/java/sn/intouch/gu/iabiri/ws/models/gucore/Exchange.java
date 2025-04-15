package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Exchange implements Serializable, Runnable{
	private static final long serialVersionUID = 1L;
	private String method;
	private String resultCode;
	private String mac;
	private Station station;
	private Date dateDebut, dateFin;
	private boolean markSyncON;
	private boolean markDefaultSyncON;
	private List<String> promos;
	private String resultMessage;
	private double jauge;
	private Date jour;
	private String agtLogin;
	private String errorCode;
	private String tempId;
	public static final Gson gson = new Gson();
	private String partner;
	private String urlAppBoutique;
	private String updateImportanceLevel;
	private String token;
	private String fcmToken;
	private String doToken;
	private String touchWebLogoFolder;
	private String tokenSms;
	private long syncRefTimestamp;
	private String apkVersion;
	private List<Service> services;
	private String idSim;
	private String apkType;
	private String tokenPda;
	private String devise;
	private String categorie; // STANDARD OU PROXY
	private double curseurDmaAgent;
	private  double dmaStation;
	private double soldeStation;
	private double dmaAgent;
    private boolean isDegradedMode;
    private String degradedServices;
    private boolean isDegradedDistri;
    private boolean isDegradedPay;
	private List<Operation> operations;
	private Utilisateur user;
	private PDA pda;
	private Operation operation;
	private String passEdit = "";
	private int longtel;
	@Override
	public void run() {
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public boolean isMarkSyncON() {
		return markSyncON;
	}
	public void setMarkSyncON(boolean markSyncON) {
		this.markSyncON = markSyncON;
	}
	public boolean isMarkDefaultSyncON() {
		return markDefaultSyncON;
	}
	public void setMarkDefaultSyncON(boolean markDefaultSyncON) {
		this.markDefaultSyncON = markDefaultSyncON;
	}
	public List<String> getPromos() {
		return promos;
	}
	public void setPromos(List<String> promos) {
		this.promos = promos;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public double getJauge() {
		return jauge;
	}
	public void setJauge(double jauge) {
		this.jauge = jauge;
	}
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public String getAgtLogin() {
		return agtLogin;
	}
	public void setAgtLogin(String agtLogin) {
		this.agtLogin = agtLogin;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getUrlAppBoutique() {
		return urlAppBoutique;
	}
	public void setUrlAppBoutique(String urlAppBoutique) {
		this.urlAppBoutique = urlAppBoutique;
	}
	public String getUpdateImportanceLevel() {
		return updateImportanceLevel;
	}
	public void setUpdateImportanceLevel(String updateImportanceLevel) {
		this.updateImportanceLevel = updateImportanceLevel;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFcmToken() {
		return fcmToken;
	}
	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
	public String getDoToken() {
		return doToken;
	}
	public void setDoToken(String doToken) {
		this.doToken = doToken;
	}
	public String getTouchWebLogoFolder() {
		return touchWebLogoFolder;
	}
	public void setTouchWebLogoFolder(String touchWebLogoFolder) {
		this.touchWebLogoFolder = touchWebLogoFolder;
	}
	public String getTokenSms() {
		return tokenSms;
	}
	public void setTokenSms(String tokenSms) {
		this.tokenSms = tokenSms;
	}
	public long getSyncRefTimestamp() {
		return syncRefTimestamp;
	}
	public void setSyncRefTimestamp(long syncRefTimestamp) {
		this.syncRefTimestamp = syncRefTimestamp;
	}
	public String getApkVersion() {
		return apkVersion;
	}
	public void setApkVersion(String apkVersion) {
		this.apkVersion = apkVersion;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public String getIdSim() {
		return idSim;
	}
	public void setIdSim(String idSim) {
		this.idSim = idSim;
	}
	public String getApkType() {
		return apkType;
	}
	public void setApkType(String apkType) {
		this.apkType = apkType;
	}
	public String getTokenPda() {
		return tokenPda;
	}
	public void setTokenPda(String tokenPda) {
		this.tokenPda = tokenPda;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static Gson getGson() {
		return gson;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public PDA getPda() {
		return pda;
	}
	public void setPda(PDA pda) {
		this.pda = pda;
	}
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	public double getCurseurDmaAgent() {
		return curseurDmaAgent;
	}
	public void setCurseurDmaAgent(double curseurDmaAgent) {
		this.curseurDmaAgent = curseurDmaAgent;
	}
	public double getDmaStation() {
		return dmaStation;
	}
	public void setDmaStation(double dmaStation) {
		this.dmaStation = dmaStation;
	}
	public double getSoldeStation() {
		return soldeStation;
	}
	public void setSoldeStation(double soldeStation) {
		this.soldeStation = soldeStation;
	}
	public double getDmaAgent() {
		return dmaAgent;
	}
	public void setDmaAgent(double dmaAgent) {
		this.dmaAgent = dmaAgent;
	}
	public boolean isDegradedMode() {
		return isDegradedMode;
	}
	public void setDegradedMode(boolean isDegradedMode) {
		this.isDegradedMode = isDegradedMode;
	}
	public String getDegradedServices() {
		return degradedServices;
	}
	public void setDegradedServices(String degradedServices) {
		this.degradedServices = degradedServices;
	}
	public boolean isDegradedDistri() {
		return isDegradedDistri;
	}
	public void setDegradedDistri(boolean isDegradedDistri) {
		this.isDegradedDistri = isDegradedDistri;
	}
	public boolean isDegradedPay() {
		return isDegradedPay;
	}
	public void setDegradedPay(boolean isDegradedPay) {
		this.isDegradedPay = isDegradedPay;
	}
    public String getPassEdit() {
        return passEdit;
    }
    public void setPassEdit(String passEdit) {
        this.passEdit = passEdit;
    }
	public int getLongtel() {
		return longtel;
	}
	public void setLongtel(int longtel) {
		this.longtel = longtel;
	}
	

    public Exchange() {
		super();
	}


	@Override
	public String toString() {
		return "Exchange{" +
				"method='" + method + '\'' +
				", resultCode='" + resultCode + '\'' +
				", mac='" + mac + '\'' +
				", station=" + station +
				", dateDebut=" + dateDebut +
				", dateFin=" + dateFin +
				", markSyncON=" + markSyncON +
				", markDefaultSyncON=" + markDefaultSyncON +
				", promos=" + promos +
				", resultMessage='" + resultMessage + '\'' +
				", jauge=" + jauge +
				", jour=" + jour +
				", agtLogin='" + agtLogin + '\'' +
				", errorCode='" + errorCode + '\'' +
				", tempId='" + tempId + '\'' +
				", partner='" + partner + '\'' +
				", urlAppBoutique='" + urlAppBoutique + '\'' +
				", updateImportanceLevel='" + updateImportanceLevel + '\'' +
				", token='" + token + '\'' +
				", fcmToken='" + fcmToken + '\'' +
				", doToken='" + doToken + '\'' +
				", touchWebLogoFolder='" + touchWebLogoFolder + '\'' +
				", tokenSms='" + tokenSms + '\'' +
				", syncRefTimestamp=" + syncRefTimestamp +
				", apkVersion='" + apkVersion + '\'' +
				", services=" + services +
				", idSim='" + idSim + '\'' +
				", apkType='" + apkType + '\'' +
				", tokenPda='" + tokenPda + '\'' +
				", devise='" + devise + '\'' +
				", categorie='" + categorie + '\'' +
				", curseurDmaAgent=" + curseurDmaAgent +
				", dmaStation=" + dmaStation +
				", soldeStation=" + soldeStation +
				", dmaAgent=" + dmaAgent +
				", isDegradedMode=" + isDegradedMode +
				", degradedServices='" + degradedServices + '\'' +
				", isDegradedDistri=" + isDegradedDistri +
				", isDegradedPay=" + isDegradedPay +
				", operations=" + operations +
				", user=" + user +
				", pda=" + pda +
				", operation=" + operation +
				", passEdit='" + passEdit + '\'' +
				", longtel=" + longtel +
				'}';
	}
}
