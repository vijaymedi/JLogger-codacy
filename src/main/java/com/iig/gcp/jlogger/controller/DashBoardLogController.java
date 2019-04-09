package com.iig.gcp.jlogger.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iig.gcp.jlogger.dto.ProjectMasterDTO;
import com.iig.gcp.jlogger.entity.ArchiveLog;
import com.iig.gcp.jlogger.entity.DashboardLogger;
import com.iig.gcp.jlogger.entity.JuniperSchLogData;
import com.iig.gcp.jlogger.entity.NifiStatus;
import com.iig.gcp.jlogger.service.DashBoardLogService;

@Controller
public class DashBoardLogController {

	@Autowired
	private DashBoardLogService dashBoardLogService;
/**
 * 	
 * @param jsonObject
 * @param map
 * @param request
 * @return String
 */
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	 public String logDashboard(@Valid @ModelAttribute("jsonObject") String jsonObject,ModelMap map,HttpServletRequest request) {
		List <ProjectMasterDTO> pmdtolist= dashBoardLogService.getProjectDetails();
	    map.addAttribute("pltList", pmdtolist);
        return "/index";
   }
	

/**
 * 
 * @param projectName
 * @return feedDetails
 */
		@RequestMapping(value = { "/feedDetails"},method = RequestMethod.POST)
		@ResponseBody
		public List<String> feedDetails(@Valid  @ModelAttribute("projectName") long projectName) 	{
		  List<String> feedList = dashBoardLogService.getFeedDetails(projectName);
	      return feedList;
	   }
		

/**
 * 
 * @param projectName
 * @param feed_id
 * @param start_date
 * @param end_date
 * @param diffDays
 * @return ModelAndView
 * @throws Exception
 */
	@RequestMapping(value = { "/logDetails"},method = RequestMethod.POST)
	public ModelAndView logDetails(@Valid  @ModelAttribute("projectName") long projectName,@ModelAttribute("feed_id") String feed_id,@ModelAttribute("start_date") String start_date,@ModelAttribute("end_date") String end_date,@ModelAttribute("diffDays") int diffDays) throws Exception {
			
		if(diffDays==0 || diffDays<4) {
			List<DashboardLogger> feedList = dashBoardLogService.getLogDetails(projectName,feed_id,start_date,end_date);
		  return new ModelAndView("/detaillog/logtable").addObject("feedList", feedList);
		}else {
			List<ArchiveLog> feedList = dashBoardLogService.getLogArchiveDetails(projectName,feed_id,start_date,end_date);
			return new ModelAndView("/detaillog/logtable").addObject("feedList", feedList);
		}
		   }
	

/**
 * 
 * @param log_typ
 * @param job_name
 * @param start_time
 * @param run_id
 * @return Object
 */
		@RequestMapping(value = { "/details"}, method = RequestMethod.POST)
		@ResponseBody 
		public Object getLogDetails(@Valid @ModelAttribute("log_typ") String log_typ, @ModelAttribute("job_name") String job_name, @ModelAttribute("start_time") String start_time,@ModelAttribute("run_id") String run_id)  {
	    
			if("nifi".equals(log_typ)) {
				  List<NifiStatus> prjctList = dashBoardLogService.getNifiDetails(job_name);
				  return prjctList;
			}else {
				  List<JuniperSchLogData> prjctList = dashBoardLogService.getShellDetails(job_name,start_time,run_id);
					  return prjctList;
			}
		}
}
