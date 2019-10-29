package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Project;
import Entities.Tache;
import Interface.tacheServiceRemote;
@Stateless
public class tacheService implements tacheServiceRemote {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public void ajouterTache(Tache e) {
		em.persist(e);
		
	}

	@Override
	public List<Tache> getAlltaches() {
		List<Tache> emp = em.createQuery("Select e from Tache e",
				Tache.class).getResultList();
				return emp;
	}

	@Override
	public void deletetachebyid(int TId) {
		Tache entity = new Tache();
		Query query =
				em.createQuery("SELECT e FROM Tache e WHERE e.idt=:TId  ",
				Tache.class);
				query.setParameter("TId", TId);
			entity= (Tache) query.getSingleResult();
		em.remove(entity);
		
	}

	@Override
	public Project getProjectbyID(int i) 
	{
		System.out.println("bbb"+em.find(Project.class, i));
			
			return em.find(Project.class, i);
				
			
	}
	
}
