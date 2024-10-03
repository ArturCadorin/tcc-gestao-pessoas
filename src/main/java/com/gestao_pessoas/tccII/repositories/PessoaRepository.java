package com.gestao_pessoas.tccII.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao_pessoas.tccII.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
