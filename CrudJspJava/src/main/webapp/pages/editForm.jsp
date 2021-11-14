<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição de usuarios</title>
</head>
<body>
	<%@ page
		import="com.crudJspJava.dao.UsuarioDao, com.crudJspJava.bean.Usuario, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Edição de usuario</h1>

	<%
	String id = request.getParameter("id");
	Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
	%>

	<!-- FORMULÁRIO DE EDIÇÃO DE USUARIO -->
	<h1>Edição de usuario</h1>

	<form action="editusuario.jsp" method="post">
		<input type="hidden" name="id" value="<%usuario.getId();%>"/>
		<table>
			<tr> 
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%usuario.getNome();%>"/> </td>
			 </tr>
			 <tr> 
			 	<td>Usuario: </td>
				<td><input type="text" name="nome" value="<%usuario.getUsuario();%>"/> </td>
			 </tr>
			 <tr> 
			 	<td>Senha: </td>
				 <td><input type="password" name="nome" value="<%usuario.getSenha();%>"/> </td>
			 </tr> 
			 <tr>
			 	<td colspan="2">
			 		<input type="submit" value="Editar"></input>
			 	</td>
			 	<td colspan="2">
			 		<input type="submit" value="Cadastrar"></input>
			 	</td>
			 </tr>
		</table>
	</form>

</body>
</html>