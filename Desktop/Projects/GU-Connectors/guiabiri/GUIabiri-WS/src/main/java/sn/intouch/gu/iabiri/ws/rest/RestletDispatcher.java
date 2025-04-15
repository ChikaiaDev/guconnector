package sn.intouch.gu.iabiri.ws.rest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.engine.Engine;
import org.restlet.engine.application.CorsFilter;
import org.restlet.ext.gson.GsonConverter;
import org.restlet.routing.Router;
import org.restlet.routing.Template;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;

import sn.intouch.gu.iabiri.entities.TokenAPIGuProject;
import sn.intouch.gu.iabiri.service.TokenAPIService;
import sn.intouch.gu.iabiri.utils.EJBRegistry;
import sn.intouch.gu.iabiri.utils.JNDIUtils;


public class RestletDispatcher extends Application {

	@Override
	public synchronized Restlet createInboundRoot() {

		TokenAPIService tokenService = (TokenAPIService) JNDIUtils.lookUpEJB(EJBRegistry.TokenAPIServiceBean);


		// Guard the restlet with BASIC authentication.
		ChallengeAuthenticator guard = new ChallengeAuthenticator(null, ChallengeScheme.HTTP_BASIC, "testRealm");
		// Instantiates a Verifier of identifier/secret couples based on a
		// simple Map.
		MapVerifier mapVerifier = new MapVerifier();
		// Load a single static login/secret pair.
		List<TokenAPIGuProject> tokensAPI = tokenService.listTokenAPI();
		for (TokenAPIGuProject t : tokensAPI) {
			mapVerifier.getLocalSecrets().putIfAbsent(t.getUsername(), t.getPassword().toCharArray());
		}
		guard.setVerifier(mapVerifier);


		// Create a router Restlet that routes each call to a
		Router router = new Router(getContext());
		CorsFilter corsFilter = new CorsFilter(getContext(), router);
		corsFilter.setAllowedOrigins(new HashSet<String>(Arrays.asList("*")));
		corsFilter.setAllowedCredentials(true);

		router.setDefaultMatchingMode(Template.MODE_EQUALS);
		Engine.getInstance().getRegisteredConverters().add(new GsonConverter());

//		router.attach("/utility_lookup", UtilityLookup.class);
//		router.attach("/utility_request/{codeService}/{receiverMsisdn}/{amount}", UtilityRequest.class);
//		router.attach("/payment_status", PaymentStatus.class);
//		router.attach("/monitoring", MonitoringService.class);
//		router.attach("/getData", GetSelcomData.class);
//		router.attach("/setData", SetSelcomData.class);

		//CICO
//		router.attach("/cashin/{codeService}/{receiverMsisdn}/{amount}", SelcomCashIn.class);
//		router.attach("/cashout/{codeService}/{receiverMsisdn}/{amount}", SelcomCashOut.class);

		
		
		guard.setNext(router);
		return guard;

	}
}