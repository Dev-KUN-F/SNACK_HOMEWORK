<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	SnackDao dao = new SnackDao();
   		
    	
    	String pcode = request.getParameter("t_pcode");
    	
    
    	
    	
    	SnackDto dto = dao.getSnackInfo(pcode);
    	
    	
    	
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function goUpdateForm(){
		
		
		
		snack.method="post";
		snack.action="snack_update.jsp";
		snack.submit();
	}
	
	function goDeleteForm(){
		let con = confirm("정말로 삭제하시겠습니까?");
		
		if(con){
			snack.method="post";
			snack.action="db_snack_delete.jsp";
			snack.submit();
		}else{
			alert("삭제취소!");
		}
		
	}
	
	
	function goList(){
		location.href = "snack_list.jsp";
	}
	
</script>
</head>
<body>

<form name = "snack">

	<input type="hidden" name="t_pcode" value="<%=dto.getId()%>" />
	

</form>

<table border = "1" width="400">
		<caption>회원 정보</caption>
		<colgroup>
			<col width = "30%">
			<col width = "70%">
		</colgroup>
		<tr>
			<th>제품코드</th>
			<td>
				<%=dto.getId() %>
			</td>
		</tr>
		<tr>
			<th>제품명</th>
			<td>
				<%=dto.getName() %>
			</td>
		</tr>
		<tr>
			<th>제조사명</th>
			<td>
				<%=dto.getCompany_name() %>
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td><%=dto.getPrice() %></td>
		</tr>
		
		<tr>
			<th>제조일자</th>
			<td><%=dto.getDate() %></td>
		</tr>
		
		
			<td colspan="3" align = "center">
				<input type = "button" onclick = "goUpdateForm()" value = "수 정">
				<input type = "button" onclick = "goDeleteForm()" value = "삭 제">
				<input type = "button" onclick = "goList()" value = "목 록">
				
 			 </td>
		</tr>
</table>

</body>
</html>