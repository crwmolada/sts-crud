package com.edu.certus.controller;

import com.edu.certus.model.Producto;
import com.edu.certus.service.ProductoService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductoController {

	public static void main(String[] args) {
		ProductoService productoService = new ProductoService();

		// Listar
		System.out.println("Lista de todos mis productos:");
		List<Producto> productos = productoService.listProductos();
		for (Producto producto : productos) {
			System.out.println(producto);
		}

		// Opciones del CRUD
		String[] opciones = { "Agregar", "Editar", "Eliminar" };

		while (true) { // Bucle para mantener el menú hasta que se cierre el programa
			int seleccion = JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar en la tabla producto?",
					"Producto CRUD", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,
					opciones[0]);

			if (seleccion == -1) { // Si se cierra el JOptionPane
				break;
			}

			switch (seleccion) {
			case 0: // Agregar
				agregarProducto(productoService);
				break;
			case 1: // Actualizar
				actualizarProducto(productoService);
				break;
			case 2: // Eliminar
				eliminarProducto(productoService);
				break;
			default:
				break;
			}
		}
	}

	// Agregar
	private static void agregarProducto(ProductoService productoService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codProductoField = new JTextField();
		JTextField nombreField = new JTextField();
		JTextField precioField = new JTextField();

		panel.add(new JLabel("ID:"));
		panel.add(codProductoField);
		panel.add(new JLabel("Nombre:"));
		panel.add(nombreField);
		panel.add(new JLabel("Precio:"));
		panel.add(precioField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Agregar Producto", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codProducto = Integer.parseInt(codProductoField.getText());
				String nombre = nombreField.getText();
				double precio = Double.parseDouble(precioField.getText());

				Producto nuevoProducto = new Producto(codProducto, nombre, precio);
				productoService.insertProducto(nuevoProducto);
				System.out.println("Producto registrado: " + nuevoProducto);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valores inválidos, intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Editar/Actualizar
	private static void actualizarProducto(ProductoService productoService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codProductoField = new JTextField();
		JTextField nombreField = new JTextField();
		JTextField precioField = new JTextField();

		// Nombrado de campos
		panel.add(new JLabel("ID del Producto a actualizar:"));
		panel.add(codProductoField);
		panel.add(new JLabel("Nuevo Nombre:"));
		panel.add(nombreField);
		panel.add(new JLabel("Nuevo Precio:"));
		panel.add(precioField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Actualizar Producto", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codProducto = Integer.parseInt(codProductoField.getText());
				String nuevoNombre = nombreField.getText();
				double nuevoPrecio = Double.parseDouble(precioField.getText());

				Producto productoActualizado = new Producto(codProducto, nuevoNombre, nuevoPrecio);
				productoService.updateProducto(productoActualizado);
				System.out.println("Producto actualizado: " + productoActualizado);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valores inválidos, intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Eliminar
	private static void eliminarProducto(ProductoService productoService) {
		try {
			int codProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a eliminar:"));
			productoService.deleteProducto(codProducto);
			System.out.println("Producto eliminado con ID: " + codProducto);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, intenta de nuevo.", "Error de Entrada",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
