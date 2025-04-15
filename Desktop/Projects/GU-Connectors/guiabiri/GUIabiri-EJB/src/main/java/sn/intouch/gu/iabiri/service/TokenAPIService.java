package sn.intouch.gu.iabiri.service;

import java.util.List;

import javax.ejb.Remote;

import sn.intouch.gu.iabiri.entities.TokenAPIGuProject;



@Remote
public interface TokenAPIService {
	public TokenAPIGuProject getTokenByPartenaire(String partner_id);

	public List<TokenAPIGuProject> listTokenAPI();
}
