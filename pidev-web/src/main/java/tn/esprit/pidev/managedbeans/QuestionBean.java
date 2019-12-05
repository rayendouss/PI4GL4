package tn.esprit.pidev.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.entity.Evaluation;
import tn.esprit.pidev.entity.Question;
import tn.esprit.pidev.service.impl.QuestionService;

@ManagedBean(name = "QuestionBean")
@SessionScoped
public class QuestionBean implements Serializable {
	
	
private int idQst;
private String descriptionQst;
private String typeQst;
private List<Question> questions;

@EJB
QuestionService questionservice;

public int getIdQst() {
	return idQst;
}

public void setIdQst(int idQst) {
	this.idQst = idQst;
}

public String getDescriptionQst() {
	return descriptionQst;
}

public void setDescriptionQst(String descriptionQst) {
	this.descriptionQst = descriptionQst;
}

public String getTypeQst() {
	return typeQst;
}

public void setTypeQst(String typeQst) {
	this.typeQst = typeQst;
}

public List<Question> getQuestions() {
	return questions;
}

public void setQuestions(List<Question> questions) {
	this.questions = questions;
}

public QuestionService getQuestionservice() {
	return questionservice;
}

public void setQuestionservice(QuestionService questionservice) {
	this.questionservice = questionservice;
}

public QuestionBean() {
	super();
}

public QuestionBean(int idQst, String descriptionQst, String typeQst, List<Question> questions,
		QuestionService questionservice) {
	super();
	this.idQst = idQst;
	this.descriptionQst = descriptionQst;
	this.typeQst = typeQst;
	this.questions = questions;
	this.questionservice = questionservice;
}



}
