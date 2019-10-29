package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tp_jsf_employe")
public class Employe implements Serializable {
	private static final long serialVersionUID = 3L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)

 private int id;
	
	private String prenom;
	private String password;
	private String nom;
	private Boolean isActif;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employes")
	  private Set<Tache> Tachs;
	@OneToMany(mappedBy="employe")
	private List<Timesheet> timesheets;
	
	
	public Set<Tache> getTachs() {
		return Tachs;
	}

	public void setTachs(Set<Tache> tachs) {
		Tachs = tachs;
	}

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Employe(String prenom, String password, String nom, String email, Boolean isActif, Role role) {
		super();
		this.prenom = prenom;
		this.password = password;
		this.nom = nom;
		this.isActif = isActif;
		this.email = email;
		this.role = role;
	}

	private String email;
	@Enumerated(EnumType.STRING)
	Role  role ;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Employe(Integer employeIdToBeUpdated, String nom2, String prenom2, String email2, String password2, Boolean isActif2, Role role2) {
		
	}
	public Employe() {
		
		
	}
	public Employe( String prenom, String password, String nom, String email, Role role) {
		super();
		
		this.prenom = prenom;
		this.password = password;
		this.nom = nom;
		this.email = email;
		this.role = role;
	}

	public Employe(int id, String prenom, String password, String nom, Boolean isActif, String email, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.password = password;
		this.nom = nom;
		this.isActif = isActif;
		this.email = email;
		this.role = role;
	}

	@Override
	public String toString() {
		return  nom + " ";
	}
	
	
	
}
