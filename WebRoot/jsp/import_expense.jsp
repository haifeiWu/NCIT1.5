<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <span>财务报销数据导入</span><br>
        <form action="${pageContext.request.contextPath }/importExp_analyzeAndCheack.action" method="post" enctype="multipart/form-data">
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
            <th>项目经费使用上限</th>
            <th>推荐经费使用总额</th>
            <th>报销费用</th>
            <th>报销日期</th>
            <th>警告内容</th>
            <th>报销缘由</th>
        </tr>
        </thead>
        <tbody>
			<c:forEach items="${sessionScope.updateList}" var="item" varStatus="status">  
		  		<tr >  
			    	<td>${item.financeId}</td>
			    	<td>${item.projectName}</td>
			    	<td>${item.fundUseUp}</td>
			    	<td>${item.fundRecommend}</td>
			    	<td>${item.expenseMoney}</td>
			    	<td>${item.expenseDate}</td>
			    	<td>${item.expenseReason}</td>
			    	<td>${item.alert}</td>
		 		</tr>
			</c:forEach>   
        </tbody>
    </table>
    
     <div class="expense_button">
        <a href="${pageContext.request.contextPath }/importExp_cancel.action"><button class="cancel">取消</button></a>
        <a href="${pageContext.request.contextPath }/importExp_saveData.action"><button class="submit" onclick="show_confirm()">确定</button></a>
     </div>
    </div>
    <script>
        $('.tablelist tbody tr:odd').addClass('odd');
        function show_confirm()
        {
        alert("数据保存成功！");
        /* location='http://www.baidu.com'; */
        }
    </script>
</body>
</html>