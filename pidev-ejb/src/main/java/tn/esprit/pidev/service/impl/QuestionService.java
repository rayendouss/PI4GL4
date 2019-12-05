package tn.esprit.pidev.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.entity.Evaluation;
import tn.esprit.pidev.entity.Question;
import tn.esprit.pidev.service.interf.QuestionServiceRemote;

@Stateless
@LocalBean
public class QuestionService implements QuestionServiceRemote {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public int ajouterQuestion(Question question) {
		//entreprise.setName("autre entreprise"); avec ça une autre requete d'update 
		//va s'exécuter a la fin de la methode pour mettre
		//a jour la base de données avec dresdle nouveau nom
		em.persist(question);
		System.out.println("ab");
		return question.getIdQst();
		
	}
	
	@Override
	public List<Question> getAllQuestion() {
		 List<Question> emp = em.createQuery("Select e from Question e",Question.class).getResultList(); return emp; 

	}
	
	@Override
	public List<Question> getlist() {
		TypedQuery<Question> query = em.createQuery("Select t from Question t ", Question.class);
		return query.getResultList();

	}
	
	@Override
	public void updateQuestion(Question question) {
	Question emp = em.find(Question.class, question.getIdQst());
	emp.setDescriptionQst(question.getDescriptionQst());
	
	emp.setTypeQst(question.getTypeQst());
	
	}
	@Override
	public void deleteQuestionById(int questionId) {
		Question question = em.find(Question.class, questionId);
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
	
		
		em.remove(question);
	}
	





}
