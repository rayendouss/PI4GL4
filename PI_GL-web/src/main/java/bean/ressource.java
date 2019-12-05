package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entity.Employe;
import Entity.Role;
import Impl.EmployeService;
import Interf.EmployeServiceRemote;


@Path("users")
@RequestScoped
public class ressource {
@EJB
EmployeServiceRemote e ;
/*Employe ee = new Employe("aaa", "aaaaa", "edc", "rfv", Role.ADMINISTRATEUR);
List<Employe>le = new ArrayList<Employe>();*/


@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("del")
public Response deluser(@QueryParam(value="id")int id)
{ e.deleteEmployeById(id);
	return Response.status(Status.OK).entity("deleted").build();
}

@Path("add")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response ajout(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,@QueryParam("password") String password,@QueryParam("isActif") Boolean isActif,@QueryParam("email") String email,@QueryParam("role") String role)
{ 
	Employe emp= new Employe();
	emp.setEmail(email);
	emp.setIsActif(isActif);
	emp.setNom(nom);
	emp.setPrenom(prenom);
	emp.setPassword(password);
	if(role.equals("ADMINISTRATEUR"))
	{
		emp.setRole(Role.ADMINISTRATEUR);
		
	}else if (role.equals("TECHNICIEN"))
	{
		emp.setRole(Role.TECHNICIEN);
		
	}else if (role.equals("CHEF_DEPARTEMENT"))
	{
		emp.setRole(Role.CHEF_DEPARTEMENT);
	}else 
	{
		emp.setRole(Role.INGENIEUR);
	}
	
	e.ajouterEmploye(emp);
		return Response.status(Status.CREATED).build();
}


@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("all")
public Response getemp()
{
	return Response.ok(e.getAllEmployes()).build();
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("login")
public Response login(@QueryParam("email") String email,@QueryParam("password") String password)
{
	Employe p=new Employe();
	p=e.getEmployeByEmailAndPassword(email, password);
	System.out.println("12233"+p);
	if (p!=null)
	{System.out.println("aaaa");
		return  Response.ok().entity(p).build();
	}else
	{ System.out.println("abc");
		return  Response.status(Status.NOT_FOUND).build();}
}

//test ajout 2 

@POST
@Consumes(MediaType.APPLICATION_JSON)
public Response ajout2(Employe ee)
{  
	if (e.ajouterEmploye2(ee))
	{
		return Response.status(Status.ACCEPTED).build();
	} 
		return Response.ok().entity("employe vide").build();
}
}





