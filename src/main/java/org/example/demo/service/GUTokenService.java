package org.example.demo.service;

import org.apache.log4j.Logger;
import org.example.demo.config.SimpleJwtUtil;
import org.example.demo.entity.TokenAPIGuProject;
import org.example.demo.model.PhoenixBankPayoutPaymentCodes;
import org.example.demo.repository.GUTokenInterface;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GUTokenService implements GUTokenInterface {

    @PersistenceContext(unitName = "guDemo")
    static EntityManager em;
    private static final Logger LOGGER= Logger.getLogger(GUTokenService.class);

    public List<TokenAPIGuProject> findAll() {
        return em.createQuery("SELECT p FROM TokenAPIGuProject p", TokenAPIGuProject.class).getResultList();
    }

    public String login(String username, String password) {
        TokenAPIGuProject user = findUser(username);
        if (user != null) {
            return SimpleJwtUtil.generateToken(username);
        }
        return null;
    }

    public TokenAPIGuProject findUser(String username) {
        TypedQuery<TokenAPIGuProject> query = em.createQuery(
                "SELECT u FROM TokenAPIGuProject u WHERE u.username = :username ", TokenAPIGuProject.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst().orElse(null);
    }

    public TokenAPIGuProject findTokenUser(String username, String password) {
        TokenAPIGuProject tokenAPIGuProject = null ;
        List<TokenAPIGuProject> tokenAPIGuProjectList = new ArrayList<TokenAPIGuProject>();
        try {
            Query query = em.createQuery("SELECT p FROM TokenAPIGuProject p WHERE p.username = :username and p.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);

            tokenAPIGuProjectList = query.getResultList();


            if (!tokenAPIGuProjectList.isEmpty()) {
                System.out.println("jjfjf");
                tokenAPIGuProject =tokenAPIGuProjectList.get(0);
            }

            return tokenAPIGuProject;
        }catch (Exception exception){
            LOGGER.error(exception);
            return null;
        }

    }

}