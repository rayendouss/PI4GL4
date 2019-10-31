package tn.esprit.timesheet.managedbean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Project;
import Entities.Tache;
import Entities.Timesheet;
import Interface.ProjetServiceRemote;

@ManagedBean
@SessionScoped
public class ProjetBean {
	private String nomp;
	private int idprojet;
	private Date startDate;
	private Date endDate;
	private String descp;
	public List<Project> projects;
	public List<Tache> tacheAff;
	public List<Tache> Alltaches;

	
	

	public int getIdprojet() {
		return idprojet;
	}

	public void setIdprojet(int idprojet) {
		this.idprojet = idprojet;
	}

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
	public List<Tache> getAlltaches() {
		return Alltaches;
	}

	public void setAlltaches(List<Tache> alltaches) {
		Alltaches = alltaches;
	}
	public void setTacheAff(List<Tache> tacheAff) {
		this.tacheAff = tacheAff;
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
	public void removepr(int id)
	{
	pr.deleteProjetById(id);
	}


	public List<Tache> getTacheAff() {

		tacheAff = pr.getAllTacheByProjet(idprojet);
		return tacheAff;
	}


	public String reddvoirListtache(int id) 
	{
		this.idprojet=id;
		
		return "tache2?faces-redirect=true";
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
