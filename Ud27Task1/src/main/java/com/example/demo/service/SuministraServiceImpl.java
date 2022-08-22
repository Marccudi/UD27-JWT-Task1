package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDAO;
import com.example.demo.dto.Suministra;

@Service
public class SuministraServiceImpl {
	@Autowired
	ISuministraDAO SuministraDAO;
public List<Suministra> listarSuministras() {
		
		return SuministraDAO.findAll();
	}

	
	public Suministra guardarSuministra(Suministra suministra) {
		
		return SuministraDAO.save(suministra);
	}

	
	public Suministra suministraXID(int id) {
		
		return SuministraDAO.findById(id).get();
	}

	
	public Suministra actualizarSuministra(Suministra suministra) {
		
		return SuministraDAO.save(suministra);
	}

	
	public void eliminarSuministra(int id) {
		
		SuministraDAO.deleteById(id);
		
	}
}