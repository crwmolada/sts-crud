package com.edu.certus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.certus.model.Venta;

public class VentaDao {

	// Obtener lista de todas las ventas
    public List<Venta> listarVentas() {
        List<Venta> listaVentas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM venta";
            Connection cn = ConexionDB.getConexion();

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setCodVenta(rs.getInt("codigoventa"));
                venta.setCliente(rs.getString("cliente"));
                listaVentas.add(venta);
            }

            ConexionDB.closeConexion(cn);
            ConexionDB.closePreparedStatement(ps);
            ConexionDB.closeResultSet(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaVentas;
    }

    // Insertar nueva venta
    public void insertar(Venta venta) {
        try {
            String sql = "INSERT INTO venta (codigoventa, cliente) VALUES (?, ?)";
            Connection cn = ConexionDB.getConexion();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, venta.getCodVenta());
            ps.setString(2, venta.getCliente());

            ps.executeUpdate();
            	
            System.out.println("Venta registrada: codigoventa = " + venta.getCodVenta() + ", cliente = " + venta.getCliente());
            
            ConexionDB.closeConexion(cn);
            ConexionDB.closePreparedStatement(ps);

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actualizar venta existente
    public void actualizar(Venta venta) {
        try {
            String sql = "UPDATE venta SET cliente = ? WHERE codigoventa = ?";
            Connection cn = ConexionDB.getConexion();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setInt(2, venta.getCodVenta());

            ps.executeUpdate();

            ConexionDB.closeConexion(cn);
            ConexionDB.closePreparedStatement(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar una venta
    public void eliminar(Integer codVenta) {
        try {
            String sql = "DELETE FROM venta WHERE codigoventa = ?";
            Connection cn = ConexionDB.getConexion();

            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, codVenta);
            ps.executeUpdate();

            ConexionDB.closeConexion(cn);
            ConexionDB.closePreparedStatement(ps);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
