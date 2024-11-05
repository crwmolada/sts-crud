package com.edu.certus.model;

public class DetalleVenta {
	private Integer codVenta;
    private Integer codProducto;
    private Integer cantidad; // ALTER TABLE detalleventa MODIFY COLUMN cantidad INT UNSIGNED
    private Double descuento;
    
    public DetalleVenta() {
        super();
    }

    public DetalleVenta(Integer codVenta, Integer codProducto, Integer cantidad, Double descuento) {
        super();
        this.codVenta = codVenta;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }
    
    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "DetalleVenta [codVenta = " + codVenta + ", codProducto = " + codProducto + ", cantidad = " + cantidad + ", descuento = " + descuento + "]";
    }

}
