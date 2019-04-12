package com.iig.gcp.jlogger.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iig.gcp.jlogger.dto.ProjectMasterDTO;
import com.iig.gcp.jlogger.entity.ArchiveLog;
import com.iig.gcp.jlogger.entity.DashboardLogger;
import com.iig.gcp.jlogger.entity.JuniperSchLogData;
import com.iig.gcp.jlogger.entity.NifiStatus;
import com.iig.gcp.jlogger.entity.ProjectMaster;
import com.iig.gcp.jlogger.repository.ArchiveLogRepository;
import com.iig.gcp.jlogger.repository.ProjectMasterRepository;
import com.iig.gcp.jlogger.repository.ShellLogDataRepository;
import com.iig.gcp.jlogger.repository.ViewCurrentRepository;
import com.iig.gcp.jlogger.service.DashBoardLogService;

@Service
public class DashBoardLogServiceImpl implements DashBoardLogService{

	@Autowired
	private ProjectMasterRepository projectMasterDetails;
	
	@Autowired
	private ViewCurrentRepository viewLogger;
	
//	@Autowired
//	private DashboardLogRepository shellLoggerMaster;
	
	@Autowired
	private ArchiveLogRepository archiveLogRepository;
	
	@Autowired
	private ShellLogDataRepository schLogDataRepo;
	
	
//	private Map<String,String> projectmp;
	
	
	
