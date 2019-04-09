package com.iig.gcp.jlogger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.iig.gcp.jlogger.entity.JuniperSchLogData;

public interface ShellLogDataRepository  extends CrudRepository<JuniperSchLogData, Long>{

	
	
public List<JuniperSchLogData> findByJob_nameAndJob_start_timeAndRun_id(@Param("job_start_time") String job_start_time,@Param("job_name") String job_name,@Param("run_id") String run_id);



}

