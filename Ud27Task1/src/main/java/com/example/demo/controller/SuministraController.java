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

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministra")
	public List<Suministra> listarSuministras(){
		return suministraServiceImpl.listarSuministras();
	}
	
	@PostMapping("/suministra")
	public Suministra salvarSuministra(@RequestBody Suministra suministra) {
		
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	@GetMapping("/suministra/{codigo}")
	public Suministra suministraXID(@PathVariable(name="codigo") int codigo) {
		
		Suministra suministra_xid= new Suministra();
		
		suministra_xid=suministraServiceImpl.suministraXID(codigo);
		
		
		return suministra_xid;
	}
	
	@PutMapping("/suministra/{codigo}")
	public Suministra actualizarSuministra(@PathVariable(name="codigo")int codigo,@RequestBody Suministra suministra) {
		
		Suministra suministra_seleccionado= new Suministra();
		Suministra suministra_actualizado= new Suministra();
		
		suministra_seleccionado= suministraServiceImpl.suministraXID(codigo);
		
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_seleccionado.setCodigopieza(suministra.getCodigopieza());
		suministra_seleccionado.setProveedorid(suministra.getProveedorid());
		
		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		
		
		return suministra_actualizado;
	}
	
	@DeleteMapping("/suministra/{codigo}")
	public void eleiminarSuministra(@PathVariable(name="codigo")int codigo) {
		suministraServiceImpl.eliminarSuministra(codigo);
	}
	
	
}