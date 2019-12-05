package impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Competence;
import entites.Domainecompetence;
import interfaces.Domainecompetenceserviceremote;

@Stateless
@LocalBean
public class Domainecompetenceservice implements Domainecompetenceserviceremote {

	@PersistenceContext(unitName = "piedevcompetence-ejb")
	EntityManager em;

	@Override
	public int ajouterDomainecompetence(Domainecompetence domainecompetence) {
		em.persist(domainecompetence);
		return domainecompetence.getId();
	}

	@Override
	public List<Domainecompetence> getAllDomainecompetence() {
		List<Domainecompetence> comp = em.createQuery("Select e from Domainecompetence e",
				Domainecompetence.class).getResultList();
			    return comp;
	}

	@Override
	public void removesDomainecompetence(int id) {
		System.out.println("In removecategories : ");
		em.remove(em.find(Domainecompetence.class, id));
		System.out.println("Out of removecategories : ");
		
	}

}
