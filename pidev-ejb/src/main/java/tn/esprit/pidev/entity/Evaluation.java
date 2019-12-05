package tn.esprit.pidev.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity

public class Evaluation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Eval")
	private int id;
	private String commentaire;
	private String description;
	private String TypeEval;
	private String contexteEval;
	private String periodEval;
	private Date   dateEval;
	private int noteEmploye;
	private int noteManager;
	private int idCandidat;
	


	

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTypeEval() {
		return TypeEval;
	}
	
	public void setTypeEval(String typeEval) {
		this.TypeEval = typeEval;
	}
	public String getContexteEval() {
		return contexteEval;
	}
	public void setContexteEval(String contexteEval) {
		this.contexteEval = contexteEval;
	}
	public String getPeriodEval() {
		return periodEval;
	}
	public void setPeriodEval(String periodEval) {
		this.periodEval = periodEval;
	}
	public Date getDateEval() {
		return dateEval;
	}
	public void setDateEval(Date dateEval) {
		this.dateEval = dateEval;
	}
	public int getNoteEmploye() {
		return noteEmploye;
	}
	public void setNoteEmploye(int noteEmploye) {
		this.noteEmploye = noteEmploye;
	}
	public int getNoteManager() {
		return noteManager;
	}
	public void setNoteManager(int noteManager) {
		this.noteManager = noteManager;
	}
	public int getIdCandidat() {
		return idCandidat;
	}
	public void setIdCandidat(int idCandidat) {
		this.idCandidat = idCandidat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Set<ligneQst> getLigneQst() {
		return LigneQst;
	}
	public void setLigneQst(Set<ligneQst> ligneQst) {
		LigneQst = ligneQst;
	}




	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", commentaire=" + commentaire + ", description=" + description + ", TypeEval="
				+ TypeEval + ", contexteEval=" + contexteEval + ", periodEval=" + periodEval + ", dateEval=" + dateEval
				+ ", noteEmploye=" + noteEmploye + ", noteManager=" + noteManager + ", idCandidat=" + idCandidat
				+ ", employe=" + employe + ", LigneQst=" + LigneQst + "]";
	}




	@ManyToOne
	Employe employe;
	
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="evaluation")
	private Set<ligneQst> LigneQst;

	public Evaluation(Integer emvaluationIdToBeUpdated, String commentaire2, String description2, Date dateeval2, int noteemploye2, int notemanager2, Employe e) {
		super();
	}
	public Evaluation() {
		super();
	}

	
	

}
