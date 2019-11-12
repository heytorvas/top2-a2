package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.DisciplinaEJB;
import br.unitins.bean.ejb.PeriodoEJB;
import br.unitins.model.Disciplina;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class PeriodoBean implements Serializable {

	private static final long serialVersionUID = -9183439642373115570L;

	@EJB
	private PeriodoEJB periodoEJB;

	@EJB
	private DisciplinaEJB disciplinaEJB;

	private Periodo periodo;

	private Integer idPesquisa;

	private List<Periodo> listaPeriodo;

	private List<Disciplina> listaDisciplina;

	private Integer idDisciplina;

	@PostConstruct
	public void init() {
		listaPeriodo = periodoEJB.findAll();

	}

	public String insert() {

//		for (int i = 0; i < idDisciplina.size(); i++) {
//			listaDiscp.add(disciplinaEJB.load(idDisciplina.get(i)));
//		}
//		periodo.setDisciplina(listaDiscp);

		periodoEJB.insert(periodo, listaDisciplina);
		limpar();
		listaPeriodo = periodoEJB.findAll();
		return null;
	}

	public String update() {
		periodo.setIdPeriodo(getIdPesquisa());
		periodoEJB.update(periodo, listaDisciplina);
		limpar();
		listaPeriodo = periodoEJB.findAll();
		return null;
	}

	public String delete() {
		periodoEJB.delete(periodoEJB.load(idPesquisa));
		limpar();
		listaPeriodo = periodoEJB.findAll();
		return null;
	}

	public String pesquisar() {
		periodo = periodoEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		periodo = new Periodo();
		return null;
	}

	public Periodo getPeriodo() {

		if (periodo == null) {
			periodo = new Periodo();
		}

		return periodo;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<Periodo> getListaPeriodo() {
		return listaPeriodo;
	}

	public void setListaPeriodo(List<Periodo> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}

}
