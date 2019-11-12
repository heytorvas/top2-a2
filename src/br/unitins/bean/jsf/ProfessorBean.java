package br.unitins.bean.jsf;

import br.unitins.bean.ejb.ProfessorEJB;
import br.unitins.model.Professor;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ProfessorEJB professorEJB;

	private Professor professor;

	private List<Professor> listaProfessor;

	private Integer idPesquisa;

	@PostConstruct
	public void init() {
		findAll();
	}

	public void insert() {
		professorEJB.insert(professor);
		limpar();
		findAll();
	}

	private void findAll() {
		listaProfessor = professorEJB.findAll();
	}

	public void update() {
		professorEJB.update(professor);
		limpar();
		findAll();
	}

	public void delete() {
		professorEJB.delete(professorEJB.load(idPesquisa));
		limpar();
		findAll();
	}

	public void pesquisar() {
		professor = professorEJB.load(idPesquisa);
	}

	public void limpar() {
		professor = new Professor();
	}

	public Professor getProfessor() {
		if (professor == null) {
			professor = new Professor();
		}
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getlistaProfessor() {
		return listaProfessor;
	}

	public void setlistaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

}
