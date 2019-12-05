package tn.esprit.pidev.service.interf;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.pidev.entity.Evaluation;

@Remote
public interface EvaluationServiceRemote {
	 public int ajouterEvaluation(Evaluation evaluation);
	 public void deleteEvaluationById(int evaluationId);
	 public List<Evaluation> getAllEvaluations();
	 public void updateEvaluation(Evaluation evaluation);
	 List<Evaluation> getlist();
	 

}
