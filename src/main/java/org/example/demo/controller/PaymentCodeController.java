package org.example.demo.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.example.demo.model.PhoenixBankPayoutPaymentCodes;
import org.example.demo.service.BankPayoutPaymentService;

import java.util.List;

@Path("/bank-codes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentCodeController {

    @Inject
    private BankPayoutPaymentService bankPayoutPaymentService;

    @GET
    public List<PhoenixBankPayoutPaymentCodes> getAllProducts() {
        return bankPayoutPaymentService.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        PhoenixBankPayoutPaymentCodes product = bankPayoutPaymentService.findById(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProduct(PhoenixBankPayoutPaymentCodes product) {
        PhoenixBankPayoutPaymentCodes createdProduct = bankPayoutPaymentService.create(product);
        return Response.status(Response.Status.CREATED).entity(createdProduct).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, PhoenixBankPayoutPaymentCodes product) {
        product.setId(id);
        PhoenixBankPayoutPaymentCodes updatedProduct = bankPayoutPaymentService.update(product);
        return Response.ok(updatedProduct).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        bankPayoutPaymentService.delete(id);
        return Response.noContent().build();
    }
}
