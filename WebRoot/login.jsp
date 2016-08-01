<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8" />
    <title>用户登录</title>
    <script type="text/javascript" src="./script/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="./script/js/hchstudio.js"></script>
    <script type="text/javascript" src="./script/js/md5.js"></script>
    <style type="text/css">
        *{margin: 0px;padding: 0px;}
        html,body{height: 100%;width: 100%;}
        .fat_div{height: 100%;width: 100%;text-align: center;
            background: -webkit-radial-gradient(#aac6db, #0C80B0); /* Safari 5.1 - 6.0 */
            background: -o-radial-gradient(#aac6db, #0C80B0); /* Opera 11.6 - 12.0 */
            background: -moz-radial-gradient(#aac6db, #0C80B0); /* Firefox 3.6 - 15 */
            background: radial-gradient(#aac6db, #0C80B0); /* 标准的语法（必须放在最后） */}
        .login_back_log{width: 100%;height: 20%;position: absolute;top: 53%;border-bottom-width: 2px;
            -moz-border-bottom-color: #fff #04a5e0;
            background: -webkit-linear-gradient(#f6f6f6, #b7dcff, #9dc6fe); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#f6f6f6, #b7dcff, #9dc6fe); /* Opera 11.1 - 12.0 */
            background: -moz-linear-gradient(#f6f6f6, #b7dcff, #9dc6fe); /* Firefox 3.6 - 15 */
            background: linear-gradient(#f6f6f6, #b7dcff, #9dc6fe); /* 标准的语法 */
        }
    </style>
</head>
<body>
<div class="fat_div" >
    <div style="width: 100%;position: absolute;top: 5.8%">
        <img style="width: 25%;" src="./script/image/logo_left.png">
        <img style="width: 20%;position: absolute;" src="./script/image/logo1.png">
        <img style="width: 25%;margin-left: 20%;margin-top: 2.7%" src="./script/image/logo_right.png">
    </div>
    <div style="width: 100%;position: absolute;top: 29%;color: #fdfdfd;font-size: 36px;margin: 0 auto;text-align: center;">工程师奖金管理系统</div>
    <div class="login_back_log"></div>
    <div style="width: 100%;position: absolute;top: 36%;">
        <img style="width: 54%" src="./script/image/login_back.png">
        <form action="${pageContext.request.contextPath }/Login.action" method="post" >
	        <div style="position: absolute;top: 0%;width: 100%;height: 100%;color: #0f0f0f;font-size: 20px;line-height: 34px;">
	            <div style="margin-top: 8%;">帐号<input style="height: 30px;margin-left: 2%;" type="text" id="username" name="userAccount"/></div>
	            <div style="margin-top: 1.5%;">密码<input style="height: 30px;margin-left: 2%;" type="password" id="password" name="userPwd"/></div>
	            <input style="width: 13%;height: 35px;background: #6485c1;margin-top: 2%;border-width: 0px;" type="submit" value="登陆"/>
	        </div>
        </form>
        <font color="red" width: 100%;position: absolute;top: 0px;margin-top: 15%;><s:fielderror/></font>
        <div id="login_error" style="color: red;width: 100%;position: absolute;top: 0px;margin-top: 15%;display: none">帐号或密码错误</div>
    </div>
</div>
<script type="text/javascript">
   /*   var ip = "http://localhost:8080/";
//    var url = "http://123.206.8.147:80/NCIT1.3/Login.action";
    var url = ip + "NCIT1.5/Login.action";
    function postLogin() {
        var username = document.getElementById("username").value;
        var password = hex_md5(document.getElementById("password").value);
        if (username == null || username == ""){
            alert("帐号不能为空");
            return;
        }
        if (password == null || password == ""){
            alert("密码不能为空");
            return;
        }
        var jsondata = {'userAccount':username,'userPwd':password};
         $.ajax({
            type:"POST",
            url:url,
            dataType:"json",
            data: jsondata,
            success:function (data) {
                var response = JSON.parse(data);
                var successData = response.success;
                if (successData == "loginError" || successData == ""){
                    document.getElementById("login_error").style.display = "";
                } else {
                    console.log(successData);
                    setCookie('nttdatajjname',username,30);
                    setCookie('nttdatajjses',successData,30);
                    window.location.href = "./index.jsp";
                }
            }
        }); 
    }  */
</script>
</body>
</html>