package br.unitins.bean.jsf;

import br.unitins.bean.ejb.InstituicaoEJB;
import br.unitins.model.Instituicao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class InstituicaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private InstituicaoEJB instituicaoEJB;

	private Instituicao instituicao;

	private Integer idPesquisa;

	private List<Instituicao> listaInstituicao;

	@PostConstruct
	public void init() {
		listaInstituicao = instituicaoEJB.findAll();
	}

	public String insert() {
		instituicaoEJB.insert(instituicao);
		limpar();
		listaInstituicao = instituicaoEJB.findAll();
		return null;
	}

	public String update() {
		instituicao.setIdInstituicao(getIdPesquisa());
		instituicaoEJB.update(instituicao);
		limpar();
		listaInstituicao = instituicaoEJB.findAll();
		return null;
	}

	public String delete() {
		instituicaoEJB.delete(instituicaoEJB.load(idPesquisa));
		limpar();
		listaInstituicao = instituicaoEJB.findAll();
		return null;
	}

	public String pesquisar() {
		instituicao = instituicaoEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		instituicao = new Instituicao();
		return null;
	}

	public Instituicao getInstituicao() {

		if (instituicao == null) {
			instituicao = new Instituicao();
		}

		return instituicao;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<Instituicao> getListaInstituicao() {
		return listaInstituicao;
	}

	public void setListaInstituicao(List<Instituicao> listaInstituicao) {
		this.listaInstituicao = listaInstituicao;
	}

}
