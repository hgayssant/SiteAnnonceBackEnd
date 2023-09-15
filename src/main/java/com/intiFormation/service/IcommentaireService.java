package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateur;

public interface IcommentaireService {
	public Commentaire ajouter(Commentaire c);
	public void supprimer(int id);
	
	public Optional<Commentaire> selectionUn(int id);
	
	public List<Commentaire> selectionTous();
	
	public List<Commentaire> chercherParAnnonce(Annonce a);
	public List<Commentaire> findByUtilisateur(Utilisateur utilisateur);

}
