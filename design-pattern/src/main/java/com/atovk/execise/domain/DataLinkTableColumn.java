package com.atovk.execise.domain;

import java.io.Serializable;

public class DataLinkTableColumn  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String dataCode;
	
	private String tableCode;
	
	private String columnCode;
	
	private String columnName;

	private String columnType;

	private Boolean isInUsing;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public Boolean getIsInUsing() {
		return isInUsing;
	}

	public void setIsInUsing(Boolean isInUsing) {
		this.isInUsing = isInUsing;
	}
}
