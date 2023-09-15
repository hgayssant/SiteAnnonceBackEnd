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
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Categorie;
import com.intiFormation.service.IcategorieService;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("http://localhost:4200")
public class CategorieController {
	
	@Autowired
	IcategorieService catService;
	
	@GetMapping("/public")
	public List<Categorie> listeCategorie(){
		return catService.selectionTous();
	}
	
	@GetMapping("/public/{id}")
	public Categorie categorieById(@PathVariable("id") int id){
		return catService.selectionUn(id).get();
	}
	
	@PostMapping("/user/save")
	public Categorie saveCategorie(@RequestBody Categorie categorie) {
		return catService.ajouter(categorie);
	}
	
	@PutMapping("/admin/modifier")
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		return catService.ajouter(categorie);
	}
	
	@DeleteMapping("/admin/supprimer/{id}")
	public void deleteCategorie(@PathVariable("id") int id) {
		catService.supprimer(id);
	}
	
}
