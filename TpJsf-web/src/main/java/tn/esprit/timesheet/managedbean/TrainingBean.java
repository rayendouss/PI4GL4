/*package tn.esprit.timesheet.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import com.sun.faces.taglib.html_basic.SelectOneMenuTag;

import Entities.Employe;
import Entities.Tache;
import Entities.Training;
import Entities.Trainer;
import Interface.EmployeServiceRemote;
import Interface.TrainingServiceRemote;


@ManagedBean (name = "TrainingBean")
@SessionScoped
public class TrainingBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Training training;
	 private int id_training;
	private int id_skill ;
	private int Duree ;	 
	
	 private Employe employe ;
	 private Trainer trainer ;
	 private List<Training> trainings ;
	 
	 private Integer IdToBeUpdated;
	 private List<Employe> employes ;
	 public Employe selectedEmploye;
	 public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public void displayEmploye(Training empl)
	 {
	 this.setId_skill(empl.getId_skill());
	 this.setDuree(empl.getDuree());
	 
	
	 this.setIdToBeUpdated(empl.getId_training());
	 }
	public Integer getIdToBeUpdated() {
		return IdToBeUpdated;
	}
	public void setIdToBeUpdated(Integer idToBeUpdated) {
		IdToBeUpdated = idToBeUpdated;
	}
	public Training getTraining() {
		return training;
	}
	public void setTraining(Training training) {
		this.training = training;
	}
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
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int Duree) {
		this.Duree = Duree;
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
	
	public Employe getSelectedEmploye() {
		return selectedEmploye;
	}
	public void setSelectedEmploye(Employe selectedEmploye) {
		this.selectedEmploye = selectedEmploye;
	}
	
	public TrainingServiceRemote getTs() {
		return ts;
	}
	public void setTs(TrainingServiceRemote ts) {
		this.ts = ts;
	}
	
	@EJB
	TrainingServiceRemote ts;
	@EJB
	EmployeServiceRemote es ;
	
	public void addts() {
		System.out.println(selectedEmploye+"*******************************");
		Training e = new Training(id_training,id_skill,Duree,selectedEmploye,trainer);
		
	ts.ajouterTraining(e);
	}

	public List<Training> getTS() {
		trainings = ts.getAllEmployes();
		return trainings;
		}
	public List<Employe> getAllEmployes()
	{
		System.out.println("haha");
		employes = es.getAllEmployes();
		return employes ;
	}
	public List<Training> getTrainings() {
		trainings = ts.getAllEmployes();
		return trainings;
	}
	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}
	public void removeTraiaing(int id)
	{
	ts.deleteEmployeById(id);
	}
	public int updateTraining()
	{ 
	Training i=  new Training();
	i.setId_skill(this.getId_skill());
	i.setDuree(this.getDuree());
	
	
	ts.updateTraining(IdToBeUpdated, i );
	return IdToBeUpdated; 
	}

}
*/