package com.iig.gcp.jlogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iig.gcp.jlogger.entity.ProjectMaster;


@Repository
public interface ProjectMasterRepository extends JpaRepository<ProjectMaster, Long>{
	
	/*@Query(value = QueryDetails.FIND_PROJECTS, nativeQuery = true)
	public List<Object[]> findProjects();
*/
	
	
}
