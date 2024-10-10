package com.gestao_pessoas.tccII.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestao_pessoas.tccII.dto.SetorDTO;
import com.gestao_pessoas.tccII.entities.Setor;
import com.gestao_pessoas.tccII.services.SetorService;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {

	@Autowired
	private SetorService service;
	
	@GetMapping
	public ResponseEntity<List<SetorDTO>> findAll(){
		List<SetorDTO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SetorDTO> findById(@PathVariable Long id){
		SetorDTO setorDTO = service.findById(id);
		return ResponseEntity.ok().body(setorDTO);
	}
	
	@PostMapping
	public ResponseEntity<SetorDTO> insert(@RequestBody SetorDTO setorDTO){
		Setor setor = service.insert(setorDTO);
		SetorDTO createdSetorDTO = service.convertToDTO(setor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSetorDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(createdSetorDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Setor> update(@PathVariable Long id, @RequestBody Setor obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
