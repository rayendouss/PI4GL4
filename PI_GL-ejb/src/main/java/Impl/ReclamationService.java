package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Employe;
import Entity.Reclamation;
import Entity.Timesheet;
import Interf.ReclamationServiceRemote;
@Stateless
public class ReclamationService implements ReclamationServiceRemote {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public void ajouterRec(Reclamation r) {
		
		em.persist(r);
		
	}

	public Employe getEmployesbyID(int idg, int idemp) {
		
		return null;
	}
	@Override
	
	public List<Employe> getAllEmployes(int i) {
		TypedQuery<Employe> query = em.createQuery("Select t from Employe t where t.id!=:i"
				,
				Employe.class);
		query.setParameter("i", i);
		List<Employe>emp = query.getResultList();
				return emp;
	}
	public List<Reclamation> gettAllRecById(int i)
	{
		TypedQuery<Reclamation> query = em.createQuery("select t from Reclamation t where t.idRec=:i"
				,
				Reclamation.class);
		query.setParameter("i", i);
		List<Reclamation>emp = query.getResultList();
				return emp;
	}

	@Override
	public List<Reclamation> getMyrec(int i) {
		
		TypedQuery<Reclamation> query = em.createQuery("select t from Reclamation t where t.idemp =:i",
				Reclamation.class);
		query.setParameter("i", i);
		List<Reclamation>emp = query.getResultList();
				return emp; 
	}

	@Override
	public List<Reclamation> getRecA(int i) {
		TypedQuery<Reclamation> query = em.createQuery("select t from Reclamation t where t.emps.id =:i",
				Reclamation.class);
		query.setParameter("i", i);
		List<Reclamation>emp = query.getResultList();
				return emp; 
	}

	@Override
	public String getnombyid(int i) {
		Employe e= em.find(Employe.class, i);
		return e.getNom();
	}

	@Override
	public int addrec(int z,String s) {
		
		return em.createQuery("update Reclamation u set u.rep='"+s+"' where u.idRec="+z).executeUpdate();
		
	}
	public List<Reclamation> GetRespons(int id)
	{
		TypedQuery<Reclamation> query = em.createQuery("select t from Reclamation t where t.idRec =:id AND t.rep IS NOT NULL",
				Reclamation.class);
		query.setParameter("id", id);
		List<Reclamation>emp = query.getResultList();
				return emp; 
	}
	
}
