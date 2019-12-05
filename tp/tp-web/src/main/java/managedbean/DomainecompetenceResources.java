package managedbean;

import javax.ejb.EJB;

import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entites.Domainecompetence;
import entites.Employe;
import impl.Domainecompetenceservice;
import interfaces.Domainecompetenceserviceremote;
import interfaces.Employeserviceremote;


@RequestScoped
@Path("domainecompetence")
public class DomainecompetenceResources {

	@EJB
	Domainecompetenceserviceremote e ;
/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		return Response.ok(e.getAllDomainecompetence()).build();
	}
	*/
	@GET
	@Path("/afficher")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		return Response.ok(e.getAllDomainecompetence()).build();
	}
	/*
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterDomainecompetence(Domainecompetence domainecompetence)
	{  
		System.out.println("hello");
            e.ajouterDomainecompetence(domainecompetence);
		
		return Response.status(Status.OK).entity("employes created:").build();	
	}
	
	*/
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
	
	/*
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response removesemploye(@PathParam("id")int id) {
		 e.removesemploye(id);
		return Response.status(Status.OK).entity("user removed").build();
	}
	
	 @PUT
	  @Path("{cin}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response updatesemploye(@PathParam("cin") int cin, Employe user) {
	  	user.setId(cin);
	  	e.updatesemploye(user);
	  	

	  	return Response.status(Status.NOT_FOUND).entity(user).build();
	  }
	 */
}
