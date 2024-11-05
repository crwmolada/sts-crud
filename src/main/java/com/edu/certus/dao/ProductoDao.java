package com.edu.certus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.certus.model.Producto;

public class ProductoDao {
	public List<Producto> listProductos(){
		
		List<Producto> listProducto = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM producto";
			Connection conn = ConexionDB.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); //Método especificamente para consultas de retorno de datos (SELECT)
			
			//Iteramos sobre el resultado 
			while(rs.next()) {
				//Clase Producto usamos los setters
				Producto p = new Producto();
				p.setCodeProducto(rs.getInt("codigoproducto")); 
				p.setNombre(rs.getString("nombre")); 
				p.setPrecio(rs.getDouble("precio"));
				listProducto.add(p);
			}
			
			//Cerramos sesión
			ConexionDB.closeConexion(conn);
			ConexionDB.closePreparedStatement(ps);
			ConexionDB.closeResultSet(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProducto;
	}
	
	public void insertar(Producto producto) {
		try {
			String sql = "INSERT INTO PRODUCTO (codigoproducto, nombre, precio) VALUES (?,?,?)";
			Connection conn = ConexionDB.getConexion();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, producto.getCodeProducto());
			ps.setString(2, producto.getNombre());
			ps.setDouble(3, producto.getPrecio());
			
			ps.executeUpdate();
			
			ConexionDB.closeConexion(conn);
			ConexionDB.closePreparedStatement(ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar(Producto producto) {
	    try {
	        String sql = "UPDATE producto SET nombre=?, precio=? WHERE codigoproducto=?";
	        Connection cn = ConexionDB.getConexion();
	        PreparedStatement ps = cn.prepareStatement(sql);
	        
	        ps.setString(1, producto.getNombre());
	        ps.setDouble(2, producto.getPrecio());
	        ps.setInt(3, producto.getCodeProducto());
	        ps.executeUpdate();
	        
	        ConexionDB.closeConexion(cn);
	        ConexionDB.closePreparedStatement(ps);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void eliminar(Integer codigoProducto) {
		try {
			String sql = "DELETE FROM producto WHERE codigoProducto = ?";
			Connection cn = ConexionDB.getConexion();
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setInt(1, codigoProducto);
	        ps.executeUpdate();
	        
	        ConexionDB.closeConexion(cn);
	        ConexionDB.closePreparedStatement(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

