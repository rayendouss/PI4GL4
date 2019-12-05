package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tp_jsf_Reclamation")
public class Reclamation implements Serializable{
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int idRec;
	private String description ;
	private String rep ;
	
	@ManyToOne
	private Employe emps;
	
	private int idemp ;

	
	private String name ;
	
	public String getName() {
		
		return name ;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public int getIdRec() {
		return idRec;
	}

	public void setIdRec(int idRec) {
		this.idRec = idRec;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employe getEmps() {
		return emps;
	}

	public void setEmps(Employe emps) {
		this.emps = emps;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public Reclamation(String description, Employe emps, int idemp) {
		super();
		this.description = description;
		this.emps = emps;
		this.idemp = idemp;
	}

	public Reclamation(String description, int idemp) {
		super();
		this.description = description;
		this.idemp = idemp;
	}

	public Reclamation() {
		super();
	}

	
 
	
	

}
