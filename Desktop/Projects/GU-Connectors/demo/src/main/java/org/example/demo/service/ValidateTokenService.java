package org.example.demo.service;

import org.example.demo.entity.TokenAPIGuProject;

import javax.inject.Inject;
import javax.ws.rs.ext.Provider;
import java.util.Base64;

@Provider
public class ValidateTokenService {

    static GUTokenService guTokenService = new GUTokenService();

    public static boolean validateToken(String token){
        byte [] decryptedToken = Base64.getDecoder().decode(token);
        String  decryptedAuth = new String(decryptedToken);

        String [] auth = decryptedAuth.split(":");

        System.out.println(auth[0]);
        System.out.println(auth[1]);

        TokenAPIGuProject guProject = guTokenService.findTokenUser(auth[0],auth[1]);

        if(guProject !=null){
            return true;
        }else {
            return false;
        }
    }
}
