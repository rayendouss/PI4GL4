package Impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Employe;
import Entities.Timesheet;
import Entities.Trainer;
import Entities.Training;
import Interface.EmployeServiceRemote;
import Interface.TrainingServiceRemote;

@Stateless
public class TrainingService implements TrainingServiceRemote{
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	
	@Override
	public void ajouterTraining(Training e) {
		em.persist(e);
		
	}

	@Override
	public List<Training> getAllEmployes() {
		List<Training> emp = em.createQuery("Select e from Training e",
				Training.class).getResultList();
				return emp;
	}

	@Override
	public void deleteEmployeById(int TId) {
		Training entity = new Training();
		Query query =
				em.createQuery("SELECT e FROM Training e WHERE e.id_training=:TId  ",
						Training.class);
				query.setParameter("TId", TId);
			entity= (Training) query.getSingleResult();
		em.remove(entity);
		
	}

	@Override
	public int updateTraining(int i, Training e) {
		return em.createQuery("update Training u set u.id_skill='"+e.getId_skill()+"' , u.duree='"+e.getDuree()+"' where u.id_training="+i).executeUpdate();
	}

	EmployeServiceRemote es =new EmployeService();
	public Employe GetEmployeByid(int id)
	{
		return es.getEmployesbyID(id);
	}
	public Trainer getTrainingrById(int id) {
		
		return em.find(Trainer.class, id);
	}
	
}
