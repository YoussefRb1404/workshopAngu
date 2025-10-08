package resourcesRest;

import entities.Module;
import entities.UniteEnseignement;
import filtres.Secured;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("M")
public class ModuleRessources {
    public static ModuleBusiness mb= new ModuleBusiness();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addModule(Module m) {
        if(mb.addModule(m))
            return Response.status(Response.Status.CREATED).entity(m).type(MediaType.APPLICATION_JSON).build();
            return Response.status(Response.Status.BAD_REQUEST).entity(m).type(MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Path("UE")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModules(@QueryParam("code") Integer code) {
        List<Module> list;

        if (code != null) {
            // Récupérer les modules selon le code de l’unité d’enseignement
            list = new ArrayList<>();
            for (Module m : mb.getListeModules()) {
                if (m.getUniteEnseignement() != null && m.getUniteEnseignement().getCode() == code) {
                    list.add(m);
                }
            }
        } else {
            // Si aucun code n'est fourni, retourner tous les modules
            list = mb.getListeModules();
        }

        if (list == null || list.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(list).build();
    }
    @DELETE
    @Path("/{matricule}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteM(@PathParam("matricule") String matricule) {
        boolean deleted = mb.deleteModule(matricule);

        if (deleted) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{matricule}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierM(@PathParam("matricule") String  matricule, Module m) {
        boolean updated = mb.updateModule(matricule, m);

        if (updated) {
            return Response.status(Response.Status.OK).entity(m).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
