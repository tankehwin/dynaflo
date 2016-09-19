package model;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LoginModel {

	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NAME = "name";
	public static final String COLNAME_PASSWORD = "password";
	public static final String COLNAME_ACC_TYPE = "acc_type";
	public static final String COLNAME_DATE_CREATED = "date_created";
	public static final String COLNAME_DATE_UPDATED = "date_updated";
	
	public static final String TABLENAME = "login_master";
	
	private Integer id;
	private String name;
	private String password;
	private String accType;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
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
