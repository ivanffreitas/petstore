package br.com.ivanilson.controller;

import br.com.ivanilson.dto.StoreDto;
import br.com.ivanilson.service.StoreService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("store")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StoreController {

    @Inject
    private StoreService service;


    @GET
    public List<StoreDto> listar(){
        return this.service.listarStore();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            StoreDto storeDto = this.service.buscarPorId(id);
            return Response.ok().entity(storeDto).build();
        } catch (Exception e) {
            return Response.ok(null).build();
        }
    }

    @POST
    public Response incluir(StoreDto storeDto) throws Exception {
        return Response.ok().entity(this.service.inserir(storeDto)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Integer id) {
        boolean excluir = this.service.excluir(id);
        return Response.ok(excluir).status(Response.Status.OK).build();
    }
}
