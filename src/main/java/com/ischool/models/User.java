package com.ischool.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "pk_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pkUser;
	
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String email;

	

	public User() {

	}

	public User(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	

	public Long getPkUser() {
		return pkUser;
	}

	public void setPkUser(Long pkUser) {
		this.pkUser = pkUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
