package org.example.contas;

import org.example.domain.contas.ContaCorrente;
import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CCorrenteTest {

    private ContaCorrente contaCorrente;

    @BeforeEach
    public void setUp() {
        ClientePF titular = new ClientePF("1", "12345678900", EstadoCivil.SOLTEIRO, "Banco X", 1234, 56789);
        contaCorrente = new ContaCorrente(titular, null, 1000.0, 1234, 56789);
    }

    @Test
    public void testRealizarFinanciamento() {
        Double valorFinanciamento = 500.0;
        Integer periodoEmDias = 30;
        Double expectedTotalAPagar = (valorFinanciamento * 0.03) * periodoEmDias;
        Double initialSaldo = contaCorrente.getSaldo();

        Double valorAPagar = contaCorrente.realizarFinanciamento(valorFinanciamento, periodoEmDias);

        assertEquals(initialSaldo - valorFinanciamento, contaCorrente.getSaldo());
        assertEquals(expectedTotalAPagar, valorAPagar);
    }

    @Test
    public void testRealizarFinanciamentoSemSaldo() {
        Double valorFinanciamento = 1500.0;
        Integer periodoEmDias = 30;
        Double initialSaldo = contaCorrente.getSaldo();

        Double valorAPagar = contaCorrente.realizarFinanciamento(valorFinanciamento, periodoEmDias);

        assertEquals(initialSaldo, contaCorrente.getSaldo());
        assertEquals(0.0, valorAPagar);
    }

    @Test
    public void testRealizarFinanciamentoComValorNegativo() {
        Double valorFinanciamento = -500.0;
        Integer periodoEmDias = 30;
        Double initialSaldo = contaCorrente.getSaldo();

        Double valorAPagar = contaCorrente.realizarFinanciamento(valorFinanciamento, periodoEmDias);

        assertEquals(initialSaldo, contaCorrente.getSaldo());
        assertEquals(0.0, valorAPagar);
    }

    @Test
    public void testRealizarFinanciamentoComValorZero() {
        Double valorFinanciamento = 0.0;
        Integer periodoEmDias = 30;
        Double initialSaldo = contaCorrente.getSaldo();

        Double valorAPagar = contaCorrente.realizarFinanciamento(valorFinanciamento, periodoEmDias);

        assertEquals(initialSaldo, contaCorrente.getSaldo());
        assertEquals(0.0, valorAPagar);
    }
}
