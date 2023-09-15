package com.intiFormation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description;
	private boolean valide;
	private String image;

	@Temporal(TemporalType.DATE)
	private Date datePublication;

	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	
	@ManyToOne
	@JoinColumn(name = "idutilisateur")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "annonce",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Commentaire> commentaires;
	
	@ManyToOne
	@JoinColumn(name = "idcategorie")
	private Categorie categorie;

	public Annonce(String titre, String description, boolean valide, Date datePublication,
			Date dateExpiration, Utilisateur utilisateur, List<Commentaire> commentaires) {
		super();
		this.titre = titre;
		this.description = description;
		this.valide = valide;
		this.datePublication = datePublication;
		this.dateExpiration = dateExpiration;
		this.utilisateur = utilisateur;
		this.commentaires = commentaires;
	}

	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annonce(String titre, String description, boolean valide, String image, Date datePublication,
			Date dateExpiration, Utilisateur utilisateur, List<Commentaire> commentaires) {
		super();
		this.titre = titre;
		this.description = description;
		this.valide = valide;
		this.image = image;
		this.datePublication = datePublication;
		this.dateExpiration = dateExpiration;
		this.utilisateur = utilisateur;
		this.commentaires = commentaires;
	}

	
	
	public Annonce(String titre, String description, boolean valide, String image, Date datePublication,
			Date dateExpiration, Utilisateur utilisateur, List<Commentaire> commentaires, Categorie categorie) {
		super();
		this.titre = titre;
		this.description = description;
		this.valide = valide;
		this.image = image;
		this.datePublication = datePublication;
		this.dateExpiration = dateExpiration;
		this.utilisateur = utilisateur;
		this.commentaires = commentaires;
		this.categorie = categorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public String toString() {
		return "Annonce [id=" + id + ", titre=" + titre + ", description=" + description + ", valide=" + valide
				+ ", image=" + image + ", datePublication=" + datePublication + ", dateExpiration=" + dateExpiration
				+ ", utilisateur=" + utilisateur + ", categorie=" + categorie + "]";
	}

}
