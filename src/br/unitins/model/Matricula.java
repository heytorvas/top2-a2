package br.unitins.model;

import br.unitins.model.Aluno;
import br.unitins.model.DisciplinaOfertada;
import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

@Entity
public class Matricula implements Serializable {

	   
	@Id
	private Integer idMatricula;
	private Aluno aluno;
	private DisciplinaOfertada disciplinaOfertada;
	private static final long serialVersionUID = 1L;

	public Matricula() {
		super();
	}   
	public Integer getIdMatricula() {
		return this.idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}   
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}   
	public DisciplinaOfertada getDisciplinaOfertada() {
		return this.disciplinaOfertada;
	}

	public void setDisciplinaOfertada(DisciplinaOfertada disciplinaOfertada) {
		this.disciplinaOfertada = disciplinaOfertada;
	}
   
}
