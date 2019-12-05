package tn.esprit.pidev.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pidev.managedbeans.EvaluationBean;

@Path("users")
@RequestScoped
public class EvaluationRessource {
@EJB
EvaluationBean metier;
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getall() {
	return Response.ok(metier.getEvaluations()).build();
	
}
}
