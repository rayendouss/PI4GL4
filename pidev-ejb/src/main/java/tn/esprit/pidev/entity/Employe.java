package tn.esprit.pidev.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity

public class Employe implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Emp")
	private int id;
	
	private String prenom;
	
	private String nom;
	
	//@Column(unique=true)
	private String email;
	
	private String password;	
	
	private Boolean isActif;
	
 
	
	
	
	public Employe() {
	}
	
	public Employe(String nom, String prenom, String email, String password, Boolean isActif ) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password; 
		this.isActif = isActif;
	 
	}
	
	
	
	public Employe(int id, String prenom, String nom, String email, String password, Boolean isActif ) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.isActif = isActif;
		 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
 

	



	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", password="
				+ password + ", isActif=" + isActif +"]";
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employe")
	private Set<Evaluation> evaluation;




	public Employe(int id) {
		super();
		this.id = id;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy="employe")
	private Set<Evaluation> evaluations;
	
	
	
	
	
	
}

