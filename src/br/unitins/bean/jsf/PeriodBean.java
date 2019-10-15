package br.unitins.bean.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.bean.ejb.PeriodEJB;
import br.unitins.bean.ejb.SubjectEJB;
import br.unitins.model.Period;
import br.unitins.model.Subject;

@Named
@RequestScoped
public class PeriodBean {
	
	@EJB
	private PeriodEJB periodEJB;
	
	@EJB
	private SubjectEJB subjectEJB;
	
	private Period period;
	
	private Integer idSearch;
	
	private Integer idSubject;
	
	private List<Period> periods;
	
	private List<Subject> subjects;
	
	@PostConstruct
	public void init() {
		periods = periodEJB.findAll();
		setSubjects(subjectEJB.findAll());
	}
	
	public String insert() {
		periodEJB.insert(period, idSubject);
		clean();
		Util.redirect("period.xhtml");
		return null;
	}
	
	public String update() {
		period.setId(getIdSearch());
		periodEJB.update(period);
		clean();
		Util.redirect("period.xhtml");
		return null;
	}
	
	public String delete() {
		periodEJB.delete(periodEJB.load(getIdSearch()));
		clean();
		Util.redirect("period.xhtml");
		return null;
	}
	
	public String searchId() {
		period = periodEJB.load(getIdSearch());
		return null;
	}
	
	public String clean() {
		period = new Period();
		return null;
	}

	public Period getPeriod() {
		if (period == null) {
			period = new Period();
		}
		return period;
	}

	public Integer getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Integer idSubject) {
		this.idSubject = idSubject;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Integer getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
