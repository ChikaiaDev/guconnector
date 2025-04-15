package sn.intouch.gu.iabiri.ws.models.gucore;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Moyen {

	private static final long serialVersionUID = 1L;
    private int moyId, moyStatut = 1;
    private String moyCode, moyLibelle;
    private double moyMontant;

    public Moyen() {
        super();
    }

    public int getMoyId() {
        return moyId;
    }

    public void setMoyId(int moyId) {
        this.moyId = moyId;
    }

    public int getMoyStatut() {
        return moyStatut;
    }

    public void setMoyStatut(int moyStatut) {
        this.moyStatut = moyStatut;
    }

    public String getMoyCode() {
        return moyCode;
    }

    public void setMoyCode(String moyCode) {
        this.moyCode = moyCode;
    }

    public String getMoyLibelle() {
        return moyLibelle;
    }

    public void setMoyLibelle(String moyLibelle) {
        this.moyLibelle = moyLibelle;
    }

    public double getMoyMontant() {
        return moyMontant;
    }

    public void setMoyMontant(double moyMontant) {
        this.moyMontant = moyMontant;
    }


}
