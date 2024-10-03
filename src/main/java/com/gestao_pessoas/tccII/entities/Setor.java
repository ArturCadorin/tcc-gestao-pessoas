package com.gestao_pessoas.tccII.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_setor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Setor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	private String descricao;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	@OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
	private List<Cargo> cargos;
	
	@OneToMany(mappedBy = "setor")
	@JsonIgnore
	private List<Colaborador> colaboradores;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	@JsonIgnore
	private Empresa empresa;
	
	//CONSTRUCTORS
	public Setor(Long id, String nome, String descricao, LocalDate dataInicial, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.empresa = empresa;
	}
	public Setor(Long id, String nome, String descricao, LocalDate dataInicial, Empresa empresa, List<Cargo> cargos) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.cargos = cargos;
		this.empresa = empresa;
	}
	public Setor(Long id, String nome, String descricao, LocalDate dataInicial, Empresa empresa, List<Cargo> cargos, List<Colaborador> colaboradores) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.cargos = cargos;
		this.colaboradores = colaboradores;
		this.empresa = empresa;
	}
	public Setor() {}
	
	//GETTERS e SETTERS
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}
	
}
