package sn.intouch.gu.iabiri.ws.rest;

import com.google.gson.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import sn.intouch.gu.iabiri.service.ParameterService;
import sn.intouch.gu.iabiri.service.TempTableService;
import sn.intouch.gu.iabiri.utils.EJBRegistry;
import sn.intouch.gu.iabiri.utils.JNDIUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;


public class IabiriCallback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getLogger(IabiriCallback.class);
	TempTableService transactionStatusService = (TempTableService) JNDIUtils.lookUpEJB(EJBRegistry.TempTableServiceBean);
	private static ParameterService parameterService = (ParameterService) JNDIUtils.lookUpEJB(EJBRegistry.ParameterServiceBean);
	static Gson GSON = new Gson();

	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return null;
			}
		});
		builder.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter());
		GSON = builder.create();

	}
	private static class ByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
		public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			return  Base64.decodeBase64(json.getAsString());
		}
		public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(Base64.encodeBase64String(src));

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceCode = "";
		String receiptNo = String.valueOf(System.currentTimeMillis());
		JsonObject callbackJsonRequest = new JsonObject();
		JsonObject joRep = new JsonObject();
		response.setContentType("application/json");

		LOGGER.warn("###  CALLBACK RECEIVED  ###");

		try {
			String entry = IOUtils.toString(request.getInputStream());
			callbackJsonRequest = (JsonObject) new JsonParser().parse(entry);
		} catch (Exception e) {
			joRep.addProperty("Result", 400);
			joRep.addProperty("Message", "Bad Request.");
			joRep.addProperty("ReceiptNo", receiptNo);

			LOGGER.info("###  BAD REQUEST CALLBACK RESPONSE " + joRep);
			response.getWriter().append(joRep.toString());
			return;
		}

		LOGGER.warn("### CALLBACK REQUEST BODY" + GSON.toJson(callbackJsonRequest));
		/*
		 * write your code here
		 */
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IabiriCallback() {
		super();

	}
}
