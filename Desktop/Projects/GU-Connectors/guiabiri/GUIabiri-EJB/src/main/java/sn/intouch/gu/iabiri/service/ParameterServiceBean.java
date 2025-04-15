package sn.intouch.gu.iabiri.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.intouch.gu.iabiri.entities.Parametre;

@Stateless
public class ParameterServiceBean implements ParameterService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParameterServiceBean.class);

	@PersistenceContext(unitName = "guIabiriPU")
	EntityManager em;

	@Override
	public int nextValue(String code) {

		Query query = em.createQuery("SELECT p FROM Parametre p WHERE p.prmCode = :code and p.prmStatut = 1  ");
		query.setParameter("code", code);
		Parametre p = (Parametre) query.getSingleResult();

		int i = p.getPrmValue();

		p.setPrmValue(i + 1);
		em.merge(p);

		return i;

	}

	@Override
	public int getValue(String code) {
		List<Parametre> parametreList = new ArrayList<Parametre>();
		try {
			Query query = em.createQuery("SELECT p FROM Parametre p WHERE p.prmCode = :code and p.prmStatut = 1  ");
			query.setParameter("code", code);

			parametreList = query.getResultList();
			if (!parametreList.isEmpty()) {
				return parametreList.get(0).getPrmValue();
			} else {
				return -1;
			}
		}catch (Exception exception){
			LOGGER.error("### ERROR ENCOUNTERED FETCHING PARAMETER VALUE - ", exception);
			return -1;
		}

	}

	@Override
	public Parametre getParameterByCode(String code) {
		Parametre parametre = null ;
		List<Parametre> parametreList = new ArrayList<Parametre>();
		try {
			Query query = em.createQuery("SELECT p FROM Parametre p WHERE p.prmCode = :code and p.prmStatut = 1  ");
			query.setParameter("code", code);

			parametreList = query.getResultList();
			if (!parametreList.isEmpty()) {
				parametre = parametreList.get(0);
			}

			return parametre;
		}catch (Exception exception){
			LOGGER.error("### ERROR ENCOUNTERED FETCHING PARAMETER - ", exception);
			return null;
		}
	}

	@Override
	public int setValue(String code, String value) {
		try {
			Query query = em.createQuery("SELECT p FROM Parametre p WHERE p.prmCode = :code and p.prmStatut = 1  ");
			query.setParameter("code", code);
			Parametre p = (Parametre) query.getSingleResult();

			p.setPrmStringValue(value);
			em.merge(p);

			return 1;
		}catch (Exception exception){
			LOGGER.error("### ERROR ENCOUNTERED SETTING PARAMETER VALUE - ", exception);
			return -1;
		}

	}

	@Override
	public String getStringValue(String code) {
		List<Parametre> listes = new ArrayList<Parametre>();
		Parametre p = new Parametre();
		String s = null;
		try {
			Query query = em.createQuery("SELECT p FROM Parametre p WHERE p.prmCode = :code and p.prmStatut = 1  ");
			query.setParameter("code", code);
			listes = query.getResultList();
			if (!listes.isEmpty()) {
				p = listes.get(0);
				s = p.getPrmStringValue();

			}

			return s;
		}catch (Exception exception){
			LOGGER.error("### ERROR ENCOUNTERED FETCHING PARAMETER STRING VALUE - ", exception);
			return null;
		}
	}

	@Override
	public Parametre getParameterByLabelleAndCodeNetworkGroup(String label, String codeNetworkGroup) {
		Parametre parametre = null;
		try {
			Query query = em.createQuery(
					"SELECT p FROM Parametre p WHERE p.prmLabel = :label and p.networkGroup.network_group_code = :codeNetworkGroup and p.prmStatut = 1  ");
			query.setParameter("label", label);
			query.setParameter("codeNetworkGroup", codeNetworkGroup);
			parametre = (Parametre) query.getSingleResult();
		} catch (Exception e) {
			LOGGER.error("NO PARAMETER WITH THIS LABEL ( " + label + " ) FOUND FOR THE NETWORK GROUP - " + codeNetworkGroup, e);
			return null;
		}

		if (parametre == null) {
			codeNetworkGroup = "GNL";
			try {
				Query query = em.createQuery(
						"SELECT p FROM Parametre p WHERE p.prmLabel = :label and p.networkGroup.network_group_code = :codeNetworkGroup and p.prmStatut = 1  ");
				query.setParameter("label", label);
				query.setParameter("codeNetworkGroup", codeNetworkGroup);
				parametre = (Parametre) query.getSingleResult();
			} catch (Exception e) {
				LOGGER.error("NO PARAMETER WITH THIS LABEL ( " + label + " ) FOUND FOR THE NETWORK GROUP - "  + codeNetworkGroup);
				return null;
			}
		}
		return parametre;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void save(Parametre p) {
		em.persist(p);
	}

}
