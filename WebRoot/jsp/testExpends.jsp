<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
	<META HTTP-EQUIV="pragma" CONTENT="no-cache">
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
	<META HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">
	<META HTTP-EQUIV="expires" CONTENT="0">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
    <link rel="stylesheet" type="text/css" href="../script/css/style.css">
    <script type="text/javascript" src="../script/js/jquery.js"></script>
</head>
<body> 
    <div class="rightinfo">  
    <div class="exdata">
        <span>财务报销数据导入</span><br>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>项目编号</th>
            <th>项目名称</th>
            <th>项目经费使用上限</th>
            <th>推荐经费使用总额</th>
            <th>报销费用</th>
            <th>报销日期</th>
            <th>警告内容</th>
            <th>报销缘由</th>
        </tr>
        </thead>
        <tbody>
			<c:forEach items="${updateList}" var="item" varStatus="status">  
		  		<tr >  
			    	<td>${item.financeId}</td>
			    	<td>${item.projectName}</td>
			    	<td>${item.fundRecommend}</td>
			    	<td>${item.expenseMoney}</td>
			    	<td>${item.expenseDate}</td>
			    	<td>${item.alert}</td>
			    	<td>${item.expenseReason}</td>
		 		</tr>
			</c:forEach>   
        </tbody>
    </table>
    </div>
</body>
</html>