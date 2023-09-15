package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	@JsonIgnore
	private String password;
	
	private String nom;
	private String prenom;
	private boolean bloque;
	private String mail;
	
	@ManyToOne
	@JoinColumn(name = "idrole")
	private Role role;
	@OneToMany(mappedBy = "utilisateur",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Annonce> annonces;
	@OneToMany(mappedBy = "utilisateur",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Commentaire> commentaires;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String username, String password, String nom, String prenom, boolean bloque, String mail,
			Role role) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.bloque = bloque;
		this.mail = mail;
		this.role = role;
	}

	

	public Utilisateur(String username, String password, String nom, String prenom, boolean bloque, String mail,
			Role role, List<Annonce> annonces, List<Commentaire> commentaires) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.bloque = bloque;
		this.mail = mail;
		this.role = role;
		this.annonces = annonces;
		this.commentaires = commentaires;
	}


	public List<Annonce> getAnnonces() {
		return annonces;
	}


	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}


	public List<Commentaire> getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public boolean isBloque() {
		return bloque;
	}


	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", bloque=" + bloque + ", mail=" + mail + ", role=" + role + "]";
	}
	
	
	
}
