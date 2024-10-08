package com.gestao_pessoas.tccII.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_pessoas.tccII.dto.PessoaDTO;
import com.gestao_pessoas.tccII.entities.Pessoa;
import com.gestao_pessoas.tccII.repositories.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository repository;
	
	// Converter a entidade para uma lista de DTO
	public List<PessoaDTO> convertToDTOList(List<Pessoa> pessoas) {
		return pessoas.stream()
				.map(pessoa -> new PessoaDTO(pessoa))
		        .collect(Collectors.toList());
	}
			
	// Buscar todas as pessoas
	public List<PessoaDTO> findAll(){
		List<Pessoa> pessoas = repository.findAll();
		return convertToDTOList(pessoas);
	}
}
