package Interf;



import java.util.List;

import javax.ejb.Remote;

import Entity.Project;
import Entity.Tache;




@Remote
public interface tacheServiceRemote  {
	public void ajouterTache(Tache e) ;
		
	
	public List<Tache> getAlltaches() ;
	public void deletetachebyid(int TId) ;
	public Project getProjectbyID(int i) ;
		
	
	
}
