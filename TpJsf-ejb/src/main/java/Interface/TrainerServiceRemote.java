package Interface;

import java.util.List;

import Entities.Trainer;
import Entities.Training;
import javax.ejb.Remote;

public interface TrainerServiceRemote {
	
	void ajouterTrainer(Trainer e);

	List<Trainer> getAllEmployes();

	

	void deleteEmployeById(int employeId);

	
	int updateTrainer(int i, Trainer e);

}
