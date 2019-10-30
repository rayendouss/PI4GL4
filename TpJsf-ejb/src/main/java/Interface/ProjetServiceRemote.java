package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Project;
@Remote
public interface ProjetServiceRemote {

	int ajouterProjet(Project p);
	Project getProjetByNom(String nom);
	List<Project> getAll();
	
}
