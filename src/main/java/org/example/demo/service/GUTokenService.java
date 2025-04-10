package org.example.demo.service;

import org.example.demo.entity.TokenAPIGuProject;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GUTokenService {

    @PersistenceContext
    private EntityManager em;

    public List<TokenAPIGuProject> findAll() {
        return em.createQuery("SELECT p FROM TokenAPIGuProject p", TokenAPIGuProject.class).getResultList();
    }

    public TokenAPIGuProject findTokenUser(String username, String password) {
        TypedQuery<TokenAPIGuProject> query = em.createQuery("SELECT p FROM TokenAPIGuProject p WHERE p.username =:username AND p.password =:password ",TokenAPIGuProject.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        TokenAPIGuProject user = query.getResultStream().findFirst().orElse(null);
        if (user == null) {
            return null; // User not found
        }else {
            return user;
        }

    }
}