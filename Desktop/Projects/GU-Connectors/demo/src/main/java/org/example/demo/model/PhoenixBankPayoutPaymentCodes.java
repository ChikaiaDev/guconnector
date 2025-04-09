package org.example.demo.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "phoenix_bank_payment_codes")
public class PhoenixBankPayoutPaymentCodes implements Serializable {
    public static final long serialVersionUID = 1L;
    private long id;
    private String service;
    private String paymentCode;

    public PhoenixBankPayoutPaymentCodes() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Column(name = "payment_code")
    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public String toString() {
        return "PhoenixBankPayoutPaymentCodes{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", paymentCode='" + paymentCode + '\'' +
                '}';
    }
}
