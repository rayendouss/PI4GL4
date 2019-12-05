package tn.esprit.pidev.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Qst")
	private int idQst;
	
	private String descriptionQst;
	private String typeQst;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Question [idQst=" + idQst + ", descriptionQst=" + descriptionQst + ", typeQst=" + typeQst + "]";
	}
	public Question(int idQst, String descriptionQst, String typeQst) {
		super();
		this.idQst = idQst;
		this.descriptionQst = descriptionQst;
		this.typeQst = typeQst;
	}
	public Question() {
		super();
	}
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Question")
	private Set<ligneQst> ligneQst;
}
