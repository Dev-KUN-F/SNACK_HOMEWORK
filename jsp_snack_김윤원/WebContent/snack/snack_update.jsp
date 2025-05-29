<%@page import="common.DateChange"%>
<%@page import="dto.SnackDto"%>
<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	SnackDao dao = new SnackDao();
    	DateChange dc = new DateChange();
    	
  	 	String pcode = request.getParameter("t_pcode");
		
    	
    
 
    	
		SnackDto dto = dao.getSnackInfo(pcode);
    
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function goUpdate(){
	
	
		snack.method = "post"; //post , get
		snack.action = "db_snack_update.jsp";
		snack.submit();
	}
	
	
	function goList(){
		location.href = "snack_list.jsp";
	}
	
</script>
</head>
<body>

<form  name = "snack" >
<table border = "1" width="400">
		<caption>제품 수정</caption>
		<colgroup>
			<col width = "30%">
			<col width = "70%">
		</colgroup>
		<tr>
			<th>제품코드</th>
			<td>
				<%=dto.getId() %>
				<input  type="hidden" name = "t_pcode" value = "<%=dto.getId()%>"/>
			</td>
		</tr>
		
		
		
		<tr>
			<th>제품명</th>
			<td><input type="text" name ="t_pname" size = "10" value="<%=dto.getName()%>"/></td>
		</tr>
		
		<tr>
			<th>제조사</th>
			<td>
				<select name = "t_ccode">
					
					<option value="10" <%if(dto.getCompany_name().equals("해태")) out.print("selected"); %>) >해태</option>
					<option value="20" <%if(dto.getCompany_name().equals("롯데")) out.print("selected"); %>>롯데</option>
					<option value="30" <%if(dto.getCompany_name().equals("농심")) out.print("selected"); %>>농심</option>
					<option value="40" <%if(dto.getCompany_name().equals("삼양")) out.print("selected"); %>>삼양</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>가격</th>
			<td><input type="number"   name ="t_price"value="<%=dto.getPrice()%>"/></td>
		</tr>
		
		<tr>
			<th>제조일자</th>
			<td><input type="date"   name ="t_makeDate"  value="<%=dc.dateChange(dto.getDate())%>"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align = "center">
				<input type = "button" onclick = "goUpdate()" value = "수정 저장">
				<input type = "button" onclick = "goList()" value = "목 록">
				
 			 </td>
		</tr>
</table>	

</form>

</body>
</html>