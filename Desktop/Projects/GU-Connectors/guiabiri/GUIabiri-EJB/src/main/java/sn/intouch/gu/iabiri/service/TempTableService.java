package sn.intouch.gu.iabiri.service;

import java.util.List;

import sn.intouch.gu.iabiri.entities.TempTable;

public interface TempTableService {

	public void saveStatus(TempTable tempTable);
	public List<TempTable> getTransByStatusAndService(String code, String service);
	public List<TempTable> getTransByStatus(String status);
	public TempTable getStatusByToken(String token);
	public void removeTempTrans(TempTable s);

}
