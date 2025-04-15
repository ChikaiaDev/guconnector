package sn.intouch.gu.iabiri.ws.models;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class TransactionExchange extends ExchangeAbstract {

	private ServiceExchange serviceExchange;
	private MoyenExchange moyenExchange;
	private Double transactionMontant;
	private Double transactionRemise;

	public ServiceExchange getServiceExchange() {
		return serviceExchange;
	}

	public void setServiceExchange(ServiceExchange serviceExchange) {
		this.serviceExchange = serviceExchange;
	}

	public MoyenExchange getMoyenExchange() {
		return moyenExchange;
	}

	public void setMoyenExchange(MoyenExchange moyenExchange) {
		this.moyenExchange = moyenExchange;
	}

	public Double getTransactionMontant() {
		return transactionMontant;
	}

	public void setTransactionMontant(Double transactionMontant) {
		this.transactionMontant = transactionMontant;
	}

	public Double getTransactionRemise() {
		return transactionRemise;
	}

	public void setTransactionRemise(Double transactionRemise) {
		this.transactionRemise = transactionRemise;
	}

	public TransactionExchange() {
		super();
	}
	public static Gson gson, gson2;
	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				String date = json.getAsJsonPrimitive().getAsString();
				String myFormat = "yyyy/MM/dd hh:mm:ss";
				SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
				try {
					return sdf.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new Date();
			}
		});
		gson = builder.create();
	}
	
	static {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				String date = json.getAsJsonPrimitive().getAsString();
				String myFormat = "dd/MM/yyyy hh:mm";
				SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
				try {
					return sdf.parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return new Date();
			}
		});
		gson2 = builder.create();
	}


}
