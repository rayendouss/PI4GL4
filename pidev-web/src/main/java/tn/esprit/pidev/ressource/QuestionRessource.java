package tn.esprit.pidev.ressource;

import java.util.ArrayList;
import java.util.List;

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

import tn.esprit.pidev.entity.Question;
import tn.esprit.pidev.service.impl.QuestionService;

@Path("quetion")
@RequestScoped
public class QuestionRessource {

	@EJB
	QuestionService questionservice;
	
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTimesheet() {
		List<Question> list = new ArrayList<>();
		list = questionservice.getAllQuestion();
		return Response.status(Status.FOUND).entity(list).build();

	}

	@DELETE
	  @Path("{id}")
	  public Response deleteModules(@PathParam(value="id")int id)
	  {
		questionservice.deleteQuestionById(id);
	  return Response.status(Status.ACCEPTED).build();}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ClockOut(Question r){
		questionservice.updateQuestion(r);
		return Response.status(Status.OK).entity("ClockOut").build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addQuestion(Question d) {
		if (d != null) {
			int i = questionservice.ajouterQuestion(d);
		}
		return Response.status(Status.CREATED).entity("ok").build();
	}
	

}
	
	
