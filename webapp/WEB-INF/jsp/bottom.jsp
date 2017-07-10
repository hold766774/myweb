<script>
$(function(){
	 //消息循环判断
	 function getMsgAlert()
	 {
		 $.post("/getmsg",null,function(result){
			 if(result!=null){
				 if(result=="0"){
					 $("#msgAlert").removeClass("msg");
					 setTimeout("getMsgAlert()",5000);//自己的调用自己
				 }else if(result=="1"){
					 $("#msgAlert").addClass("msg");
				 }else{
					 $("#msgAlert").removeClass("msg");
				 }
					 
					 
			 }
				 
		 });
	 }
	 getMsgAlert();
 });

</script>
</body>
</html>