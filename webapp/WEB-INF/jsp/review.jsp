<script>
	$(function(){
		var newsid='${newsid}';
		var newstype='${newstype}';
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
		})
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
				<div class="row clearfix col-md-11" style="margin-top:10px;">
					<div class="panel panel-default">
							<div class="panel-heading">
						    	<h3 class="panel-title">用户名 发表时间：2015-4-9</h3>
						  </div>
						  <div class="panel-body">
						  		<div class="col-md-9">评论内容</div>
						  </div>
					</div>
					
				</div>
			 </div>
			
		</div>
		  