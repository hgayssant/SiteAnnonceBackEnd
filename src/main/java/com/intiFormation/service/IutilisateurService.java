package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Utilisateur;

public interface IutilisateurService {
	public Utilisateur ajouter(Utilisateur u);
	public void supprimer(int id);
	public Optional<Utilisateur> selectionUn(int id);
	public List<Utilisateur> selectionTous();
	public Optional<Utilisateur> authentifier(String username, String password);
	public Optional<Utilisateur> findByMail(String mail);
	public Optional<Utilisateur> findByUsername(String username);
}
