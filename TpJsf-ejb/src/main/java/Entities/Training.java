package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="tp_jsf_TRAINING")
public class Training implements Serializable{

	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(insertable= true)
	 private int id_training;
	 
	 private int id_skill;
	 private int duree ;
	 
	 @ManyToOne
	    @JoinColumn(name = "idEmploye", referencedColumnName = "id", updatable=false)
		private Employe employe;
	 @ManyToOne
	    @JoinColumn(name = "idTrainer", referencedColumnName = "id_trainer", updatable=false)
		private Trainer trainer;
	public int getId_training() {
		return id_training;
	}
	public void setId_training(int id_training) {
		this.id_training = id_training;
	}
	public int getId_skill() {
		return id_skill;
	}
	public void setId_skill(int id_skill) {
		this.id_skill = id_skill;
	}
	/*public int getDuree() {
		return Duree;
	}
	public void setDuree(int Duree) {
		this.Duree = Duree;
	}*/
	
	
	
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public Training(int id_training, int id_skill, int duree, Employe employe, Trainer trainer) {
		
		this.id_training = id_training;
		this.id_skill = id_skill;
		this.duree = duree;
		this.employe = employe;
		this.trainer = trainer;
	}
	 
	public Training() {
		
	}
	 
	 
}
