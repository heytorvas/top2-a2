package br.unitins.bean.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.application.Util;
import br.unitins.bean.ejb.SubjectEJB;
import br.unitins.model.Subject;

@Named
@RequestScoped
public class SubjectBean {
	@EJB
	private SubjectEJB subjectEJB;
	
	private Subject subject;
	
	private Integer idSearch;
	
	private List<Subject> subjects;
	
	@PostConstruct
	public void init() {
		setSubjects(subjectEJB.findAll());
	}
	
	public String insert() {
		subjectEJB.insert(subject);
		clean();
		Util.redirect("subject.xhtml");
		return null;
	}
	
	public String update() {
		subject.setId(getIdSearch());
		subjectEJB.update(subject);
		clean();
		Util.redirect("subject.xhtml");
		return null;
	}
	
	public String delete() {
		subjectEJB.delete(subjectEJB.load(idSearch));
		clean();
		Util.redirect("subject.xhtml");
		return null;
	}
	
	public String searchId() {
		subject = subjectEJB.load(idSearch);
		return null;
	}
	
	public String clean() {
		subject = new Subject();
		return null;
	}
	
	public Subject getSubject() {
		if (subject == null) {
			subject = new Subject();
		}
		return subject;
	}
	
	public Integer getIdSearch() {
		return idSearch;
	}
	
	public void setIdSearch(Integer idSearch) {
		this.idSearch = idSearch;
	}
	
	public List<Subject> getSubjects() {
		return subjects;
	}
	
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
