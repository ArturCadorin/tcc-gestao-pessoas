package com.gestao_pessoas.tccII.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_pessoas.tccII.entities.Colaborador;
import com.gestao_pessoas.tccII.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll(){
		
		List<Colaborador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Long id){
		Colaborador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
