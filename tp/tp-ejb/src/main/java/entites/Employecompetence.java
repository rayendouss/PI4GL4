package entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employecompetence implements Serializable {

private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	Employe employe;
	
	@ManyToOne
	Competence competence;
	
	public Employecompetence() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	@Override
	public String toString() {
		return "employecompetence [id=" + id + ", employe=" + employe + ", competence=" + competence + "]";
	}

	public Employecompetence(int id, entites.Employe employe, entites.Competence competence) {

		this.id = id;
		this.employe = employe;
		this.competence = competence;
	}

	public Employecompetence(entites.Employe employe, entites.Competence competence) {
		
		this.employe = employe;
		this.competence = competence;
	}
*/

	public Employecompetence(int id, Employe employe, Competence competence) {
		
		this.id = id;
		this.employe = employe;
		this.competence = competence;
	}

	public Employecompetence(Employe employe, Competence competence) {
		
		this.employe = employe;
		this.competence = competence;
	}

	@Override
	public String toString() {
		return "Employecompetence [id=" + id + ", employe=" + employe + ", competence=" + competence + "]";
	}
	
	
	
	
	
	
}
