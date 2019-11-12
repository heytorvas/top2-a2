package br.unitins.bean.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Disciplina;
import br.unitins.model.Periodo;

@Stateful
public class PeriodoEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Periodo periodo, List<Disciplina> listaDisciplina) {
		List<Disciplina> disciplinaBD = new ArrayList<>();
		for (Disciplina disc : listaDisciplina) {
			disciplinaBD.add(em.find(Disciplina.class, disc.getIdDisciplina()));
		}
		em.persist(periodo);
	}

	public void update(Periodo periodo, List<Disciplina> listaDisciplina) {
		List<Disciplina> disciplinaBD = new ArrayList<>();
		for (Disciplina disc : listaDisciplina) {
			disciplinaBD.add(em.find(Disciplina.class, disc.getIdDisciplina()));
		}
		em.merge(periodo);
	}

	public void delete(Periodo periodo) {
		periodo = load(periodo.getIdPeriodo());
		em.remove(periodo);
	}

	public Periodo load(Integer id) {
		return em.find(Periodo.class, id);
	}

	public List<Periodo> findAll() {
		return em.createQuery("select pe from Periodo pe", Periodo.class).getResultList();
	}
}
