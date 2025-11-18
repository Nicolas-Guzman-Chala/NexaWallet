package co.edu.uniquindio.poo.nexawallet.test;

import co.edu.uniquindio.poo.nexawallet.NexaWAplication;
import co.edu.uniquindio.poo.nexawallet.clases.*;
import co.edu.uniquindio.poo.nexawallet.controllers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.nexawallet.*;

import static org.junit.jupiter.api.Assertions.*;

class NexaWAplicationTest {

    @Test
    void changeScene() {
    }

    @Test
    void guardarClienteDesdeRegistro() {
    }

    @Test
    void enviarNotificacion() {

    }

        @BeforeEach
        void setUp() {
            NexaWAplication.getListaClientes().clear();
            NexaWAplication.getListaClienteRegistro().clear();
            NexaWAplication.setClienteActual(null);
            NexaWAplication.setClienteRegistroActual(null);
        }

        @Test
        void testSetAndGetClienteActual() {
            ClienteRegistro reg = new ClienteRegistro("Luisa", "123", "test@gmail.com");
            Cliente cliente = new Cliente("Luisa", "", "", "",
                    "test@gmail.com", 0.0, 0, reg, 0, 100, TipoRango.BRONCE);

            NexaWAplication.setClienteActual(cliente);

            assertNotNull(NexaWAplication.getClienteActual());
            assertEquals("Luisa", NexaWAplication.getClienteActual().getNombres());
        }

        @Test
        void testSetAndGetClienteRegistroActual() {
            ClienteRegistro reg = new ClienteRegistro("Ana", "555", "ana@example.com");

            NexaWAplication.setClienteRegistroActual(reg);

            assertNotNull(NexaWAplication.getClienteRegistroActual());
            assertEquals("Ana", NexaWAplication.getClienteRegistroActual().getNombre());
        }

        @Test
        void testGuardarClienteDesdeRegistro() {

            ClienteRegistro reg = new ClienteRegistro("Carlos", "999", "carlos@mail.com");

            NexaWAplication.guardarClienteDesdeRegistro(reg);

            assertEquals(1, NexaWAplication.getListaClientes().size());
            assertEquals(1, NexaWAplication.getListaClienteRegistro().size());

            Cliente clienteGuardado = NexaWAplication.getClienteActual();

            assertNotNull(clienteGuardado);
            assertEquals("Carlos", clienteGuardado.getNombres());
            assertEquals(TipoRango.BRONCE, clienteGuardado.getTipoRango());
            assertEquals(reg, clienteGuardado.getClienteRegistro());
        }

        @Test
        void testListasInicialesVacias() {
            assertTrue(NexaWAplication.getListaClientes().isEmpty());
            assertTrue(NexaWAplication.getListaClienteRegistro().isEmpty());
        }

        @Test
        void testAgregarMultiplesClientes() {
            ClienteRegistro r1 = new ClienteRegistro("A", "1", "a@mail.com");
            ClienteRegistro r2 = new ClienteRegistro("B", "2", "b@mail.com");

            NexaWAplication.guardarClienteDesdeRegistro(r1);
            NexaWAplication.guardarClienteDesdeRegistro(r2);

            assertEquals(2, NexaWAplication.getListaClientes().size());
            assertEquals(2, NexaWAplication.getListaClienteRegistro().size());
        }
        @Test
        void testClienteActualActualizado() {
            ClienteRegistro r1 = new ClienteRegistro("Mario", "100", "m@mail.com");
            ClienteRegistro r2 = new ClienteRegistro("Sofia", "200", "s@mail.com");

            NexaWAplication.guardarClienteDesdeRegistro(r1);
            assertEquals("Mario", NexaWAplication.getClienteActual().getNombres());

            NexaWAplication.guardarClienteDesdeRegistro(r2);
            assertEquals("Sofia", NexaWAplication.getClienteActual().getNombres());
        }
        @Test
        void testEnviarNotificacionNoRevienta() {
            // Mock de cliente
            ClienteRegistro r = new ClienteRegistro("Test", "300", "t@mail.com");
            Cliente cliente = new Cliente("Test", "", "", "",
                    "t@mail.com", 0.0, 0, r, 0, 100, TipoRango.BRONCE);

            cliente.setNumero("3001234567");

            NexaWAplication.setClienteActual(cliente);
            assertDoesNotThrow(() -> NexaWAplication.enviarNotificacion("Hola test"));
        }
    }
