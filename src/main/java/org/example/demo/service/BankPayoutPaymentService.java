package org.example.demo.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.example.demo.model.PhoenixBankPayoutPaymentCodes;
import org.example.demo.model.Product;

import java.util.List;

@Stateless
public class BankPayoutPaymentService {

    @PersistenceContext
    private EntityManager em;

    public PhoenixBankPayoutPaymentCodes create(PhoenixBankPayoutPaymentCodes payoutPaymentCode) {
        em.persist(payoutPaymentCode);
        return payoutPaymentCode;
    }

    public PhoenixBankPayoutPaymentCodes update(PhoenixBankPayoutPaymentCodes payoutPaymentCode) {
        return em.merge(payoutPaymentCode);
    }

    public void delete(Long id) {
        PhoenixBankPayoutPaymentCodes payoutPaymentCode = em.find(PhoenixBankPayoutPaymentCodes.class, id);
        if (payoutPaymentCode != null) {
            em.remove(payoutPaymentCode);
        }
    }

    public PhoenixBankPayoutPaymentCodes findById(Long id) {
        return em.find(PhoenixBankPayoutPaymentCodes.class, id);
    }

    public List<PhoenixBankPayoutPaymentCodes> findAll() {
        return em.createQuery("SELECT p FROM PhoenixBankPayoutPaymentCodes p", PhoenixBankPayoutPaymentCodes.class).getResultList();
    }
}