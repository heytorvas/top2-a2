package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.SemestreEJB;
import br.unitins.model.Semestre;

@Named
@SessionScoped
public class SemestreBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private SemestreEJB semestreEJB;

	private Semestre semestre;

	private Integer idPesquisa;

	private List<Semestre> listaSemestre;

	@PostConstruct
	public void init() {
		listaSemestre = semestreEJB.findAll();
	}

	public String insert() {
		semestreEJB.insert(semestre);
		limpar();
		listaSemestre = semestreEJB.findAll();
		return null;
	}

	public String update() {
		semestre.setId(getIdPesquisa());
		semestreEJB.update(semestre);
		limpar();
		listaSemestre = semestreEJB.findAll();
		return null;
	}

	public String delete() {
		semestreEJB.delete(semestreEJB.load(idPesquisa));
		limpar();
		listaSemestre = semestreEJB.findAll();
		return null;
	}

	public String pesquisar() {
		semestre = semestreEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		semestre = new Semestre();
		return null;
	}

	public Semestre getSemestre() {

		if (semestre == null) {
			semestre = new Semestre();
		}

		return semestre;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<Semestre> getListaSemestre() {
		return listaSemestre;
	}

	public void setListaSemestre(List<Semestre> listaSemestre) {
		this.listaSemestre = listaSemestre;
	}

}
