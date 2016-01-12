<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.mt20{
  margin-top: 20px;
}
</style>
</head>
<body>

<div style="text-align: center;">
  <div class="mt20"><label>账号：</label><input id="account" type="text"/></div>
  <div class="mt20"><label>姓名：</label><input id="name" type="text"/></div>
  <div class="mt20"><label>地址：</label><input id="address" type="text"/></div>
  <div class="mt20"><button id="addUser" >添加</button></div>
</div>

<h3>用户列表:</h3>
<ul id="userList">
</ul>

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>

<script>
  $(function() {
      $.ajax({
          url : 'queryAllUser.action',
          type : 'post',
          dataType : 'json',
          success : function(data) {
            try {
            	for(var i = 0; i < data.length; i++){
            		$("#userList").append("<li><span style='color:red'>id="+data[i].id+"</span>,account="+data[i].account+",name="+data[i].name+",address="+data[i].address+"</li>");
            	}
            } catch (e) {};
            
          }
          ,
          error : function(e) {
            alert("sys error");
          }
        });
        
    $("#addUser").on("click", function() {
      var account = $("#account").val();
      var name = $("#name").val();
      var address = $("#address").val();
      $.ajax({
        url : 'addUser.action',
        type : 'post',
        dataType : 'json',
        data : {
          account : account,
          name : name,
          address : address
        },
        success : function(data) {
          try {
            
            $("#userList").append("<li>account="+account+",name="+name+",address="+address+"</li>");
            alert("添加成功");
          } catch (e) {

          }
        },
        error : function(e) {
          alert("sys error");
        }
      });

    });
  });
</script>
</body>
</html>