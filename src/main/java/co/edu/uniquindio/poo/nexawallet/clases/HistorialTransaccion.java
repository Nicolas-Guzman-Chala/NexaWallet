package co.edu.uniquindio.poo.nexawallet.clases;

import java.time.LocalDateTime;

public class HistorialTransaccion {
    private Cliente cliente;
    private TipoTransaccion tipoTransaccion;
    private double puntos;
    private String tipoRango;
    private double cantidad;
    private LocalDateTime fecha;

    public HistorialTransaccion(Cliente cliente, TipoTransaccion tipoTransaccion, double puntos, String tipoRango, double cantidad, LocalDateTime fecha) {
        this.cliente = cliente;
        this.tipoTransaccion = tipoTransaccion;
        this.puntos = puntos;
        this.tipoRango = tipoRango;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoRango() {
        return tipoRango;
    }

    public void setTipoRango(String tipoRango) {
        this.tipoRango = tipoRango;
    }
}
