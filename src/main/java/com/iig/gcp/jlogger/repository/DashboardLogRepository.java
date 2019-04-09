package com.iig.gcp.jlogger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iig.gcp.jlogger.entity.LoggerMaster;
@Repository
public interface DashboardLogRepository extends CrudRepository<LoggerMaster, Long>{

	
	public List<LoggerMaster> findByJob_nameAndJob_start_time(@Param("job_start_time") String job_start_time,@Param("job_name") String job_name);
}
