
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	request.setCharacterEncoding("utf-8");
    	SnackDao dao = new SnackDao();
  		 	
    	
    	String pcode = request.getParameter("t_pcode");
    	String pname = request.getParameter("t_pname");
    	String ccode = request.getParameter("t_ccode");
    	int price = Integer.parseInt(request.getParameter("t_pprice"));
    	String makeDate = request.getParameter("t_makeDate");
    	
    	
    	SnackDto dto = new SnackDto(pcode, pname, ccode, price, makeDate);
    	
    	int result = dao.SnackSave(dto);
    	
    	String msg = "저장성공~";
    	if(result != 1) msg = "저장 실패!";
    
    
    
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