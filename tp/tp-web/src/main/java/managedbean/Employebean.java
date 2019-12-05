package managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entites.Employe;
import impl.Employeservice;


@ManagedBean (name= "employebean")
@SessionScoped
public class Employebean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cin;
	private String nom;
	private String prenom;
	private int niveau;
	
	@EJB
	Employeservice employeservice;

	public Employebean() {
	
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

	public Employeservice getEmployeservice() {
		return employeservice;
	}

	public void setEmployeservice(Employeservice employeservice) {
		this.employeservice = employeservice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	private List<Employe> employes;


	public void addEmploye() {
		Employe e= new Employe(cin, nom, prenom, niveau);
	employeservice.ajouterEmploye(e); }
	
	public List<Employe> getEmployes() {
		employes = employeservice.getAllEmployes();
		return employes;
		}
	
	public void removetableemploye(int tableemployeId)
	{
	employeservice.removesemploye(tableemployeId);;
	}
	
	 private Integer tableemployeIdToBeUpdated;
	 
	 
	 
	public Integer getTableemployeIdToBeUpdated() {
		return tableemployeIdToBeUpdated;
	}

	public void setTableemployeIdToBeUpdated(Integer tableemployeIdToBeUpdated) {
		this.tableemployeIdToBeUpdated = tableemployeIdToBeUpdated;
	}
	
	

	public void displaytablesemploye(Employe emp)
	{
	this.setCin(emp.getCin());
	this.setNom(emp.getNom());
	this.setPrenom(emp.getPrenom());
	this.setNiveau(emp.getNiveau());
	this.setTableemployeIdToBeUpdated(emp.getId());
	}
	
	public void updatetablesemploye(){ 
		employeservice.updatesemploye(new Employe(tableemployeIdToBeUpdated, cin, nom, prenom, niveau) );
		                                      
	}
}
