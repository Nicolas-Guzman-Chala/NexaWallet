package co.edu.uniquindio.poo.nexawallet.controllers;
import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import co.edu.uniquindio.poo.nexawallet.controllers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.nexawallet.*;

import java.awt.*;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CanjearControllerTest {

    @Test
    void cambiarPuntos() {
    }

    @Test
    void rebajar() {
    }

    @Test
    void validarPlatino() {
    }

    @Test
    void onCanjear2() {
    }

    @Test
    void onCanjear3() {
    }

    private CanjearController controller;
    private Cliente cliente;

    @BeforeEach
    void setup() throws Exception {
        controller = new CanjearController();

        cliente = new Cliente(
                "Luisa",
                "",
                "",
                "",
                "correo@test.com",
                1000.0,
                200,
                new ClienteRegistro("Luisa", "correo@test.com", "000"),
                0,
                100,
                TipoRango.BRONCE
        );

        Field campo = NexaWAplication.class.getDeclaredField("clienteActual");
        campo.setAccessible(true);
        campo.set(null, cliente);
    }
    @Test
    void validarPlatino_falseCuandoNoEsPlatino() {
        cliente.setTipoRango(TipoRango.ORO);
        assertFalse(controller.validarPlatino());
    }

    @Test
    void validarPlatino_trueCuandoEsPlatino() {
        cliente.setTipoRango(TipoRango.PLATINO);
        assertTrue(controller.validarPlatino());
    }

    @Test
    void onCanjear1_platinoDescuenta50() {
        cliente.setPuntos(100);
        cliente.setTipoRango(TipoRango.PLATINO);

        controller.onCanjear1(null);

        assertEquals(50, cliente.getPuntos());
        assertEquals(10, cliente.getDescuento());
    }

    @Test
    void onCanjear1_normalDescuenta100() {
        cliente.setPuntos(150);
        cliente.setTipoRango(TipoRango.BRONCE);

        controller.onCanjear1(null);

        assertEquals(50, cliente.getPuntos());
        assertEquals(10, cliente.getDescuento());
    }

    @Test
    void onCanjear2_platinoDescuenta250() {
        cliente.setPuntos(300);
        cliente.setTipoRango(TipoRango.PLATINO);

        controller.onCanjear2(null);

        assertEquals(50, cliente.getPuntos());
        assertEquals(0, cliente.getCargos());
    }

    @Test
    void onCanjear2_normalDescuenta500() {
        cliente.setPuntos(600);
        cliente.setTipoRango(TipoRango.BRONCE);

        controller.onCanjear2(null);

        assertEquals(100, cliente.getPuntos());
        assertEquals(0, cliente.getCargos());
    }
    @Test
    void onCanjear3_platinoDescuenta500YSumaSaldo() {
        cliente.setPuntos(700);
        cliente.setTipoRango(TipoRango.PLATINO);
        cliente.setSaldo(2000);

        controller.onCanjear3(null);

        assertEquals(200, cliente.getPuntos());
        assertEquals(3000, cliente.getSaldo());
    }

    @Test
    void onCanjear3_normalDescuenta1000YSumaSaldo() {
        cliente.setPuntos(1200);
        cliente.setTipoRango(TipoRango.ORO);
        cliente.setSaldo(500);

        controller.onCanjear3(null);

        assertEquals(200, cliente.getPuntos());
        assertEquals(1500, cliente.getSaldo());
    }
}