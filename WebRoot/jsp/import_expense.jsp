<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 财务报销数据的导入 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>财务报销数据的导入</h4>
	<form action="${pageContext.request.contextPath }/importExp_analyzeAndCheack.action" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="file" name="uploadfile"/></td>
				<td><input type="submit" value="上传"/></td>
			</tr>
		</table>
	</form>
</body>
</html>