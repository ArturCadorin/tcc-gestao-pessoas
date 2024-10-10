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

import com.gestao_pessoas.tccII.dto.PlanoCarreiraDTO;
import com.gestao_pessoas.tccII.entities.PlanoCarreira;
import com.gestao_pessoas.tccII.services.PlanoCarreiraService;

@RestController
@RequestMapping(value = "/plano_carreira")
public class PlanoCarreiraController {
	
	@Autowired
	private PlanoCarreiraService service;
	
	@GetMapping
	public ResponseEntity<List<PlanoCarreiraDTO>> findAll(){
		List<PlanoCarreiraDTO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PlanoCarreiraDTO> findById(@PathVariable Long id){
		PlanoCarreiraDTO planoCarreiraDTO = service.findById(id);
		return ResponseEntity.ok().body(planoCarreiraDTO);
	}

	@PostMapping
	public ResponseEntity<PlanoCarreiraDTO> insert(@RequestBody PlanoCarreiraDTO planoCarreiraDTO){
		PlanoCarreira planoCarreira = service.insert(planoCarreiraDTO);
		PlanoCarreiraDTO createdPlanoCarreiraDTO = service.convertToDTO(planoCarreira);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPlanoCarreiraDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(createdPlanoCarreiraDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PlanoCarreira> update(@PathVariable Long id, @RequestBody PlanoCarreira obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
