package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.DisciplinaOfertadaEJB;
import br.unitins.model.DisciplinaOfertada;

@Named
@SessionScoped
public class DisciplinaOfertadaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private DisciplinaOfertadaEJB disciplinaOfertadaEJB;

	private DisciplinaOfertada discplinaOfertada;

	private Integer idPesquisa;
	private Integer idSemestre;
	private Integer idProfessor;
	private Integer idDisciplina;

	private List<DisciplinaOfertada> listaOfertada;

	@PostConstruct
	public void init() {
		listaOfertada = disciplinaOfertadaEJB.findAll();
	}

	public String insert() {
		disciplinaOfertadaEJB.insert(discplinaOfertada, idSemestre, idDisciplina, idProfessor);
		limpar();
		listaOfertada = disciplinaOfertadaEJB.findAll();
		return null;
	}

	public String update() {
		discplinaOfertada.setId(getIdPesquisa());
		disciplinaOfertadaEJB.update(discplinaOfertada, idSemestre, idDisciplina, idProfessor);
		limpar();
		listaOfertada = disciplinaOfertadaEJB.findAll();
		return null;
	}

	public String delete() {
		disciplinaOfertadaEJB.delete(disciplinaOfertadaEJB.load(idPesquisa));
		limpar();
		listaOfertada = disciplinaOfertadaEJB.findAll();
		return null;
	}

	public String pesquisar() {
		discplinaOfertada = disciplinaOfertadaEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		discplinaOfertada = new DisciplinaOfertada();
		return null;
	}

	public DisciplinaOfertada getDisciplinaOfertada() {

		if (discplinaOfertada == null) {
			discplinaOfertada = new DisciplinaOfertada();
		}

		return discplinaOfertada;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<DisciplinaOfertada> getListaOfertada() {
		return listaOfertada;
	}

	public void setListaOfertada(List<DisciplinaOfertada> listaOfertada) {
		this.listaOfertada = listaOfertada;
	}

}
