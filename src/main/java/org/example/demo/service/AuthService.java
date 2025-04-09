package org.example.demo.service;

import org.example.demo.config.SimpleJwtUtil;
import org.example.demo.entity.TokenAPIGuProject;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AuthService {

    @PersistenceContext
    private EntityManager em;

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

    public boolean validateToken(String token) {
        return ValidateTokenService.validateToken(token);
    }

    public String getUsernameFromToken(String token) {
        return SimpleJwtUtil.getUsernameFromToken(token);
    }
}
