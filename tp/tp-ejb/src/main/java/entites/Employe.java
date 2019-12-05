package entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employe implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private int niveau;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy="employe")
	//@OneToMany(mappedBy="employe",fetch =FetchType.EAGER,cascade={CascadeType.REMOVE})
	private Set<Employecompetence> employecompetences;

	public Employe() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Set<Employecompetence> getEmployecompetences() {
		return employecompetences;
	}

	@XmlTransient
	public void setEmployecompetences(Set<Employecompetence> employecompetences) {
		this.employecompetences = employecompetences;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	@Override
	public String toString() {
		return "Employe [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", niveau=" + niveau
				+ "]";
	}*/
	
	public Employe(int id, String cin, String nom, String prenom, int niveau) {

		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.niveau = niveau;
	}


	@Override
	public String toString() {
		return  cin;
	}

	public Employe(String cin, String nom, String prenom, int niveau) {
	
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.niveau = niveau;
	}

	
}
