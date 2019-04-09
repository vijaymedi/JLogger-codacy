package com.iig.gcp.jlogger.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="JUNIPER_PROJECT_MASTER")
public class ProjectMaster {

	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PROJECT_SEQUENCE")
	private String project_sequence;
	
	@Column(name="PROJECT_ID")
	private String project_id;
	
	@Column(name="PROJECT_NAME")
	private String project_name;
	
	@Column(name="PROJECT_DESCRIPTION")
	private String project_description;
	
	@Column(name="CREATED_BY")
	private String created_by;
	
	@Column(name="CREATED_DATE")
    private String created_date;
	
	@Column(name="UPDATED_BY")
	private String updated_by;
	
	@Column(name="UPDATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date updated_date;
	
		
	@Column(name="GSD_GROUP")
	private String gsd_group;
	
	@Column(name="GSD_KEY")
	private String gsd_key;
	
	@Column(name="NIFI_SEQUENCE")
	private String nifi_sequence;
	
	@Column(name="DRIVE_SEQUENCE")
	private String drive_sequence;

	public String getProject_sequence() {
		return project_sequence;
	}

	public void setProject_sequence(String project_sequence) {
		this.project_sequence = project_sequence;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getGsd_group() {
		return gsd_group;
	}

	public void setGsd_group(String gsd_group) {
		this.gsd_group = gsd_group;
	}

	public String getGsd_key() {
		return gsd_key;
	}

	public void setGsd_key(String gsd_key) {
		this.gsd_key = gsd_key;
	}

	public String getNifi_sequence() {
		return nifi_sequence;
	}

	public void setNifi_sequence(String nifi_sequence) {
		this.nifi_sequence = nifi_sequence;
	}

	public String getDrive_sequence() {
		return drive_sequence;
	}

	public void setDrive_sequence(String drive_sequence) {
		this.drive_sequence = drive_sequence;
	}
}
