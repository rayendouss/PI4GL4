package tn.esprit.timesheet.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import Entities.Employe;
import Entities.Project;
import Entities.Tache;
import Entities.Timesheet;
import Interface.EmployeServiceRemote;
import Interface.ProjetServiceRemote;
import Interface.TimesheetServiceRemote;
@ManagedBean
@SessionScoped
public class TimeSheetBean {
	private Timesheet timesheet;
	private int idg ;
	private int idpr ;
	 private int idT;
		private String etatTache ;
	private int nbreHeureTRavS ;	 
	private int nbreHeureTRavJour ;
	 private int nbreConge ;
	 private Employe employe ;
	 private List<Timesheet> timesheets ;
	 private Tache tache ;
	 private Integer IdToBeUpdated;
	 private List<Employe> employes ;
	 public Employe selectedEmploye;
	 private List<Project> projects ;
	
	 
	 
	public int getIdpr() {
		return idpr;
	}
	public void setIdpr(int idpr) {
		this.idpr = idpr;
	}
	public List<Project> getProjects() {
		projects = ts.getAllPr();
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public int getIdg() {
		return idg;
	}
	public void setIdg(int idg) {
		this.idg = idg;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public void displayEmploye(Timesheet empl)
	 {
	 this.setEtatTache(empl.getEtatTache());
	 this.setNbreConge(empl.getNbreConge());
	 this.setNbreHeureTRavJour(empl.getNbreHeureTRavJour());
	 this.setNbreHeureTRavS(empl.getNbreHeureTRavS());
	
	 this.setIdToBeUpdated(empl.getIdT());
	 }
	public Integer getIdToBeUpdated() {
		return IdToBeUpdated;
	}
	public void setIdToBeUpdated(Integer idToBeUpdated) {
		IdToBeUpdated = idToBeUpdated;
	}
	public Timesheet getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(Timesheet timesheet) {
		this.timesheet = timesheet;
	}
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public String getEtatTache() {
		return etatTache;
	}
	public void setEtatTache(String etatTache) {
		this.etatTache = etatTache;
	}
	public int getNbreHeureTRavS() {
		return nbreHeureTRavS;
	}
	public void setNbreHeureTRavS(int nbreHeureTRavS) {
		this.nbreHeureTRavS = nbreHeureTRavS;
	}
	public int getNbreHeureTRavJour() {
		return nbreHeureTRavJour;
	}
	public void setNbreHeureTRavJour(int nbreHeureTRavJour) {
		this.nbreHeureTRavJour = nbreHeureTRavJour;
	}
	public int getNbreConge() {
		return nbreConge;
	}
	public void setNbreConge(int nbreConge) {
		this.nbreConge = nbreConge;
	}
	
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public TimesheetServiceRemote getTs() {
		return ts;
	}
	public void setTs(TimesheetServiceRemote ts) {
		this.ts = ts;
	}
	
	public Employe getSelectedEmploye() {
		return selectedEmploye;
	}
	public void setSelectedEmploye(Employe selectedEmploye) {
		this.selectedEmploye = selectedEmploye;
	}

	@EJB
	TimesheetServiceRemote ts;
	@EJB
	EmployeServiceRemote es ;
	@EJB
	ProjetServiceRemote ep ;
	
	public void addts() {
	
		Timesheet e = new Timesheet(etatTache,nbreHeureTRavS,nbreHeureTRavJour,nbreConge);
		e.setEmploye(es.getEmployesbyID(idg));
		System.out.println("aaaaa"+idpr);
		e.setProjet(ep.getProjectbyID(idpr));
		//es.getEmployesbynom(nom)
	ts.ajouterTimeSheet(e);
	}
	
	public List<Timesheet> getTS() {
		timesheets = ts.getAllEmployes();
		return timesheets;
		}
	public List<Employe> getAllEmployes()
	{
		System.out.println("haha");
		employes = es.getAllEmployes();
		return employes ;
	}
	@SuppressWarnings("unchecked")
	public List<Employe> getAllEmployess()
	{
		
		employes = es.getAllEmployes();
		return (List<Employe>) employes.get(idT) ;
	}
	public List<Timesheet> getTimesheets() {
		timesheets = ts.getAllEmployes();
		return timesheets;
	}
	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	public void removeTimesheet(int id)
	{
	ts.deleteEmployeById(id);
	}
	public int updateTimesheet()
	{ 
	Timesheet i=  new Timesheet();
	i.setEtatTache(this.getEtatTache());
	i.setNbreConge(this.getNbreConge());
	i.setNbreHeureTRavJour(this.getNbreHeureTRavJour());
	i.setNbreHeureTRavS(this.getNbreHeureTRavS());
	
	ts.updateTimeSheet(IdToBeUpdated, i );
	return IdToBeUpdated; 
	}

}
