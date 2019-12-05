package interfaces;

import javax.ejb.Remote;

import entites.Employecompetence;

@Remote
public interface employecompetenceserviceremote {

	int ajouterEmployecompetence(Employecompetence employecompetence);
	
}
