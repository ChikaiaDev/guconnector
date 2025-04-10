package org.example.demo.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.demo.service.AuthService;
import org.example.demo.service.BankPayoutPaymentService;
import org.example.demo.service.GUTokenService;
import org.example.demo.util.HttpStatus;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.http.HttpResponse;

@Provider
public class SimpleJwtFilter implements ContainerRequestFilter {

    private static final String AUTH_HEADER_PREFIX = "Basic ";
    Gson GSON = new Gson();
    @Inject
    private AuthService authService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        JsonObject validAuthTokenResponse =  new JsonObject();

        // Skip auth for login and register endpoints
        if (requestContext.getUriInfo().getPath().contains("auth")) {
            return;
        }

        // Get Authorization header
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate header format
        if (authHeader == null || !authHeader.startsWith(AUTH_HEADER_PREFIX)) {
            validAuthTokenResponse.addProperty("validity", false);
            validAuthTokenResponse.addProperty("error", "Unauthorized");
            validAuthTokenResponse.addProperty("errorCode", HttpStatus.UNAUTHORIZED.getCode());
            validAuthTokenResponse.addProperty("message", "Missing or invalid Authorization header");

            abortWithUnauthorized(requestContext, validAuthTokenResponse);
            return;
        }

        // Extract token
        String token = authHeader.substring(AUTH_HEADER_PREFIX.length()).trim();
        validAuthTokenResponse = authService.validateToken(token);


        // Validate token
        if (!validAuthTokenResponse.get("validity").getAsBoolean()) {
            abortWithUnauthorized(requestContext, validAuthTokenResponse);
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext context, String message) {
        context.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity(message)
                        .build());
    }

    private void abortWithUnauthorized(ContainerRequestContext context, JsonObject message) {
        context.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity(GSON.toJson(message))
                        .build());
    }
}