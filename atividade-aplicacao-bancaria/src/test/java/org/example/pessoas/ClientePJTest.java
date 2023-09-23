package org.example.pessoas;

import org.example.domain.pessoas.ClientePJ;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientePJTest {

    private ClientePJ clientePJ;

    @BeforeEach
    void setUp() {
        clientePJ = new ClientePJ("12345", "12345678901", "Banco Teste" +
                "", 123, 456789, "Empresa Teste");
    }

    @Test
    void testGetters() {
        assertEquals("12345", clientePJ.getIdPessoa());
        assertEquals("12345678901", clientePJ.getCnpj());
        assertEquals("Banco Teste", clientePJ.getNomeBanco());
        assertEquals(123, clientePJ.getAgencia());
        assertEquals(456789, clientePJ.getConta());
        assertEquals("Empresa Teste", clientePJ.getEmpresa());
    }

    @Test
    void testSetters() {
        clientePJ.setNomeBanco("Banco Teste");
        clientePJ.setAgencia(789);
        clientePJ.setConta(987654);
        clientePJ.setEmpresa("Empresa Teste");

        assertEquals("Banco Teste", clientePJ.getNomeBanco());
        assertEquals(789, clientePJ.getAgencia());
        assertEquals(987654, clientePJ.getConta());
        assertEquals("Empresa Teste", clientePJ.getEmpresa());
    }

    @Test
    void testToString() {
        String expected = "Nome do banco: Banco Teste\nNome da empresa: Empresa Teste, Ag.: 123 - CC: 456789";
        assertEquals(expected, clientePJ.toString());
    }
}
