package Interface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Project;
import Entities.Timesheet;

@Remote
public interface TimesheetServiceRemote {

	void ajouterTimeSheet(Timesheet e);

	List<Timesheet> getAllEmployes();

	List<Project> getAllPr();

	void deleteEmployeById(int employeId);

	
	int updateTimeSheet(int i, Timesheet e);

	List<Timesheet> getTimeSheetByidEmp(int i);

}
