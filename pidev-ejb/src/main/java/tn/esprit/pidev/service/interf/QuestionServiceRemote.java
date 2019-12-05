package tn.esprit.pidev.service.interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entity.Evaluation;
import tn.esprit.pidev.entity.Question;

@Remote
public interface QuestionServiceRemote {
	
	 public void deleteQuestionById(int questionId);
	public int ajouterQuestion(Question question);
	public void updateQuestion(Question question);
	public List<Question> getAllQuestion();
	 List<Question> getlist();
	
}
