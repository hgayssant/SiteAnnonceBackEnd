package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IroleService;
import com.intiFormation.service.IutilisateurService;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IutilisateurService utilisateurService;
	@Autowired
	IroleService roleService;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping(path="/public")
	public List<Utilisateur> listeUtilisateur(){
		return utilisateurService.selectionTous();
	}
	
	@GetMapping(path="/public/user/{id}")
	public Utilisateur utilisateurById(@PathVariable("id") int id) {
		return utilisateurService.selectionUn(id).get();
	}
	
	@GetMapping(path="/public/username/{username}")
	public Utilisateur utilisateurByUsername(@PathVariable("username") String username) {
		return utilisateurService.findByUsername(username).get();
	}
	
	@PostMapping(path="/user/save")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateur.setPassword(encoder.encode("1234"));
		return utilisateurService.ajouter(utilisateur);
	}
	
	@PutMapping(path="/admin/modifier")
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.ajouter(utilisateur);
	}
	
	@DeleteMapping(path="/admin/supprimer/{id}")
	public void deleteUtilisateur(@PathVariable("id") int id) {
		utilisateurService.supprimer(id);
	}
	
	@GetMapping(path="/public/roles")
	public List<Role> listeRole() {
		return roleService.selectionTous();
	}

}
