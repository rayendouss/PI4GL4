package Interf;



import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import Entity.Employe;
import Entity.Tache;



@Local
public interface EmployeServiceRemote {

	int ajouterEmploye(Employe employe);

	Employe getEmployeByEmailAndPassword(String email, String password);

	List<Employe> getAllEmployes();

	void deleteEmployeById(int employeId);

	int updateEmploye(Employe employe, int i);
	
	void displayEmploye(Employe empl);
	public Employe getEmployesbyID(int i);
	public Tache getTachebyID(int i) ;
	
	Boolean ajouterEmploye2(Employe employe);
	
}
