package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateur;


public interface IcommentaireDao extends JpaRepository<Commentaire, Integer>{
	public List<Commentaire> findByAnnonce(Annonce a);
	public List<Commentaire> findByUtilisateur(Utilisateur utilisateur);

}
