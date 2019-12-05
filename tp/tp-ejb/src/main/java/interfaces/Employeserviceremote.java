package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entites.Employe;

@Remote
public interface Employeserviceremote {

	int ajouterEmploye(Employe employe);
	List<Employe> getAllEmployes();
	public void removesemploye(int id);
	public void updatesemploye(Employe user);
	
}
