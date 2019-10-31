package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Project;
import Entities.Tache;



@Remote
public interface tacheServiceRemote  {
	public void ajouterTache(Tache e) ;
		
	
	public List<Tache> getAlltaches() ;
	public void deletetachebyid(int TId) ;
	public Project getProjectbyID(int i) ;
		
	
	
}
