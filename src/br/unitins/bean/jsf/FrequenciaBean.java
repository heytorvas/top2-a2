package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.FrequenciaEJB;
import br.unitins.model.Frequencia;

@Named
@SessionScoped
public class FrequenciaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private FrequenciaEJB frequenciaEJB;

	private Frequencia frequencia;

	private Integer idMatricula;

	private List<Frequencia> listaFrequencia;

	private Integer idPesquisa;

	@PostConstruct
	public void init() {
		findAll();
	}

	public void insert() {
		frequenciaEJB.insert(frequencia, idMatricula);
		clean();
		findAll();
	}

	private void findAll() {
		listaFrequencia = frequenciaEJB.findAll();
	}

	public void update() {
		frequenciaEJB.update(frequencia, idMatricula);
		clean();
		findAll();
	}

	public void delete() {
		frequenciaEJB.delete(frequenciaEJB.load(idPesquisa));
		clean();
		findAll();
	}

	public void pesquisar() {
		frequencia = frequenciaEJB.load(idPesquisa);
	}

	public void clean() {
		frequencia = new Frequencia();
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setTurma(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public List<Frequencia> getListaFrequencia() {
		return listaFrequencia;
	}

	public void setListaFrequencia(List<Frequencia> listaFrequencia) {
		this.listaFrequencia = listaFrequencia;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}
}
