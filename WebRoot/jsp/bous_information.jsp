<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/script/css/inquiry_distribution.css">
<title></title>
</head>
<body>
<div class="indis_rightinfo">
		<span class="title">项目奖金暂定分配</span>
		<div class="textinput">
		<span>财务ID</span><input name="keyword" type="text" class="" value="" size="30" />
		<span>部门</span><input name="keyword" type="text" class="" value="" size="30" />
		<span>本部</span><input name="keyword" type="text" class="" value="" size="30" />
		<span>中心</span><input name="keyword" type="text" class="" value="" size="30" />
		<button class="btn">查询</button>
		</div>
		<div class="show">
		<table width="100%" cellpadding="8" cellspacing="0" class="tableBasic">
      		<tr>
		        <th width="20" ><input name='' type='checkbox'></th>
		        <th width="40">编号</th>
		        <th width="200">奖金总额</th>
		        <th width="150" >分配额</th>
		       <th width="80" >项目余额</th>
     	    </tr>
            <tr>
		        <td><input type="checkbox" name="" value="15" /></td>
		        <td>15</td>
		        <td></td>
		        <td></td>
		        <td></td>
      		</tr>
      		<tr>
		        <td><input type="checkbox" name="" value="15" /></td>
		        <td>14</td>
		        <td></td>
		        <td></td>
		        <td></td>
     		</tr>
		 </div>
	</div>
</body>
</html>