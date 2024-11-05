package com.edu.certus.model;

public class Venta {
	private Integer codVenta;
    private String cliente;
    // Mejor eliminamos el campo fecha, para lo haga la base de datos con un TIMESTAMP
    // ALTER TABLE venta MODIFY COLUMN fecha DATETIME DEFAULT CURRENT_TIMESTAMP;

    public Venta() {
        super();
    }

    public Venta(Integer codVenta, String cliente) {
        super();
        this.codVenta = codVenta;
        this.cliente = cliente;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta [codVenta=" + codVenta + ", cliente=" + cliente + "]";
    }
}
