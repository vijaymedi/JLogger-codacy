<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="cdg_header.jsp" />

<link href="${pageContext.request.contextPath}/assets/css/bootstrap-table.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/pagination.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.min.js"></script>
	<style>

#loading {
   width: 100%;
   height: 100%;
   top: 0;
   left: 0;
   position: static;
   display: block;
   opacity: 1;
  z-index: 99;
   text-align: center;
}

#loading-image {
  position: fixed;
  top: 250px;
  left: 600px;
  z-index: 99;
}
.table-bordered tr {
    border: 1px solid  #a6c9e2 !important;
  }
/*  .scrollstyle {
     overflow-y: auto;   
     overflow-x: auto;  
} */

/* table tr:hover { 
   background-color: #d0e5f5;
} */


   .table-bordered th,
   .table-bordered tr {
    border: 1px solid  #a6c9e2 !important;
  }
  .table-bordered th {
   color:#2e6e9e;
   font-weight:bold;	
   background-color:#dfeffc; 
  } 

/*  table tr.active {background: #fbec88 ;} */
/* width */
/* ::-webkit-scrollbar {
  width: 10px;
} */

/* Track */
/* .tabscroll::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
  border-radius: 10px;
} */
 
/* Handle */
/* #tabid::-webkit-scrollbar-thumb {
  background: grey; 
  border-radius: 10px;
} */

/* Handle on hover */
/* #tabid::-webkit-scrollbar-thumb:hover {
  background: grey; 
}
 */

/* .table-dark th,.table-dark td,.table-dark thead th{
border-color:#fff;
} */

	</style>
	
<script type="text/javascript">
	
	function dataload(job_name,log_typ,comments,start_time,run_id){
		$(".detailtablerow").empty();
		if(log_typ=="nifi"){
			$('#myModal').modal('show'); 
			$('#tbodydetail:last').after('<tr class=detailtablerow><td>' + job_name + '</td><td>' + log_typ  + '</td><td>' +comments + '</td></tr>');
		//	$('#tbodydetail').html(tblHtml);	
			
		}
		else{
			
			$.post('${pageContext.request.contextPath}/details',
					{
					job_name : job_name,
					log_typ : log_typ,
					start_time:start_time,
					run_id:run_id
					
					}, function(data) {
						$(".detailtablerow").empty();
					//$('#modal-body').html(data);
						
					if(data.length==0){
						
						 alert("System error. please try after some time");
					}
					for (i = 0; i < data.length; i++) {
							$('#myModal').modal('show'); 
						$('#tbodydetail:last').after('<tr class=detailtablerow><td>' + job_name + '</td><td>' + log_typ + '</td><td>' + data[i].job_status_detail_desc + '</td></tr>');
						}
						//$('#tbodyid').html(tblHtml);
						
					}).fail(function() {
						  alert("System error. please try after some time  ");
						 
						  });
		}
		
		
	}

	
	/* function check() {
	var len=document.getElementById("project_name").options.length;
		if(len==0){
		    alert("System error. please try after some time  ");
		}
	} */
	
	function dataLoadByDate(){
		
		$('#loading').show();
		
		
		var start=document.getElementById("datepicker1").value;
		var end=document.getElementById("datepicker2").value;
		var date1 = new Date(start);
		var date2 = new Date(end);
		var timeDiff = Math.abs(date2.getTime() - date1.getTime());
		var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
		var e = document.getElementById("project_name");
		
        var strUser = e.options[e.selectedIndex].text;
		var projectName = document.getElementById('project_name').value;
		
		var feed_id = document.getElementById('feed_id').value;
		
					if(document.getElementById("datepicker1").value < document.getElementById("datepicker2").value){
						if(document.getElementById("datepicker1").value=="")
						{
						 alert("START DATE equals END DATE");
						 var date1 = document.getElementById("datepicker2").value;
						}
						else
						{
							var date1 = document.getElementById("datepicker1").value;
						}
					var date2 = document.getElementById("datepicker2").value;
					var date = date1 + " - "+ date2;
					
					if (feed_id != '' && date != '') {
					$.post('${pageContext.request.contextPath}/logDetails',
					{
						'projectName' : projectName,
						'feed_id' : feed_id,
						'start_date':start,
						'end_date':end,
						'diffDays':diffDays
					},
					function(data) {
						$('#loading').hide();
							$('#addFeed1').html(data);
							$('#datepicker1').val(start);
							$('#datepicker2').val(end);
						
				$('.tabprogid').html(strUser);
			$('#info-alert1').hide();
		//	$('#space').show();
			$("#space").html("<center>The below statistics are shown from "+start+" and "+end+"</center>");
			
				
					}
					).fail(function() {
						  alert("System error. please try after some time  ");
					    $('#loading').hide();
					  });
					}
					}else{
						alert("START DATE IS GREATER THAN END DATE");
					}
				
	
	}
	/* function loadMsg(e)
	 {
	 $('.tablerow').closest('tr').attr("style",'background-color:none');
	 $(e).css('background-color','#fad42e');	
	 } */

	//Document Ready----Start
	
	
	
	
	
	
	
	$(document)
			.ready(
					function() {

						
					
						$('#loading').hide();		
						
					

						$("#project_name")
								.change(
										function() {
											$('#loading').show();	
											var projectName = document
													.getElementById('project_name').value;

											$
													.ajax({
														type : "POST",
														url : '${pageContext.request.contextPath}/feedDetails',
														data : {
															'projectName' : projectName
														},
														success : function(data) {
															$('#loading').hide();	
															if (!$.trim(data)){  
																$("#feedidshow").hide();
																$('#addFeed1').hide();
																
															    alert("Feed is not available for the selected project");
															    
															}
															else{   
																$("#feedidshow").show();
																var selectList = $("#feed_id");
																selectList
																		.find(
																				"option:gt(0)")
																		.remove();
																var option = '';
																for (var i = 0; i < data.length; i++) {
																	option += '<option id=prid value="'+ data[i] + '">'
																			+ data[i]
																			+ '</option>';
																}
																$('#feed_id')
																		.append(
																				option);
															}
															
															
													

														},
														  error: function(XMLHttpRequest, textStatus, errorThrown) {
															     alert("System error. please try after some time  ");
															 	$('#loading').hide();	
															  }
														
														
														
													})
										});

					

						$("#feed_id")
								.change(
										function() {
											$('#loading').show();
											var projectName = document
													.getElementById('project_name').value;
											var e = document
													.getElementById("project_name");
											var strUser = e.options[e.selectedIndex].text;
											var feed_id = document
													.getElementById('feed_id').value;

											$
													.ajax({
														type : "POST",
														url : '${pageContext.request.contextPath}/logDetails',
														data : {
															'projectName' : projectName,
															'feed_id' : feed_id,
															'start_date':'',
															'end_date':'',
															'diffDays':0
														},
														success : function(data) {
															$('#loading').hide();
															$("#addFeed1").show();
															$('#addFeed1')
																	.html(data);
															$('.tabprogid')
																	.html(strUser);
															$('#space').hide();		
															
														},
														  error: function(XMLHttpRequest, textStatus, errorThrown) {
															     alert("System error. please try after some time  ");
															 	$('#loading').hide();	
															  }
													})
										});
						
						
						
						
						
				

					});
	//$( "#tbodyid" ).scrollTop( 300 );
	//$.scrollTo($('#tbodyid'), 1000);
	
	

	
	
