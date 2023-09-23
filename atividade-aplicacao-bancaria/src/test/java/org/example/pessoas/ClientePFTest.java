package org.example.pessoas;

import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientePFTest {

    private ClientePF clientePF;

    @BeforeEach
    void setUp() {
        clientePF = new ClientePF("12345", "12345678901", EstadoCivil.CASADO, "Banco Test", 123, 456789);
    }

    @Test
    void testGetters() {
        assertEquals("12345", clientePF.getIdPessoa());
        assertEquals("12345678901", clientePF.getCpf());
        assertEquals(EstadoCivil.CASADO, clientePF.getEstadoCivil());
        assertEquals("Banco Test", clientePF.getNomeBanco());
        assertEquals(123, clientePF.getAgencia());
        assertEquals(456789, clientePF.getConta());
    }

    @Test
    void testSetters() {
        clientePF.setNomeBanco("New Banco");
        clientePF.setAgencia(789);
        clientePF.setConta(987654);

        assertEquals("New Banco", clientePF.getNomeBanco());
        assertEquals(789, clientePF.getAgencia());
        assertEquals(987654, clientePF.getConta());
    }

    @Test
    void testToString() {
        String expected = "Banco: Banco Test, Ag.123 - CC: 456789";
        assertEquals(expected, clientePF.toString());
    }
}
