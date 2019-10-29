package tn.esprit.timesheet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Employe;
import Entities.Tache;
import Entities.Timesheet;
import Interface.ProjetServiceRemote;
import Interface.TimesheetServiceRemote;

@ManagedBean
@SessionScoped
public class EmpBean implements Serializable{
	 private List<Timesheet> times ;
	 private Employe employe ;
	 private int idprojet ;
	 private List<Tache> tachess ;
	 private int idp ;
	 
		public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
		public int getIdprojet() {
		return idprojet;
	}
	public void setIdprojet(int idprojet) {
		this.idprojet = idprojet;
	}
	@EJB
	ProjetServiceRemote pr;

		@EJB
		TimesheetServiceRemote ts;
	 
	 
	 
	 
	
	public List<Tache> getTaches() {
			return tachess=pr.getAllTacheByProjet(idprojet);
		}
		public void setTaches(List<Tache> tachess) {
			this.tachess = tachess;
		}
	public List<Timesheet> getTimes() {
		System.out.println("baaa0"+LoginBean.getIda());
		times = ts.getTimeSheetByidEmp(LoginBean.getIde());
		System.out.println(times+"nnnnnn");
		return times;
		}
		public void setTimes(List<Timesheet> times) {
			this.times = times;
		}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	 
	public String reddvoirListtache(int id) 
	{
		this.idprojet=id;
		
		return "tache3?faces-redirect=true";
	}
	 
	 
}
