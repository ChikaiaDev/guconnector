package sn.intouch.gu.iabiri.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.intouch.gu.iabiri.entities.SalePoint;

@Stateless
public class SalePointServiceBean implements SalePointService {

	private static final Logger LOG = Logger.getLogger(SalePointServiceBean.class.getName());

	/**
	 * Session Bean implementation class SalePointServiceBean
	 */
	@PersistenceContext(unitName = "guIabiriPU")
	EntityManager em;

	@Resource
	SessionContext session;

	/**
	 * Default constructor.
	 */
	public SalePointServiceBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SalePoint getSalePointByCode(String code) {
		SalePoint salePoint = null;
		List<SalePoint> salepoints = new ArrayList<SalePoint>();
		try {
			Query query = em.createQuery("from SalePoint s where s.supprime = false and s.salepoint_code = :code");
			salepoints = query.setParameter("code", code).getResultList();
			if (salepoints != null) {
				if (!salepoints.isEmpty()) {
					salePoint = salepoints.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salePoint;

	}

}
