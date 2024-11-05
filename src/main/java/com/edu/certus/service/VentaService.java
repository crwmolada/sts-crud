package com.edu.certus.service;

import java.util.List;

import com.edu.certus.dao.VentaDao;
import com.edu.certus.model.Venta;

public class VentaService {

	private VentaDao ventaDao = new VentaDao();

	// Listar todas las ventas
	public List<Venta> listarVentas() {
		return ventaDao.listarVentas();
	}

	// Insertar una nueva venta
	public void insertarVenta(Venta venta) {
		ventaDao.insertar(venta);
	}

	// Actualizar una venta existente
	public void actualizarVenta(Venta venta) {
		ventaDao.actualizar(venta);
	}

	// Eliminar una venta
	public void eliminarVenta(Integer codVenta) {
		ventaDao.eliminar(codVenta);
	}

}
