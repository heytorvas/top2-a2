package br.unitins.bean.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.bean.ejb.PeriodEJB;
import br.unitins.bean.ejb.SyllabusEJB;
import br.unitins.model.Period;
import br.unitins.model.Syllabus;

@Named
@RequestScoped
public class SyllabusBean {
	
	@EJB
	private SyllabusEJB syllabusEJB;
	
	@EJB
	private PeriodEJB periodEJB;
	
	private Syllabus syllabus;
	
	private Integer idSearch;
	
	private Integer idPeriod;
	
	private List<Syllabus> syllabusList;
	
	private List<Period> periods;
	
	@PostConstruct
	public void init() {
		syllabusList = syllabusEJB.findAll();
		setPeriods(periodEJB.findAll());
	}
	
	public String insert() {
		syllabusEJB.insert(syllabus, idPeriod);
		clean();
		Util.redirect("syllabus.xhtml");
		return null;
	}
	
	public String update() {
		syllabus.setId(getIdSearch());
		syllabusEJB.update(syllabus);
		clean();
		Util.redirect("syllabus.xhtml");
		return null;
	}
	
	public String delete() {
		syllabusEJB.delete(syllabusEJB.load(getIdSearch()));
		clean();
		Util.redirect("syllabus.xhtml");
		return null;
	}
	
	public String searchId() {
		syllabus = syllabusEJB.load(getIdSearch());
		return null;
	}
	
	public String clean() {
		syllabus = new Syllabus();
		return null;
	}

	public Syllabus getSyllabus() {
		if (syllabus == null) {
			syllabus = new Syllabus();
		}
		return syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public Integer getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}

	public Integer getIdPeriod() {
		return idPeriod;
	}

	public void setIdPeriod(Integer idPeriod) {
		this.idPeriod = idPeriod;
	}

	public List<Syllabus> getSyllabusList() {
		return syllabusList;
	}

	public void setSyllabusList(List<Syllabus> syllabusList) {
		this.syllabusList = syllabusList;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}
