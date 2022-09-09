package br.com.ivanilson.controller;

import br.com.ivanilson.dto.PetDto;
import br.com.ivanilson.service.PetService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("pet")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PetController {

    @Inject
    private PetService service;

    @GET
    public List<PetDto> listar(){
        return this.service.listarPet();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            PetDto petDto = this.service.buscarPorId(id);
            return Response.ok().entity(petDto).build();
        } catch (Exception e) {
            return Response.ok(null).build();
        }
    }

    @POST
    public Response incluir(PetDto petDto) throws Exception {
        return Response.ok().entity(this.service.inserir(petDto)).build();
    }

    @PUT
    public Response alterar(PetDto petDto) {
        return Response.ok(this.service.alterar(petDto))
                .status(Response.Status.OK).build();
    }
}
