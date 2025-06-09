<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<style type="text/css">
body {
    margin: 0;
    padding-top: 60px; /* 네비게이션 바 높이만큼 */
}
.navbar {
    width: 100%;
    background-color: #333;
    overflow: auto;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
    box-shadow: 0 2px 5px rgba(0,0,0,0.2);
}
.navbar a {
    float: left;
    padding: 15px 20px;
    color: white;
    text-decoration: none;
    font-size: 17px;
    text-align: center;
    transition: background-color 0.3s;
}
.navbar a:hover {
    background-color: #555;
}
.navbar a.active {
    background-color: #04AA6D;
    color: white;
}
</style>

<nav class="navbar">
    <a href="<%= request.getContextPath() %>/book/book_list.jsp" class="<%= request.getRequestURI().endsWith("/book/book_list.jsp") ? "active" : "" %>">도서 목록</a>
    <a href="<%= request.getContextPath() %>/rent/rent_list.jsp" class="<%= request.getRequestURI().endsWith("/rent/rent_list.jsp") ? "active" : "" %>">대여 목록</a>
    <a href="<%= request.getContextPath() %>/book/book_write.jsp" class="<%= request.getRequestURI().endsWith("/book/book_write.jsp") ? "active" : "" %>">도서 등록</a>
    </nav>