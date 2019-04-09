package com.iig.gcp.jlogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@NamedQuery(
		name = "JuniperSchLogData.findByJob_nameAndJob_start_timeAndRun_id",
		query = "from JuniperSchLogData s where s.job_name = :job_name and s.job_start_time=:job_start_time and s.run_id=:run_id"
		)

@Entity
@Table(name = "JUNIPER_SCH_LOG_DATA")
public class JuniperSchLogData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "LOG_ID")
	private String log_id;

	@Column(name = "JOB_NAME")
	private String job_name;

	@Column(name = "JOB_START_TIME")
	private String job_start_time;

	@Column(name = "JOB_STATUS_DETAIL_DESC")
	private String job_status_detail_desc;

	@Column(name = "RUN_ID")
	private  String run_id;
	

	public String getRun_id() {
		return run_id;
	}

	public void setRun_id(String run_id) {
		this.run_id = run_id;
	}

	public String getLog_id() {
		return log_id;
	}

	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getJob_start_time() {
		return job_start_time;
	}

	public void setJob_start_time(String job_start_time) {
		this.job_start_time = job_start_time;
	}

	public String getJob_status_detail_desc() {
		return job_status_detail_desc;
	}

	public void setJob_status_detail_desc(String job_status_detail_desc) {
		this.job_status_detail_desc = job_status_detail_desc;
	}

}
