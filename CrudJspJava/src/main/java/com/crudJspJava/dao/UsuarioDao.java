package com.crudJspJava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudJspJava.bean.Usuario;
import com.mysql.cj.jdbc.JdbcPreparedStatement;

public class UsuarioDao {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			// Configurando a nossa conexão com um banco de dados//
			String serverName = "localhost:3306"; // caminho do servidor do BD
			String mydatabase = "estacionamento"; // nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root"; // nome de um usuário de seu BD
			String password = "1234"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.print("erro de sql ");
			e.printStackTrace();
		}

		return connection;
	}
	
	public static int deletarUsuario(Usuario usuario) {
int status = 0;
		
		String sql = "DELETE FROM  tbl_usuario WHERE id = ?";
		try {
			Connection con = getConnection();

			JdbcPreparedStatement ps = (JdbcPreparedStatement) con.prepareStatement(sql);
			
			ps.setInt(1, usuario.getId());
			status = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return status;
	}
	
	/**
	 * Salvar usuario
	 */
	public static int salvarUsuario(Usuario usuario) {
		int status = 0;
		
		String sql = "INSERT INTO  tbl_usuario (nome, usuario, senha) VALUES (?,?,?)";
		try {
			Connection con = getConnection();

			JdbcPreparedStatement ps = (JdbcPreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getSenha());
			status = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return status;
		
	}

	/**
	 * Buscar usuaro pelo id
	 */
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM tbl_usuario WHERE id = ?";
		try {
			Connection con = getConnection();

			JdbcPreparedStatement ps = (JdbcPreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			// retorna os dados do banco e guarda em usuario
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);
		}

		return usuario;
	}

	/**
	 * Fazer update de usuario
	 */
	public static int uptateUsuario(Usuario usuario) {
		int status = 0;
		String sql = "UPDATE usuario SET nome=?, usuario=?, senha=? WHERE id=?";
		try {
			Connection con = getConnection();

			JdbcPreparedStatement ps = (JdbcPreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getSenha());
			status = ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * Listar usuarios
	 */
	public static List<Usuario> getAllUsuarios() {
		List<Usuario> list = new ArrayList<Usuario>();

		String sql = "SELECT * FROM tbl_usuario";
		try {
			Connection con = getConnection();

			JdbcPreparedStatement ps = (JdbcPreparedStatement) con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				list.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e);
		}

		return list;
	}
}
