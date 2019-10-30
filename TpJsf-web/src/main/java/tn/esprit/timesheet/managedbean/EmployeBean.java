package tn.esprit.timesheet.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Employe;
import Entities.Role;

import Interface.EmployeServiceRemote;

@ManagedBean(name="employeBean")
@SessionScoped
public class EmployeBean implements Serializable {

private static final long serialVersionUID = 123L;
private int id ;
private String prenom; private String nom; private String password;
private String email; private Boolean isActif; private Role role;
private int EmployeIdToBeUpdated;
public int getEmployeIdToBeUpdated() {
	return EmployeIdToBeUpdated;
}

public void setEmployeIdToBeUpdated(int employeIdToBeUpdated) {
	EmployeIdToBeUpdated = employeIdToBeUpdated;
}







private List<Employe> employes;






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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}







@EJB
EmployeServiceRemote employeService;




public void addEmploye() {
	Employe e= new Employe(nom, prenom, email, password, isActif,role);
employeService.ajouterEmploye(e); }

public List<Employe> getEmployes() {
employes = employeService.getAllEmployes();
return employes;
}
public void removeEmploye(int employeId)
{
employeService.deleteEmployeById(employeId);
}
 public void afficher(Employe emp)
 {
	 employeService.displayEmploye(emp);
 }
 public void displayEmploye(Employe empl)
	{
	this.setPrenom(empl.getPrenom());
	this.setNom(empl.getNom());
	this.setIsActif(empl.getIsActif());
	this.setEmail(empl.getEmail());
	this.setRole(empl.getRole());
	
	this.setPassword(empl.getPassword());
	this.setEmployeIdToBeUpdated(empl.getId());
	}


public void updateEmploye() {
	 Employe i= new Employe();
	 
	
	i.setEmail(this.getEmail());
	i.setIsActif(this.getIsActif());
	i.setNom(this.getNom());
i.setPassword(this.getPassword());
	i.setRole(this.getRole());
	i.setPrenom(this.getPrenom());
 employeService.updateEmploye(i,this.getEmployeIdToBeUpdated()); 
 }
}
