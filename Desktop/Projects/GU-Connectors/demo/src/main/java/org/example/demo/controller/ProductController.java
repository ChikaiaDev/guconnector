package org.example.demo.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.example.demo.model.Product;
import org.example.demo.service.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductService productService;

    @GET
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProduct(Product product) {
        Product createdProduct = productService.create(product);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        product.setId(id);
        Product updatedProduct = productService.update(product);
        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        productService.delete(id);
        return Response.noContent().build();
    }
}
