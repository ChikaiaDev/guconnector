package sn.intouch.gu.iabiri.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.intouch.gu.iabiri.entities.MoteurTemp;

@Stateless
public class MoteurTempServiceBean implements MoteurTempService {

	@PersistenceContext(unitName = "guIabiriPU")
	EntityManager em;

	@Override
	public void saveTempId(MoteurTemp moteurTemp) {
		em.persist(moteurTemp);

	}

}
