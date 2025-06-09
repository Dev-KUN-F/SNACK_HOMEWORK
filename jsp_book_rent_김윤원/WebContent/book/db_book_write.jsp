<%@page import="dto.BookDto"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
        <%
    	request.setCharacterEncoding("utf-8");
    	BookDao dao = new BookDao();
  		 	
    	
    	String b_code = request.getParameter("t_code");
    	String b_name = request.getParameter("t_name");
    	String b_pub = request.getParameter("t_pub");
    	String b_writer = request.getParameter("t_writer");
    	
    	String reg_date = request.getParameter("t_regDate");
    	
    	String rent_able = request.getParameter("t_rent_able");
    	
    	
    	String msg = "저장성공~";
    	
    	
    	
    		
    	
    		BookDto dto = new BookDto(b_code, b_name, b_pub, b_writer, reg_date, rent_able);
        	
        	int result = dao.bookSave(dto);
        	
        	
        	if(result != 1) msg = "저장 실패!";
    	
    	
    	
    	
    	
    
    
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