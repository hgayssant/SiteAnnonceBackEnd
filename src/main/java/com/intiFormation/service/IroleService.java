package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Role;

public interface IroleService {
	
	public Role ajouter(Role r);
	public void supprimer(int id);
	public Optional<Role> selectionUn(int id);
	public List<Role> selectionTous();
}
