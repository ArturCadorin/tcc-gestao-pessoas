package com.gestao_pessoas.tccII.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.services.SetorService;

@RestController
@RequestMapping(value = "/setor")
public class SetorResource {

	@Autowired
	private SetorService service;
	
	@GetMapping
	public ResponseEntity<List<Setor>> findAll(){
		
		List<Setor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
