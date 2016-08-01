<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>项目奖金分配</title>
    <script type="text/javascript" src="../script/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../script/js/hchstudio.js"></script>
    <link type="text/css" href="../script/css/admin.css" rel="stylesheet"/>
    <script type="text/javascript">
    </script>
    <style type="text/css">
        .martop2{margin-top: 2%;}
        .inline_con{border: 1px dashed #000;padding: 20px;}
        select{margin-left: 3%;height: 30px;}
    </style>
</head>
<body class="inline_body">
<div class="inline_divh2">
    <h2 id="approve_h2">项目奖金分配</h2>
</div>
<div class="martop2">批量导入:</div>
<div class="inline_con">
    <input id="uploadfile" style="width: 20%;font-size: 15px;" type="file" name="uploadfile"/>
    <input type="button" value="确定导入" style="margin-left: 20%;height: 31px;width: 10%;" onclick="upFile()"/>
</div>
<div style="margin-top: 2%;">手动分配:</div>
<div class="inline_con">
    <div><label>选择中心:
        <select id="div_center" onchange="seleChang()"></select>
    </label></div>
    <div><label>选择项目ID:
        <select id="div_proid" disabled="true">
            <option>ere</option>
            <option>erett</option>
        </select>
    </label></div>
</div>
<script type="text/javascript">
    var ip = "http://192.168.1.56:8080/";
    var url = ip + "NCIT1.3/importDis_whichCenter.action";
   // var jsondata = {"userAccount":nttdatajjname,"usersession":nttdatajjses};
    $.ajax({
        type: "POST",
        url: "./importDis_whichCenter.action",
        dataType: "json",
        data: "test",
        success: function (data) {
            console.log(data);
            var response = JSON.parse(data);
            var successData = response.success;
            if (successData == "loginError" || successData == ""){
                alert("未登录账户或已过期");
                window.location.href = "login.html";
            } else {
                setCookie('nttdatajjses',successData,30);
//                alert("导入成功");
                console.log(response.data);
                var arr = JSON.parse(response.data);
                var div_center = document.getElementById("div_center");
                for (let i = 0;i<arr.length;i++) {
                    console.log(arr[i].centerName);
                    var option = document.createElement("option");
                    option.innerHTML = arr[i].centerName;
                    div_center.appendChild(option);
                }
            }
        }
    });
    function seleChang() {
        var centerdiv = document.getElementById("div_center");
        var centeri = centerdiv.selectedIndex;
        var text = centerdiv.options[centeri].value;
        var center = "";
        switch (text) {
            case "无锡开发中心":
                center = "W";
                break;
            case "长春开发中心":
                center = "C";
                break;
            case "天津开发中心":
                center = "T";
                break;
            case "西安开发中心":
                center = "X";
                break;
            case "北京开发中心":
                center = "B";
                break;
        }
        console.log(center);
        var pro_url = ip + "NCIT1.3/importDis_selectProjectId.action";
        var pro_jsondata = {"center":center};
        $.ajax({
            type: "POST",
            url: "./importDis_selectProjectId.action",
            dataType: "json",
            data: pro_jsondata,
            success: function (data) {
                console.log(data);
                var response = JSON.parse(data);
                var successData = response.success;
                if (successData == "loginError" || successData == ""){
                    alert("未登录账户或已过期");
                    window.location.href = "login.html";
                } else {
//                    setCookie('nttdatajjses',successData,30);
////                alert("导入成功");
//                    console.log(response.data);
//                    var arr = JSON.parse(response.data);
//                    var div_center = document.getElementById("div_center");
//                    for (let i = 0;i<arr.length;i++) {
//                        console.log(arr[i].centerName);
//                        var option = document.createElement("option");
//                        option.innerHTML = arr[i].centerName;
//                        div_center.appendChild(option);
//                    }
//                    document.getElementById("div_proid").disabled = false;
                }
            }
        });
    }
    function upFile() {
        var import_url = ip + "NCIT1.3/importDis_analyzeAndSaveData.action";
        console.log(import_url);
        var file = document.getElementById("uploadfile").files[0];
        if (file == null) {
            alert("上传文件不能为空");
            return;
        }
        var formData = new FormData();
       // formData.append("userAccount",nttdatajjname);
        //formData.append("usersession",nttdatajjses);
        formData.append("uploadfile",file);
        $.ajax({
            url: "./importDis_analyzeAndSaveData.action",
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data);
                var response = JSON.parse(data);
                var successData = "user";
                if (successData == null){
                    alert("未登录账户或已过期");
                    window.location.href = "./login.jsp";
                } else {
                    //setCookie('nttdatajjses',successData,30);
                    alert("导入成功");
                }
            }
        });
    }
</script>
</body>
</html>