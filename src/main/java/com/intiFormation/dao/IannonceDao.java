package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;



public interface IannonceDao extends JpaRepository<Annonce, Integer> {
	public List<Annonce> findByCategorieAndValide(Categorie categorie, boolean valide);
	public List<Annonce> findByValide(boolean valide);
	public List<Annonce> findByUtilisateur(Utilisateur utilisateur);
	public List<Annonce> findByCategorie(Categorie categorie);
	
}
