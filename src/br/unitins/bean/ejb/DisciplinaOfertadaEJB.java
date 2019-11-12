package br.unitins.bean.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Disciplina;
import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Professor;
import br.unitins.model.Semestre;

@Stateful
public class DisciplinaOfertadaEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(DisciplinaOfertada discOfertada, Integer idSemestre, Integer idDisciplina, Integer idProfessor) {
    	discOfertada.setSemestre(em.find(Semestre.class, idSemestre));
    	discOfertada.setDisciplina(em.find(Disciplina.class, idDisciplina));
    	discOfertada.setProfessor(em.find(Professor.class, idProfessor));
        em.persist(discOfertada);
    }

    public void update(DisciplinaOfertada discOfertada, Integer idSemestre, Integer idDisciplina, Integer idProfessor) {
    	discOfertada.setSemestre(em.find(Semestre.class, idSemestre));
    	discOfertada.setDisciplina(em.find(Disciplina.class, idDisciplina));
    	discOfertada.setProfessor(em.find(Professor.class, idProfessor));
        em.merge(discOfertada);
    }

    public void delete(DisciplinaOfertada discOfertada) {
        DisciplinaOfertada tmpDisciplinaOfertada = load(discOfertada.getId());
        em.remove(tmpDisciplinaOfertada);
    }

    public DisciplinaOfertada load(Integer id) {
        return em.find(DisciplinaOfertada.class, id);
    }

    public List<DisciplinaOfertada> findAll() {
        return em.createQuery("select tp from DisciplinaOfertada tp", DisciplinaOfertada.class).getResultList();
    }
}
