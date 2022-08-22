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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	@GetMapping("/piezas/{codigo}")
	public Pieza piezaXID(@PathVariable(name="codigo") int codigo) {
		
		Pieza pieza_xid= new Pieza();
		
		pieza_xid=piezaServiceImpl.piezaXID(codigo);
		
		
		return pieza_xid;
	}
	
	@PutMapping("/piezas/{codigo}")
	public Pieza actualizarPieza(@PathVariable(name="codigo")int codigo,@RequestBody Pieza pieza) {
		
		Pieza pieza_seleccionado= new Pieza();
		Pieza pieza_actualizado= new Pieza();
		
		pieza_seleccionado= piezaServiceImpl.piezaXID(codigo);
		
		pieza_seleccionado.setNombre(pieza.getNombre());
		
		pieza_actualizado = piezaServiceImpl.actualizarPieza(pieza_seleccionado);
		
		
		return pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{codigo}")
	public void eleiminarPieza(@PathVariable(name="codigo")int codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}
	
	
}