package managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entites.Competence;
import impl.Competenceservice;

@ManagedBean (name= "competencebean")
@SessionScoped
public class Competencebean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nomcompetence;
	private String descriptioncompetence;
	
	@EJB
	Competenceservice competenceservice;

	public Competencebean() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomcompetence() {
		return nomcompetence;
	}

	public void setNomcompetence(String nomcompetence) {
		this.nomcompetence = nomcompetence;
	}

	public String getDescriptioncompetence() {
		return descriptioncompetence;
	}

	public void setDescriptioncompetence(String descriptioncompetence) {
		this.descriptioncompetence = descriptioncompetence;
	}

	public Competenceservice getCompetenceservice() {
		return competenceservice;
	}

	public void setCompetenceservice(Competenceservice competenceservice) {
		this.competenceservice = competenceservice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private List<Competence> competences;
	
	public void addCompetence() {
		Competence e= new Competence(nomcompetence, descriptioncompetence);
	competenceservice.ajouterCompetence(e); }
	
	public List<Competence> getCompetences() {
		competences = competenceservice.getAllCompetences();
		return competences;
		}
	
	public void removetablecompetence(int tablecompetenceId)
	{
	competenceservice.removescompetence(tablecompetenceId);
	}
	
	 private Integer tablecompetenceeIdToBeUpdated;

	public Integer getTablecompetenceeIdToBeUpdated() {
		return tablecompetenceeIdToBeUpdated;
	}

	public void setTablecompetenceeIdToBeUpdated(Integer tablecompetenceeIdToBeUpdated) {
		this.tablecompetenceeIdToBeUpdated = tablecompetenceeIdToBeUpdated;
	}

	public void displaytablescompetence(Competence comp)
	{
	this.setDescriptioncompetence(comp.getDescriptioncompetence());
	this.setNomcompetence(comp.getNomcompetence());
	this.setTablecompetenceeIdToBeUpdated(comp.getId());
	}
	
	public void updatetablescompetence(){ 
		competenceservice.updatescompetence(new Competence(tablecompetenceeIdToBeUpdated, nomcompetence, descriptioncompetence) );
		                                      
	}
	
}
