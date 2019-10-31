package tn.esprit.timesheet.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import com.sun.faces.taglib.html_basic.SelectOneMenuTag;


import Entities.Trainer;
import Interface.TrainerServiceRemote;

@ManagedBean (name="trainerBean")
@SessionScoped
public class TrainerBean {
	
	private static final long serialVersionUID = 1L;
	private Trainer trainer;
	private int id_trainer;
	private int id_skill ;
	private int isAvailable;
	
	 private List<Trainer> trainers ;
	 
	 private Integer IdToBeUpdated;
	 
	 
	 public void displayEmploye(Trainer empl)
	 {
	 this.setId_skill(empl.getId_skill());
	 this.setIsAvailable(empl.getIsAvailable());
	// this.setTrainer(empl.getTrainer());
	
	 this.setIdToBeUpdated(empl.getId_trainer());
	 }


	public Trainer getTrainer() {
		return trainer;
	}


	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


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


	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}


	public List<Trainer> getTrainers() {
		return trainers;
	}



	public Integer getIdToBeUpdated() {
		return IdToBeUpdated;
	}


	public void setIdToBeUpdated(Integer idToBeUpdated) {
		IdToBeUpdated = idToBeUpdated;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TrainerServiceRemote getTrs() {
		return trs;
	}
	public void setTs(TrainerServiceRemote trs) {
		this.trs = trs;
	}
	
	@EJB
	TrainerServiceRemote trs;
	
	public void removeTrainer(int id_trainer)
	{
	trs.deleteEmployeById(id_trainer);
	}
	
	public void addts() {

		Trainer e = new Trainer(id_trainer,id_skill,isAvailable);
		
		trs.ajouterTrainer(e);
	}
	
	///
	public List<Trainer> getTS() {
		trainers = trs.getAllEmployes();
		return trainers;
		}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	
	public int updateTrainer()
	{ 
		Trainer i=  new Trainer();
	i.setId_skill(this.getId_skill());
	i.setIsAvailable(this.getIsAvailable());
	
	trs.updateTrainer(IdToBeUpdated, i );
	return IdToBeUpdated; 
	}
	
}
