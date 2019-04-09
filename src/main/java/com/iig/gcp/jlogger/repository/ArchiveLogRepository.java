package com.iig.gcp.jlogger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iig.gcp.jlogger.entity.ArchiveLog;

public interface ArchiveLogRepository extends CrudRepository<ArchiveLog, String>{

	
	public List<ArchiveLog> findArchiveDataByProject_idAndFeed_nameAndStart_timeBetween(@Param("project_id") long project_id,@Param("feed_name") String feed_name,@Param("start_date") String start_date,@Param("end_date") String end_date);


}
