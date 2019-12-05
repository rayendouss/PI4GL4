package entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Domainecompetence implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private TypeDomainCompetence type;
	public Domainecompetence() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Domainecompetence [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	public Domainecompetence(int id, String name, TypeDomainCompetence type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public Domainecompetence(String name, TypeDomainCompetence type) {
		super();
		this.name = name;
		this.type = type;
	}

	
	
	
}
