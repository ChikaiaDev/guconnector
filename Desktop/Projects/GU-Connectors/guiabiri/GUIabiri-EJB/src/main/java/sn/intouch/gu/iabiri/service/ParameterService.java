package sn.intouch.gu.iabiri.service;

import javax.ejb.Remote;

import sn.intouch.gu.iabiri.entities.Parametre;

@Remote
public interface ParameterService {

	public int nextValue(String code);

	public int getValue(String code);

	public Parametre getParameterByCode(String code);

	public int setValue(String code, String value);

	public String getStringValue(String code);
	
	public Parametre getParameterByLabelleAndCodeNetworkGroup(String label, String codeNetworkGroup);
	
	public void save(Parametre p);

}
