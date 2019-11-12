package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Disciplina;

@Stateful
public class DisciplinaEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(Disciplina disciplina) {
		em.persist(disciplina);
	}

	public void update(Disciplina disciplina) {
		em.merge(disciplina);
	}

	public void delete(Disciplina disciplina) {
		disciplina = load(disciplina.getIdDisciplina());
		em.remove(disciplina);
	}

	public Disciplina load(Integer id) {
		return em.find(Disciplina.class, id);
	}

	public List<Disciplina> findAll() {
		return em.createQuery("select disc from Disciplina disc", Disciplina.class).getResultList();
	}

}
