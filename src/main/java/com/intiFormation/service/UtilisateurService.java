package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IutilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IutilisateurService {
	@Autowired
	IutilisateurDao dao;

	public Utilisateur ajouter(Utilisateur p) {
		return dao.save(p);
	}
	
	public void supprimer(int id) {
		dao.deleteById(id);
	}
	
	public Optional<Utilisateur> selectionUn(int id){
		return dao.findById(id);
	}
	
	public List<Utilisateur> selectionTous(){
		return dao.findAll();
	}
	
	public Optional<Utilisateur> authentifier(String username, String password){
		return dao.findByUsernameAndPassword(username, password);
	}
	
	public Optional<Utilisateur> findByMail(String mail){
		return dao.findByMail(mail);
	}
	public Optional<Utilisateur> findByUsername(String username){
		return dao.findByUsername(username);
	}
}
