package impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entites.Competence;
import entites.Employe;
import interfaces.competenceserviceremote;

@Stateless
@LocalBean
public class Competenceservice implements competenceserviceremote {

	@PersistenceContext(unitName = "piedevcompetence-ejb")
	EntityManager em;

	@Override
	public int ajouterCompetence(Competence competence) {
		em.persist(competence);
		return competence.getId();
	}
/*
	@Override
	public List<Competence> getAllCompetences() {
		List<Competence> comp = em.createQuery("Select c from Competence c",
	    Competence.class).getResultList();
		return comp;
	}
*/
	@Override
	public void removescompetence(int id) {
		System.out.println("In removecategories : ");
		em.remove(em.find(Competence.class, id));
		System.out.println("Out of removecategories : ");
		
	}

	@Override
	public void updatescompetence(Competence user) {
		Competence c = em.find(Competence.class, user.getId());
		c.setDescriptioncompetence(user.getDescriptioncompetence());
		c.setNomcompetence(user.getNomcompetence());
		
	}
	@Override
	public List<Competence> getAllCompetences() {
		List<Competence> comp = em.createQuery("Select e from Competence e",
				Competence.class).getResultList();
			    return comp;
	}

	public Competence findcompetencebyname(String nomcompetencede) {
		TypedQuery<Competence> query = em.createQuery("Select c from Competence c where"
				+ " c.nomcompetence=:nomcompetencede ", Competence.class);
		query.setParameter("nomcompetencede", nomcompetencede);
		return query.getSingleResult();
	}
	
}
