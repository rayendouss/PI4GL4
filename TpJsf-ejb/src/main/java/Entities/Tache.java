package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tp_jsf_tache")
public class Tache implements Serializable{
	public Project getProjects() {
		return projects;
	}
	public void setProjects(Project projects) {
		this.projects = projects;
	}
	public Employe getEmployes() {
		return employes;
	}
	public void setEmployes(Employe employes) {
		this.employes = employes;
	}
	private static final long serialVersionUID = 2L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(insertable= true)
	 private int idt;
	  private String nomt;
	  private Date StartDate ;
	  private Date EndDate ;
	  private String desct;
	  @ManyToOne
	   Project projects ;
	  @ManyToOne
	  Employe employes;
	  @OneToMany
		private  List<Timesheet> timesheets;
	  
	  
	  
	
	public int getIdt() {
		return idt;
	}
	public void setIdt(int idt) {
		this.idt = idt;
	}
	public String getNomt() {
		return nomt;
	}
	public List<Timesheet> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	public void setNomt(String nomt) {
		this.nomt = nomt;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public String getDesct() {
		return desct;
	}
	public void setDesct(String desct) {
		this.desct = desct;
	}
	public Tache() {
		super();
	}
	  

}
