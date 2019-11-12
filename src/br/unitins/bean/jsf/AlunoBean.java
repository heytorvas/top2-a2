package br.unitins.bean.jsf;

import br.unitins.bean.ejb.AlunoEJB;
import br.unitins.model.Aluno;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private AlunoEJB alunoEJB;

	private Aluno aluno;

	private List<Aluno> listaAluno;

	private Integer idPesquisa;

	@PostConstruct
	public void init() {
		findAll();
	}

	public void insert() {
		alunoEJB.insert(aluno);
		limpar();
		findAll();
	}

	private void findAll() {
		listaAluno = alunoEJB.findAll();
	}

	public void update() {
		alunoEJB.update(aluno);
		limpar();
		findAll();
	}

	public void delete() {
		alunoEJB.delete(alunoEJB.load(idPesquisa));
		limpar();
		findAll();
	}

	public void pesquisar() {
		aluno = alunoEJB.load(idPesquisa);
	}

	public void limpar() {
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		if (aluno == null) {
			aluno = new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno entity) {
		this.aluno = entity;
	}

	public List<Aluno> getlistaAluno() {
		return listaAluno;
	}

	public void setlistaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

}
