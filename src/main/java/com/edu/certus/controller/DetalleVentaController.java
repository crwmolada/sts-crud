package com.edu.certus.controller;

import java.util.List;
import javax.swing.*;
import java.awt.*;

import com.edu.certus.model.DetalleVenta;
import com.edu.certus.service.DetalleVentaService;

public class DetalleVentaController {

	public static void main(String[] args) {
		DetalleVentaService detalleVentaService = new DetalleVentaService();

		// Mostrar los detalles de ventas actuales en consola
		System.out.println("Lista de todos los detalles de ventas:");
		List<DetalleVenta> detalles = detalleVentaService.listarDetalles();
		for (DetalleVenta detalle : detalles) {
			System.out.println(detalle);
		}

		// Opciones del CRUD (sin la opción de listar)
		String[] opciones = { "Agregar", "Editar", "Eliminar" };

		while (true) { // Bucle para mantener el menú hasta que se cierre el programa
			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una operación para la Venta", "Venta CRUD",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			if (seleccion == -1) { // Si se cierra el JOptionPane
				break;
			}

			switch (seleccion) {
			case 0: // Agregar
				agregarDetalle(detalleVentaService);
				break;
			case 1: // Editar
				editarDetalle(detalleVentaService);
				break;
			case 2: // Eliminar
				eliminarDetalle(detalleVentaService);
				break;
			default:
				break;
			}
		}
	}

	// Agregar a Detalle venta
	private static void agregarDetalle(DetalleVentaService detalleVentaService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codVentaField = new JTextField();
		JTextField codProductoField = new JTextField();
		JTextField cantidadField = new JTextField();
		JTextField descuentoField = new JTextField();

		panel.add(new JLabel("Código de Venta:"));
		panel.add(codVentaField);
		panel.add(new JLabel("Código de Producto:"));
		panel.add(codProductoField);
		panel.add(new JLabel("Cantidad:"));
		panel.add(cantidadField);
		panel.add(new JLabel("Descuento:"));
		panel.add(descuentoField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Agregar Detalle de Venta",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codVenta = Integer.parseInt(codVentaField.getText());
				int codProducto = Integer.parseInt(codProductoField.getText());
				int cantidad = Integer.parseInt(cantidadField.getText());
				double descuento = Double.parseDouble(descuentoField.getText());

				DetalleVenta nuevoDetalle = new DetalleVenta(codVenta, codProducto, cantidad, descuento);
				detalleVentaService.insertarDetalle(nuevoDetalle);
				System.out.println("Detalle de venta registrado: " + nuevoDetalle);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valores inválidos, intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Editar/Actualizar Detalle de Venta
	private static void editarDetalle(DetalleVentaService detalleVentaService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codVentaField = new JTextField();
		JTextField codProductoField = new JTextField();
		JTextField cantidadField = new JTextField();
		JTextField descuentoField = new JTextField();

		panel.add(new JLabel("Código de Venta a editar:"));
		panel.add(codVentaField);
		panel.add(new JLabel("Nuevo Código de Producto:"));
		panel.add(codProductoField);
		panel.add(new JLabel("Nueva Cantidad:"));
		panel.add(cantidadField);
		panel.add(new JLabel("Nuevo Descuento:"));
		panel.add(descuentoField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Actualizar Detalle de Venta",
				JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codVenta = Integer.parseInt(codVentaField.getText());
				int codProducto = Integer.parseInt(codProductoField.getText());
				int cantidad = Integer.parseInt(cantidadField.getText());
				double descuento = Double.parseDouble(descuentoField.getText());

				DetalleVenta detalleActualizado = new DetalleVenta(codVenta, codProducto, cantidad, descuento);
				detalleVentaService.actualizarDetalle(detalleActualizado);
				System.out.println("Detalle de venta actualizado: " + detalleActualizado);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valores inválidos, intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Eliminar Detalle de Venta
	private static void eliminarDetalle(DetalleVentaService detalleVentaService) {
		try {
			int codVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Código de Venta a eliminar:"));
			detalleVentaService.eliminarDetalle(codVenta);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, intenta de nuevo.", "Error de Entrada",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
