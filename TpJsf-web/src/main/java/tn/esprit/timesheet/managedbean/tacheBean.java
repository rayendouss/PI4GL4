package tn.esprit.timesheet.managedbean;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Project;
import Entities.Tache;
import Interface.TimesheetServiceRemote;
import Interface.tacheServiceRemote;
@ManagedBean
@SessionScoped
public class tacheBean {
	private int idp;
	 private int idt;
	 private Tache tache;
	  private String nomt;
	  private Date startDate ;
	  private Date endDate ;
	  private String desct;
	  public List<Tache> taches ;
	  
	  
	  
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public int getIdt() {
		return idt;
	}
	public void setIdt(int idt) {
		this.idt = idt;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public List<Tache> getTaches() {
		taches=ts.getAlltaches();
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public String getNomt() {
		return nomt;
	}
	public void setNomt(String nomt) {
		this.nomt = nomt;
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
	public String getDesct() {
		return desct;
	}
	public void setDesct(String desct) {
		this.desct = desct;
	}
	@EJB
	tacheServiceRemote ts ;
	
	public void addt() {
	
		Tache e = new Tache(nomt, startDate, endDate, desct);
		//e.setProjet(ep.getProjectbyID(idpr));
		//es.getEmployesbynom(nom)
		e.setProjects(ts.getProjectbyID(idt));
	ts.ajouterTache(e);
	
	
	
	}
	public void removet(int id)
	{
		ts.deletetachebyid(id);
	}
	@EJB
	TimesheetServiceRemote tss;
	public List<Project> getProjects() {
		List<Project> projects = tss.getAllPr();
		return projects;
	}
	
	
	
}
