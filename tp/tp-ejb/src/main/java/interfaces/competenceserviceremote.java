package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entites.Competence;

@Remote
public interface competenceserviceremote {

	int ajouterCompetence(Competence competence);
	List<Competence> getAllCompetences();
	public void removescompetence(int id);
	public void updatescompetence(Competence user);
	
}
