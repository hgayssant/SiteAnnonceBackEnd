package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcommentaireDao;
import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateur;

@Service
public class CommentaireService implements IcommentaireService{
	
	@Autowired
	IcommentaireDao dao;
	
	public Commentaire ajouter(Commentaire c) {
		return dao.save(c);
	}
	public void supprimer(int id) {
		dao.deleteById(id);
	}
	
	public Optional<Commentaire> selectionUn(int id){
		return dao.findById(id);
	}
	
	public List<Commentaire> selectionTous(){
		return dao.findAll();
	}
	
	public List<Commentaire> chercherParAnnonce(Annonce a)
	{
		return dao.findByAnnonce(a);
	}
	
	public List<Commentaire> findByUtilisateur(Utilisateur utilisateur) {
		return dao.findByUtilisateur(utilisateur);
	}
}
