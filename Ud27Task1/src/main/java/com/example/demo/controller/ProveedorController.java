package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores(){
		return proveedorServiceImpl.listarProveedores();
	}
	
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores/{codigo}")
	public Proveedor proveedorXID(@PathVariable(name="codigo") String codigo) {
		
		Proveedor proveedor_xid= new Proveedor();
		
		proveedor_xid=proveedorServiceImpl.proveedorXID(codigo);
		
		
		return proveedor_xid;
	}
	
	@PutMapping("/proveedores/{codigo}")
	public Proveedor actualizarProveedor(@PathVariable(name="codigo")String codigo,@RequestBody Proveedor proveedor) {
		
		Proveedor proveedor_seleccionado= new Proveedor();
		Proveedor proveedor_actualizado= new Proveedor();
		
		proveedor_seleccionado= proveedorServiceImpl.proveedorXID(codigo);
		
		proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{codigo}")
	public void eleiminarProveedor(@PathVariable(name="codigo")String codigo) {
		proveedorServiceImpl.eliminarProveedor(codigo);
	}
	
	
}