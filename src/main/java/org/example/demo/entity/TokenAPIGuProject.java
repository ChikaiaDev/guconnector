package org.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "token_api_gu_project")
@NamedQuery(
		name = "User.findByUsername",
		query = "SELECT u FROM TokenAPIGuProject u WHERE u.username = :username"
)
@NamedQuery(
		name = "User.findByUsernameAndPassword",
		query = "SELECT u FROM TokenAPIGuProject u WHERE u.username = :username AND u.password =:password"
)
public class TokenAPIGuProject implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "partner_id")
	private String partner_id;
	@Column(name = "supprime")
	private Boolean supprime;

	public TokenAPIGuProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public Boolean getSupprime() {
		return supprime;
	}

	public void setSupprime(Boolean supprime) {
		this.supprime = supprime;
	}
}
