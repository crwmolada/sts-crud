package com.edu.certus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.certus.model.DetalleVenta;

public class DetalleVentaDao {

	// Método para listar los detalles de venta
	public List<DetalleVenta> listarDetalles(){
		List<DetalleVenta> detalles = new ArrayList<>();
		String query = "SELECT * FROM detalleventa";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ConexionDB.getConexion();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
                int codVenta = rs.getInt("codigoventa");
                int codProducto = rs.getInt("codigoproducto");
                int cantidad = rs.getInt("cantidad");
                double descuento = rs.getDouble("descuento");

                DetalleVenta detalleVenta = new DetalleVenta(codVenta, codProducto, cantidad, descuento);
                detalles.add(detalleVenta);
            }
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDB.closeResultSet(rs);
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeConexion(conn);
        }
        return detalles;
	}
	
	//Método para listar por codigo
	
	public List<DetalleVenta> listarDetallesPorVenta(Integer codVenta) {
        List<DetalleVenta> detalles = new ArrayList<>();
        String query = "SELECT * FROM detalleventa WHERE codigoventa = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.getConexion();
            ps = conn.prepareStatement(query);
            ps.setInt(1, codVenta);
            rs = ps.executeQuery();

            while (rs.next()) {
                int codProducto = rs.getInt("codigoproducto");
                int cantidad = rs.getInt("cantidad");
                double descuento = rs.getDouble("descuento");

                DetalleVenta detalleVenta = new DetalleVenta(codVenta, codProducto, cantidad, descuento);
                detalles.add(detalleVenta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDB.closeResultSet(rs);
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeConexion(conn);
        }
        return detalles;
    }
	
	//Método para insertar productos
	public void insertar(DetalleVenta detalle) {
        String query = "INSERT INTO detalleventa (codigoventa, codigoproducto, cantidad, descuento) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionDB.getConexion();
            ps = conn.prepareStatement(query);

            ps.setInt(1, detalle.getCodVenta());
            ps.setInt(2, detalle.getCodProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getDescuento());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeConexion(conn);
        }
    
	}
	
	//Método para Actualizar
    public void actualizar(DetalleVenta detalle) {
    	
    	// Tuve que modificar este query
        String query = "UPDATE detalleventa SET codigoproducto = ?, cantidad = ?, descuento = ? WHERE codigoventa = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionDB.getConexion();
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, detalle.getCodProducto());
            ps.setInt(2, detalle.getCantidad());
            ps.setDouble(3, detalle.getDescuento());
            ps.setInt(4, detalle.getCodVenta());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeConexion(conn);
        }
    }

    // Eliminar
    public void eliminar(Integer codVenta) {

        String query = "DELETE FROM detalleventa WHERE codigoventa = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionDB.getConexion();
            ps = conn.prepareStatement(query);
            ps.setInt(1, codVenta);
            ps.executeUpdate();
            System.out.println("Detalle de venta eliminado con Código de Venta: " + codVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeConexion(conn);
        }
    }
	
}
