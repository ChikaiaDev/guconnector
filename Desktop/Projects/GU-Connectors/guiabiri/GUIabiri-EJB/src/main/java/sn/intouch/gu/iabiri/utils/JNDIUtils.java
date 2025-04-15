package sn.intouch.gu.iabiri.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIUtils {

	private JNDIUtils() {
		super();
	}

	public static Object lookUpEJB(EJBRegistry ejbRegistry) {
		try {
			InitialContext initialContext = new InitialContext();
			return initialContext.lookup("java:app/GUSelcom-EJB/" + ejbRegistry.name());
		} catch (NamingException e) {
			MyLOG.log(e);
		}
		return null;
	}
}
