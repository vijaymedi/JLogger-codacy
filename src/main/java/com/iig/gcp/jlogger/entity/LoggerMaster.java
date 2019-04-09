package com.iig.gcp.jlogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(
			name = "LoggerMaster.findByJob_nameAndJob_start_time",
			query = "from LoggerMaster s where s.job_name = :job_name and s.job_start_time=:job_start_time" 
			)
	//    
})
@Entity
@Table(name="JUNIPER_LOG_TEST")
public class LoggerMaster /*implements Serializable*/ {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOGID")
	private long logid;
	@Column(name="PROJECT_ID")
	private String project_id;
	@Column(name="COUNTRY_CODE")
	private String country_code;
	@Column(name="PROJECT_NAME")
	private String project_name;
	@Column(name="FEED_ID")
	private String feed_id;
	@Column(name="FEED_NAME")
	private String feed_name;
	@Column(name="JOB_ID")
	private String job_id;
	@Column(name="JOB_NAME")
	private String job_name;
	@Column(name="RUN_DATE")
	private String run_date;
	@Column(name="RUN_ID")
	private String run_id;
	@Column(name="JOB_START_TIME")
	private String job_start_time;
	@Column(name="JOB_END_TIME")
	private String job_end_time;
	@Column(name="JOB_STATUS")
	private String job_status;
	@Column(name="SEVERITY")
	private String severity;
	@Column(name="PROCESS_NAME")
	private String process_name;
	@Column(name="HOST_NAME")
	private String host_name;
	@Column(name="JOB_STATUS_COMMENTS")
	private String job_status_comments;
	@Lob
	@Column(name="JOB_STATUS_DETAIL_DESC")
	private String  job_status_detail_desc;
	
	
	public String getJob_status_detail_desc() {
		return job_status_detail_desc;
	}
	public void setJob_status_detail_desc(String job_status_detail_desc) {
		this.job_status_detail_desc = job_status_detail_desc;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getFeed_id() {
		return feed_id;
	}
	public void setFeed_id(String feed_id) {
		this.feed_id = feed_id;
	}
	public String getFeed_name() {
		return feed_name;
	}
	public void setFeed_name(String feed_name) {
		this.feed_name = feed_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getRun_date() {
		return run_date;
	}
	public void setRun_date(String run_date) {
		this.run_date = run_date;
	}
	public String getRun_id() {
		return run_id;
	}
	public void setRun_id(String run_id) {
		this.run_id = run_id;
	}
	public String getJob_start_time() {
		return job_start_time;
	}
	public void setJob_start_time(String job_start_time) {
		this.job_start_time = job_start_time;
	}
	public String getJob_end_time() {
		return job_end_time;
	}
	public void setJob_end_time(String job_end_time) {
		this.job_end_time = job_end_time;
	}
	public String getJob_status() {
		return job_status;
	}
	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getProcess_name() {
		return process_name;
	}
	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getJob_status_comments() {
		return job_status_comments;
	}
	public void setJob_status_comments(String job_status_comments) {
		this.job_status_comments = job_status_comments;
	}
	public long getLogid() {
		return logid;
	}
	public void setLogid(long logid) {
		this.logid = logid;
	}
	
}
