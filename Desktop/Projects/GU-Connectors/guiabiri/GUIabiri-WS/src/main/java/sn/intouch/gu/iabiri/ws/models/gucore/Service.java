package sn.intouch.gu.iabiri.ws.models.gucore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Service {

	// Code service
		private String srvCode;

		// Label du service : pour l'affichage sur le PDA et la borne
		private String srvLabel;

		// Prix unitaire
		private int srvUnitPrice;

		// Remise en %
		private double srvDiscountRate, srvPrivDiscountRate;

		// Remise en forfait
		private double srvDiscountAmount, srvPrivDiscountAmount;

		// Type du service: SIMPLE, PLUS, PRIVILEGE
		private String srvType;

		// Ordre d'affichage sur le PDA et la borne
		private int srvDisplayLevel;

		// Champs et valeurs du service
		private Map<String, String> srvChamps;

		// Service plus
		private int srvPlus;

		private String srvPromo;

		private String srvPrivPromo;

		private int srvAppDiscount;
		private Double montantMin;
		private Double montantMax;
		private String spareOp1;
		private String spareOp2;
		private String spareOp3;
		private String spareOp4;
		private String spareOp5;
		private String serviceSubCategoryCode;
		private Boolean initiatedByCustomer;
		private String serviceSubCategoryNom;
		private Integer mutliple;
		private OperateurService operateurService;
		private String categoryService;
		private Boolean isFavory;
		private String prioriteFavories;

		
		public String getCategoryService() {
			return categoryService;
		}

		public void setCategoryService(String categoryService) {
			this.categoryService = categoryService;
		}

		public Boolean getIsFavory() {
			return isFavory;
		}

		public void setIsFavory(Boolean isFavory) {
			this.isFavory = isFavory;
		}

		public String getPrioriteFavories() {
			return prioriteFavories;
		}

		public void setPrioriteFavories(String prioriteFavories) {
			this.prioriteFavories = prioriteFavories;
		}

		public String getSrvCode() {
			return srvCode;
		}

		public void setSrvCode(String srvCode) {
			this.srvCode = srvCode;
		}

		public String getSrvLabel() {
			return srvLabel;
		}

		public void setSrvLabel(String srvLabel) {
			this.srvLabel = srvLabel;
		}

		public int getSrvUnitPrice() {
			return srvUnitPrice;
		}

		public void setSrvUnitPrice(int srvUnitPrice) {
			this.srvUnitPrice = srvUnitPrice;
		}

		public double getSrvDiscountRate() {
			return srvDiscountRate;
		}

		public void setSrvDiscountRate(double srvDiscountRate) {
			this.srvDiscountRate = srvDiscountRate;
		}

		public double getSrvDiscountAmount() {
			return srvDiscountAmount;
		}

		public void setSrvDiscountAmount(double srvDiscountAmount) {
			this.srvDiscountAmount = srvDiscountAmount;
		}

		public String getSrvType() {
			return srvType;
		}

		public void setSrvType(String srvType) {
			this.srvType = srvType;
		}

		public int getSrvDisplayLevel() {
			return srvDisplayLevel;
		}

		public void setSrvDisplayLevel(int srvDisplayLevel) {
			this.srvDisplayLevel = srvDisplayLevel;
		}

		public Map<String, String> getSrvChamps() {
			return srvChamps;
		}

		public void setSrvChamps(Map<String, String> srvChamps) {
			this.srvChamps = srvChamps;
		}

		public Service(String srvCode, String srvLabel, Integer srvUnitPrice, Double srvDiscountRate,
                       Double srvDiscountAmount, String srvType, Integer srvDisplayLevel, Map srvChamps) {
			super();
			this.srvCode = srvCode;
			this.srvLabel = srvLabel;
			this.srvUnitPrice = srvUnitPrice != null ? srvUnitPrice : 0;
			this.srvDiscountRate = srvDiscountRate != null ? srvDiscountRate : 0;
			this.srvDiscountAmount = srvDiscountAmount != null ? srvDiscountAmount : 0;
			this.srvType = srvType;
			this.srvDisplayLevel = srvDisplayLevel != null ? srvDisplayLevel : 0;
			this.srvChamps = srvChamps;

			srvChamps = new HashMap();

		}

		public String getSrvPromo() {
			return srvPromo;
		}

		public void setSrvPromo(String srvPromo) {
			this.srvPromo = srvPromo;
		}

		public int getSrvAppDiscount() {
			return srvAppDiscount;
		}

		public void setSrvAppDiscount(int srvAppDiscount) {
			this.srvAppDiscount = srvAppDiscount;
		}

		public int getSrvPlus() {
			return srvPlus;
		}

		public void setSrvPlus(int srvPlus) {
			this.srvPlus = srvPlus;
		}

		public String getSrvPrivPromo() {
			return srvPrivPromo;
		}

		public void setSrvPrivPromo(String srvPrivPromo) {
			this.srvPrivPromo = srvPrivPromo;
		}

		public double getSrvPrivDiscountRate() {
			return srvPrivDiscountRate;
		}

		public void setSrvPrivDiscountRate(double srvPrivDiscountRate) {
			this.srvPrivDiscountRate = srvPrivDiscountRate;
		}

		public double getSrvPrivDiscountAmount() {
			return srvPrivDiscountAmount;
		}

		public void setSrvPrivDiscountAmount(double srvPrivDiscountAmount) {
			this.srvPrivDiscountAmount = srvPrivDiscountAmount;
		}

		public Service(String srvCode, String srvLabel, Integer srvUnitPrice, Double srvDiscountRate,
                       Double srvPrivDiscountRate, Double srvDiscountAmount, Double srvPrivDiscountAmount, String srvType,
                       Integer srvDisplayLevel, Map<String, String> srvChamps, Integer srvPlus, String srvPromo,
                       String srvPrivPromo, Integer srvAppDiscount) {
			super();
			this.srvCode = srvCode;
			this.srvLabel = srvLabel;
			this.srvUnitPrice = srvUnitPrice != null ? srvUnitPrice : 0;
			this.srvDiscountRate = srvDiscountRate != null ? srvDiscountRate : 0;
			this.srvPrivDiscountRate = srvPrivDiscountRate != null ? srvPrivDiscountRate : 0;
			this.srvDiscountAmount = srvDiscountAmount != null ? srvDiscountAmount : 0;
			this.srvPrivDiscountAmount = srvPrivDiscountAmount != null ? srvPrivDiscountAmount : 0;
			this.srvType = srvType;
			this.srvDisplayLevel = srvDisplayLevel != null ? srvDisplayLevel : 0;
			this.srvChamps = srvChamps;
			this.srvPlus = srvPlus != null ? srvPlus : 0;
			this.srvPromo = srvPromo;
			this.srvPrivPromo = srvPrivPromo;
			this.srvAppDiscount = srvAppDiscount != null ? srvAppDiscount : 0;
		}

		public Double getMontantMin() {
			return montantMin;
		}

		public void setMontantMin(Double montantMin) {
			this.montantMin = montantMin;
		}

		public Double getMontantMax() {
			return montantMax;
		}

		public void setMontantMax(Double montantMax) {
			this.montantMax = montantMax;
		}

		public String getSpareOp1() {
			return spareOp1;
		}

		public void setSpareOp1(String spareOp1) {
			this.spareOp1 = spareOp1;
		}

		public String getSpareOp2() {
			return spareOp2;
		}

		public void setSpareOp2(String spareOp2) {
			this.spareOp2 = spareOp2;
		}

		public String getSpareOp3() {
			return spareOp3;
		}

		public void setSpareOp3(String spareOp3) {
			this.spareOp3 = spareOp3;
		}

		public String getSpareOp4() {
			return spareOp4;
		}

		public void setSpareOp4(String spareOp4) {
			this.spareOp4 = spareOp4;
		}

		public String getSpareOp5() {
			return spareOp5;
		}

		public void setSpareOp5(String spareOp5) {
			this.spareOp5 = spareOp5;
		}

		public String getServiceSubCategoryCode() {
			return serviceSubCategoryCode;
		}

		public void setServiceSubCategoryCode(String serviceSubCategoryCode) {
			this.serviceSubCategoryCode = serviceSubCategoryCode;
		}

		public String getServiceSubCategoryNom() {
			return serviceSubCategoryNom;
		}

		public void setServiceSubCategoryNom(String serviceSubCategoryNom) {
			this.serviceSubCategoryNom = serviceSubCategoryNom;
		}

		public Integer getMutliple() {
			return mutliple;
		}

		public void setMutliple(Integer mutliple) {
			this.mutliple = mutliple;
		}

		public OperateurService getOperateurService() {
			return operateurService;
		}

		public void setOperateurService(OperateurService operateurService) {
			this.operateurService = operateurService;
		}

		public Boolean getInitiatedByCustomer() {
			return initiatedByCustomer;
		}

		public void setInitiatedByCustomer(Boolean initiatedByCustomer) {
			this.initiatedByCustomer = initiatedByCustomer;
		}

		

		public Service() {
			super();
		}
}
