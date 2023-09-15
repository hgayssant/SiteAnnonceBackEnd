package com.intiFormation.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IannonceDao;
import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;

@Service
public class AnnonceService implements IannonceService {
		
		@Autowired
		IannonceDao dao;
		
		@Autowired
		EmailService mailservice;
		
		public Annonce ajouter(Annonce a) {
			return dao.save(a);
		}
		public void supprimer(int id) {
			dao.deleteById(id);
		}
		
		public Optional<Annonce> selectionUn(int id){
			return dao.findById(id);
		}
		
		public List<Annonce> selectionTous(){
			return dao.findAll();
		}
		public List<Annonce> chercherParCategorieAndValide(Categorie categorie, boolean valide){
			return dao.findByCategorieAndValide(categorie, valide);
		}
		@Override
		public List<Annonce> findByValide(boolean valide) {
		
			return dao.findByValide(valide);
		}
		public List<Annonce> findByUtilisateur(Utilisateur utilisateur)
		{
			return dao.findByUtilisateur(utilisateur);
		}
		
		public void validerAnnonce(int id, String mail, String subject, String message) {
			Annonce a = dao.findById(id).get();
			a.setValide(true);
			
			Date today = new Date();
			a.setDatePublication(today);
			
			Calendar c = Calendar.getInstance();
	        c.setTime(today);
	        c.add(Calendar.MONTH, 1);
			
	        Date exp = c.getTime();
	        a.setDateExpiration(exp);
	        mailservice.sendSimpleMessage(mail, subject, message);
			dao.save(a);
		}
		@Override
		public List<Annonce> findByCategorie(Categorie categorie) {
			return dao.findByCategorie(categorie);
		}
}
