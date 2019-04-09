package com.iig.gcp.jlogger.service;

import java.util.List;

import com.iig.gcp.jlogger.dto.ProjectMasterDTO;
import com.iig.gcp.jlogger.entity.ArchiveLog;
import com.iig.gcp.jlogger.entity.DashboardLogger;
import com.iig.gcp.jlogger.entity.JuniperSchLogData;
import com.iig.gcp.jlogger.entity.NifiStatus;

public interface DashBoardLogService {

	List<ProjectMasterDTO> getProjectDetails();
	List<String> getFeedDetails(long projectName);
    List<DashboardLogger> getLogDetails(long projectName,String feedName,String start_date, String end_date);
    public List<NifiStatus> getNifiDetails(String jobName);
    public List<JuniperSchLogData> getShellDetails(String jobName,String start_time,String run_id);
    public List<ArchiveLog> getLogArchiveDetails(long projectName,String feedName,String start_date,String end_date);
}
