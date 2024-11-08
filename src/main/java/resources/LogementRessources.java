package resources;

import entities.Logement;
import filtres.Secured;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/lb")
public class LogementRessources {


    public static LogementBusiness logB=new LogementBusiness();

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addLog(Logement log){
        if (logB.addLogement(log))
            return  Response.status(Response.Status.CREATED).build();
        return  Response.status(Response.Status.NOT_FOUND).build();

    }

   // @GET
 //   @Consumes(MediaType.APPLICATION_XML)
    //consumes ki taadi haja
    //produces pour afficher des donnes
  /*  public List<Logement> getLogs() {
        return logB.getLogements();


        */
/* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogs(){
         if (logB.getLogements()!=null)
             return  Response.status(Response.Status.NOT_FOUND)
                     .entity(logB.getLogements()) //entity pour afficher un obj  avec la response
                     .build();
         return  Response.status(Response.Status.FOUND).build();
        }*/
   public Response getLogs() {

       return Response.status(Response.Status.OK)
               .entity(logB.getLogements()) //entity pour afficher un obj  avec la response
               .build();
   }
    @Secured
    @GET
    //on  ajout un path pour eviter le  conflit
    //@Path("search") avec ce path pas bonne methode car le client ne connait pas cette path: solution on fusion les 2 methode (et supprume  une des methodes)
    //et aussi pour ne pas surcharge la doculentation
    @Produces(MediaType.APPLICATION_JSON)
    //2 status  donc il faut une  condiditon
    //@QuerryParam:pour afficher dans le recherche
    public Response getLogByDel(@QueryParam("delegation") String deleg){

        if (deleg==null)


        return Response.status(Response.Status.OK)
                .entity(logB.getLogements()) //entity pour afficher un obj  avec la response
                .build();

        return  Response.status(Response.Status.OK)
                .entity(logB.getLogementsByDeleguation(deleg))
                .build();
    }


    @DELETE
    //PathParam=>ajout @Path
    //passer{ref} pour afficher le ref de lobjet
    @Path("/{ref}")
    public Response deleteByRef(@PathParam("ref") int ref)
    {
        if (logB.deleteLogement(ref))
            return Response.ok().build();
        return  Response.status(Response.Status.FOUND).build();
    }
    //response par defaut est OK
    }


