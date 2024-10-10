package com.gestao_pessoas.tccII.dto;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.gestao_pessoas.tccII.entities.Empresa;
import com.gestao_pessoas.tccII.entities.Pessoa;
import com.gestao_pessoas.tccII.enums.Sexo;

public class PessoaDTO {
	
	private Long id;
	private String nome;
	private LocalDate nascimento;
	private String cpf;
	private String rg;
	private Sexo sexo;
	private Empresa empresa;

	public PessoaDTO(Pessoa pessoa) {
		BeanUtils.copyProperties(pessoa, this);
	}
	public PessoaDTO() {
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
