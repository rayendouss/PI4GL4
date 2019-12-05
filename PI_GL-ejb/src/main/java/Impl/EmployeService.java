package Impl;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Employe;
import Entity.Tache;
import Interf.EmployeServiceRemote;



@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote {
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public int ajouterEmploye(Employe employe) {
		em.persist(employe);
		return employe.getId();
	}
	@Override
	public Employe getEmployeByEmailAndPassword(String email, String password) {
	TypedQuery<Employe> query =
	em.createQuery("SELECT e FROM Employe e WHERE e.email=:email AND e.password=:password ",
	Employe.class);
	query.setParameter("email", email);
	query.setParameter("password", password);
	Employe employe = null;
	try { employe = query.getSingleResult(); }
	catch (Exception e) { System.out.println("Erreur : " + e); }
	return employe;
	}
	public List<Employe> getAllEmployes() {
		System.out.println("aqw");
		List<Employe> emp=null;
	emp = em.createQuery("from Employe e",	Employe.class).getResultList();
	
	return emp;
	}
	
	public Employe getEmployesbyID(int i) {
		System.out.println(em.find(Employe.class, i)+"gaston");
	return em.find(Employe.class, i);
		
		}
	
	public void deleteEmployeById(int employeId) {
		Employe entity = new Employe();
		Query query =
				em.createQuery("SELECT e FROM Employe e WHERE e.id=:employeId  ",
				Employe.class);
				query.setParameter("employeId", employeId);
			entity=(Employe) query.getSingleResult();
		em.remove(entity);
	}
	@Override
	public int updateEmploye(Employe e,int i) {
		
		return em.createQuery("update Employe u set u.id='"+e.getId()+"' , "
				+ "u.nom='"+e.getNom()+"', u.prenom='"+e.getPrenom()+"' , u.password='"+e.getPassword()+"' where u.id="+i).executeUpdate();
		
	}
	public void displayEmploye(Employe empl)
	{ Employe e = new Employe();
	e.setPrenom(empl.getPrenom());
	e.setNom(empl.getNom());
	e.setIsActif(empl.getIsActif());
	e.setEmail(empl.getEmail());
	e.setRole(empl.getRole());
	
	e.setPassword(empl.getPassword());
	e.setId(empl.getId());
	}
public Tache getTachebyID(int i) {
		
		Query query = em.createQuery("Select e from Tache e where e.idT=:i",
		Tache.class);
		query.setParameter("id", i);
		return (Tache) query.getSingleResult();
		
		}
@Override
public Boolean ajouterEmploye2(Employe employe) {
	// TODO Auto-generated method stub

	if(employe==null)
	{
		return false ;
	} else
	{
		em.persist(employe);
		return true;
	}
	
}


	
}
