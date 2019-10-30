package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Employe;
import Entities.Project;
import Entities.Timesheet;
import Interface.ProjetServiceRemote;
@Stateless
public class ProjetService implements ProjetServiceRemote {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public int ajouterProjet(Project p) {
		//Project proj = getProjetByNom(p.getNomp());
		//if(proj==null) {
		em.persist(p);
		return p.getIdp();//}
		//return -1;// 
	}

	@Override
	public Project getProjetByNom(String nom) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select e from Project e where e.nomp=: nom",
				Project.class);
		query.setParameter("nom", nom);
		Project proj = (Project)query.getSingleResult();
		return proj; 
	}
	@Override
	public List<Project> getAll() {
		List<Project> emp = em.createQuery("Select p from Project p",
				Project.class).getResultList();
				return emp;
		
	}
	
}
