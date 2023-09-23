package org.example.contas;

import org.example.domain.contas.ContaPoupanca;
import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CPoupancaTest {

    private ContaPoupanca contaPoupanca;

    @BeforeEach
    void setUp() {
        ClientePF titular = new ClientePF("Teste pessoa", "12341234", EstadoCivil.UNIAO_ESTAVEL, "Nome Banco teste", 1234, 56789);
        contaPoupanca = new ContaPoupanca(titular, 1000.0, 1234, 56789, 0d);
    }

    @Test
    void testRealizarAplicacao() {
        Double valorAplicacao = 300.0;
        Double saldoInicial = contaPoupanca.getSaldo();
        Double taxaDeJuroPorDia = 0.03;
        Integer periodoEmDias = 30;
        Double rendimentoEsperado = (valorAplicacao * taxaDeJuroPorDia) * periodoEmDias;

        Double valorGerado = contaPoupanca.realizarAplicacao(valorAplicacao);

        assertEquals(saldoInicial - valorAplicacao, contaPoupanca.getSaldo());
        assertEquals(rendimentoEsperado, valorGerado);
    }

    @Test
    void testRealizarAplicacaoSemSaldo() {
        Double valorAplicacao = 2000.0;

        Double valorGerado = contaPoupanca.realizarAplicacao(valorAplicacao);

        assertEquals(1000.0, contaPoupanca.getSaldo());
        assertEquals(0.0, valorGerado);
    }

    @Test
    void testRealizarAplicacaoComValorNegativo() {
        Double valorAplicacao = -100.0;

        Double valorGerado = contaPoupanca.realizarAplicacao(valorAplicacao);

        assertEquals(1000.0, contaPoupanca.getSaldo());
        assertEquals(0.0, valorGerado);
    }

    @Test
    void testRealizarDeposito() {
        Double valorDeposito = 200.0;
        Double saldoInicial = contaPoupanca.getSaldo();
        Double rendimentoEsperado = (saldoInicial + valorDeposito) * 0.001;

        Double novoSaldo = contaPoupanca.realizarDeposito(valorDeposito, true);

        assertEquals(saldoInicial + valorDeposito + rendimentoEsperado, novoSaldo);
    }

    @Test
    void testRealizarDepositoComValorNegativo() {
        Double valorDeposito = -100.0;

        Double novoSaldo = contaPoupanca.realizarDeposito(valorDeposito, true);

        assertEquals(1000.0, novoSaldo);
    }
}
