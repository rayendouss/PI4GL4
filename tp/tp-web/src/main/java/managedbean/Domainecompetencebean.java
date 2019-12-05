package managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import entites.Competence;
import entites.Domainecompetence;
import entites.TypeDomainCompetence;
import impl.Competenceservice;
import impl.Domainecompetenceservice;

@ManagedBean (name= "domainecompetencebean")
@SessionScoped
public class Domainecompetencebean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private TypeDomainCompetence type;
	private String console;
	

	@EJB
	Domainecompetenceservice domainecompetenceservice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeDomainCompetence getType() {
		return type;
	}
	public void setType(TypeDomainCompetence type) {
		this.type = type;
	}
	
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Domainecompetencebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void addDomainecompetence() {
		
		
		
		domainecompetenceservice.ajouterDomainecompetence(new Domainecompetence(name,TypeDomainCompetence.valueOf(console)));
		
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Ajout du theme avec succes")) ;
	
		}
	
	private List<Domainecompetence> domainecompetences;
	
	public List<Domainecompetence> getCompetences() {
		domainecompetences = domainecompetenceservice.getAllDomainecompetence();
		return domainecompetences;
		}
	
	public void removetablecompetence(int tablecompetenceId)
	{
	domainecompetenceservice.removesDomainecompetence(tablecompetenceId);
	}
	
}
