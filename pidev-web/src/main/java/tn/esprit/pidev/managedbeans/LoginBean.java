package tn.esprit.pidev.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.pidev.entity.Employe;



import tn.esprit.pidev.service.interf.EmployeServiceRemote;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
  private static int ide ;
  private static int ida ;
	private String login;
	private String password;
	private Employe employe;
	private Boolean loggedIn;
	
	public static int getIda() {
		return ida;
	}

	public static void setIda(int ida) {
		LoginBean.ida = ida;
	}

	public static int getIde() {
		return ide;
	}

	public static void setIde(int ide) {
		LoginBean.ide = ide;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public EmployeServiceRemote getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeServiceRemote employeService) {
		this.employeService = employeService;
	}
	//
	@EJB
	EmployeServiceRemote employeService;



	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";

	}
	public String doAjout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/admin/Ajouter?faces-redirect=true";

	}
	public String doProjet() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/admin/projet?faces-redirect=true";

	}
	public String doe() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/admin/Ajouter?faces-redirect=true";

	}
}
