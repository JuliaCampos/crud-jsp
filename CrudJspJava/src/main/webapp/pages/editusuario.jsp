<%@ page import="com.crudJspJava.dao.UsuarioDao"%>
<jsp:useBean id="usuario" class=com.crudJspJava.bean.Usuario></jsp:useBean>
<jsp:setProperty property="*" name="usuario"></jsp:setProperty>
<%
	int i = UsuarioDao.uptateUsuario(usuario);
	response.sendRedirect("viewUsuario.jsp");
%>

