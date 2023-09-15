package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Commentaire;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IannonceService;
import com.intiFormation.service.IcommentaireService;
import com.intiFormation.service.IutilisateurService;

@RestController
@RequestMapping("/commentaire")
@CrossOrigin("http://localhost:4200")
public class CommentaireController {
	@Autowired
	IcommentaireService commentaireService;
	@Autowired
	IannonceService annonceService;
	@Autowired
	IutilisateurService utilService;
	
	@GetMapping(path="/public")
	public List<Commentaire> listeCommentaire(){
		return commentaireService.selectionTous();
	}
	
	@GetMapping(path="/public/{id}")
	public Commentaire commentaireById(@PathVariable("id") int id) {
		return commentaireService.selectionUn(id).get();
	}
	
	@GetMapping("/public/annonce/{idannonce}")
	public List<Commentaire> commentaireByAnnonce(@PathVariable("idannonce")int idannonce){
		Annonce annonce = annonceService.selectionUn(idannonce).get();
		return commentaireService.chercherParAnnonce(annonce);
		
	}
	@GetMapping("/public/utilisateur/{idutil}")
	public List<Commentaire> commentaireByUtilisateur(@PathVariable("idutil")int idutil){
		Utilisateur utilisateur = utilService.selectionUn(idutil).get();
		return commentaireService.findByUtilisateur(utilisateur);
		
	}
	
	@PostMapping(path="/user/save")
	public Commentaire saveCommentaire(@RequestBody Commentaire commentaire) {
		return commentaireService.ajouter(commentaire);
	}
	
	@PutMapping(path="/admin/modifier")
	public Commentaire updateCommentaire(@RequestBody Commentaire commentaire) {
		return commentaireService.ajouter(commentaire);
	}
	
	@DeleteMapping(path="/admin/supprimer/{id}")
	public void deleteCommentaire(@PathVariable("id") int id) {
		commentaireService.supprimer(id);
	}
}