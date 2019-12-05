package Interf;



import java.util.List;

import javax.ejb.Remote;

import Entity.Project;
import Entity.Timesheet;



@Remote
public interface TimesheetServiceRemote {

	void ajouterTimeSheet(Entity.Timesheet e);

	List<Timesheet> getAllEmployes();

	List<Project> getAllPr();

	void deleteEmployeById(int employeId);

	
	int updateTimeSheet(int i, Timesheet e);

	List<Timesheet> getTimeSheetByidEmp(int i);

}
