package co.edu.uniquindio.poo.nexawallet.controllers;
import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.Cliente;
import co.edu.uniquindio.poo.nexawallet.clases.ClienteRegistro;
import co.edu.uniquindio.poo.nexawallet.clases.TipoRango;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class InicioClienteControllerTest {

    InicioClienteController controller;

    @BeforeEach
    void setup() {
        ClienteRegistro reg = new ClienteRegistro(
                "Luis", "luis@gmail.com", "123"
        );

        Cliente cliente = new Cliente(
                "Luis", "Hernandez", "100", "300123",
                "luis@gmail.com", 5000.0, 0, reg,
                0, 0, TipoRango.BRONCE
        );

        NexaWAplication.setClienteActual(cliente);

        controller = new InicioClienteController();
    }
 @Test
    void cambiarRango() {
        NexaWAplication.getClienteActual().setTipoRango(TipoRango.ORO);

        controller.cambiarRango();

        assertEquals(
                "ORO",
                controller.TxtRango.getText(),
                "El label del rango debe mostrar el nuevo rango"
        );
    }
@Test
    void calcularRango() {
        NexaWAplication.getClienteActual().setPuntos(1200);

        controller.calcularRango();

        assertEquals(
                TipoRango.ORO,
                NexaWAplication.getClienteActual().getTipoRango(),
                "Debe asignar rango ORO cuando tiene entre 1001 y 5000 puntos"
        );
    }
    @Test
    void mirarRango() {

        controller.rangoAnterior = TipoRango.BRONCE;
        NexaWAplication.getClienteActual().setTipoRango(TipoRango.PLATA);
        controller.mirarRango();
        assertEquals(
                TipoRango.PLATA,
                controller.rangoAnterior,
                "El método debe actualizar rangoAnterior cuando cambia el rango"
        );
    }
}