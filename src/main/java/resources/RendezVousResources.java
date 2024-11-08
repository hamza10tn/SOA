package resources;

import entities.Logement;
import metiers.LogementBusiness;

import javax.validation.constraints.Max;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logements")
public class RendezVousResources {
    public LogementBusiness lb=new LogementBusiness();


    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Logement> getAllLog(){
        return lb.getLogements();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
   // @Produces(MediaType.TEXT_PLAIN) car void
    //Response:a la place de void(pour retour un msg)
    public void addLog(Logement log){
        lb.addLogement(log);
    }





}
