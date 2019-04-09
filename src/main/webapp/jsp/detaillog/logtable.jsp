<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="${pageContext.request.contextPath}/assets/css/bootstrap-table.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/pagination.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.min.js"></script>
<style>
.alert {
  position: relative;
  padding: 0.75rem 1.25rem;
  margin-bottom: 1rem;
   margin-top: 1rem;
  border: 1px solid transparent;
  border-radius: 0.25rem;
  margin-right:1rem;
}
/* width */
/* .table::-webkit-scrollbar {
  width: 10px;
} */
#detaillog {
  table-layout: fixed;
  word-wrap: break-word;
}
/* Track */
/* .table::-webkit-scrollbar-track {
  background: #f1f1f1; 
} */
 
/* Handle */
/* .table::-webkit-scrollbar-thumb {
  background: #888; 
}
 */
/* Handle on hover */
/* .table::-webkit-scrollbar-thumb:hover {
  background: #555; 
}
 */
 /*  .table-bordered th {
   color:#000;
   font-weight:bold;	
   background-color:#dfeffc; 
   border: 1px solid  #a6c9e2 !important;
   
  } 
  


 */


/* .table-bordered tr{
 background-color:black; 
}
 .table-bordered td {
      border: 2px solid  a6c9e2 !important;
      background-color:#fcfdfd; 
      color:#222222;
  }
   .table-bordered th {
      border: 2px solid  a6c9e2 !important;
      background-color:#dfeffc ; 
        color#2e6e9e;
        font-weight:bold;
  } */
/*  .table-bordered tr:hover { 
   background-color: #fcfdfd;
} */
   
</style>



 <div   id="dateshow" >    
<div class=" form-row align-items-center" >
			<div class="col-md-2 " >
				<label class="form-check-label "  style="color:#2e6e9e; font-weight: initial;" >
					Date Range :
				</label>
			</div>
			<div class="col-md-8 " >
				<div class="input-group">
					<input id="datepicker1"  type="date" class="form-control" >&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="datepicker2"  type="date" class="form-control" onchange="dataLoadByDate()">
				</div>	
			</div>
			
			</div>
</div>

<div id="space" class="alert alert-info col-md-10">

</div>
<div class="alert alert-info col-md-10" id="info-alert1">
    		 		<label id="info">The below statistics are shown for a default range of last 3 days.
    		 		Please select a date range to filter!		<label>
</div>



<div class="col-md-12">
<table id="logtab" 
			class="table  table-bordered table-hover"
			data-toggle="table"  
		    data-sort-order="desc"
		   	data-pagination="true"  
		   	data-id-field="name2" 
		   	data-page-size="5"
		   	data-page-list="[5, 10, 25, 50, 100, ALL]" > 
  <thead id="theadid">
    
     <th data-sortable="true">
	                  PROJECT NAME
	                </th>
	                <th data-sortable="true" >
	                 FEED NAME
	                </th>
	                <th data-sortable="true"  >
	                 JOB NAME
	                </th>           
	                
	                   
	                <th data-sortable="true"  >
	                  RUN ID
	                </th>
	                <th data-sortale="true" >
	                 RUN DATE
	                </th>         
	                <th data-sortable="true" >
	                 JOB START TIME
	                </th>
	                   <th data-sortable="true" >
	                JOB END TIME
	                </th>
	                   <th data-sortable="true" >
	                 JOB STATUS
	                </th>
	                
	                 
    
  </thead>
                <tbody>
               <c:forEach var="row" items="${feedList}">
				<tr>
					<td class="tabprogid"></td>
					<td><c:out value="${row.feed_name}" /></td>
					<td><c:out value="${row.job_name}" /></td>
					<td><c:out value="${row.run_id}" /></td>
					<td><c:out value="${row.run_date}" /></td>
					<td><c:out value="${row.start_time}" /></td>
					<td><c:out value="${row.end_time}" /></td>
						
					<c:choose>
         
         <c:when test = "${row.status=='FAILED'}">
          <td> <a href="javascript:dataload('${row.job_name}','${row.log_type}','${row.comments}','${row.start_time}','${row.run_id}');"> <c:out value="${row.status}" /></a></td>
         </c:when>
         
         <c:when test = "${row.status== 'SUCCESS'}">
          <td><c:out value="${row.status}" /></td>
         </c:when>
       </c:choose>
   
				
				</tr>
			</c:forEach>
                  
                </tbody>
        	</table>
        	
        	
        	</div>
        	
        	 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        
          <h4 class="modal-title">Detail Log Description</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
       
       <table class="table table-hover table-sm table-striped table-bordered shadow p-3 mb-5 bg-white rounded table-condensed" id="detaillog" > 
  <thead id="theaddetail">
    
           <th>
	                 JOB_NAME
	                </th>
          <th>
	                 LOG_TYPE
	                </th>
       
      <th>
	                 COMMENTS
	                </th>
     </thead>
     
      <tbody id="tbodydetail">
        </tbody>
       </table>
       
       
       
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
                            

  
  
  
  
  