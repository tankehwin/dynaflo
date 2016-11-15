package model;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BrandModel {

	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NAME = "name";
	public static final String COLNAME_FREIGHT_CHARGES = "freight_charges";
	public static final String COLNAME_EXPIRY_DATE = "expiry_date";
	public static final String COLNAME_EXCHANGE_RATE = "exchange_rate";
	public static final String COLNAME_DATE_CREATED = "date_created";
	public static final String COLNAME_DATE_UPDATED = "date_updated";
	
	public static final String TABLENAME = "brands_master";
		
	private Integer id;
	private String name;
	// the following fields: freightCharges, expiryDate, exchangeRate have no business logic, merely info values
	private String freightCharges;
	private String expiryDate;
	private String exchangeRate;
	private Timestamp dateCreated;
	private Timestamp dateUpdated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFreightCharges() {
		return freightCharges;
	}
	public void setFreightCharges(String freightCharges) {
		this.freightCharges = freightCharges;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Timestamp getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Timestamp dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
