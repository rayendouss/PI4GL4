package tn.esprit.pidev.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.entity.Employe;
import tn.esprit.pidev.entity.Evaluation;
import tn.esprit.pidev.service.interf.EmployeServiceRemote;

@Stateless
@LocalBean

public class EmployeServiceImpl implements EmployeServiceRemote {
	@PersistenceContext
	EntityManager em;


	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}
	
	@Override
	public void updateEmploye(Employe employe) { 
		Employe emp = em.find(Employe.class, employe.getId()); 
		emp.setPrenom(employe.getPrenom()); 
		emp.setNom(employe.getNom()); 
		emp.setEmail(employe.getEmail()); 
		emp.setPassword(employe.getPassword()); 
		emp.setIsActif(employe.getIsActif()); 
	 
	}
	
	@Override
	public long getNombreEmployeJPQL() {
		TypedQuery<Long> query = 
				em.createQuery("select count(e) from Employe e", Long.class);
		return query.getSingleResult();
	}

	@Override
	public Employe getEmployeByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployeById(int employeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employe> getAllEmployeByEntreprise(Evaluation entreprise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSalaireMoyenByDepartementId(int departementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desaffecterEmployeDuDepartement(int employeId, int depId) {
		// TODO Auto-generated method stub
		
	} 
}