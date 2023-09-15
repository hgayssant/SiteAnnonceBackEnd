package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IcategorieDao;
import com.intiFormation.entity.Categorie;

@Service
public class CategorieService implements IcategorieService {
	
	@Autowired
	IcategorieDao dao;
	
	public Categorie ajouter(Categorie p) {
		return dao.save(p);
	}
	
	public void supprimer(int id) {
		dao.deleteById(id);
	}
	
	public Optional<Categorie> selectionUn(int id){
		return dao.findById(id);
	}
	
	public List<Categorie> selectionTous(){
		return dao.findAll();
	}

}
