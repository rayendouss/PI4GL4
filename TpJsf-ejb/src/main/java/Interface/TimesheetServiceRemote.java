package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Timesheet;

@Remote
public interface TimesheetServiceRemote {

	void ajouterTimeSheet(Timesheet e);

	List<Timesheet> getAllEmployes();

	

	void deleteEmployeById(int employeId);

	
	int updateTimeSheet(int i, Timesheet e);

	

}
