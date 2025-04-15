package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperateurService {

	private String codeOperateur;
    private String libelleOperateur;

    public String getCodeOperateur() {
        return codeOperateur;
    }

    public void setCodeOperateur(String codeOperateur) {
        this.codeOperateur = codeOperateur;
    }

    public String getLibelleOperateur() {
        return libelleOperateur;
    }

    public void setLibelleOperateur(String libelleOperateur) {
        this.libelleOperateur = libelleOperateur;
    }

    public OperateurService(String codeOperateur, String libelleOperateur) {
        this.codeOperateur = codeOperateur;
        this.libelleOperateur = libelleOperateur;
    }

    public OperateurService() {
    }
}
