package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaServiceImpl {
	@Autowired
	IPiezaDAO PiezaDAO;
public List<Pieza> listarPiezas() {
		
		return PiezaDAO.findAll();
	}

	
	public Pieza guardarPieza(Pieza pieza) {
		
		return PiezaDAO.save(pieza);
	}

	
	public Pieza piezaXID(int id) {
		
		return PiezaDAO.findById(id).get();
	}

	
	public Pieza actualizarPieza(Pieza pieza) {
		
		return PiezaDAO.save(pieza);
	}

	
	public void eliminarPieza(int id) {
		
		PiezaDAO.deleteById(id);
		
	}
}
