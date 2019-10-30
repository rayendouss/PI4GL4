package Interface;

import java.util.List;

import Entities.Trainer;
import Entities.Training;
import javax.ejb.Remote;


@Remote
public interface TrainingServiceRemote {

	void ajouterTraining(Training e);

	List<Training> getAllEmployes();

	

	void deleteEmployeById(int employeId);

	
	int updateTraining(int i, Training e);
	public Trainer getTrainingrById(int id);
}
