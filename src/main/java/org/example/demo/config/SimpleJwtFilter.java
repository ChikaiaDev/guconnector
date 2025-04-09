package org.example.demo.config;

import org.example.demo.service.AuthService;
import org.example.demo.service.BankPayoutPaymentService;
import org.example.demo.service.GUTokenService;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class SimpleJwtFilter implements ContainerRequestFilter {

    private static final String AUTH_HEADER_PREFIX = "Basic ";

    @Inject
    private AuthService authService;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Skip auth for login and register endpoints
        if (requestContext.getUriInfo().getPath().contains("auth")) {
            return;
        }

        // Get Authorization header
        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate header format
        if (authHeader == null || !authHeader.startsWith(AUTH_HEADER_PREFIX)) {
            abortWithUnauthorized(requestContext, "Missing or invalid Authorization header");
            return;
        }

        // Extract token
        String token = authHeader.substring(AUTH_HEADER_PREFIX.length()).trim();

        // Validate token
        if (!authService.validateToken(token)) {
            abortWithUnauthorized(requestContext, "Invalid JWT token");
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext context, String message) {
        context.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity(message)
                        .build());
    }
}