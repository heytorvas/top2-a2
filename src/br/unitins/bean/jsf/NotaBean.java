package br.unitins.bean.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.bean.ejb.NotaEJB;
import br.unitins.model.Nota;

@Named
@SessionScoped
public class NotaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private NotaEJB notaEJB;

	private Nota nota;

	private Integer idMatricula;

	private Integer idPesquisa;

	private List<Nota> listaNota;

	@PostConstruct
	public void init() {
		findAll();
	}

	public void insert() {
		notaEJB.insert(nota, idMatricula);
		clean();
		findAll();
	}

	private void findAll() {
		listaNota = notaEJB.findAll();
	}

	public void update() {
		notaEJB.update(nota, idMatricula);
		clean();
		findAll();
	}

	public void delete() {
		notaEJB.delete(notaEJB.load(idPesquisa));
		clean();
		findAll();
	}

	public void pesquisar() {
		nota = notaEJB.load(idPesquisa);
	}

	public void clean() {
		nota = new Nota();
	}

	public Nota getNota() {
		if (nota == null) {
			nota = new Nota();
		}
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<Nota> getListaNota() {
		return listaNota;
	}

	public void setListaNota(List<Nota> listaNota) {
		this.listaNota = listaNota;
	}
}