	@Override
	public List<ProjectMasterDTO>  getProjectDetails(){
		List <ProjectMasterDTO> pmdtolist=new ArrayList<ProjectMasterDTO>();
		  ProjectMasterDTO projectMasterDTO=null;
		  
		  //projectMasterDetails.findAll().forEach(pmdtolist::add);
		//check if empty ??	
		  
	   for(ProjectMaster projectMaster:projectMasterDetails.findAll()) {
		   projectMasterDTO=new ProjectMasterDTO();
		   projectMasterDTO.setProject_sequence(projectMaster.getProject_sequence());
		   projectMasterDTO.setProject_name(projectMaster.getProject_name());
		   pmdtolist.add(projectMasterDTO);
	   }
		return  pmdtolist ;
	}
/**
 * @return feedDtls	
 */
	@Override
	public List<String> getFeedDetails(long projectName){
	List<String> feedDtls=viewLogger.findfeed(projectName);
	//check if empty ??	
	return  feedDtls;
	}
/**
 * @param projectName
 * @param feedName
 * @param start_date
 * @param end_date
 * @return	
 */
	@Override
	public List<DashboardLogger> getLogDetails(long projectName,String feedName,String start_date,String end_date) {
		
		  // Date firstDate=null;
		   //Date secondDate=null;
		
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("01", "JAN");
		mp.put("02", "FEB");
		mp.put("03", "MAR");
		mp.put("04", "APR");
		mp.put("05", "MAY");
		mp.put("06", "JUN");
		mp.put("07", "JUL");
		mp.put("08", "AUG");
		mp.put("09", "SEP");	
		mp.put("10", "OCT");
		mp.put("11", "NOV");
		mp.put("12", "DEC");
		List<DashboardLogger> dashboard=null;
	//DateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd");
		//DateFormat originalFormat2 = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.SSSSSSSSS");
		Date date=null;
		//Date date_end=null;
		if((null==start_date && null==end_date)|| ((null!=start_date && "".equals(start_date)) && (null!=end_date && "".equals(end_date)) )) {
			
			date= new Date();
			start_date=dateFormat.format(date);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			Date result = cal.getTime();
			end_date=dateFormat.format(result);
			//dashboard= loggerMstrDAO.getLogDetails(projectName,feedName,end_date,start_date);
			dashboard=viewLogger.findByProject_idAndFeed_nameAndStart_timeBetween(projectName,feedName,end_date,start_date);
				
			
			return dashboard;
		}else {
		
			/*//
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd", Locale.ENGLISH);
			 	try {
					firstDate = sdf.parse(start_date);
				     secondDate = sdf.parse(end_date);
				     long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
					 long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					 
					  if(diff>30) {
						 
						  
					  }
					  
					  else {
						  
						  
						  
						  
						  
						  
						  
					  }
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			 
			
			*/
			if((null!=start_date) && !("".equals(start_date))) {
					 
					String ar[]= start_date.split("-");
					String year=ar[0].substring(2);
					String month=ar[1];
					String day=ar[2];
					month=mp.get(month);
					start_date=day+"-"+month+"-"+year+".0.0.0.000000000";
				 }
				 if((null!=end_date) && !("".equals(end_date))) {
					 
						String ar[]= end_date.split("-");
						String year=ar[0].substring(2);
						String month=ar[1];
						String day=ar[2];
						month=mp.get(month);
						end_date=day+"-"+month+"-"+year+".0.0.0.000000000";
					 }
				 //date = originalFormat.parse(start_date);
				  //start_date = dateFormat.format(date);
					//  date_end = originalFormat2.parse(end_date);
			   // end_date = dateFormat.format(date_end);
			    
			  //dashboard= loggerMstrDAO.getLogDetails(projectName,feedName,start_date,end_date);
			  //
				 dashboard=viewLogger.findByProject_idAndFeed_nameAndStart_timeBetween(projectName,feedName,start_date,end_date);
			     return  dashboard;
			    	
			 
		}
		
		
		
		
	}
	@Override
	public List<NifiStatus> getNifiDetails(String jobName){
		
		return new ArrayList<NifiStatus>();
		//return  loggerMstrDAO.getNifiDetails(jobName);
	}
/**
 * @param jobName
 * @param start_time
 * @param run_id	
 */
	@Override
	public List<JuniperSchLogData> getShellDetails(String jobName,String start_time,String run_id){

		
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("01", "JAN");
		mp.put("02", "FEB");
		mp.put("03", "MAR");
		mp.put("04", "APR");
		mp.put("05", "MAY");
		mp.put("06", "JUN");
		mp.put("07", "JUL");
		mp.put("08", "AUG");
		mp.put("09", "SEP");	
		mp.put("10", "OCT");
		mp.put("11", "NOV");
		mp.put("12", "DEC");
		if((null!=start_time) && !("".equals(start_time))) {
				 
			   String ar2[]= start_time.split(" ");
				String ar[]= ar2[0].split("-");
				String year=ar[0].substring(2);
				String month=ar[1];
				String day=ar[2];
				month=mp.get(month);
				String ar3[]= ar2[1].split(":");
				String hours=ar3[0];
				String mins=ar3[1];
				String sec=ar3[2];
				String milliseconds="000000000";
			
				String millisecondlen="000000000";
				
				if(sec.length()>2) {
					String ar4[]= sec.split("\\.");
					
					sec=ar4[0];
					milliseconds=ar4[1];
					millisecondlen="";
				 switch(milliseconds.length()) {
				 case 1:  millisecondlen=milliseconds+"0000000";
				 case 2:  millisecondlen=milliseconds+"000000";
				 case 3:  millisecondlen=milliseconds+"00000";
				 case 4:  millisecondlen=milliseconds+"0000";
				 case 5:  millisecondlen=milliseconds+"000";
				 case 6:  millisecondlen=milliseconds+"00";
				 case 7:  millisecondlen=milliseconds+"0";
				 case 8:  millisecondlen=milliseconds;
				
				 }
				// start_time=day+"-"+month+"-"+year+"."+hours+"."+mins+"."+sec1+"."+millisecondlen;
				}
				start_time=day+"-"+month+"-"+year+"."+hours+"."+mins+"."+sec+"."+millisecondlen;		
			 }
		
		 
		
		
		//
		//List<LoggerMaster> dtllog=shellLoggerMaster.findByJob_nameAndJob_start_time(start_time, jobName);
		
		List<JuniperSchLogData> junSchLog=schLogDataRepo.findByJob_nameAndJob_start_timeAndRun_id(start_time,jobName,run_id);
	
		
		
		return junSchLog;
	//	return  loggerMstrDAO.getShellDetails(jobName);
	}
/**
 * @param projectName
 * @param feedName
 * @param start_date
 * @param end_date
 * @return	
 */
	@Override
	public List<ArchiveLog> getLogArchiveDetails(long projectName,String feedName,String start_date,String end_date) {
		
		//   Date firstDate=null;
		 //  Date secondDate=null;
		
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("01", "JAN");
		mp.put("02", "FEB");
		mp.put("03", "MAR");
		mp.put("04", "APR");
		mp.put("05", "MAY");
		mp.put("06", "JUN");
		mp.put("07", "JUL");
		mp.put("08", "AUG");
		mp.put("09", "SEP");	
		mp.put("10", "OCT");
		mp.put("11", "NOV");
		mp.put("12", "DEC");
		List<ArchiveLog> dashboard=null;
	//DateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd");
		//DateFormat originalFormat2 = new SimpleDateFormat("yyyy-mm-dd");
		//DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.SSSSSSSSS");
		//Date date=null;

			
			if((null!=start_date) && !("".equals(start_date))) {
					 
					String ar[]= start_date.split("-");
					String year=ar[0].substring(2);
					String month=ar[1];
					String day=ar[2];
					month=mp.get(month);
					start_date=day+"-"+month+"-"+year+".0.0.0.000000000";
				 }
				 if((null!=end_date) && !("".equals(end_date))) {
					 
						String ar[]= end_date.split("-");
						String year=ar[0].substring(2);
						String month=ar[1];
						String day=ar[2];
						month=mp.get(month);
						end_date=day+"-"+month+"-"+year+".0.0.0.000000000";
					 }
				 //date = originalFormat.parse(start_date);
				  //start_date = dateFormat.format(date);
					//  date_end = originalFormat2.parse(end_date);
			   // end_date = dateFormat.format(date_end);
			    
			  //dashboard= loggerMstrDAO.getLogDetails(projectName,feedName,start_date,end_date);
			  //
				 dashboard=archiveLogRepository.findArchiveDataByProject_idAndFeed_nameAndStart_timeBetween(projectName,feedName,start_date,end_date);
			     return  dashboard;
			    	
			 
		}

	 
	
}
