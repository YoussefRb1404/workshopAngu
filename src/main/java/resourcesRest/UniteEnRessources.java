package resourcesRest;

import entities.UniteEnseignement;
import filtres.Secured;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("UE")
public class UniteEnRessources {
    public static UniteEnseignementBusiness ueb= new UniteEnseignementBusiness();


    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response addUniteEnseignement(UniteEnseignement ue) {
        if(ueb.addUniteEnseignement(ue))
            return Response.status(Response.Status.CREATED).build();
            return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUE(@QueryParam("semestre") String semestre,
                          @QueryParam("code") String code) {


        if (semestre == null && code == null) {
            List<UniteEnseignement> liste = ueb.getListeUE();
            if (liste.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            return Response.status(Response.Status.OK).entity(liste).build();
        }


        if (semestre != null && code == null) {
            List<UniteEnseignement> liste = ueb.getUEBySemestre(Integer.parseInt(semestre));
            if (liste.isEmpty()) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            return Response.status(Response.Status.OK).entity(liste).build();
        }


        if (code != null) {
            UniteEnseignement ue = ueb.getUEByCode(Integer.parseInt(code));
            if (ue == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.status(Response.Status.OK).entity(ue).build();
        }

        // Si jamais les deux sont fournis en même temps → Bad Request
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUE(@PathParam("id") int id) {
        boolean deleted = ueb.deleteUniteEnseignement(id);

        if (deleted) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @PUT
    @Path("/{code}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response modifierUE(@PathParam("code") int code, UniteEnseignement ue) {
        boolean updated = ueb.updateUniteEnseignement(code, ue);

        if (updated) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }






}
