<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.*" %>
<table border='1'>
<% DAO dao = new DAO();
 List<Dados> dados = dao.getLista();
 for (Dados dado : dados ) { %>
 <tr>
 <td><%=dado.getHora()%></td>
 <td><%=dado.getMinuto()%></td>
 <td><%=dado.getSegundo()%></td>
 </tr>
<% } %>
</table>
</body>
</html>