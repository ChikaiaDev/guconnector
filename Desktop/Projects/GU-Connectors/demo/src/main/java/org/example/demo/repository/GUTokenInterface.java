package org.example.demo.repository;

import org.example.demo.entity.TokenAPIGuProject;

import javax.ws.rs.ext.Provider;
import java.util.List;

@Provider
public interface GUTokenInterface {
    public TokenAPIGuProject findTokenUser(String username, String password);
    public List<TokenAPIGuProject> findAll();
    public String login(String username, String password);
    public TokenAPIGuProject findUser(String username);
}
