package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Employe;
import Entities.Project;
import Entities.Tache;
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
	@Override
	public void deleteProjetById(int TId) {
		Project entity = new Project();
		Query query =
				em.createQuery("SELECT e FROM Project e WHERE e.idp=:TId  ",
				Project.class);
				query.setParameter("TId", TId);
			entity= (Project) query.getSingleResult();
		em.remove(entity);
		
	}

	@Override
	public Project getProjectbyID(int i) {
		
	return em.find(Project.class, i);
		
		}
	@Override
	public List<Tache> getAllTacheByProjet(int projectid) {
		
		
		List<Tache> taches = em.find(Project.class,projectid).getTaches();
		return taches ;
	}

	
}
