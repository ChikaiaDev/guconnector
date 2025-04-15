package sn.intouch.gu.iabiri.service;

import javax.ejb.Remote;

import sn.intouch.gu.iabiri.entities.MoteurTemp;

@Remote
public interface MoteurTempService {

	public void saveTempId(MoteurTemp moteurTemp);

}
