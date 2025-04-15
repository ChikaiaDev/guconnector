package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PDA {

    private String codePDA;
    private String codeStation;
    private String nomStation;
    private String numeroGerant;
    private String codeIMSI;
    private String numero;
    private String mdpOM;
    private String token;
    private Double montantRapatriement;

    public PDA() {
    }

    public PDA(String codePDA, String codeStation, String nomStation, String numeroGerant, String codeIMSI, String numero, String mdpOM) {
        this.codePDA = codePDA;
        this.codeStation = codeStation;
        this.nomStation = nomStation;
        this.numeroGerant = numeroGerant;
        this.codeIMSI = codeIMSI;
        this.numero = numero;
        this.mdpOM = mdpOM;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getMontantRapatriement() {
        return montantRapatriement;
    }

    public void setMontantRapatriement(Double montantRapatriement) {
        this.montantRapatriement = montantRapatriement;
    }

    public String getCodePDA() {
        return codePDA;
    }

    public void setCodePDA(String codePDA) {
        this.codePDA = codePDA;
    }

    public String getCodeStation() {
        return codeStation;
    }

    public void setCodeStation(String codeStation) {
        this.codeStation = codeStation;
    }

    public String getNomStation() {
        return nomStation;
    }

    public void setNomStation(String nomStation) {
        this.nomStation = nomStation;
    }

    public String getNumeroGerant() {
        return numeroGerant;
    }

    public void setNumeroGerant(String numeroGerant) {
        this.numeroGerant = numeroGerant;
    }

    public String getCodeIMSI() {
        return codeIMSI;
    }

    public void setCodeIMSI(String codeIMSI) {
        this.codeIMSI = codeIMSI;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMdpOM() {
        return mdpOM;
    }

    public void setMdpOM(String mdpOM) {
        this.mdpOM = mdpOM;
    }
}
