package br.unitins.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MatrizCurricular implements Serializable {

	@Id
	private Integer idMatriz;
	private String nomeMatriz;
	private Integer ch;
	private Curso curso;
	
	@OneToMany
	private List<Periodo> listaPeriodo;
	
	private static final long serialVersionUID = 1L;

	public MatrizCurricular() {
		super();
	}

	public Integer getIdMatriz() {
		return this.idMatriz;
	}

	public void setIdMatriz(Integer idMatriz) {
		this.idMatriz = idMatriz;
	}

	public String getNomeMatriz() {
		return this.nomeMatriz;
	}

	public void setNomeMatriz(String nomeMatriz) {
		this.nomeMatriz = nomeMatriz;
	}

	public Integer getCh() {
		return this.ch;
	}

	public void setCh(Integer ch) {
		this.ch = ch;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Periodo> getListaPeriodo() {
		return this.listaPeriodo;
	}

	public void setListaPeriodo(List<Periodo> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}

}
