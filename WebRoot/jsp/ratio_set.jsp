<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/script/css/parameter.css">
<script type="text/javascript">
    function checkAll()
	{
		var allNode=document.getElementsByName("all")[0];
        var citys = document.getElementsByName("city");
        for(var x=0; x<citys.length;x++)
        {
        	citys[x].checked = allNode.checked;
        }
	}
	</script>
</head>
<body>
	<div class="cs_rightinfo">
		<form action="${pageContext.request.contextPath }/import_ratioSet.action" method="post">

		<span class="title">参数设置</span>

		<table class="cs_tablelist">
	        <thead>
	        <tr>
	        	<th><input type="checkbox" name="all" onclick="checkAll()">全选</th>
	            <th>开发中心</th>
	            <th>中心共通经费</th>
	            <th>本部经费</th>
	            <th>部门经费</th>
	            <th>项目经费</th>
	            <th>小计</th>
	        </tr>
	        </thead>
	        <tbody>
	            <tr>
	            	<td width="10%"><input type="checkbox" name="city"></input></td>
	                <td width="12%">北京</td>
	                <td width="12%"><input type="text"  name="" placeholder="10%" /></td>
	                <td width="12%"><input type="text"  name="" placeholder="0%" /></td>
	                <td width="12%"><input type="text"  name="" placeholder="0%" /></td>
	                <td width="12%"><input type="text"  name="" placeholder="90%" /></td>
	                <td width="12%"><input type="text"  name="" placeholder="100%" /></td>
	            </tr> 
	            <tr>
	            	<td><input type="checkbox" name="city"></input></td>
	                <td>无锡</td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder="4%" /></td>
	                <td><input type="text"  name="" placeholder="6%" /></td>
	                <td><input type="text"  name="" placeholder="80%" /></td>
	                <td><input type="text"  name="" placeholder="100%" /></td>
	            </tr> 
	            <tr>
	            	<td><input type="checkbox" name="city"></input></td>
	                <td>天津</td>
	                <td><input type="text"  name="" placeholder="15%" /></td>
	                <td><input type="text"  name="" placeholder="0%" /></td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder="75%" /></td>
	                <td><input type="text"  name="" placeholder="100%" /></td>
	            </tr> 
	            <tr>
	            	<td><input type="checkbox" name="city"></input></td>
	                <td>长春</td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder="0%" /></td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder="75%" /></td>
	                <td><input type="text"  name="" placeholder="100%" /></td>
	            </tr> 
	            <tr>
	            	<td><input type="checkbox" name="city"></input></td>
	                <td>西安</td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder="10%" /></td>
	                <td><input type="text"  name="" placeholder=" 0%" /></td>
	                <td><input type="text"  name="" placeholder="80%" /></td>
	                <td><input type="text"  name="" placeholder="100%" /></td>
	            </tr> 
	           </tbody>
	         </table>

	         <div class="cs_button">
        		<button class="submit">提交</button>
   			 </div>
		</form>
	</div>
</body>
</html>