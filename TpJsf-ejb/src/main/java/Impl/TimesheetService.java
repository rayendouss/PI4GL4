package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Employe;
import Entities.Timesheet;
import Interface.EmployeServiceRemote;
import Interface.TimesheetServiceRemote;

@Stateless
public class TimesheetService implements TimesheetServiceRemote {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	@Override
	public void ajouterTimeSheet(Timesheet e) {
		em.persist(e);
		
	}
	@Override
	public List<Timesheet> getAllEmployes() {
		List<Timesheet> emp = em.createQuery("Select e from Timesheet e",
				Timesheet.class).getResultList();
				return emp;
		
	}
	@Override
	public void deleteEmployeById(int TId) {
		Timesheet entity = new Timesheet();
		Query query =
				em.createQuery("SELECT e FROM Timesheet e WHERE e.idT=:TId  ",
				Timesheet.class);
				query.setParameter("TId", TId);
			entity= (Timesheet) query.getSingleResult();
		em.remove(entity);
		
	}
	@Override
	public int updateTimeSheet(int i ,Timesheet e) {
		
		return em.createQuery("update Timesheet u set u.EtatTache='"+e.getEtatTache()+"' , u.NbreConge='"+e.getNbreConge()+"', u.NbreHeureTRavJour='"+e.getNbreHeureTRavJour()+"' , u.NbreHeureTRavS='"+e.getNbreHeureTRavS()+"' where u.idT="+i).executeUpdate();
		
	}
	EmployeServiceRemote es =new EmployeService();
	public Employe GetEmployeByid(int id)
	{
		return es.getEmployesbyID(id);
	}
		
	}
	


