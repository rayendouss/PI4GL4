package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Employe;
import Entities.Project;
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
	@Override
	public List<Project> getAllPr() {
		List<Project> emp = em.createQuery("Select e from Project e",
				Project.class).getResultList();
		return emp;
	}
	@Override
	public List<Timesheet> getTimeSheetByidEmp(int i) {
		TypedQuery<Timesheet> query = em.createQuery("Select t from Timesheet t where t.employe.id=:i"
				,
				Timesheet.class);
		query.setParameter("i", i);
		List<Timesheet>emp = query.getResultList();
				return emp;
	}
		
	}
	


