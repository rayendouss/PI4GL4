package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tp_jsf_TimeSheet")
public class Timesheet implements Serializable{

	private static final long serialVersionUID = 4L;
	
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(insertable= true)
	 private int idT;
		private String EtatTache ; 
	private int NbreHeureTRavS ;
	private int NbreHeureTRavJour ;
	 private int NbreConge ;
	 @ManyToOne
	    @JoinColumn(name = "idEmploye", referencedColumnName = "id", updatable=false)
	
		private Employe employe;
	 
	 @ManyToOne
	    @JoinColumn(name = "idpfk", referencedColumnName = "idp", updatable=false)
	
		private Project projet;
	 
	 @OneToMany(mappedBy="timesheets",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		private List<Tache> taches ;
	
	 
	 
	 
	
	public Project getProjet() {
		return projet;
	}
	public void setProjet(Project projet) {
		this.projet = projet;
	}
	public Timesheet(String etatTache, int nbreHeureTRavS, int nbreHeureTRavJour, int nbreConge, Employe employe) {
		super();
		EtatTache = etatTache;
		NbreHeureTRavS = nbreHeureTRavS;
		NbreHeureTRavJour = nbreHeureTRavJour;
		NbreConge = nbreConge;
		this.employe = employe;
	}
	public String getEtatTache() {
		return EtatTache;
	}
	public void setEtatTache(String etatTache) {
		EtatTache = etatTache;
	}
	public int getNbreHeureTRavS() {
		return NbreHeureTRavS;
	}
	public void setNbreHeureTRavS(int nbreHeureTRavS) {
		NbreHeureTRavS = nbreHeureTRavS;
	}
	public int getNbreHeureTRavJour() {
		return NbreHeureTRavJour;
	}
	public void setNbreHeureTRavJour(int nbreHeureTRavJour) {
		NbreHeureTRavJour = nbreHeureTRavJour;
	}
	public int getNbreConge() {
		return NbreConge;
	}
	public void setNbreConge(int nbreConge) {
		NbreConge = nbreConge;
	}
	
	public Timesheet(Integer idToBeUpdated, String etatTache2, int nbreHeureTRavS2, int nbreHeureTRavJour2, int nbreConge2) {
		super();
	}
	
	
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	public Timesheet( String etatTache, int nbreHeureTRavS, int nbreHeureTRavJour, int nbreConge) {
		super();
		
		EtatTache = etatTache;
		NbreHeureTRavS = nbreHeureTRavS;
		NbreHeureTRavJour = nbreHeureTRavJour;
		NbreConge = nbreConge;
	}
	public Timesheet(int idT, String etatTache, int nbreHeureTRavS, int nbreHeureTRavJour, int nbreConge,
			Employe employe, List<Tache> taches) {
		super();
		this.idT = idT;
		EtatTache = etatTache;
		NbreHeureTRavS = nbreHeureTRavS;
		NbreHeureTRavJour = nbreHeureTRavJour;
		NbreConge = nbreConge;
		this.employe = employe;
		this.taches = taches;
	}
	public Timesheet() {
		
	}
	
	

	 
	
}
