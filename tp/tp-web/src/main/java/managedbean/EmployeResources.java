package managedbean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.Employe;
import interfaces.Employeserviceremote;

@Path("employes")
@RequestScoped
public class EmployeResources {

	@EJB
	Employeserviceremote e ;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		return Response.ok(e.getAllEmployes()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterEmploye(Employe employe)
	{  
		System.out.println("hello");
            e.ajouterEmploye(employe);
		System.out.println(employe);
		return Response.status(Status.OK).entity("employes created:").build();	
	}
	
	/*
	@DELETE
	@Consumes(MediaType.APPLICATION_XML)
	public Response removesemploye(int id)
	{  
		System.out.println("hello");
            e.removesemploye(id);
		System.out.println(id);
		return Response.status(Status.CREATED).build();	
	}
	*/
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response removesemploye(@PathParam("id")int id) {
		 e.removesemploye(id);
		return Response.status(Status.OK).entity("user removed").build();
	}
	/*
	 @PUT
	  @Path("{id}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response updatesemploye(@PathParam("id") int id, Employe user) {
	  	user.setId(id);
	  	e.updatesemploye(user);
	  	

	  	return Response.status(Status.NOT_FOUND).entity(user).build();
	  }*/
	/*
	@PUT
 	@Path("/id")
    public Response updatesemploye(Employe c) {

        if (e.updatesemploye(c)) {
        	  return Response.ok().status(Response.Status.ACCEPTED).build();
           // return Response.ok().status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.notModified().build();
        }           
    }*/
}
