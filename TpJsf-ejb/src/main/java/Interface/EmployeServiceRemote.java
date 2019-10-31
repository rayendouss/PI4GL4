package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Employe;
import Entities.Tache;

@Remote
public interface EmployeServiceRemote {

	int ajouterEmploye(Employe employe);

	Employe getEmployeByEmailAndPassword(String email, String password);

	List<Employe> getAllEmployes();

	void deleteEmployeById(int employeId);

	int updateEmploye(Employe employe, int i);
	
	void displayEmploye(Employe empl);
	public Employe getEmployesbyID(int i);
	public Tache getTachebyID(int i) ;
	
}
