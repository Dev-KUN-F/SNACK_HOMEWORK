<%@page import="java.util.ArrayList"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
      <%
   	 request.setCharacterEncoding("UTF-8");
     SnackDao dao = new SnackDao();
     
     String search = request.getParameter("t_search");
     
     if(search == null ){
    	 search = "";
     }
     
     String ccode = request.getParameter("t_code");
     
     if(ccode == null){
    	 ccode = "";
     }
     
     
   
    
    

    
     ArrayList<SnackDto> dtos = dao.getSnackList(ccode, search );
     
     
     
     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 관리</title>

<script type="text/javascript">
	function goSearch(){
		snack.method="post";
		snack.action="snack_list.jsp";
		snack.submit();
	}
</script>

</head>
<body>

<form name="snack">
	<table border = "1" width="400">

		<tr>
			<td align = "right">
				<select name = "t_code">
					<option value= ""  >전체</option>
					<option value="10"  >해태</option>
					<option value="20" >롯데</option>
					<option value="30" >농심</option>
					<option value="40" >삼양</option>
				</select>
				
				
				<input type = "text" value = "<%= search %>"  name = "t_search" size = "5">
				<input type = "button" onclick = "goSearch()" value = "검색">
			</td>
		</tr>
	</table>
</form>

	<p>총 상품 수 : <%=dtos.size()%></p>

<table border ="1" width="100%">
	<colgroup>
		<col width="20%">
		<col width="40%">
		
		<col width="40%">
	</colgroup>
	<caption>제품목록</caption>
	
	<tr>
		<th>제품코드</th>
		<th>제품명</th>
		<th>제조사명</th>
		
	</tr>
	
	<%for(SnackDto dto : dtos){ %>
	
	<tr>
		<td align="center"><%= dto.getId()%></td>
		<td align="center"><a href="snack_view.jsp?t_pcode=<%=dto.getId()%>"><%= dto.getName()%></a></td>
		<td align="center"><%= dto.getCompany_name()%></td>
		
	</tr>
	<%} %>
	
	
	<tr>
		<td colspan="3" align = "center">
			<a href="snack_write.jsp">
				제품 등록
			</a>
		</td>
	</tr>
</table>
</body>
</html>