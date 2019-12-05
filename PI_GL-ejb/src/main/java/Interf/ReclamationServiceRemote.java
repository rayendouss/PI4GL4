package Interf;



import java.util.List;

import javax.ejb.Remote;

import Entity.Employe;
import Entity.Reclamation;

@Remote
public interface ReclamationServiceRemote {
	public void ajouterRec(Reclamation r);

	public Employe getEmployesbyID(int idg, int idemp);

	public List<Employe> getAllEmployes(int i);
	public List<Reclamation> gettAllRecById(int i);
	public List<Reclamation> getMyrec(int i);

	public List<Reclamation> getRecA(int i);
	public String getnombyid(int i);
	public int addrec(int z,String s);
	public List<Reclamation> GetRespons(int id);
}
