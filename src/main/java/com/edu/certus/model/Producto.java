package com.edu.certus.model;

public class Producto {
	private Integer codeProducto;
	private String nombre;
	private Double precio;
	
	// Constructor vacío
	public Producto() {
		super();
	}

	// Constructor
	public Producto(Integer codeProducto, String nombre, Double precio) {
		super();
		this.codeProducto = codeProducto;
		this.nombre = nombre;
		this.precio = precio;
	}

	//Getters and setters
	public Integer getCodeProducto() {
		return codeProducto;
	}

	public void setCodeProducto(Integer codeProducto) {
		this.codeProducto = codeProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	// Método toString para mostrar en consola para ver si la data viene correctamente
	@Override
	public String toString() {
		return "Producto [codeProducto=" + codeProducto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	

}
