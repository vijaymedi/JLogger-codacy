package com.iig.gcp.jlogger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iig.gcp.jlogger.entity.DashboardLogger;
@Repository
public interface ViewCurrentRepository extends CrudRepository<DashboardLogger, String>{

	public static final String FIND_PROJECTS = "SELECT distinct a.feed_name  FROM DashboardLogger a where a.project_id=:project_id";

	@Query(FIND_PROJECTS)
	public List<String> findfeed(@Param("project_id") long project_id);

	public List<DashboardLogger> findByProject_idAndFeed_nameAndStart_timeBetween(@Param("project_id") long project_id,@Param("feed_name") String feed_name,@Param("start_date") String start_date,@Param("end_date") String end_date);

}
