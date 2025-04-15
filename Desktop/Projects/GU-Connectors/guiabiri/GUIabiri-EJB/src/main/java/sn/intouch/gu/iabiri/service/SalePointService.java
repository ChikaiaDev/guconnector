package sn.intouch.gu.iabiri.service;

import javax.ejb.Remote;

import sn.intouch.gu.iabiri.entities.SalePoint;

@Remote
public interface SalePointService {

	public SalePoint getSalePointByCode(String code);

}
