package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entites.Competence;
import entites.Domainecompetence;

@Remote
public interface Domainecompetenceserviceremote {

	int ajouterDomainecompetence(Domainecompetence domainecompetence);
	List<Domainecompetence> getAllDomainecompetence();
	public void removesDomainecompetence(int id);
	//public void updatesDomainecompetence(Competence user);
}
