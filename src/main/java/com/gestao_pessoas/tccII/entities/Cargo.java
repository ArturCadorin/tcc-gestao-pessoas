package com.gestao_pessoas.tccII.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.gestao_pessoas.tccII.dto.CargoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cargo")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cargo implements Serializable{	
	
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
	
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	
	@ManyToOne
	@JoinColumn(name = "nivel_profissional_id")
	protected PlanoCarreira nivelProfissional;
		
	@OneToMany(mappedBy = "cargo")
	private List<Colaborador> colaboradores;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	@JsonIgnore
	private Empresa empresa;
	
	//CONSTRUCTORS
	public Cargo(Long id, String nome, String descricao, LocalDate dataInicial) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
	}
	public Cargo(Long id, String nome, String descricao, LocalDate dataInicial, Empresa empresa, Setor setor, PlanoCarreira nivelProfissional) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.empresa = empresa;
		this.setor = setor;
		this.nivelProfissional = nivelProfissional;
	}
	public Cargo(Long id, String nome, String descricao, LocalDate dataInicial, Empresa empresa,  Setor setor, PlanoCarreira nivelProfissional, List<Colaborador> colaboradores) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.empresa = empresa;
		this.setor = setor;
		this.nivelProfissional = nivelProfissional;
		this.colaboradores = colaboradores;
	}
	public Cargo(CargoDTO cargoDTO) {
		BeanUtils.copyProperties(cargoDTO, this);
	}
	public Cargo() {}

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
	
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	
	public PlanoCarreira getNivelProfissional() {
		return nivelProfissional;
	}
	public void setNivelProfissional(PlanoCarreira nivelProfissional) {
		this.nivelProfissional = nivelProfissional;
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
		Cargo other = (Cargo) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}
	
}
