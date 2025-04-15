package sn.intouch.gu.iabiri.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sn.intouch.gu.iabiri.entities.TempTable;

@Stateless
public class TempTableServiceBean implements TempTableService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TempTableServiceBean.class);

	@PersistenceContext(unitName = "guIabiriPU")
	EntityManager em;

	@Override
	public void saveStatus(TempTable tempTable) {
		em.merge(tempTable);
	}

	@Override
	public List<TempTable> getTransByStatusAndService(String code, String service) {
		try {
			Query query = em.createQuery("SELECT p FROM TempTable p WHERE p.statusTr = :status and p.service= :service");
			query.setParameter("status", code);
			query.setParameter("service", service);
			return (List<TempTable>) query.getResultList();
		} catch (Exception e) {
			LOGGER.error("### EXCEPTION CAUGHT WHILE GETTING TEMP TABLE - ", e);
			return null;
		}

	}

	@Override
	public TempTable getStatusByToken(String token) {
		TempTable tempTransaction = null;
		try {
			Query query = em.createQuery("SELECT p FROM TempTable p WHERE p.token = :token ");
			query.setParameter("token", token);
			List<TempTable> list = (List<TempTable>) query.getResultList();
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}else{
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("### EXCEPTION CAUGHT WHILE GETTING TEMP TABLE - ", e);
			return null;
		}
	}

	@Override
	public List<TempTable> getTransByStatus(String status) {
		try {
			Query query = em.createQuery("SELECT p FROM TempTable p WHERE p.statusTr = :status ");
			query.setParameter("status", status);
			return (List<TempTable>) query.getResultList();
		} catch (Exception e) {
			LOGGER.error("### EXCEPTION CAUGHT WHILE GETTING TEMP TABLE - ", e);
			return null;
		}
	}

	@Override
	public void removeTempTrans(TempTable tempTransaction) throws IllegalStateException {
		try {
			if (tempTransaction != null && tempTransaction.getId() != null) {
				Query query = em.createQuery("DELETE FROM TempTable g WHERE g.id = :id");
				query.setParameter("id", tempTransaction.getId());
				query.executeUpdate();
			}
		}catch (Exception exception){
			LOGGER.error("### EXCEPTION CAUGHT WHILE DELETING TEMP TABLE - ", exception);

		}
	}


}
