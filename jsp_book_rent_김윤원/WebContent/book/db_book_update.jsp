<%@page import="dto.BookDto"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	BookDao dao = new BookDao();
    	
  		 	
    	
    	String bcode = request.getParameter("t_bcode");
    	String bname = request.getParameter("t_bname");
    	String pub = request.getParameter("t_pub");
    	String writer = request.getParameter("t_writer");
    	String regDate = request.getParameter("t_regDate");
    	
    	
    	BookDto dto = new BookDto(bcode, bname, pub, writer, regDate);
    	
    	
    	
    	int result = dao.updateBook(dto);
    	
    	String msg = "수정 성공~";
    	if(result != 1) msg = "수정 실패!";
    
    
    
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