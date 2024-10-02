package com.gestao_pessoas.tccII.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestao_pessoas.tccII.enums.Sexo;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String usuario;
	
	@NotNull
	@NotEmpty
	@Size(min = 6)
	@JsonIgnore
	private String senha;
	
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	//CONSTRUCTORS
	public Usuario(Long id, String nome, LocalDate nascimento, String cpf, String rg, Sexo sexo, Empresa empresa, String usuario, String senha, LocalDate dataInicial) {
		super(id, nome, nascimento, cpf, rg, sexo, empresa);
		this.usuario = usuario;
		this.senha = senha;
		this.dataInicial = dataInicial;
	}

	//GETTERS e SETTERS
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	protected String getSenha() {
		return senha;
	}
	protected void setSenha(String senha) {
		this.senha = senha;
	}
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(usuario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
	}
}
