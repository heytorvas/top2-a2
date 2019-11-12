package br.unitins.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Periodo implements Serializable {

	   
	@Id
	private Integer idPeriodo;
	private String nomePeriodo;
	
	@ManyToMany
	private List<Disciplina> listaDisciplina;
	
	private static final long serialVersionUID = 1L;

	public Periodo() {
		super();
	}   
	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}   
	public String getNomePeriodo() {
		return this.nomePeriodo;
	}

	public void setNomePeriodo(String nomePeriodo) {
		this.nomePeriodo = nomePeriodo;
	}   
	public List<Disciplina> getListaDisciplina() {
		return this.listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
   
}
