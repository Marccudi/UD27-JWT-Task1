package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorServiceImpl {
	@Autowired
	IProveedorDAO ProveedorDAO;
public List<Proveedor> listarProveedores() {
		
		return ProveedorDAO.findAll();
	}

	
	public Proveedor guardarProveedor(Proveedor proveedor) {
		
		return ProveedorDAO.save(proveedor);
	}

	
	public Proveedor proveedorXID(String id) {
		
		return ProveedorDAO.findById(id).get();
	}

	
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		
		return ProveedorDAO.save(proveedor);
	}

	
	public void eliminarProveedor(String id) {
		
		ProveedorDAO.deleteById(id);
		
	}
}