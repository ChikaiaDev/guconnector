package sn.intouch.gu.iabiri.ws.utils;

import com.squareup.okhttp.Callback;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import org.apache.log4j.Logger;

import sn.intouch.gu.iabiri.entities.Parametre;
import sn.intouch.gu.iabiri.service.ParameterService;
import sn.intouch.gu.iabiri.utils.EJBRegistry;
import sn.intouch.gu.iabiri.utils.JNDIUtils;
import sn.intouch.gu.iabiri.ws.models.gucore.ModelMonitoringApp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import java.net.Proxy;

public class ConnectionMonitoringRequest {
	
	
	static ParameterService parameterService=(ParameterService) JNDIUtils.lookUpEJB(EJBRegistry.ParameterServiceBean);
	static String login = parameterService.getParameterByCode("CREDENTIAL_LOGIN_PEXO").getPrmStringValue();
	static String pass = parameterService.getParameterByCode("CREDENTIAL_PASS_PEXO").getPrmStringValue();
	private static String auth = login +":"+ pass;
	private static byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
	private static String authHeader = "Basic " + new String(encodedAuth);
	private static Logger LOG = Logger.getLogger(ConnectionMonitoringRequest.class);
	private static final String ERROR_PROXY = "###### Erreur recuperation proxy port et proxy host #####";
	private static final String PROXY_INFO = "##### Using Proxy #####";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";
	private static final String CHARSET = "UTF-8";


	
	public static HttpHost getTarget(String baseUrl) {
		String protocole = baseUrl.split(":")[0];
		String ip = baseUrl.split("//")[1].split(":")[0];
		String portStr = null;
		try {
			portStr = baseUrl.split("//")[1].split(":")[1].split("/")[0];
		} catch (Exception e) {
			LOG.error("[BO CLASSIC]" + e.getMessage());
		}
		Integer port;
		if (portStr != null) {
			port = Integer.valueOf(portStr);
		} else {
			if ("https".equalsIgnoreCase(protocole)) {
				port = 443;
			} else {
				port = 80;
			}
			ip = baseUrl.split("//")[1].split("/")[0];
		}
		return new HttpHost(ip, port, protocole);
	}

	public static void sendRseponseMonitoring(ModelMonitoringApp te) {
		Gson gson = new Gson();
		Parametre paramURL = parameterService.getParameterByCode("PEXO_CONNECTOR_NOTIFICATION_URL");
		try {
			OkHttpClient client = new OkHttpClient();
			LOG.info("### SET AML STARDED ###");
			try {
				if (paramURL != null) {

					String url = paramURL.getPrmStringValue();
					LOG.info(url);
					if (paramURL.getPrmValue() == 1) {

						String proxyPort = null;
						String proxyHost = null;
						try {
							proxyPort = parameterService.getParameterByCode("proxy_port").getPrmStringValue().trim();
							proxyHost = parameterService.getParameterByCode("proxy_host").getPrmStringValue().trim();
						} catch (Exception e) {
							LOG.info("###### Erreur recuperation proxy port et proxy host #####");
						}
						if (proxyHost != null && proxyPort != null) {
							LOG.info("###### USING PROXY #####");
							Proxy proxy = new Proxy(Proxy.Type.HTTP,
									new InetSocketAddress(proxyHost, Integer.valueOf(proxyPort)));
							client.setProxy(proxy);
						}
					}

					MediaType mediaType = MediaType.parse("application/json");
					String data = gson.toJson(te);
					RequestBody body = RequestBody.create(mediaType, data);

					String auth = login + ":" + pass;
					byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("UTF-8")));
					String authHeader = "Basic " + new String(encodedAuth);

					Request request = new Request.Builder().addHeader("Accept", "application/json")
							.addHeader("Content-Type", "application/json").addHeader("Authorization", authHeader)
							.url(url).post(body).build();

					client.newCall(request).enqueue(new Callback() {

						@Override
						public void onFailure(Request arg0, IOException arg1) {
							LOG.info("OnFailure");
							LOG.error("", arg1);
						}

						@Override
						public void onResponse(Response arg0) throws IOException {

							if (!arg0.isSuccessful()) {
								throw new IOException("Unexpected code " + arg0);
							} else {
								LOG.info("OnResponse");
								String repbody = arg0.body().string();
								Integer codeRep = arg0.code();
								LOG.info("Response code: " + codeRep);
								LOG.info("Response Body: " + repbody);
							}

						}

					});

				}

			} catch (Exception e) {
				LOG.error("", e);
			}

			LOG.info("### SET AML ENDED ###");

		} catch (Exception e) {
			LOG.error("", e);
		}

	}
	
	
	
	
	
//	public static ModelMonitoringApp sendRseponseMonitoring(ModelMonitoringApp moni) {
//		String url ="https://dev.gutouch.net/pda/pexo-connector/notification";
//		HttpPost request = new HttpPost(url);
//		ModelMonitoringApp resp = null;
//		HttpClient httpclient= new DefaultHttpClient();
//		try {
//			request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
//			request.addHeader(CONTENT_TYPE, APPLICATION_JSON);
//			StringEntity data = new StringEntity(new Gson().toJson(moni), CHARSET);
//			request.setEntity(data);
//			HttpResponse response = httpclient.execute(getTarget(url.toString()), request);
////			if (response.getStatusLine().getStatusCode() == 200) {
//				Reader reader = new InputStreamReader((response).getEntity().getContent(), CHARSET);
//				resp = new Gson().fromJson(reader, ModelMonitoringApp.class);
////			} else {
////				request.abort();
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
////				httpclient.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return resp;
//	}
	

	
	




}
