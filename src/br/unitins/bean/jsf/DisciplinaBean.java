package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.DisciplinaEJB;
import br.unitins.model.Disciplina;

@Named
@SessionScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1932440258663850981L;

	@EJB
	private DisciplinaEJB disciplinaEJB;

	private Disciplina disciplina;

	private Integer idPesquisa;
	
	private List<Disciplina> listaDisciplina;

	@PostConstruct
	public void init() {
		listaDisciplina = disciplinaEJB.findAll();
	}

	public String insert() {
		disciplinaEJB.insert(disciplina);
		limpar();
		listaDisciplina = disciplinaEJB.findAll();
		return null;
	}

	public String update() {
		disciplina.setIdDisciplina(getIdPesquisa());
		disciplinaEJB.update(disciplina);
		limpar();
		listaDisciplina = disciplinaEJB.findAll();
		return null;
	}

	public String delete() {
		disciplinaEJB.delete(disciplinaEJB.load(idPesquisa));
		limpar();
		listaDisciplina = disciplinaEJB.findAll();
		return null;
	}

	public String pesquisar() {
		disciplina = disciplinaEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		disciplina = new Disciplina();
		return null;
	}

	public Disciplina getDisciplina() {

		if (disciplina == null) {
			disciplina = new Disciplina();
		}

		return disciplina;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

}
