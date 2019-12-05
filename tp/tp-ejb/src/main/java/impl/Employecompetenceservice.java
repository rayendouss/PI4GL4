package impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Employecompetence;
import interfaces.employecompetenceserviceremote;

@Stateless
@LocalBean
public class Employecompetenceservice implements employecompetenceserviceremote {

	@PersistenceContext(unitName = "piedevcompetence-ejb")
	EntityManager em;

	@Override
	public int ajouterEmployecompetence(Employecompetence employecompetence) {
		em.persist(employecompetence);
		return employecompetence.getId();
	}
	
	

}
