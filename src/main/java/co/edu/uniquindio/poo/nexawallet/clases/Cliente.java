package co.edu.uniquindio.poo.nexawallet.clases;

import java.util.LinkedList;
import java.util.List;

public class Cliente{
    private String nombres;
    private String apellidos;
    private String cedula;
    private String numero;
    private String correo;
    private double saldo;
    private int puntos;
    private ClienteRegistro clienteRegistro;
    private double descuento;
    private double cargos;
    private TipoRango tipoRango;
    private List<HistorialTransaccion> historialTransaccion;

    public Cliente(String nombres, String apellidos, String cedula, String numero, String correo, double saldo, int puntos, ClienteRegistro clienteRegistro, double descuento, double cargos, TipoRango tipoRango) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.numero = numero;
        this.correo = correo;
        this.saldo = saldo;
        this.puntos = puntos;
        this.clienteRegistro = clienteRegistro;
        this.descuento = descuento;
        this.cargos = cargos;
        this.tipoRango = tipoRango;
        this.historialTransaccion = new LinkedList<>();
    }

    public List<HistorialTransaccion> getHistorialTransaccion() {
        return historialTransaccion;
    }

    public void setHistorialTransaccion(HistorialTransaccion t) {
        historialTransaccion.add(t);
    }

    public TipoRango getTipoRango() {
        return tipoRango;
    }

    public void setTipoRango(TipoRango tipoRango) {
        this.tipoRango = tipoRango;
    }

    public ClienteRegistro getClienteRegistro() {
        return clienteRegistro;
    }

    public void setClienteRegistro(ClienteRegistro clienteRegistro) {
        this.clienteRegistro = clienteRegistro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getCargos() {
        return cargos;
    }

    public void setCargos(double cargos) {
        this.cargos = cargos;
    }


}
