package model;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class GeneralConfigModel {

	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NAME = "name";
	public static final String COLNAME_CONTENTS = "contents";
	
	public static final String TABLENAME = "general_config_master";
	
	public static final String CONFIG_LAST_IMPORTED_FILENAME = "cfg_last_imported_filename";
	
	private Integer id;
	private String name;
	private String contents;
	
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
}
