package br.com.ivanilson.controller;

import br.com.ivanilson.dto.UserDto;
import br.com.ivanilson.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService service;

    @GET
    public List<UserDto> listar(){
        return this.service.listarUser();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            UserDto userDto = this.service.buscarPorId(id);
            return Response.ok().entity(userDto).build();
        } catch (Exception e) {
            return Response.ok(null).build();
        }
    }

    @POST
    public Response incluir(UserDto produto) throws Exception {
        return Response.ok().entity(this.service.inserir(produto)).build();
    }

    @PUT
    public Response alterar(UserDto userDto) {
        return Response.ok(this.service.alterar(userDto))
                .status(Response.Status.OK).build();
    }

}
