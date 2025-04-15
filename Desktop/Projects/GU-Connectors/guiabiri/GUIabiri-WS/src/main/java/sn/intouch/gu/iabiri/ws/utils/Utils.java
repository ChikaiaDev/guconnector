package sn.intouch.gu.iabiri.ws.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.log4j.Logger;

import sn.intouch.gu.iabiri.entities.Parametre;
import sn.intouch.gu.iabiri.service.ParameterService;
import sn.intouch.gu.iabiri.utils.EJBRegistry;
import sn.intouch.gu.iabiri.utils.JNDIUtils;
import sn.intouch.gu.iabiri.ws.models.TransactionExchange;
import sn.intouch.gu.iabiri.ws.models.gucore.ModelMonitoringApp;

public class Utils {
	private static final Logger LOGGER = Logger.getLogger(Utils.class);
	static final ParameterService parameterService = (ParameterService) JNDIUtils.lookUpEJB(EJBRegistry.ParameterServiceBean);
	public static Date getEnDateTime(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = formatter.parse(str);
			return date;

		} catch (ParseException e) {

			return null;

		}
	}

	public static String getEnDate(Date date) {
		String d = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return d;
	}

	private static String chars = "1234567890";
	private static int charLength = chars.length();

	public static String generateString(int length) {
		StringBuilder pass = new StringBuilder(charLength);
		for (int x = 0; x < length; x++) {
			int i = (int) (Math.random() * charLength);
			pass.append(chars.charAt(i));
		}
		return pass.toString();
	}

	public static String getCommonProperty(String property) {
		Properties props = new Properties();
		try {
			props.load(Utils.class.getResourceAsStream("/common.properties"));
		} catch (IOException e) {
			return null;
		}
		return props.getProperty(property);
	}

	public static String getSettingsProperty(String property) {
		InputStream settingsStream = Utils.class.getClassLoader().getResourceAsStream("settings.properties");

		Properties props = new Properties();
		try {
			props.load(settingsStream);
		} catch (IOException e) {
			return null;
		}
		return props.getProperty(property);
	}

	public static Date getDateFromOmId(String omId) {
		if (omId != null) {
			String strs[] = omId.split(".");

			// Annee
			String year = omId.substring(2, 4);
			String month = omId.substring(4, 6);
			String day = omId.substring(6, 8);
			String hour = omId.substring(9, 11);
			String minute = omId.substring(11, 13);

			SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

			try {
				Date date = formatter.parse(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + "00");
				return date;

			} catch (ParseException e) {

				return null;

			}
		} else
			return null;
	}
	public static boolean isDateValid(String date) {
		try {
			SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
			sdformat.setLenient(false);
			sdformat.parse(date);
			return true;
		} catch (ParseException e) {
			LOGGER.error("Date d'echeance invalide", e);
			e.printStackTrace();
			return false;
		}
	}

	
	public static String getMD5(String key) throws NoSuchAlgorithmException {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}
	/**
	 * Decoder Base 64
	 * @param string
	 * @return
	 */
	public static String decodeBase64(String string){
		byte[] valueDecoded= Base64.decodeBase64(string.getBytes() );
		return new String(valueDecoded);
	}
	/**
	 * Crytage SHA 512
	 * @param input
	 * @return
	 */
	public static String encryptThisString(String input) { 
        try { 
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
	/**
	 * Encodage Base 64
	 * @param string
	 * @return
	 */
	public static String encodeBase64(String string){
		byte[] valueDecoded= Base64.encodeBase64(string.getBytes() );
		return new String(valueDecoded);
	}
	
	/**
	 * Methode pour le calcul du jeton
	 * @param text
	 * @return
	 */
	public static String calculJeton(String text) { 
		//return Base64.getEncoder().encodeToString(encryptThisString(text));
		return encodeBase64(encryptThisString(text));
	}
	
	public static String getToken(TransactionExchange te) {
		 String requuestId = te.getToken()+"";
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss");
		 Date date = new Date();
		 String requestDate = formatter.format(date);
		 Parametre parametre = parameterService.getParameterByCode("COFINA_PARTNER_ID");
		 String partnerId = parametre.getPrmStringValue();
		 String serviceId = te.getServiceExchange().getInfosSup().get("serviceId");
		 
		 String tokenClair = requuestId+":"+requestDate+":"+partnerId+":"+serviceId;
		 
		
		 return calculJeton(tokenClair);
	 }
	
	public static CloseableHttpClient createHttpClientAcceptsUntrustedCerts()
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		HttpClientBuilder b = HttpClientBuilder.create();

		// setup a Trust Strategy that allows all certificates.
		//
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				return true;
			}
		}).build();
		b.setSslcontext(sslContext);

		// don't check Hostnames, either.
		// -- use SSLConnectionSocketFactory.getDefaultHostnameVerifier(), if you don't
		// want to weaken
		HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

		// here's the special part:
		// -- need to create an SSL Socket Factory, to use our weakened "trust
		// strategy";
		// -- and create a Registry, to register it.
		//
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext,
				(X509HostnameVerifier) hostnameVerifier);
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sslSocketFactory)
				.build();

		// now, we create connection-manager using our Registry.
		// -- allows multi-threaded use
		PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		b.setConnectionManager(connMgr);

		// finally, build the HttpClient;
		// -- done!
		CloseableHttpClient client = b.build();
		return client;
	}
	
	public static Long diffDateMillisSeconds(Date date1, Date date2) {
		long date=0L;
		try {
			if (date1 != null && date2 != null) {
				date  = (TimeUnit.MILLISECONDS.toMillis((date2.getTime() - date1.getTime())));
			} else {
				date = 0L;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;

	}


	public static void sendMonitoring(String errorCode,String errorMessage,String context,Exception e, Date dateDebut, Date dateFin) {
		try {
			String stackTrace=null;
			ModelMonitoringApp modelMonitoringApp= new ModelMonitoringApp();
			modelMonitoringApp.setErrorCode(errorCode);
			modelMonitoringApp.setErrorMessage(errorMessage);
			modelMonitoringApp.setTransactionRequest(null);
			modelMonitoringApp.setIpAddress("");
			if (e != null) {
				stackTrace = ExceptionUtils.getStackTrace(e);
			}
			modelMonitoringApp.setStacktrace(stackTrace);
			
			Parametre envParam = parameterService.getParameterByCode("ENVIRONNMENT_PARAM");
			String env = envParam != null ? envParam.getPrmStringValue() : "WL_HT";
			modelMonitoringApp.setSource(env);
			modelMonitoringApp.setDate(new Date().getTime());
			modelMonitoringApp.setResponseDuration(diffDateMillisSeconds(dateDebut, dateFin));
			modelMonitoringApp.setContext(context);
			modelMonitoringApp.setUrl(context);
			modelMonitoringApp.setIdProcess("");
			modelMonitoringApp.setIdError("1");
			modelMonitoringApp.setTypeOfError("1");
			modelMonitoringApp.setDescriptionError("Unstable link between Core GU and partner connector");
			modelMonitoringApp.setProjectName("GUCMECOBANKCBCINETPAY");
			ConnectionMonitoringRequest.sendRseponseMonitoring(modelMonitoringApp);
		} catch (Exception e1) {
			// TODO: handle exception
			LOGGER.info(""+e1);
			LOGGER.info("###ERROR "+e1.getMessage());
		}
		
	}	
	

}
