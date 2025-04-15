package sn.intouch.gu.iabiri.ws.utils;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import sn.intouch.gu.iabiri.service.ParameterService;
import sn.intouch.gu.iabiri.utils.EJBRegistry;
import sn.intouch.gu.iabiri.utils.JNDIUtils;

public class StarterHttpClient {
	private static Logger LOGGER = Logger.getLogger(StarterHttpClient.class);
	private static ParameterService parametreService = (ParameterService) JNDIUtils.lookUpEJB(EJBRegistry.ParameterServiceBean);
	private static final Gson GSON = new Gson();

	/*
	Here is where we write code to connect to external partners
	Jibambe!!
	 */

}
