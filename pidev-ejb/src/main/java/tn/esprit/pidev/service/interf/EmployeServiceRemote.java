package tn.esprit.pidev.service.interf;

import java.util.List;

import javax.ejb.Remote;


import tn.esprit.pidev.entity.Employe;
import tn.esprit.pidev.entity.Evaluation;



@Remote
public interface EmployeServiceRemote {
	 public int ajouterEmploye(Employe employe); 
	 public void updateEmploye(Employe employe);
	 public long getNombreEmployeJPQL();
	 public Employe getEmployeByEmailAndPassword(String email, String password);
	
	 public void deleteEmployeById(int employeId);
	 public void affecterEmployeADepartement(int employeId, int depId);

	 public void mettreAjourEmailByEmployeId(String email, int employeId);
	 public List<String> getAllEmployeNamesJPQL();
	 public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	
	 public List<Employe>  getAllEmployeByEntreprise(Evaluation entreprise);
	 public Double getSalaireMoyenByDepartementId(int departementId);
	// public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, 
		//		Mission mission, Date dateDebut, Date dateFin);
	 public List<Employe> getAllEmployes() ;
	 public String getEmployePrenomById(int employeId); 
	 public void desaffecterEmployeDuDepartement(int employeId, int depId);
}
