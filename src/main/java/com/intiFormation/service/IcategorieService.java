package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Categorie;

public interface IcategorieService {
	public Categorie ajouter(Categorie p);
	public void supprimer(int id);
	public Optional<Categorie> selectionUn(int id);
	public List<Categorie> selectionTous();
}
