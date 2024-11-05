package com.edu.certus.controller;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

import com.edu.certus.service.VentaService;
import com.edu.certus.model.Venta;

public class VentaController {


	public static void main(String[] args) {
		VentaService ventaService = new VentaService();

		// Mostrar lista de ventas en consola
		System.out.println("Lista de todas las ventas registradas:");
		List<Venta> ventas = ventaService.listarVentas();
		for (Venta venta : ventas) {
			System.out.println(venta);
		}

		// Opciones del CRUD
		String[] opciones = { "Agregar", "Editar", "Eliminar" };

		while (true) { // Bucle para mantener el menú hasta que se cierre el programa
			int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una operación para la Venta", "Venta CRUD",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			if (seleccion == -1) { // Si se cierra el JOptionPane
				break;
			}

			switch (seleccion) {
			case 0: // Agregar
				agregarVenta(ventaService);
				break;
			case 1: // Editar
				editarVenta(ventaService);
				break;
			case 2: // Eliminar
				eliminarVenta(ventaService);
				break;
			default:
				break;
			}
		}
	}

	// Agregar Venta
	private static void agregarVenta(VentaService ventaService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codVentaField = new JTextField();
		JTextField clienteField = new JTextField();

		panel.add(new JLabel("Código de Venta:"));
		panel.add(codVentaField);
		panel.add(new JLabel("Cliente:"));
		panel.add(clienteField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Agregar Venta", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codVenta = Integer.parseInt(codVentaField.getText());
				String cliente = clienteField.getText();

				Venta nuevaVenta = new Venta(codVenta, cliente); // La fecha se maneja desde la base de datos
				ventaService.insertarVenta(nuevaVenta);
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Código de venta inválido. Intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Editar/Actualizar Venta
	private static void editarVenta(VentaService ventaService) {
		JPanel panel = new JPanel(new GridLayout(0, 2));

		JTextField codVentaField = new JTextField();
		JTextField clienteField = new JTextField();

		panel.add(new JLabel("Código de Venta (ID a actualizar):"));
		panel.add(codVentaField);
		panel.add(new JLabel("Nuevo Cliente:"));
		panel.add(clienteField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Actualizar Venta", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			try {
				int codVenta = Integer.parseInt(codVentaField.getText());
				String nuevoCliente = clienteField.getText();

				Venta ventaActualizada = new Venta(codVenta, nuevoCliente); // Fecha se mantiene desde la base de datos
				ventaService.actualizarVenta(ventaActualizada);
				System.out.println("Venta actualizada: " + ventaActualizada);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Código de venta inválido. Intenta de nuevo.", "Error de Entrada",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// Eliminar Venta
	private static void eliminarVenta(VentaService ventaService) {
		try {
			int codVenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Código de Venta a eliminar:"));
			ventaService.eliminarVenta(codVenta);
			System.out.println("Venta eliminada con Código de Venta: " + codVenta);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido, intenta de nuevo.", "Error de Entrada",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
