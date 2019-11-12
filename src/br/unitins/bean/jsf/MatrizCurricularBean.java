package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.MatrizCurricularEJB;
import br.unitins.model.MatrizCurricular;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class MatrizCurricularBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private MatrizCurricularEJB matrizCurricularEJB;

	private MatrizCurricular matrizCurricular;

	private Integer idPesquisa;

	private List<Periodo> listaPeriodo;

	private List<MatrizCurricular> listaMatriz;

	@PostConstruct
	public void init() {
		listaMatriz = matrizCurricularEJB.findAll();
	}

	public String insert() {
		matrizCurricularEJB.insert(matrizCurricular, listaPeriodo);
		limpar();
		listaMatriz = matrizCurricularEJB.findAll();
		return null;
	}

	public String update() {
		matrizCurricular.setIdMatriz(getIdPesquisa());
		matrizCurricularEJB.update(matrizCurricular, listaPeriodo);
		limpar();
		listaMatriz = matrizCurricularEJB.findAll();
		return null;
	}

	public String delete() {
		matrizCurricularEJB.delete(matrizCurricularEJB.load(idPesquisa));
		limpar();
		listaMatriz = matrizCurricularEJB.findAll();
		return null;
	}

	public String pesquisar() {
		matrizCurricular = matrizCurricularEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		matrizCurricular = new MatrizCurricular();
		return null;
	}

	public MatrizCurricular getMatrizCurricular() {

		if (matrizCurricular == null) {
			matrizCurricular = new MatrizCurricular();
		}

		return matrizCurricular;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<MatrizCurricular> getListaMatriz() {
		return listaMatriz;
	}

	public void setListaMatriz(List<MatrizCurricular> listaMatriz) {
		this.listaMatriz = listaMatriz;
	}

}
