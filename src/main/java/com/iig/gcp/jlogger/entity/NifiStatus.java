package com.iig.gcp.jlogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(
			name = "getNifiDetails",
			query = "from NifiStatus s where s.job_name = :job_name"
			)
	
})
@Entity
@Table(name="JUNIPER_EXT_NIFI_STATUS")
public class NifiStatus {

	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="NIFI_STATUS_SEQUENCE")
	private String 	nifi_status_sequence ;
	@Column(name="COUNTRY_CODE")
	private String  country_code;
	@Column(name="FEED_ID")
	private String FEED_ID;
	@Column(name="FEED_UNIQUE_NAME")
	private String feed_unique_name;
	@Column(name="RUN_ID")
	private String  RUN_ID;
	@Column(name="NIFI_PG")
	private String  nifi_pg;
	@Column(name="PG_TYPE")
	private String  pg_type;
	@Column(name="EXTRACTED_DATE")
	private String  extracted_date;
	@Column(name="JOB_START_TIME")
	private String  JOB_START_TIME;
	@Column(name="JOB_END_TIME")
	private String  JOB_END_TIME;
	@Column(name="STATUS")
	private String  STATUS;
	@Column(name="PROJECT_SEQUENCE")
	private String  PROJECT_SEQUENCE;
	@Column(name="JOB_NAME")
	private String  job_name;
	@Column(name="JOB_TYPE")
	private String  job_type;
	@Column(name="COMMENTS")
	private String  comments;
	public String getNifi_status_sequence() {
		return nifi_status_sequence;
	}
	public void setNifi_status_sequence(String nifi_status_sequence) {
		this.nifi_status_sequence = nifi_status_sequence;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getFEED_ID() {
		return FEED_ID;
	}
	public void setFEED_ID(String fEED_ID) {
		FEED_ID = fEED_ID;
	}
	public String getFeed_unique_name() {
		return feed_unique_name;
	}
	public void setFeed_unique_name(String feed_unique_name) {
		this.feed_unique_name = feed_unique_name;
	}
	public String getRUN_ID() {
		return RUN_ID;
	}
	public void setRUN_ID(String rUN_ID) {
		RUN_ID = rUN_ID;
	}
	public String getNifi_pg() {
		return nifi_pg;
	}
	public void setNifi_pg(String nifi_pg) {
		this.nifi_pg = nifi_pg;
	}
	public String getPg_type() {
		return pg_type;
	}
	public void setPg_type(String pg_type) {
		this.pg_type = pg_type;
	}
	public String getExtracted_date() {
		return extracted_date;
	}
	public void setExtracted_date(String extracted_date) {
		this.extracted_date = extracted_date;
	}
	public String getJOB_START_TIME() {
		return JOB_START_TIME;
	}
	public void setJOB_START_TIME(String jOB_START_TIME) {
		JOB_START_TIME = jOB_START_TIME;
	}
	public String getJOB_END_TIME() {
		return JOB_END_TIME;
	}
	public void setJOB_END_TIME(String jOB_END_TIME) {
		JOB_END_TIME = jOB_END_TIME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getPROJECT_SEQUENCE() {
		return PROJECT_SEQUENCE;
	}
	public void setPROJECT_SEQUENCE(String pROJECT_SEQUENCE) {
		PROJECT_SEQUENCE = pROJECT_SEQUENCE;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_type() {
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
