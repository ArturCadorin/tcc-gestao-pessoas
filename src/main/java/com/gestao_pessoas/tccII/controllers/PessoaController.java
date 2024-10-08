package com.gestao_pessoas.tccII.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_pessoas.tccII.dto.PessoaDTO;
import com.gestao_pessoas.tccII.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		
		List<PessoaDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
