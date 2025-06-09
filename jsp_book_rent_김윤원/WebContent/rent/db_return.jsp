<%@page import="dao.BookRentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
   		request.setCharacterEncoding("utf-8");
    	BookRentDao dao = new BookRentDao();
    	
    	String rcode = request.getParameter("t_rcode");
    	String bcode = request.getParameter("t_bcode");
    	
    	int result = dao.returnBook(rcode , bcode);
    	
    	String msg = "반납 성공~";
    	if(result != 2) msg = "반납 실패!";
    
    	
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	alert("<%=msg%>");
	location.href = "rent_list.jsp";
</script>
</head>
<body>



</body>
</html>