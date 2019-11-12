package br.unitins.bean.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.MatrizCurricular;
import br.unitins.model.Periodo;

@Stateful
public class MatrizCurricularEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(MatrizCurricular matrizCurricular, List<Periodo> listaPeriodo) {
		List<Periodo> periodoBD = new ArrayList<>();
		for (Periodo periodo : listaPeriodo) {
			periodoBD.add(em.find(Periodo.class, periodo.getIdPeriodo()));
		}
		em.persist(matrizCurricular);
	}

	public void update(MatrizCurricular matrizCurricular, List<Periodo> listaPeriodo) {
		List<Periodo> periodoBD = new ArrayList<>();
		for (Periodo periodo : listaPeriodo) {
			periodoBD.add(em.find(Periodo.class, periodo.getIdPeriodo()));
		}
		em.merge(matrizCurricular);
	}

	public void delete(MatrizCurricular matrizCurricular) {
		MatrizCurricular tmpMatrizCurricular = load(matrizCurricular.getIdMatriz());
		em.remove(tmpMatrizCurricular);
	}

	public MatrizCurricular load(Integer id) {
		return em.find(MatrizCurricular.class, id);
	}

	public List<MatrizCurricular> findAll() {
		return em.createQuery("select tp from MatrizCurricular tp", MatrizCurricular.class).getResultList();
	}
}
