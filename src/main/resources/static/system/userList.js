/**
 *  用户列表
 *//*

//$(function(){
//	selectUserList();
//});

      

function selectUserList(){
	
	var beginTime = $("#start").val();
	var beginTime = $("#end").val();
	var beginTime = $("#username").val();
	
	var formdata = new FormData($("#userID")[0]);
	
	alert(formdata);
	
	  $.ajax({
	        url:'user/userList',
	        type:'post',
	        data: formdata,
	        contentType: false,
	        success:function(res){
	            console.log(res.data);
	            if(res.data["code"]=="succ"){
	                alert('成功');
	            }else if(res.data["code"]=="err"){
	                alert('失败');
	            }else{
	                console.log(res);
	            }
	        }
	  })
}*/