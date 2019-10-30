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
import Interface.TrainerServiceRemote;
import Interface.TrainingServiceRemote;

public class TrainerService implements TrainerServiceRemote{
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	
	@Override
	public void ajouterTrainer(Trainer e) {
		em.persist(e);
		
	}

	@Override
	public List<Trainer> getAllEmployes() {
		List<Trainer> emp = em.createQuery("Select e from Trainer e",
				Trainer.class).getResultList();
				return emp;
	}

	@Override
	public void deleteEmployeById(int employeId) {
		Trainer e = em.find(Trainer.class,employeId);

		em.remove(e);
		
	}

	@Override
	public int updateTrainer(int i, Trainer e) {
		return em.createQuery("update Trainer u set u.id_skill='"+e.getId_skill()+"' , u.available='"+e.getIsAvailable()+"' where u.id_trainer="+i).executeUpdate();

	}

}