</script>


	<body>					
<div class="main-panel" style="width: 100%;height:100%">
<div class="content-wrapper">
		<div class="row">
			<div class="col-12 grid-margin stretch-card">
			<div class="card">
					<div class="card-body">
					<div class="row">
					<div class="col-sm-12">
					<h5 style="text-align:right;">
					<a href="text-decoration:none;" href="/JuniperHome">HOME</a>
</h5>
</div></div>
				
						<div class="row">	
							<label class=" col-md-2 " style="color:#2e6e9e; font-weight: initial;" >
					            Project Name:
					        </label>
					         <div class=" form-group col-md-8">
								<select name="project_name"
										id="project_name" class="js-example-basic-single form-control" >
										<option value="" selected disabled>Select Project Name ...</option>
										<c:forEach items="${pltList}" var="pltList1">
											<option value="${pltList1.project_sequence}">${pltList1.project_name}</option>
										</c:forEach>
									</select>
							</div>
                          </div>
							
							
						 <div class="row" id="feedidshow" style="display:none">	
							<label class=" col-md-2"  style="color:#2e6e9e; font-weight: initial;" >
					            Select Feed :
					        </label>
					         <div class="form-group col-md-8">
								<select name="feed_id"
										id="feed_id" class="js-example-basic-single form-control">
										<option value="" selected disabled>Select Feed ...</option>
									
									</select>
							</div>
                          </div>
                          

                          
						<!-- 	
							<table id="list2"></table>
							<div id="pager2"></div> -->
							
							
		<div id="addFeed1" ></div>
		<div class="col-md-12">
		
<!-- 		<table id="dashboard1" 
			class="table table-hover table-sm table-striped table-bordered shadow p-3 mb-5 bg-white rounded table-condensed"
			data-show-header="true"
			data-classes="table table-hover table-striped table-sm table-bordered shadow p-3 mb-5 bg-white rounded table-condensed"
			 data-toggle="table"  
			data-striped="true"
		    data-sort-order="desc"
		   	data-pagination="true"  
		   	data-id-field="name2" 
		   	data-page-size="5"
		   	data-page-list="[5, 10, 25, 50, 100, ALL]" > 
  <thead id="theadid">
    <tr>
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
	                 PROCESS NAME
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
	                 
    </tr>
  </thead>
  <tbody id="tbodyid">

  </tbody>
</table> -->
       <div id="loading" >
<img id="loading-image" src="../assets/img/load.gif" alt="Loading..." />
</div>

        	</div>
	
													   		 			
						 </div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
							
<jsp:include page="cdg_footer.jsp" />
			