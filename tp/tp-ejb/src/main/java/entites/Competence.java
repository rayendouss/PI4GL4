package entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TypedQuery;

@Entity
public class Competence implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String nomcompetence;
	private String descriptioncompetence;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="competence")
	private Set<Employecompetence> employecompetences;
	
	public Competence() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomcompetence() {
		return nomcompetence;
	}

	public void setNomcompetence(String nomcompetence) {
		this.nomcompetence = nomcompetence;
	}

	public String getDescriptioncompetence() {
		return descriptioncompetence;
	}

	public void setDescriptioncompetence(String descriptioncompetence) {
		this.descriptioncompetence = descriptioncompetence;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return nomcompetence;
	}

	public Competence(int id, String nomcompetence, String descriptioncompetence) {
		
		this.id = id;
		this.nomcompetence = nomcompetence;
		this.descriptioncompetence = descriptioncompetence;
	}

	public Competence(String nomcompetence, String descriptioncompetence) {
		
		this.nomcompetence = nomcompetence;
		this.descriptioncompetence = descriptioncompetence;
	}


}
