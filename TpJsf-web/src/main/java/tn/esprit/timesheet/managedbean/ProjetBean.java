package tn.esprit.timesheet.managedbean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Project;
import Entities.Timesheet;
import Interface.ProjetServiceRemote;

@ManagedBean
@SessionScoped
public class ProjetBean {
	private String nomp;
	private Date startDate;
	private Date endDate;
	private String descp;
	public List<Project> projects;

	
	

	public List<Project> getProjects() {
		projects = pr.getAll();

		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ProjetServiceRemote getPr() {
		return pr;
	}

	public void setPr(ProjetServiceRemote pr) {
		this.pr = pr;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	@EJB
	ProjetServiceRemote pr;

	public void addProj() {
		Project p = new Project(nomp, startDate, endDate, descp);
		pr.ajouterProjet(p);
	}

	public List<Project> getAllProject() {

		projects = pr.getAll();

		return projects;
	}

}
