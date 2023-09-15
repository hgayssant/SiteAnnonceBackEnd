package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IroleDao;
import com.intiFormation.entity.Role;

@Service
public class RoleService implements IroleService {

	@Autowired
	IroleDao dao;

	public Role ajouter(Role r) {
		return dao.save(r);
	}

	@Override
	public void supprimer(int id) {
		dao.deleteById(id);
	}

	@Override
	public Optional<Role> selectionUn(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Role> selectionTous() {
		return dao.findAll();
	}

}
