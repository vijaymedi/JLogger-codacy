package com.iig.gcp.jlogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;




/*@NamedQueries({
	@NamedQuery(
			name = "findfeedByprojectCode",
			query = "from DashboardLogger s where s.project_id = :project_name"
		
			),
	@NamedQuery(
			name = "getLogDetails",
			query = "from DashboardLogger s where s.project_id = :project_name and  s.feed_name = :feed_name and s.start_time BETWEEN  :start_date and  :end_date"
			)*/
	//and  s.start_time = :start_date and  s.end_time = :end_date
	//	query = "select distinct(s.feed_name) from   DashboardLogger s where s.project_id = :project_name"
/*})*/



@NamedQuery(
		name = "DashboardLogger.findByProject_idAndFeed_nameAndStart_timeBetween",
		query = "from DashboardLogger s where s.project_id = :project_id and  s.feed_name = :feed_name and s.start_time BETWEEN  :start_date and  :end_date"
		)

@Entity
@Immutable
@Table(name="VIEW_JLOGGER_CURRENT")
public class DashboardLogger  	{

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="LOG_SEQUENCE")
	private String  log_sequence;
	@Column(name="STATUS")
	private String  status;
	/*@Temporal(TemporalType.DATE)*/
	@Column(name="END_TIME")
	private String  end_time;
	@Column(name="START_TIME")
	/*@Temporal(TemporalType.DATE)*/
	private String  start_time;
	@Column(name="RUN_ID")
	private String  run_id;
	@Column(name="RUN_DATE")
	/*@Temporal(TemporalType.DATE)*/
	private String  run_date;
	@Column(name="JOB_NAME")
	private String  job_name;
	@Column(name="JOB_ID")
	private String  job_id;
	@Column(name="FEED_NAME")
	private String  feed_name;
	@Column(name="FEED_ID")
	private String  feed_id;
	@Column(name="PROJECT_ID")
	private long  project_id;
	@Column(name="LOG_TYPE")
	private String  log_type ;
	
	@Column(name="COMMENTS")
	private String  comments;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getRun_id() {
		return run_id;
	}
	public void setRun_id(String run_id) {
		this.run_id = run_id;
	}
	public String getRun_date() {
		return run_date;
	}
	public void setRun_date(String run_date) {
		this.run_date = run_date;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getFeed_name() {
		return feed_name;
	}
	public void setFeed_name(String feed_name) {
		this.feed_name = feed_name;
	}
	public String getFeed_id() {
		return feed_id;
	}
	public void setFeed_id(String feed_id) {
		this.feed_id = feed_id;
	}
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
	public String getLog_sequence() {
		return log_sequence;
	}
	public void setLog_sequence(String log_sequence) {
		this.log_sequence = log_sequence;
	}
	
	

}
