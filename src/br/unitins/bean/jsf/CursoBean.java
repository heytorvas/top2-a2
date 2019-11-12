package br.unitins.bean.jsf;

import br.unitins.bean.ejb.CursoEJB;
import br.unitins.bean.ejb.InstituicaoEJB;
import br.unitins.model.Curso;
import br.unitins.model.Instituicao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CursoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CursoEJB cursoEJB;

	@EJB
	private InstituicaoEJB instituicaoEJB;

	private Curso curso;

	private Integer idInstituicao;

	private Integer idPesquisa;

	private List<Curso> listaCurso;

	private List<Instituicao> listaInstituicao;

	@PostConstruct
	public void init() {
		listaCurso = cursoEJB.findAll();
		setListaInstituicao(instituicaoEJB.findAll());
	}

	public String insert() {
		cursoEJB.insert(curso, idInstituicao);
		limpar();
		listaCurso = cursoEJB.findAll();
		return null;
	}

	public String update() {
		curso.setIdCurso(getIdPesquisa());
		cursoEJB.update(curso, idInstituicao);
		limpar();
		listaCurso = cursoEJB.findAll();
		return null;
	}

	public String delete() {
		cursoEJB.delete(cursoEJB.load(idPesquisa));
		limpar();
		listaCurso = cursoEJB.findAll();
		return null;
	}

	public String pesquisar() {
		curso = cursoEJB.load(idPesquisa);
		return null;
	}

	public String limpar() {
		curso = new Curso();
		return null;
	}

	public Curso getCurso() {

		if (curso == null) {
			curso = new Curso();
		}

		return curso;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public Integer getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public List<Instituicao> getListaInstituicao() {
		return listaInstituicao;
	}

	public void setListaInstituicao(List<Instituicao> listaInstituicao) {
		this.listaInstituicao = listaInstituicao;
	}

	public List<Curso> getlistaCurso() {
		return listaCurso;
	}

	public void setlistaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

}
