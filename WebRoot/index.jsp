<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <title>NCIT项目奖金管理系统</title>
    <script type="text/javascript" src="./script/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="./script/js/hchstudio.js"></script>
    <style type="text/css">
        *{margin: 0px;padding: 0px;}
        html,body{height: 100%;width: 100%;}
        body{overflow: hidden;}
        .main_top{width: 100%;height: 10%;
            background: -webkit-linear-gradient(#9abaf6, #7797e2, #415ed4); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(#9abaf6, #7797e2, #415ed4); /* Opera 11.6 - 12.0 */
            background: -moz-linear-gradient(#9abaf6, #7797e2, #415ed4); /* Firefox 3.6 - 15 */
            background: linear-gradient(#9abaf6, #7797e2, #415ed4); /* 标准的语法（必须放在最后） */  }
        .main_left_color{width: 18.6%;height: 100%;position: absolute;z-index: 4;border-right: 2px solid #9ed1f9;
            background: -webkit-linear-gradient(90deg, #2e98fc, #2887f7, #206ff0); /* Safari 5.1 - 6.0 */
            background: -o-linear-gradient(90deg, #2e98fc, #2887f7, #206ff0); /* Opera 11.6 - 12.0 */
            background: -moz-linear-gradient(90deg, #2e98fc, #2887f7, #206ff0); /* Firefox 3.6 - 15 */
            background: linear-gradient(90deg, #2e98fc, #2887f7, #206ff0); /* 标准的语法（必须放在最后） */  }
        dt{font-size: 17px;padding-top: 3%;padding-left: 10%;padding-bottom: 3%;border-bottom: 1px solid #76e0ff;cursor: Default;}
        dd{background: #f3f3f3;font-size: 16px;padding-left: 15%;padding-top: 2%;padding-bottom: 2%;cursor: Default;}
        dt img{margin-left: 56%;}
        dd a{text-decoration: none;color: #313131;}
        dd a:hover{color: #6bc7f7}
        .Innovator{
        	margin-left: -10%;
        	margin-top: -5%;
        	color: #121212;
        	font-size: 16px;
        	
        }
    </style>
</head>
<body>
<div class="main_top">
    <div style="position: absolute;z-index: 1;width: 100%;height: 10%;">
        <img style="height: 100%;margin-left: 18%;" src="./script/image/main_top2.png">
        <img style="height: 100%;margin-left: 8%;" src="./script/image/main_top1.png">
    </div>
    <div style="position: absolute;z-index: 2;width: 100%;height: 10%;">
        <div style="float: left;width: 10%;height: 100%;text-align: center;">
            <img style="max-width: 50%;margin-top: 10%;max-height: 72%;" src="./script/image/logo2.png">
        </div>
        <div style="float: left;">
            <div style="color: #4b76c4;margin-top: 10%;font-size: 30px;margin-left: -10%;">NTT DaTa</div>
            <div class="Innovator">Global IT Innovator</div>
        </div>
        <div style="float: left;color: white;font-size: 30px;margin-top: 1%;">软件项目工程师奖金管理系统</div>
        <div style="float: right;margin-right: 2%;width: 20%;height: 100%;">
            <div style="width: 100%;height: 50%;">
                <div style="float: right;color: white;margin-top: 5%;"><a href="${pageContext.request.contextPath }/">注销登录</a></div>
                <div style="float: right;margin-right: 5%;margin-top: 5%;">当前用户:${user.userName }</div>
            </div>
            <div style="color: white;text-align: right;"><a href="#">修改密码</a></div>
        </div>
    </div>
</div>
<div style="width: 18.7%;height: 90%;float: left;">
    <div style="width: 18.6%;height: 100%;position: absolute;z-index: 5;top: 100%;">
        <img style="width: 100%;margin-top: -200%;" src="./script/image/main_tab.png"/>
    </div>
    <div class="main_left_color"></div>
    <div style="width: 18.6%;height: 100%;position: absolute;z-index: 6;color: #fefefe;">
        <div style="font-size: 18px;padding-left: 5%;background: #006891;padding-top: 4%;padding-bottom: 4%;margin-top: 1%;">导航菜单</div>
        <div id="main_left_menu" style="width: 100%;height: 100%;">
        </div>
    </div>
</div>
<div class="main_right" style="width: 81.3%;height: 90%;float: left;">
    <iframe style="width: 100%;height: 100%;border-width: 0px;" name="adminifright" src="./jsp/welcome.jsp"></iframe>
</div>
<script type="text/javascript">
    var ip = "http://localhost:8080/";
    var url = ip + "NCIT1.5/treeList.action";
    $.ajax({
        type:"POST",
        url:url,
        dataType:"json",
        data: "",
        success: function (data) {
            var response = JSON.parse(data);
            var successData = response.success;
            console.log(response.data);
            var menuJSON = JSON.parse(response.data);
            var div_menu = document.getElementById("main_left_menu");
            for (var i = 0;i<menuJSON.length;i++){
                if (menuJSON[i].rightName != null) {
                    var dl = document.createElement("dl");
                    var dt = document.createElement("dt");
                    dt.innerHTML = menuJSON[i].rightName + "<img src=\"./script/image/select_xl01.png\">";
                    dt.setAttribute("onclick","slideTo(this)");
                    dl.appendChild(dt);
                    var children = menuJSON[i].children;
                    if (children != null) {
                        for (var j = 0; j<children.length;j++) {
                            var dd = document.createElement("dd");
                            var a = document.createElement("a");
                            a.setAttribute("href",children[j].url);
                            a.setAttribute("target","adminifright");
                            a.innerHTML = children[j].rightName;
                            dd.appendChild(a);
                            dd.setAttribute("style","display: none;");
                            dl.appendChild(dd);
                        }
                    }
                    div_menu.appendChild(dl);
                }
            }
        }
    });
    function slideTo(event) {
        if ($(event).parent().find('dd').eq(0).css("display") == "none") {
            $(event).parent().find('dd').slideDown();
            $(event).find("img").attr("src","./script/image/select_xl.png");
        } else {
            $(event).parent().find('dd').slideUp();
            $(event).find("img").attr("src","./script/image/select_xl01.png");
        }
    }
</script>
</body>
</html>