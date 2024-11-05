package com.edu.certus.service;

import java.util.List;

import com.edu.certus.dao.ProductoDao;
import com.edu.certus.model.Producto;

public class ProductoService {
	private ProductoDao productoDao = new ProductoDao();
	
	public List<Producto> listProductos(){
		return productoDao.listProductos();
	}
	
	public void insertProducto(Producto producto) {
		productoDao.insertar(producto);
	}

	public void updateProducto(Producto producto) {
		productoDao.actualizar(producto);
	}
	
	public void deleteProducto(Integer codigoProducto) {
		productoDao.eliminar(codigoProducto);
	}
}
