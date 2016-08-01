<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCIT项目奖金管理系统</title>
    <script type="text/javascript" src="../script/js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../script/js/hchstudio.js"></script>
    <link type="text/css" href="../script/css/admin.css" rel="stylesheet"/>
    <style type="text/css">
        #info_content{font-size: 18px;}
        #info_content label{width: 33%;display: inline-block;text-align: center;line-height: 36px;}
        .info_head{border-bottom: 1px solid #000;margin-top: 2%;padding-left: 1%;font-size: 20px;margin-bottom: 1%;}
        .info_input{width: 30%;height: 25px;}
        .div_far{height: 350px;margin-top: 2%;border: 1px solid #0f0f0f;}
        #sec_content{width: 100%;text-align: center;}
        #sec_content label{width: 14%;height: 34px;display: inline-block;overflow: hidden;border-bottom: 1px dashed #0f0f0f;border-left: 1px dashed #0f0f0f;}
        .sec_sub_head{width: 6.9%;float: left;height: 69px;border-bottom: 1px dashed #0f0f0f;}
        .sec_sub_div{float: left;width: 93%;height: 35px;overflow: hidden;}
        .border_null{border-bottom-width: 0px;}
        .div_but{text-align: right;margin-top: 2%;}
        .div_but input{margin-right: 5%;font-size: 18px;padding: 3px 6px;}
    </style>
    <script type="text/javascript">
        /* var nttdatajjname = getCookie("nttdatajjname");
        var nttdatajjses = getCookie("nttdatajjses");
        console.log("import_approve---" + nttdatajjname + "---" + nttdatajjses);
        if (nttdatajjses == null || nttdatajjname == null || nttdatajjses == "" || nttdatajjname == ""){
            alert("未登录账户或已过期");
            window.location.href = "login.html";
        } */
    </script>
</head>
<body class="inline_body">
<div class="inline_divh2">
    <h2 id="approve_h2">申请数据导入</h2>
</div>
<div id="div_fir" style="position: absolute;z-index: 1;width: 98%;">
    <div>
        <label>请选择数据导入方式:</label>
        <label><input type="radio" name="type" checked="checked" value="fileUp" onclick="showiU()"/>文件上传</label>
        <label><input type="radio" name="type" value="single" onclick="showiC()"/>手动录入</label>
    </div>
    <div style="margin-top: 2%;">
        <input id="uploadfile" style="width: 20%;font-size: 15px;" type="file" name="uploadfile"/>
    </div>
    <div id="info_content">
        <div>
            <div class="info_head">项目基本信息</div>
            <label>项目名称：<input id="projectName" class="info_input" type="text" name="projectName" value="wewe"/></label>
            <label>申请者ID：<input id="applyId" class="info_input" type="text" name="applierId" value="001"/></label>
            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;财务ID：<input id="financeId" class="info_input" type="text" name="financeId" value="5W211011605"/></label>
        </div>
        <div>
            <label>&nbsp;&nbsp;&nbsp;&nbsp;部门ID：<input id="departmentId" class="info_input" type="text" name="departmentId" value="003"/></label>
            <label>部门名称：<input id="department" class="info_input" type="text" name="department" value="jdhd"/></label>
            <label>PM员工ID：<input id="pmId" class="info_input" type="text" name="pmId" value="0016"/></label>
        </div>
        <div>
            <div class="info_head">项目开发信息</div>
            <label>社员人月数：<input id="memberPersonMonth" class="info_input" type="text" name="memberPersonMonth" value="10"/></label>
            <label>BP人月数：<input id="bPPersonMonth" class="info_input" type="text" name="BPPersonMonth" value="2"/></label>
            <label>离职人月数：<input id="quitPersonMonth" class="info_input" type="text" name="quitPersonMonth" value="1"/></label>
        </div>
        <div>
            <label>连携人月数：<input id="workPersonMonth" class="info_input" type="text" name="workPersonMonth" value="0"/></label>
            <label style="display: none;">BP人月数<input type="text" name="pmId"/></label>
            <label style="display: none;">离职人月数<input type="text" name="financeId"/></label>
        </div>
        <div>
            <div class="info_head">项目申请日期</div>
            <label>申请日期：<input id="applyDate" class="info_input" type="text" name="applyDate" value="1433174400000"/></label>
            <label>审批日期：<input id="approveDate" class="info_input" type="text" name="approveDate" value="1434384000000"/></label>
            <label>申请对象期间：<input id="applyDuration" class="info_input" type="text" name="applyDuration" value="ewrtwet w"/></label>
        </div>
        <div>
            <label style="width: 100%;">
                备注：<input id="note" style="width: 81%;" class="info_input" type="text" name="note" value="mukyj"/>
            </label>
        </div>
    </div>
    <div class="div_but">
        <input type="button" value="下一步" onclick="postData()"/>
    </div>
</div>
<div id="div_sec" style="position: absolute;z-index: 2;width: 98%;display: none;">
    <div id="sec_content"></div>
    <div class="div_but">
        <input type="button" value="确认导入" onclick="aff_import()"/>
    </div>
</div>
<script type="text/javascript">
    var postType = "";
    var ip = "http://192.168.1.56:8080/";
    initFirst();
    //初始化第一个界面
    
    function initFirst() {
        document.getElementById("approve_h2").innerHTML = "申请数据导入";
        document.getElementById("div_fir").style.display = "";
        document.getElementById("div_sec").style.display = "none";
        showiU();
    }
    function initSecond() {
        document.getElementById("approve_h2").innerHTML = "导入数据确认";
        document.getElementById("div_fir").style.display = "none";
        document.getElementById("div_sec").style.display = "";
    }
    //显示上传文件视图
    function showiU() {
        postType = "showiU";
        document.getElementById("uploadfile").disabled = false;
        var info_inputs = document.getElementsByClassName("info_input");
        for (let i = 0;i < info_inputs.length; i++) {
            info_inputs[i].disabled = true;
        }
    }
    //显示单条录入视图
    function showiC() {
        postType = "showiC";
        var info_inputs = document.getElementsByClassName("info_input");
        for (let i = 0;i < info_inputs.length; i++) {
            info_inputs[i].disabled = false;
        }
        document.getElementById("uploadfile").disabled = true;
    }
    //第一次数据请求
    function postData() {
        console.log(postType);
        if ( postType == "showiU") {        //文件上传
            getInfofromFile();
        } else if ( postType == "showiC") { //单条录入
            getInfofrom();
        }
    }
    //文件上传
    function getInfofromFile() {
        var import_url = ip + "NCIT1.5/import_approve.action";
        console.log(import_url);
        var file = document.getElementById("uploadfile").files[0];
        if (file == null) {
            alert("上传文件不能为空");
            return;
        }
        var formData = new FormData();
        /* formData.append("userAccount",nttdatajjname);
        formData.append("usersession",nttdatajjses); */
        
        formData.append("uploadfile",file);
        $.ajax({
            url: "./import_approve.action",
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                var response = JSON.parse(data);
                var successData = "user";
                if (successData == null){
                    alert("未登录账户或已过期");
                    window.location.href = "login.jsp";
                } else {
                    //setCookie('nttdatajjses',successData,30);
                    infoSec(response.data);
                    initSecond();
                }
            },
            error: function (returndata) {
               // console.log(returndata);
            }
        });
    }
    //单条录入数据上传
    function getInfofrom() {
        var import_url = ip + "NCIT1.5/import_singleApprove.action";
        console.log(import_url);
        var jsondata = {
            "data":JSON.stringify([{
                "projectName":document.getElementById("projectName").value,
                "applyId":document.getElementById("applyId").value,
                "financeId":document.getElementById("financeId").value,
                "departmentId":document.getElementById("departmentId").value,
                "departmentName":document.getElementById("department").value,
                "pmId":document.getElementById("pmId").value,
                "memberPersonMonth":document.getElementById("memberPersonMonth").value,
                "bPPersonMonth":document.getElementById("bPPersonMonth").value,
                "quitPersonMonth":document.getElementById("quitPersonMonth").value,
                "workPersonMonth":document.getElementById("workPersonMonth").value,
                "applyDate":document.getElementById("applyDate").value,
                "approveDate":document.getElementById("approveDate").value,
                "applyDuration":document.getElementById("applyDuration").value,
                "note":document.getElementById("note").value
            }])
        };
        //console.log(jsondata);
        $.ajax({
            type: "POST",
            url: "./import_singleApprove.action",
            dataType: "json",
            data: jsondata,
            success: function (data) {
                var response = JSON.parse(data);
                var successData = "test";
                if (successData == null){
                    alert("未登录账户或已过期，请重新登录！");
                    window.location.href = "login.jsp";
                } else {
//                    setCookie('nttdatajjses',successData,30);
                    console.log(data);
                    infoSec(response.data);
                    initSecond();
                }
            }
        });
    }
    //
    function infoSec(dataStr) {
        var infoJSON = JSON.parse(dataStr);
        var sec_content = document.getElementById("sec_content");
        for (let i = 0;i < infoJSON.length; i++) {
            var info = infoJSON[i];
            var sec_sub_head;
            var sec_sub1;
            var sec_sub_div;
            var label;
            console.log(infoJSON[i]);
            var div_far = document.createElement("div");
            div_far.setAttribute("class","div_far");


            sec_sub1 = document.createElement("div");

            sec_sub_head = document.createElement("div");
            sec_sub_head.setAttribute("class","sec_sub_head");
            sec_sub_head.innerHTML = "项目基本信息";
            sec_sub1.appendChild(sec_sub_head);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.innerHTML = "申请者ID";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "财务ID";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "部门";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目名称";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "PM员工ID";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "申请对象期间";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "备注";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.setAttribute("id","applyId" + i);
            label.innerHTML = info.applyId;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","financeId" + i);
            label.innerHTML = info.financeId;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","department" + i);
            label.innerHTML = info.department;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","projectName" + i);
            label.innerHTML = info.projectName;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","pmId" + i);
            label.innerHTML = info.pmId;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","applyDuration" + i);
            label.innerHTML = info.applyDuration;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","note" + i);
            label.innerHTML = info.note;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            div_far.appendChild(sec_sub1);


            sec_sub1 = document.createElement("div");

            sec_sub_head = document.createElement("div");
            sec_sub_head.setAttribute("class","sec_sub_head");
            sec_sub_head.setAttribute("style","height: 139px;");
            sec_sub_head.innerHTML = "金额计算";
            sec_sub1.appendChild(sec_sub_head);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.innerHTML = "项目人月";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "BP人月";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "社员人月";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "BP率";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "奖金(社员分)";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "中心共通经费(BP)";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "连携人月";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.setAttribute("id","projectPersonMonth" + i);
            label.innerHTML = info.projectPersonMonth;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bPPersonMonth" + i);
            label.innerHTML = info.bPPersonMonth;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","memberPersonMonth" + i);
            label.innerHTML = info.bPPersonMonth;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bPRate" + i);
            label.innerHTML = info.bPRate;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bonusMember" + i);
            label.innerHTML = info.bonusMember;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","centerFund" + i);
            label.innerHTML = info.centerFund;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","workPersonMonth" + i);
            label.innerHTML = info.workPersonMonth;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.innerHTML = "奖金(连携分)";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "奖金(社员分+连携分)";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "奖金总额";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "申请日期";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "审批日期";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("style","border-bottom-color: #ffffff;");
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("style","border-color: #ffffff;");
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.setAttribute("id","bounsWork" + i);
            label.innerHTML = info.bounsWork;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bounsMemberWork" + i);
            label.innerHTML = info.bounsMemberWork;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bounsTotal" + i);
            label.innerHTML = info.bounsTotal;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","applyDate" + i);
            label.innerHTML = info.applyDate;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","approveDate" + i);
            label.innerHTML = info.approveDate;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","centerFund");
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","workPersonMonth");
            label.setAttribute("style","border-left-color: #ffffff;");
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            div_far.appendChild(sec_sub1);


            sec_sub1 = document.createElement("div");

            sec_sub_head = document.createElement("div");
            sec_sub_head.setAttribute("class","sec_sub_head");
            sec_sub_head.innerHTML = "总则";
            sec_sub1.appendChild(sec_sub_head);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.innerHTML = "项目经费比例上限";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目经费金额上限";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目奖金比例下限";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目奖金金额下限";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "中心共通经费";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目奖金比例";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "项目经费金额";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.setAttribute("id","ratioUp" + i);
            label.innerHTML = info.ratioUp;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","fundUp" + i);
            label.innerHTML = info.fundUp;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","ratioBounsDown" + i);
            label.innerHTML = info.ratioBounsDown;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bounsDown" + i);
            label.innerHTML = info.bounsDown;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","centerFund" + i);
            label.innerHTML = info.centerFund;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","recommendRatio" + i);
            label.innerHTML = info.recommendRatio;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","recommendFund" + i);
            label.innerHTML = info.recommendFund;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            div_far.appendChild(sec_sub1);


            sec_sub1 = document.createElement("div");

            sec_sub_head = document.createElement("div");
            sec_sub_head.setAttribute("class","sec_sub_head");
            sec_sub_head.innerHTML = "细则";
            sec_sub1.appendChild(sec_sub_head);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.innerHTML = "离职人月数";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "奖金(离职分)";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "奖金总额";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "中心奖金";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "本部项目奖金";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "部门项目奖金";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.innerHTML = "PM项目奖金";
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            sec_sub_div = document.createElement("div");
            sec_sub_div.setAttribute("class","sec_sub_div");
            label = document.createElement("label");
            label.setAttribute("id","quitPersonMonth" + i);
            label.innerHTML = info.quitPersonMonth;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bounsQuit" + i);
            label.innerHTML = info.bounsQuit;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","bounsTotal" + i);
            label.innerHTML = info.bounsTotal;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","centerBouns" + i);
            label.innerHTML = info.centerBouns;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","baseDepartDouns" + i);
            label.innerHTML = info.baseDepartDouns;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","departmentBouns" + i);
            label.innerHTML = info.departmentBouns;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);
            label = document.createElement("label");
            label.setAttribute("id","pmBouns" + i);
            label.innerHTML = info.pmBouns;
            sec_sub_div.appendChild(label);
            sec_sub1.appendChild(sec_sub_div);

            div_far.appendChild(sec_sub1);


            sec_content.appendChild(div_far);
        }
    }
    //确认导入
    function aff_import(){
        var import_url = ip + "NCIT1.5/import_approveSaveData.action";
        var arr = new Array();
        var div_arr = document.getElementsByClassName("div_far");
        for (let i = 0; i<div_arr.length; i++) {
            arr.push({
                "applyId":document.getElementById("applyId" + i).innerHTML,
                "financeId":document.getElementById("financeId" + i).innerHTML,
                "departmentName":document.getElementById("department" + i).innerHTML,
                "projectName":document.getElementById("projectName" + i).innerHTML,
                "pmId":document.getElementById("pmId" + i).innerHTML,
                "applyDuration":document.getElementById("applyDuration" + i).innerHTML,
                "note":document.getElementById("note" + i).innerHTML,
                "projectPersonMonth":document.getElementById("projectPersonMonth" + i).innerHTML,
                "bPPersonMonth":document.getElementById("bPPersonMonth" + i).innerHTML,
                "memberPersonMonth":document.getElementById("memberPersonMonth" + i).innerHTML,
                "bPRate":document.getElementById("bPRate" + i).innerHTML,
                "bonusMember":document.getElementById("bonusMember" + i).innerHTML,
                "centerFund":document.getElementById("centerFund" + i).innerHTML,
                "workPersonMonth":document.getElementById("workPersonMonth" + i).innerHTML,
                "bounsWork":document.getElementById("bounsWork" + i).innerHTML,
                "bounsMemberWork":document.getElementById("bounsMemberWork" + i).innerHTML,
                "bounsTotal":document.getElementById("bounsTotal" + i).innerHTML,
                "applyDate":document.getElementById("applyDate" + i).innerHTML,
                "approveDate":document.getElementById("approveDate" + i).innerHTML,
                "ratioUp":document.getElementById("ratioUp" + i).innerHTML,
                "fundUp":document.getElementById("fundUp" + i).innerHTML,
                "ratioBounsDown":document.getElementById("ratioBounsDown" + i).innerHTML,
                "bounsDown":document.getElementById("bounsDown" + i).innerHTML,
                "recommendRatio":document.getElementById("recommendRatio" + i).innerHTML,
                "recommendFund":document.getElementById("recommendFund" + i).innerHTML,
                "quitPersonMonth":document.getElementById("quitPersonMonth" + i).innerHTML,
                "bounsQuit":document.getElementById("bounsQuit" + i).innerHTML,
                "centerBouns":document.getElementById("centerBouns" + i).innerHTML,
                "baseDepartDouns":document.getElementById("baseDepartDouns" + i).innerHTML,
                "departmentBouns":document.getElementById("departmentBouns" + i).innerHTML,
                "pmBouns":document.getElementById("pmBouns" + i).innerHTML
            });
        }
        var jsondata = {"data":JSON.stringify(arr)
        };
        console.log(jsondata);
        $.ajax({
            type: "POST",
            url: "./import_approveSaveData.action",
            dataType: "json",
            data: jsondata,
            success: function (data) {
                console.log(data);
                var response = JSON.parse(data);
                var successData = "test";
                if (successData == null){
                    alert("未登录账户或已过期");
                    window.location.href = "login.jsp";
                } else {
                    //setCookie('nttdatajjses',successData,30);
                    alert("导入成功");
                    //initFirst();
                    window.location.href = "./welcome.jsp";//跳转到欢迎页面
                }
            }
        });
    }
</script>
</body>
</html>