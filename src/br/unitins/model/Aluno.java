package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@Entity
public class Aluno implements Serializable {

	   
	@Id
	private Integer idAluno;
	private Integer ra;
	private String nome;
	private static final long serialVersionUID = 1L;

	public Aluno() {
		super();
	}   
	public Integer getIdAluno() {
		return this.idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}   
	public Integer getRa() {
		return this.ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
