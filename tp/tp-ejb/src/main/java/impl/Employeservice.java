package impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entites.Competence;
import entites.Employe;
import interfaces.Employeserviceremote;

@Stateless
@LocalBean
public class Employeservice implements Employeserviceremote {

	@PersistenceContext(unitName = "piedevcompetence-ejb")
	EntityManager em;

	@Override
	public List<Employe> getAllEmployes() {
		List<Employe> emp = em.createQuery("Select e from Employe e",
		Employe.class).getResultList();
	    return emp;
	}

	
	@Override
	public void removesemploye(int id) {
		System.out.println("In removecategories : ");
		em.remove(em.find(Employe.class, id));
		System.out.println("Out of removecategories : ");
		
	}

	@Override
	public void updatesemploye(Employe user) {
		
		Employe e = em.find(Employe.class, user.getId());
		e.setCin(user.getCin());
		e.setNom(user.getNom());
		e.setPrenom(user.getPrenom());
		e.setNiveau(user.getNiveau());
		
	}
	
	public Employe findemployebyname(String nom) {
		TypedQuery<Employe> query = em.createQuery("Select e from Employe e where"
				+ " e.cin=:nom ", Employe.class);
		query.setParameter("nom", nom);
		return query.getSingleResult();
	}
	
	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}
	
}
