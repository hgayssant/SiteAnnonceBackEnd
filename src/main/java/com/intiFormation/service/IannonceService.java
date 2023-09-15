package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;

public interface IannonceService {
	public Annonce ajouter(Annonce a);
	public void supprimer(int id);
	public Optional<Annonce> selectionUn(int id);
	public List<Annonce> selectionTous();
	public List<Annonce> chercherParCategorieAndValide(Categorie categorie, boolean valide);
	public List<Annonce> findByValide(boolean valide);
	public List<Annonce> findByUtilisateur(Utilisateur utilisateur);
	public void validerAnnonce(int id,String mail, String subject, String message);
	public List<Annonce> findByCategorie(Categorie categorie);

	
}
