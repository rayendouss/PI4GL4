package tn.esprit.pidev.entity;

import java.io.Serializable;
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
public class ligneQst implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_LigneQst")
	private int idLigneQst;
	
	
	private int noteQst;
	
	
	public int getIdLigneQst() {
		return idLigneQst;
	}

	public void setIdLigneQst(int idLigneQst) {
		this.idLigneQst = idLigneQst;
	}

	public int getNoteQst() {
		return noteQst;
	}

	public void setNoteQst(int noteQst) {
		this.noteQst = noteQst;
	}

	public Question getQuestion() {
		return Question;
	}

	public void setQuestion(Question question) {
		Question = question;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public ligneQst() {
		super();
	}

	public ligneQst(int idLigneQst, int noteQst, tn.esprit.pidev.entity.Question question,
			Set<Evaluation> evaluations) {
		super();
		this.idLigneQst = idLigneQst;
		this.noteQst = noteQst;
		Question = question;
	
	}

	@Override
	public String toString() {
		return "ligneQst [idLigneQst=" + idLigneQst + ", noteQst=" + noteQst + ", Question=" + Question
				+ ", evaluations="+ "]";
	}


	@ManyToOne
	Evaluation evaluation;
	
	@ManyToOne
	Question Question;
	
	
	
}
