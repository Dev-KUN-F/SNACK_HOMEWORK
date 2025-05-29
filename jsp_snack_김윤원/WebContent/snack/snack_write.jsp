<%@page import="dao.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	SnackDao dao = new SnackDao();
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 등록</title>

<script type="text/javascript">
	function goSave(){
	
			
		
		
		
		if(snack.t_pcode.value == ""){
			alert("제품코드 입력!");
			
			snack.t_pcode.focus();
			
			return;
		}
		

		
		
		if(snack.t_pname.value == ""){
			alert("제품명 입력!");
			
			snack.t_pname.focus();
			
			return;
		}
		
		if(snack.t_pprice.value == ""){
			alert("제품가격 입력!");
			
			snack.t_pprice.focus();
			
			return;
		}
		
		
			
		
		
		
		
		
		snack.method = "post"; //post , get
		snack.action = "db_snack_write.jsp";
		snack.submit();
	}
	
	
	function goList(){
		location.href = "snack_list.jsp";
	}
	
</script>

</head>
<body>

<form name = "snack">
<table border = "1" width="400">
		<caption>제품 등록</caption>
		<colgroup>
			<col width = "30%">
			<col width = "70%">
		</colgroup>
		<tr>
			<th>제품코드</th>
			<td>
				<input type="text" name = "t_pcode"  />
					
					
				
			</td>
		</tr>
		<tr>
			<th>제품명</th>
			
			<td>
				<input type="text" name = "t_pname"  />	
			</td>
		</tr>
		<tr>
			<th>제조사</th>
			<td>
				<select name = "t_ccode">
					
					<option value="10" selected >해태</option>
					<option value="20" >롯데</option>
					<option value="30" >농심</option>
					<option value="40" >삼양</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" name ="t_pprice" size = "10"/></td>
		</tr>
		
		<tr>
			<th>제조일자</th>
			<td><input type="date" max="2025-05-28" name ="t_makeDate" value="2025-05-27" /></td>
		</tr>
		
		<tr>
			<td colspan="2" align = "center">
				<input type = "button" onclick = "goSave()" value = "저 장">
				<input type = "button" onclick = "goList()" value = "목 록">
				
 			 </td>
		</tr>
		
</table>		
</form>

</body>
</html>