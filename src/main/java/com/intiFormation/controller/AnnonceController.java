package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Annonce;
import com.intiFormation.entity.Categorie;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IannonceService;
import com.intiFormation.service.IcategorieService;
import com.intiFormation.service.IutilisateurService;

@RestController
@RequestMapping("/annonce")
@CrossOrigin("http://localhost:4200")
public class AnnonceController {
	@Autowired
	IannonceService annonceService;
	@Autowired
	IcategorieService categorieService;
	@Autowired
	IutilisateurService utilService;
	
	@GetMapping(path="/public")
	public List<Annonce> listeAnnonce(){
		return annonceService.selectionTous();
	}
	
	@GetMapping(path="/public/{id}")
	public Annonce annonceById(@PathVariable("id") int id) {
		return annonceService.selectionUn(id).get();
	}
	@GetMapping("/public/categorie/{idcat}")
	public List<Annonce> annonceByCategorie(@PathVariable("idcat") int idcat){
		Categorie categorie = categorieService.selectionUn(idcat).get();
		return annonceService.findByCategorie(categorie);
	}
	@GetMapping("/public/utilisateur/{idutil}")
	public List<Annonce> annonceByUtilisateur(@PathVariable("idutil") int idutil){
		Utilisateur utilisateur = utilService.selectionUn(idutil).get();
		return annonceService.findByUtilisateur(utilisateur);
		
	}
	
	@PostMapping(path="/user/save")
	public Annonce saveAnnonce(@RequestBody Annonce annonce) {
		return annonceService.ajouter(annonce);
	}
//	@PostMapping("/user/saveimg")
//	public Annonce saveAnnonceImg(@RequestParam("image") MultipartFile file,@RequestParam("idannonce") int id, @RequestParam("titre") String titre, @RequestParam(""))
	
	@PutMapping(path="/admin/modifier")
	public Annonce updateAnnonce(@RequestBody Annonce annonce) {
		return annonceService.ajouter(annonce);
	}
	
	@DeleteMapping(path="/admin/supprimer/{id}")
	public void deleteAnnonce(@PathVariable("id") int id) {
		annonceService.supprimer(id);
	}
}
