<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/script/css/style.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/js/jquery.js"></script>
</head>
<body>
<div class="rightinfo">  
    <div class="exdata">
        <span>项目相关信息核对</span><br>
        <form action="${pageContext.request.contextPath }/importCount_analyzeCountCheack.action" method="post" enctype="multipart/form-data">
            <table>
				<tr>
					<td><input type="file" name="uploadfile" value="导入Excel"/></td>
					<td><input type="submit" value="上传"/></td>
				</tr>
			</table>
        </form>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>项目编号</th>
            <th>项目名称</th>
            <th>支出金额</th>
            <th>项目计提额</th>
            <th>警告信息</th>
        </tr>
        </thead>
        <tbody>
			<c:forEach items="${countList}" var="item" varStatus="status">  
		  		<tr >  
			    	<td>${item.financeId}</td>
			    	<td>${item.projectName}</td>
			    	<td>${item.amountPaid}</td>
			    	<td>${item.countMoney}</td>
			    	<td>${item.alert}</td>
		 		</tr>
			</c:forEach>   
        </tbody>
    </table>
    </div>
    <script>
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>
</body>
</html>