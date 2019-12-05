package managedbean;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entites.Competence;
import entites.Employe;
import entites.Employecompetence;
import impl.Competenceservice;
import impl.Employecompetenceservice;
import impl.Employeservice;

@ManagedBean
@SessionScoped
public class Employecompetencebean {

	private static final long serialVersionUID = 1L;
	
	private Employe employe;
	private Competence competence;
	private String console;
	private String consoles;
	private String dom;
	private int id;
	private String nomcompetence;
	
	@EJB
	Employeservice employeservice;
	
	@EJB
	Competenceservice competenceservice;
	
	@EJB
	Employecompetenceservice employecompetenceservice;
	
	public String doAdd() throws IOException {
		Employe d1 = new Employe();
		Competence d2 = new Competence();
		String navigateTo = null;
		d1 = employeservice.findemployebyname(console);
		d2 = competenceservice.findcompetencebyname(consoles);
		
		if (employecompetenceservice.ajouterEmployecompetence(new Employecompetence(d1, d2)) == 1) {
			///FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Ajout sujet avec succes"));
			//System.out.println("okitou");
			
			// FacesContext.getCurrentInstance().getExternalContext().dispatch("/pages/chahnez/afficherTopic.xhtml");
			///navigateTo = "/pages/chahnez/afficherTopic?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Echec de l'ajout"));
			System.out.println("oh no");
			navigateTo = "/template/ajouteremploye?faces-redirect=true";

		}
		return navigateTo;
	}

	

	public String getConsole() {
		return console;
	}



	public void setConsole(String console) {
		this.console = console;
	}



	public String getConsoles() {
		return consoles;
	}

	public void setConsoles(String consoles) {
		this.consoles = consoles;
	}

	public Employeservice getEmployeservice() {
		return employeservice;
	}

	public void setEmployeservice(Employeservice employeservice) {
		this.employeservice = employeservice;
	}

	public Competenceservice getCompetenceservice() {
		return competenceservice;
	}

	public void setCompetenceservice(Competenceservice competenceservice) {
		this.competenceservice = competenceservice;
	}

	public Employecompetenceservice getEmployecompetenceservice() {
		return employecompetenceservice;
	}

	public void setEmployecompetenceservice(Employecompetenceservice employecompetenceservice) {
		this.employecompetenceservice = employecompetenceservice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Employecompetencebean() {
		
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}


	@Override
	public String toString() {
		return "Employecompetencebean [employe=" + employe + ", competence=" + competence + ", console=" + console
				+ ", consoles=" + consoles + ", dom=" + dom + ", id=" + id + ", nomcompetence=" + nomcompetence
				+ ", employeservice=" + employeservice + ", competenceservice=" + competenceservice
				+ ", employecompetenceservice=" + employecompetenceservice + "]";
	}

	
	
	public Employecompetencebean(Employe employe, Competence competence, String console, String consoles, String dom,
			int id, String nomcompetence, Employeservice employeservice, Competenceservice competenceservice,
			Employecompetenceservice employecompetenceservice) {
		super();
		this.employe = employe;
		this.competence = competence;
		this.console = console;
		this.consoles = consoles;
		this.dom = dom;
		this.id = id;
		this.nomcompetence = nomcompetence;
		this.employeservice = employeservice;
		this.competenceservice = competenceservice;
		this.employecompetenceservice = employecompetenceservice;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public List<Employe> employe() {
		return employeservice.getAllEmployes();

	}
	
	public List<Competence> competence() {
		return competenceservice.getAllCompetences();

	}
	
}
