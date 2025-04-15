package sn.intouch.gu.iabiri.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.intouch.gu.iabiri.entities.TokenAPIGuProject;


@Stateless
public class TokenAPIServiceBean implements TokenAPIService {

	@PersistenceContext(unitName = "guIabiriPU")
	EntityManager em;

	@Override
	public TokenAPIGuProject getTokenByPartenaire(String partner_id) {
		List<TokenAPIGuProject> tokensAPI = new ArrayList<TokenAPIGuProject>();
		try {
			Query query = em.createQuery("from TokenAPIGuProject t where t.partner_id=:partnerId and t.supprime = false ");
			query.setParameter("partnerId", partner_id);
			tokensAPI = (List<TokenAPIGuProject>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

		return (!tokensAPI.isEmpty() && tokensAPI != null) ? tokensAPI.get(0) : null;
	}

	@Override
	public List<TokenAPIGuProject> listTokenAPI() {
		List<TokenAPIGuProject> tokensAPI = new ArrayList<TokenAPIGuProject>();
		try {
			Query query = em.createQuery("from TokenAPIGuProject t where t.supprime = false ");
			tokensAPI = query.getResultList();
		} catch (Exception e) {
		}
		return tokensAPI;
	}

}
