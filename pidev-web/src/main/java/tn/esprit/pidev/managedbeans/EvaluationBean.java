package tn.esprit.pidev.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.pidev.entity.Employe;
import tn.esprit.pidev.entity.Evaluation;
import tn.esprit.pidev.service.impl.EvaluationService;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;






@ManagedBean(name = "evaluationBean")
@SessionScoped
public class EvaluationBean implements Serializable {

private static final long serialVersionUID = 1L;
private String commentaire; 
private String description;
private Date   dateeval;
private int noteemploye;
private int notemanager;
private List<Evaluation> evaluations;

private Employe e = new Employe(1);
@EJB
EvaluationService evaluationService;

public String addEvaluation() {
evaluationService.ajouterEvaluation(new Evaluation());
System.out.println("aaa");
//sendMessage("firas.zoghlami@esprit.tn","Evalutation ajoute"+"     de nom  "+getDescription()+getCommentaire());
String	navigateTo = "/template/afficheval?faces-redirect=true";
return navigateTo;
}




public EvaluationBean(String commentaire, String description, Date dateeval, int noteemploye, int notemanager,
		List<Evaluation> evaluations, Employe e, EvaluationService evaluationService,
		Integer emvaluationIdToBeUpdated) {
	super();
	this.commentaire = commentaire;
	this.description = description;
	this.dateeval = new Date();;
	this.noteemploye = noteemploye;
	this.notemanager = notemanager;
	this.evaluations = evaluations;
	this.e = e;
	this.evaluationService = evaluationService;
	this.emvaluationIdToBeUpdated = emvaluationIdToBeUpdated;
}

public String getCommentaire() {
	return commentaire;
}

public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getDateeval() {
	return dateeval;
}

public void setDateeval(Date dateeval) {
	this.dateeval = dateeval;
}

public int getNoteemploye() {
	return noteemploye;
}

public EvaluationBean() {
	super();
}

public void setNoteemploye(int noteemploye) {
	this.noteemploye = noteemploye;
}

public int getNotemanager() {
	return notemanager;
}

public void setNotemanager(int notemanager) {
	this.notemanager = notemanager;
}

public EvaluationService getEvaluationService() {
	return evaluationService;
}

public void setEvaluationService(EvaluationService evaluationService) {
	this.evaluationService = evaluationService;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public EvaluationBean(String commentaire, String description, Date dateeval, int noteemploye, int notemanager,
		EvaluationService evaluationService) {
	super();
	this.commentaire = commentaire;
	this.description = description;
	this.dateeval = new Date();;
	this.noteemploye = noteemploye;
	this.notemanager = notemanager;
	this.evaluationService = evaluationService;
}


public List<Evaluation> getEvaluations() {
	evaluations = evaluationService.getAllEvaluations();
	return evaluations; 
}

public void setEvaluation(List<Evaluation> evaluations) {
	this.evaluations = evaluations;
}

public void removeEvaluation(int evaluationId) 
{ evaluationService.deleteEvaluationById(evaluationId); }

public EvaluationBean(String commentaire, String description, Date dateeval, int noteemploye, int notemanager,
		List<Evaluation> evaluations) {
	super();
	this.commentaire = commentaire;
	this.description = description;
	this.dateeval = new Date();;
	this.noteemploye = noteemploye;
	this.notemanager = notemanager;
	this.evaluations = evaluations;
}

public Employe getE() {
	return e;
}

public void setE(Employe e) {
	this.e = e;
}

public Integer getEmvaluationIdToBeUpdated() {
	return emvaluationIdToBeUpdated;
}

public void setEmvaluationIdToBeUpdated(Integer emvaluationIdToBeUpdated) {
	this.emvaluationIdToBeUpdated = emvaluationIdToBeUpdated;
}

public void setEvaluations(List<Evaluation> evaluations) {
	this.evaluations = evaluations;
}









public EvaluationBean(String commentaire, String description, Date dateeval, int noteemploye, int notemanager,
 Integer emvaluationIdToBeUpdated ) {
	super();
	this.commentaire = commentaire;
	this.description = description;
	this.dateeval = new Date();
	this.noteemploye = noteemploye;
	this.notemanager = notemanager;
	this.emvaluationIdToBeUpdated = emvaluationIdToBeUpdated;
	
}




public EvaluationBean(String commentaire, String description, Date dateeval, int noteemploye, int notemanager, Employe e,
		Integer emvaluationIdToBeUpdated) {
	super();
	this.commentaire = commentaire;
	this.description = description;
	this.dateeval = dateeval;
	this.noteemploye = noteemploye;
	this.notemanager = notemanager;
	this.e = e;

}




private Integer emvaluationIdToBeUpdated;
public void displayEvaluation(Evaluation ev)
{
this.setCommentaire(ev.getCommentaire());
this.setDescription(ev.getDescription());
this.setDateeval(ev.getDateEval());
this.setNoteemploye(ev.getNoteEmploye());
this.setNotemanager(ev.getNoteManager());
this.setEmvaluationIdToBeUpdated(ev.getId());
this.setE(getE());
}

public String updateEvaluation()
{ evaluationService.updateEvaluation(new Evaluation(emvaluationIdToBeUpdated, commentaire, description, dateeval,
		noteemploye, notemanager, e)); 
String	navigateTo = "/template/afficheval?faces-redirect=true";
return navigateTo;
}

public String displayEvaluationUpdate(Evaluation ev) 
{ 
	
String	navigateTo = "/template/updateEvaluation?faces-redirect=true";
	
this.setCommentaire(ev.getCommentaire());
this.setDescription(ev.getDescription());
this.setDateeval(ev.getDateEval());
this.setDateeval(ev.getDateEval());
this.setNotemanager(ev.getNoteManager());
this.setEmvaluationIdToBeUpdated(ev.getId());
this.setE(getE());
return navigateTo;



}








}
