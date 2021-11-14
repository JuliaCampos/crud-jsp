<%@ page import="com.crudJspJava.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.crudJspJava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	int i = UsuarioDao.salvarUsuario(u);

	if(i > 0){
		response.sendRedirect("addusuario-sucess.jsp");
	}else{
		response.sendRedirect("addusuario-error.jsp");
	}
%>