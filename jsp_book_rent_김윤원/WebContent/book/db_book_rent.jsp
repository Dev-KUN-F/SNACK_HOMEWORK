<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	BookDao dao = new BookDao();
  		 	
    	
    	String rcode = request.getParameter("r_code");
    	String bcode = request.getParameter("b_code");
    	String m_id = request.getParameter("m_id");
    	String rentDate = request.getParameter("rent_date");
    	
    	
    	
    	
    	
    	int result = dao.rentBook(rcode, bcode, m_id, rentDate);
    	
    	String msg = "대여 성공~";
    	if(result != 2) msg = "대여 실패!";
    
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	alert("<%=msg%>");
	location.href = "book_list.jsp";
</script>
</head>
<body>

</body>
</html>