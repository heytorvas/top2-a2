package br.unitins.model;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

@Entity
public class DisciplinaOfertada implements Serializable {

	   
	@Id
	private Integer id;
	private Semestre semestre;
	private Disciplina disciplina;
	private Professor professor;
	private static final long serialVersionUID = 1L;

	public DisciplinaOfertada() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Semestre getSemestre() {
		return this.semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}   
	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}   
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
   
}
