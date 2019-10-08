package com.atovk.execise.domain;

import java.io.Serializable;

public class TaskColumnMapping implements Serializable, Comparable<TaskColumnMapping> {
	
	private static final long serialVersionUID = 1564637187299265138L;
	/**
	 * 任务编号
	 */
	private String taskCode;
	/**
	 * 读-数据库编号
	 */
	private String readerDataCode;
	/**
	 * 读-数据库名
	 */
	private String readerDataName;
	/**
	 * 读-数据表编号
	 */
	private String readerTableCode;
	/**
	 * 读-数据表名
	 */
	private String readerTableName;
	/**
	 * 读-表列编号
	 */
	private String readerColumnCode;
	/**
	 * 读-表列编名
	 */
	private String readerColumnName;
	/**
	 * 写-数据库编号
	 */
	private String writerDataCode;
	/**
	 * 写-数据库名
	 */
	private String writerDataName;
	/**
	 * 写-数据表编号
	 */
	private String writerTableCode;
	/**
	 * 写-数据表名
	 */
	private String writerTableName;
	/**
	 * 写-表列编号
	 */
	private String writerColumnCode;
	/**
	 * 写-表列编名
	 */
	private String writerColumnName;
	/**
	 * 升序排序序号
	 */
	private Integer orderRef;
	
	public String getTaskCode() {
		return taskCode;
	}
	
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	public String getReaderDataCode() {
		return readerDataCode;
	}
	
	public void setReaderDataCode(String readerDataCode) {
		this.readerDataCode = readerDataCode;
	}
	
	public String getReaderTableCode() {
		return readerTableCode;
	}
	
	public void setReaderTableCode(String readerTableCode) {
		this.readerTableCode = readerTableCode;
	}
	
	public String getReaderColumnCode() {
		return readerColumnCode;
	}
	
	public void setReaderColumnCode(String readerColumnCode) {
		this.readerColumnCode = readerColumnCode;
	}
	
	public String getReaderColumnName() {
		return readerColumnName;
	}
	
	public void setReaderColumnName(String readerColumnName) {
		this.readerColumnName = readerColumnName;
	}
	
	public String getWriterDataCode() {
		return writerDataCode;
	}
	
	public void setWriterDataCode(String writerDataCode) {
		this.writerDataCode = writerDataCode;
	}
	
	public String getWriterTableCode() {
		return writerTableCode;
	}
	
	public void setWriterTableCode(String writerTableCode) {
		this.writerTableCode = writerTableCode;
	}
	
	public String getWriterColumnCode() {
		return writerColumnCode;
	}
	
	public void setWriterColumnCode(String writerColumnCode) {
		this.writerColumnCode = writerColumnCode;
	}
	
	public String getWriterColumnName() {
		return writerColumnName;
	}
	
	public void setWriterColumnName(String writerColumnName) {
		this.writerColumnName = writerColumnName;
	}

	public String getReaderDataName() {
		return readerDataName;
	}

	public void setReaderDataName(String readerDataName) {
		this.readerDataName = readerDataName;
	}

	public String getReaderTableName() {
		return readerTableName;
	}

	public void setReaderTableName(String readerTableName) {
		this.readerTableName = readerTableName;
	}

	public String getWriterDataName() {
		return writerDataName;
	}

	public void setWriterDataName(String writerDataName) {
		this.writerDataName = writerDataName;
	}

	public String getWriterTableName() {
		return writerTableName;
	}

	public void setWriterTableName(String writerTableName) {
		this.writerTableName = writerTableName;
	}

	public Integer getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(Integer orderRef) {
		this.orderRef = orderRef;
	}

	@Override
	public int compareTo(TaskColumnMapping o) {
		return this.orderRef - o.getOrderRef();
	}
	
}
