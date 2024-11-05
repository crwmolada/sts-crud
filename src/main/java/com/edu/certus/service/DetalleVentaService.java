package com.edu.certus.service;

import java.util.List;

import com.edu.certus.dao.DetalleVentaDao;
import com.edu.certus.model.DetalleVenta;

public class DetalleVentaService {
	
	private DetalleVentaDao detalleVentaDao = new DetalleVentaDao();

    // Listar todos los detalles de venta
    public List<DetalleVenta> listarDetalles() {
        return detalleVentaDao.listarDetalles();
    }

    // Listar detalles de una venta específica
    public List<DetalleVenta> listarDetallesPorVenta(Integer codVenta) {
        return detalleVentaDao.listarDetallesPorVenta(codVenta);
    }

    // Insertar un nuevo detalle de venta
    public void insertarDetalle(DetalleVenta detalle) {
        detalleVentaDao.insertar(detalle);
    }

    // Actualizar un detalle de venta existente
    public void actualizarDetalle(DetalleVenta detalle) {
        detalleVentaDao.actualizar(detalle);
    }

    // Eliminar un detalle de venta específico
    public void eliminarDetalle(Integer codVenta) {
        detalleVentaDao.eliminar(codVenta);
    }
}
