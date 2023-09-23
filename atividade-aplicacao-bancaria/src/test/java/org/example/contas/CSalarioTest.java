package org.example.contas;

import org.example.domain.contas.ContaSalario;
import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CSalarioTest {

    private ContaSalario contaSalario;

    @BeforeEach
    public void setUp() {
        // Create a sample ContaSalario instance for testing
        ClientePF titular = new ClientePF("Teste pessoa", "12341234", EstadoCivil.UNIAO_ESTAVEL, "Nome Banco teste", 0033, 4312);
        contaSalario = new ContaSalario(titular, 1000.0, 1234, 5678, "Sample Company");
    }

    @Test
    public void testGetEmpresa() {
        assertEquals("Sample Company", contaSalario.getEmpresa());
    }

    @Test
    public void testSetEmpresa() {
        contaSalario.setEmpresa("New Company");
        assertEquals("New Company", contaSalario.getEmpresa());
    }

    @Test
    public void testToString() {
        String expected = "Ag.: 1234 - CC: 5678\nSaldo: R$ 1000.0";
        assertEquals(expected, contaSalario.toString());
    }

    @Test
    public void testNotNull() {
        assertNotNull(contaSalario);
    }

    @Test
    public void testGetTitular() {
        assertNotNull(contaSalario.getTitular());
    }

    @Test
    public void testGetSaldo() {
        assertEquals(1000.0, contaSalario.getSaldo());
    }

    @Test
    public void testGetAgencia() {
        assertEquals(1234, contaSalario.getAgencia());
    }

    @Test
    public void testGetConta() {
        assertEquals(5678, contaSalario.getConta());
    }

    @Test
    public void testSetTitular() {
        ClientePF newTitular = new ClientePF("Teste pessoa", "12341234", EstadoCivil.UNIAO_ESTAVEL, "Nome Banco teste", 0033, 4312);
        contaSalario.setTitular(newTitular);
        assertEquals(newTitular, contaSalario.getTitular());
    }

    @Test
    public void testSetSaldo() {
        contaSalario.setSaldo(2000.0);
        assertEquals(2000.0, contaSalario.getSaldo());
    }

    @Test
    public void testSetAgencia() {
        contaSalario.setAgencia(4321);
        assertEquals(4321, contaSalario.getAgencia());
    }

    @Test
    public void testSetConta() {
        contaSalario.setConta(8765);
        assertEquals(8765, contaSalario.getConta());
    }
}
