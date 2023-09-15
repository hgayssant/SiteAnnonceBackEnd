package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intiFormation.entity.Categorie;
import com.intiFormation.service.IcategorieService;

@Controller
public class AccueilController {

	@Autowired
	IcategorieService catservice;
	
	@RequestMapping("/Accueil")
	public String acceuil(Model model) {
		List<Categorie> categories = catservice.selectionTous();
		model.addAttribute("categories",categories);
		
		return "homePage";
	}
	
	@RequestMapping("/Admin")
	public String pageAdmin() {
		return "pageAdmin";
	}
}
