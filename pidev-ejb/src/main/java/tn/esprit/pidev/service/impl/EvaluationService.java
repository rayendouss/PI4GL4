package tn.esprit.pidev.service.impl;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import tn.esprit.pidev.service.interf.EvaluationServiceRemote;


import tn.esprit.pidev.entity.Evaluation;


@Stateless
@LocalBean
public class EvaluationService implements EvaluationServiceRemote {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int ajouterEvaluation(Evaluation evaluation) {
		//entreprise.setName("autre entreprise"); avec ça une autre requete d'update 
		//va s'exécuter a la fin de la methode pour mettre
		//a jour la base de données avec le nouveau nom
		em.persist(evaluation);
		System.out.println("ab");
		return evaluation.getId();
		
	}
	
	@Override
	public List<Evaluation> getAllEvaluations() {
		 List<Evaluation> emp = em.createQuery("Select e from Evaluation e",Evaluation.class).getResultList(); return emp; 

	}

	@Override
	public void deleteEvaluationById(int evaluationId) {
		Evaluation evaluation = em.find(Evaluation.class, evaluationId);
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
	
		
		em.remove(evaluation);
	}
	
	@Override
	public void updateEvaluation(Evaluation evaluation) {
	Evaluation emp = em.find(Evaluation.class, evaluation.getId());
	emp.setDescription(evaluation.getDescription()); emp.setCommentaire(evaluation.getCommentaire());
	emp.setContexteEval(evaluation.getContexteEval()); emp.setNoteEmploye(evaluation.getNoteEmploye());
	emp.setIdCandidat(evaluation.getIdCandidat());
	emp.setPeriodEval(evaluation.getPeriodEval());
	emp.setNoteManager(evaluation.getNoteManager());
	emp.setNoteManager(evaluation.getNoteManager());
	}
	@Override
	public List<Evaluation> getlist() {
		TypedQuery<Evaluation> query = em.createQuery("Select t from Evaluation t ", Evaluation.class);
		return query.getResultList();

	}
	
	public Long nbevaluation(String q) {
		TypedQuery<Long> query = em.createQuery("Select count(q) from Evaluation q ",
				Long.class);
		query.setParameter("q", q);
		return query.getSingleResult();
	}

	
	
	
	    

	 
}
