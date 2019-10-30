package Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tp_jsf_TRAINER")
public class Trainer implements Serializable{

	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(insertable= true)
	 private int id_trainer;
	
	private int id_skill;
	private boolean isAvailable;
	
	public int getId_trainer() {
		return id_trainer;
	}
	public void setId_trainer(int id_trainer) {
		this.id_trainer = id_trainer;
	}
	public int getId_skill() {
		return id_skill;
	}
	public void setId_skill(int id_skill) {
		this.id_skill = id_skill;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Trainer(int id_trainer, int id_skill, boolean isAvailable) {
		
		this.id_trainer = id_trainer;
		this.id_skill = id_skill;
		this.isAvailable = isAvailable;
	}
	public Trainer() {
		super();
	}
	
	
	
}
