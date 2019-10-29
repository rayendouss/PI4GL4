package Entities;




import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tp_jsf_project")
public class Project implements Serializable{
	public List<Tache> getTaches() {
		return Taches;
	}
	public void setTaches(List<Tache> taches) {
		Taches = taches;
	}
	private static final long serialVersionUID = 2L;
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(insertable= true)
	 private int idp;
	  private String nomp;
	  private Date startDate ;
	  private Date endDate ;
	  private String descp;
	  
	  @OneToMany(mappedBy="projet")
		private List<Timesheet> timep;
	  
	  @OneToMany(cascade = CascadeType.ALL, mappedBy="projects",fetch=FetchType.EAGER)
	  private List<Tache> Taches;
	  
	  
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
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
	public String getDescp() {
		return descp;
	}
	public void setDescp(String descp) {
		this.descp = descp;
	}
	public Project() {
		super();
	}
	public Project(String nomp, Date startDate, Date endDate, String descp) {
		super();
		this.nomp = nomp;
		this.startDate = startDate;
		this.endDate = endDate;
		this.descp = descp;
	}
	@Override
	public String toString() {
		return "Project =" + nomp + "";
	}

	
	
	
	  
}
