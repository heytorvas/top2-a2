package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Curso;
import br.unitins.model.Instituicao;

@Stateful
public class CursoEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(Curso curso, Integer idInstituicao) {
		curso.setInstituicao(em.find(Instituicao.class, idInstituicao));
		em.persist(curso);
	}

	public void update(Curso curso, Integer idInstituicao) {
		curso.setInstituicao(em.find(Instituicao.class, idInstituicao));
		em.merge(curso);
	}

	public void delete(Curso curso) {
		curso = load(curso.getIdCurso());
		em.remove(curso);
	}

	public Curso load(Integer id) {
		return em.find(Curso.class, id);
	}

	public List<Curso> findAll() {
		return em.createQuery("select pay from Curso pay", Curso.class).getResultList();
	}

}
