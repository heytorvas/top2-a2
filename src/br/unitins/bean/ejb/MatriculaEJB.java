package br.unitins.bean.ejb;

import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Matricula;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class MatriculaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Matricula matricula, Integer idDiscOferta) {
		matricula.setDisciplinaOfertada(em.find(DisciplinaOfertada.class, idDiscOferta));
		em.persist(matricula);
	}

	public void update(Matricula matricula, Integer idDiscOferta) {
		matricula.setDisciplinaOfertada(em.find(DisciplinaOfertada.class, idDiscOferta));
		em.merge(matricula);
	}

	public void delete(Matricula matricula) {
		Matricula tmpMatricula = load(matricula.getIdMatricula());
		em.remove(tmpMatricula);
	}

	public Matricula load(Integer id) {
		return em.find(Matricula.class, id);
	}

	public List<Matricula> findAll() {
		return em.createQuery("select tp from Matricula tp", Matricula.class).getResultList();
	}
}
