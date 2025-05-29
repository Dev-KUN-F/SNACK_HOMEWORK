<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	SnackDao dao = new SnackDao();
  		 	
    	
    	String pcode = request.getParameter("t_pcode");
    	
    	
    	
    	
    	
    	int result = dao.deleteSnack(pcode);
    	
    	String msg = "삭제 성공~";
    	if(result != 1) msg = "삭제 실패!";
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	alert("<%=msg%>");
	location.href = "snack_list.jsp";
</script>
</head>
<body>

</body>
</html>