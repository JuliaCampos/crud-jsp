<%@ page import="com.crudJspJava.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.crudJspJava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
	UsuarioDao.deletarUsuario(u);
	response.sendRedirect("viewUsuario.jsp");
%>