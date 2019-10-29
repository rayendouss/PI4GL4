package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Employe;
import Entities.Project;
import Entities.Tache;
@Remote
public interface ProjetServiceRemote {

	int ajouterProjet(Project p);
	Project getProjetByNom(String nom);
	List<Project> getAll();
	void deleteProjetById(int TId);
	public Project getProjectbyID(int i);
	List<Tache> getAllTacheByProjet(int id); 
	
}
