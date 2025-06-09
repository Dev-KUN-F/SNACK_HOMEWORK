<%@page import="dto.BookDto"%>
<%@page import="dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	BookDao dao = new BookDao();
   		
    	
    	String b_code = request.getParameter("t_code");
    	
    	int result = dao.checkRent(b_code);
    	
    	
    	BookDto dto = dao.getBookInfo(b_code);
    	
    	
    	
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title> <style type="text/css">
/* navbar.jsp에서 포함될 CSS와 중복되지 않도록,
   이 페이지에만 적용될 스타일을 추가합니다. */

/* body padding-top은 navbar.jsp의 style 태그에 있을 것입니다.
   만약 navbar.jsp에서 CSS를 별도의 파일로 분리한다면, 여기에도 body 스타일을 추가해야 합니다. */
body {
    font-family: Arial, sans-serif; /* 기본 글꼴 설정 */
    background-color: #f4f4f4; /* 전체 배경색 */
    color: #333; /* 기본 글자색 */
    margin: 0;
    padding-top: 60px; /* 네비게이션 바 높이만큼 여백 확보 */
}

/* 폼 스타일 */
form[name="book"] {
    max-width: 800px; /* 폼의 최대 너비 설정 */
    margin: 20px auto; /* 중앙 정렬 및 상하 여백 */
    padding: 20px;
    background-color: #fff; /* 폼 배경색 */
    border-radius: 8px; /* 둥근 모서리 */
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* 테이블 스타일 */
table {
    width: 100%;
    border-collapse: collapse; /* 셀 경계선 병합 */
    margin-top: 20px;
    background-color: #fff;
    border-radius: 8px;
    overflow: hidden; /* 둥근 모서리 안쪽 내용도 둥글게 */
}

caption {
    font-size: 1.5em; /* 제목 글자 크기 */
    margin-bottom: 10px;
    font-weight: bold;
    color: #333;
}

th, td {
    border: 1px solid #ddd; /* 옅은 회색 테두리 */
    padding: 12px 15px; /* 패딩 */
    text-align: left; /* 텍스트 왼쪽 정렬 */
}

th {
    background-color: #f2f2f2; /* 헤더 배경색 */
    font-weight: bold;
    color: #555;
    text-align: center; /* 헤더 텍스트 중앙 정렬 */
}

tr:nth-child(even) {
    background-color: #f9f9f9; /* 짝수 행 배경색 */
}

tr:hover {
    background-color: #e9e9e9; /* 호버 시 배경색 */
}

/* 링크 스타일 */
a {
    color: #007bff; /* 파란색 링크 */
    text-decoration: none; /* 밑줄 제거 */
}

a:hover {
    text-decoration: underline; /* 호버 시 밑줄 */
}

/* 버튼 및 입력 필드 스타일 */
input[type="text"], input[type="button"], button {
    padding: 8px 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1em;
    cursor: pointer;
    transition: background-color 0.3s, border-color 0.3s;
}

input[type="button"], button {
    background-color: #04AA6D; /* 네비게이션 바 활성 링크 색과 비슷하게 */
    color: white;
    border-color: #04AA6D;
}

input[type="button"]:hover, button:hover {
    background-color: #058f5d; /* 호버 시 약간 어둡게 */
    border-color: #058f5d;
}

input[type="text"] {
    width: 150px; /* 텍스트 입력 필드 너비 */
}

/* 총 도서 수 표시 */
p {
    text-align: center;
    font-size: 1.1em;
    margin: 15px 0;
    color: #666;
}

</style>

<script type="text/javascript">

const isRentable = "<%= dto.getRent_able() %>";

	function goUpdateForm(result){
		
		
		if(result != 0){
			alert("대여기록이 있는 도서는 수정될 수 없습니다.");
			return;
		}
		
		if(isRentable !== "y"){
			alert("대여중인 도서는 수정할수 없습니다!");
			return;
		}
		
		
		book.method="post";
		book.action="book_update.jsp";
		book.submit();
	}
	
	function goDeleteForm(result){
		if(result != 0){
			alert("대여기록이 있는 도서는 삭제될 수 없습니다.");
			return;
		}
		
		if(isRentable !== "y"){
			alert("대여중인 도서는 삭제할수 없습니다!");
			return;
		}
		
		
		let con = confirm("정말로 삭제하시겠습니까?");
		
		if(con){
			book.method="post";
			book.action="db_book_delete.jsp";
			book.submit();
		}else{
			alert("삭제취소!");
		}
		
	}
	
	
	function goList(){
		location.href = "book_list.jsp";
	}
	
</script>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>

<form name = "book">

	<input type="hidden" name="t_code" value="<%=b_code%>" />
	



<table border = "1" width="400">
		<caption>도서 정보</caption>
		<colgroup>
			<col width = "30%">
			<col width = "70%">
		</colgroup>
		<tr>
			<th>도서 코드</th>
			<td>
				<%=b_code %>
			</td>
		</tr>
		<tr>
			<th>도서명</th>
			<td>
				<%=dto.getB_name() %>
			</td>
		</tr>
		<tr>
			<th>출판사명</th>
			<td>
				<%=dto.getPublisher() %>
			</td>
		</tr>
		<tr>
			<th>저자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		
		<tr>
			<th>등록 일자</th>
			<td><%=dto.getReg_date() %></td>
		</tr>
		
		<tr>
			<th>대여여부</th>
			<td ><% if(dto.getRent_able().equals("y")){
			out.print("대여가능!");
		}else{
			out.print("대여중!");
		} %></td>
		</tr>
		
		
			<td colspan="3" align = "center">
				<input type = "button" onclick = "goUpdateForm(<%=result %>)" value = "수 정">
				<input type = "button" onclick = "goDeleteForm(<%=result %>)" value = "삭 제">
				<input type = "button" onclick = "goList()" value = "목 록">
				
 			 </td>
		</tr>
</table>
</form>
</body>
</html>