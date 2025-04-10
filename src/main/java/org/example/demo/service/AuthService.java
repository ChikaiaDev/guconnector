package org.example.demo.service;

import com.google.gson.JsonObject;
import org.example.demo.config.SimpleJwtUtil;
import org.example.demo.entity.TokenAPIGuProject;
import org.example.demo.util.HttpStatus;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Base64;
import java.util.List;

@Stateless
public class AuthService {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private GUTokenService guTokenService;

    public String registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        // Check if user exists
        TypedQuery<TokenAPIGuProject> query = em.createNamedQuery("TokenAPIGuProject.findByUsername", TokenAPIGuProject.class);
        query.setParameter("username", username);

        if (!query.getResultList().isEmpty()) {
            throw new IllegalStateException("Username already exists");
        }

        // Generate and return token
        return SimpleJwtUtil.generateToken(username);
    }

    public String authenticate(String username, String password) {
        TypedQuery<TokenAPIGuProject> query = em.createNamedQuery("TokenAPIGuProject.findByUsernameAndPassword", TokenAPIGuProject.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        TokenAPIGuProject user = query.getResultStream().findFirst().orElse(null);
        if (user == null) {
            return null; // User not found
        }
        return SimpleJwtUtil.generateToken(username);


    }

    public JsonObject validateToken(String token) {
        JsonObject response = new JsonObject();
        boolean validToken = false;

        response.addProperty("validity", validToken);
        response.addProperty("error", "Invalid token");
        response.addProperty("errorCode", HttpStatus.UNAUTHORIZED.getCode());
        response.addProperty("message", "The token is either expired or invalid");

        try {


            byte[] decryptedToken = Base64.getDecoder().decode(token);
            String decryptedAuth = new String(decryptedToken);

            String[] auth = decryptedAuth.split(":");

            System.out.println(auth[0]);
            System.out.println(auth[1]);


            List<TokenAPIGuProject> tokenLists = guTokenService.findAll();

            for (TokenAPIGuProject guProject : tokenLists) {
                if (guProject.getUsername().equalsIgnoreCase(auth[0]) && guProject.getPassword().equalsIgnoreCase(auth[1])) {
                    response.addProperty("validity", true);
                    response.addProperty("error", "Valid token");
                    response.addProperty("errorCode", HttpStatus.OK.getCode());
                    response.addProperty("message", "Valid token");
                    break;
                }
            }
            return response;
        }catch (Exception e) {

            return response;
        }

    }

    public String getUsernameFromToken(String token) {
        return SimpleJwtUtil.getUsernameFromToken(token);
    }
}
