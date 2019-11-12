package br.unitins.bean.jsf;

import br.unitins.bean.ejb.MatriculaEJB;
import br.unitins.model.Matricula;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MatriculaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private MatriculaEJB matriculaEJB;

	private Matricula matricula;

	private List<Matricula> matriculas;

	private Integer disciplinaOfertada;

	private Integer idPesquisa;

	@PostConstruct
	public void init() {
		findAll();
	}

	public void insert() {
		matriculaEJB.insert(matricula, disciplinaOfertada);
		clean();
		findAll();
	}

	private void findAll() {
		matriculas = matriculaEJB.findAll();
	}

	public void update() {
		matriculaEJB.update(matricula, disciplinaOfertada);
		clean();
		findAll();
	}

	public void delete() {
		matriculaEJB.delete(matriculaEJB.load(idPesquisa));
		clean();
		findAll();
	}

	public void find() {
		matricula = matriculaEJB.load(idPesquisa);
	}

	public void clean() {
		matricula = new Matricula();
	}

	public Matricula getMatricula() {
		if (matricula == null) {
			matricula = new Matricula();
		}
		return matricula;
	}

	public void setMatricula(Matricula entity) {
		this.matricula = entity;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Integer getDisciplinaOfertada() {
		return disciplinaOfertada;
	}

	public void setDisciplinaOfertada(Integer disciplinaOfertada) {
		this.disciplinaOfertada = disciplinaOfertada;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}
}
