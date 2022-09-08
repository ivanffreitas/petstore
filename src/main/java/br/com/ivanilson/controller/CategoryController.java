package br.com.ivanilson.controller;

import br.com.ivanilson.dto.CategoryDto;
import br.com.ivanilson.service.CategoryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("category")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryController {

    @Inject
    private CategoryService service;

    @GET
    public List<CategoryDto> listar(){
        return this.service.listarCategory();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        try {
            CategoryDto categoryDto = this.service.buscarPorId(id);
            return Response.ok().entity(categoryDto).build();
        } catch (Exception e) {
            return Response.ok(null).build();
        }
    }

    @POST
    public Response incluir(CategoryDto category) throws Exception {
        return Response.ok().entity(this.service.inserir(category)).build();
    }

}
