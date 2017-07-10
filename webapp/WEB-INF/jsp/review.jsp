<script type="text/javascript">
	$(function(){
		var newsid='${newsid}';
		var newstype='${newstype}';
		var page=1;//当前页码
		var pagesize=1;//一页显示多少条
		$("#cmdReview").click(function(){
			var getReviewCnt=$("#reviewcnt").val();
			if(getReviewCnt.trim()=="")
				alert("评论内容不能为空");
			else{
				  var $btn = $(this).button('loading')
				    // business logic...
				  $.post("/addreview",{"rcnt":getReviewCnt,"newsid":newsid,"newstype":newstype},function(result){
					  if(result=="unlogin")
						  {
						  alert("请先登录再评论");
						  }else if(result=="1"){
							  alert("评论发表成功");
						  }
					  $btn.button('reset')
				  });
				
			}
		});
		$("#loadView").click(function(){
			  var btn = $(this).button('loading');
			  
			  loadReview(btn);
		});
		 loadReview(null);
		function loadReview(bnt)
		{
			$.post("/loadreview",{"newsid":newsid,"newstype":newstype,"page":page,"pagesize":pagesize,"isload":1},function(result){
				 // alert(result);
				
				 page++;
				 if(bnt!=null)
					 {
						 bnt.button('reset');
					 }
					
				 var getReview=eval("("+result+")");//json->对象
				 if(getReview.length>0)
					 {
					 var htmlTpl=$('#reviewTpl').prop("outerHTML");
					 htmlTpl=htmlTpl.replace('id="reviewTpl"',"");
					 htmlTpl=htmlTpl.replace('display:none',"");
					 	for(var i=0;i<getReview.length;i++)
					 		{
					 			var newHtml=htmlTpl.replace("{reviewtime}",getReview[i].addtime);
					 			newHtml=newHtml.replace("{reviewcnt}",getReview[i].rcnt);
					 		
					 			$("#reviewlist").append(newHtml)
					 		}
					 
					 }else{
						 alert("后面没有评论了");
					 }
				  
			  })
		}
		
	})
</script>
<div class="panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title">发表评论</h3>
			  </div>
			  <div class="panel-body">
			  	<div class="row clearfix"><!-- 发表评论 -->
			  		<div class="col-md-12 column">
					
							<div class="form-group">
								<textarea rows="5" class="form-control" id="reviewcnt"></textarea>
							</div>
							
							
							 <button type="button" id="cmdReview" class="btn btn-success" data-loading-text="正在提交..." autocomplete="off" >提交</button>
						
					</div>
					
				</div>
				<!-- 评论列表 -->
				<div class="row clearfix col-md-11" style="margin-top:5px;display:none" id="reviewTpl">
					<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">用户名 发表时间：{reviewtime}</h3>
						  </div>
						  <div class="panel-body">
						  		<div class="col-md-9">{reviewcnt}</div>
						  </div>
					</div>
					
				</div>
				<div id="reviewlist">
				
				</div>
				<div class="row clearfix col-md-11" style="margin-top:10px;">
					 <button type="button" id="loadView" class="btn btn-info col-md-12" data-loading-text="正在加载..." autocomplete="off">加载更多评论</button>
				</div>
			 </div>
			
		</div>
		  