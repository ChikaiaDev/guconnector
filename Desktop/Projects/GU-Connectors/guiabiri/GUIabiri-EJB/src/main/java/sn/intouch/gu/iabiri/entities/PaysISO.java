package sn.intouch.gu.iabiri.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pays_iso")
public class PaysISO implements Serializable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "code_iso", unique = true)
	private String codeISO;
	@Column(name = "currency")
	private String currency;
	@Column(name = "services", columnDefinition = "TEXT")
	private String services;
	@Column(name = "numero_spoc")
	private String numeroSpoc;
	@Column(name = "tel_length")
	private Integer telLength;
	@Column( name = "supprime")
	private Boolean supprime = false;

	public PaysISO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getCodeISO() {
		return codeISO;
	}

	public void setCodeISO(String codeISO) {
		this.codeISO = codeISO;
	}
	
	public Boolean getSupprime() {
		return supprime;
	}

	public void setSupprime(Boolean supprime) {
		this.supprime = supprime;
	}

	public String getNumeroSpoc() {
		return numeroSpoc;
	}

	public void setNumeroSpoc(String numeroSpoc) {
		this.numeroSpoc = numeroSpoc;
	}

	public Integer getTelLength() {
		return telLength;
	}

	public void setTelLength(Integer telLength) {
		this.telLength = telLength;
	}

	@Override
	public String toString() {
		return "PaysISO [id=" + id + ", codeISO=" + codeISO + ", currency=" + currency + ", services=" + services
				+ ", numeroSpoc=" + numeroSpoc + ", telLength=" + telLength + ", supprime=" + supprime + "]";
	}

}
