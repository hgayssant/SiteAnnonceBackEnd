package com.intiFormation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;
import java.util.List;



public interface IutilisateurDao extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByUsernameAndPassword(String username, String password);
	public Optional<Utilisateur> findByMail(String mail);
	public Optional<Utilisateur> findByUsername(String username);
}
