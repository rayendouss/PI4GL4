package Interf;



import java.util.List;

import javax.ejb.Remote;

import Entity.Project;
import Entity.Tache;

@Remote
public interface ProjetServiceRemote {

	int ajouterProjet(Project p);
	Project getProjetByNom(String nom);
	List<Project> getAll();
	void deleteProjetById(int TId);
	public Project getProjectbyID(int i);
	List<Tache> getAllTacheByProjet(int id); 
	
}
