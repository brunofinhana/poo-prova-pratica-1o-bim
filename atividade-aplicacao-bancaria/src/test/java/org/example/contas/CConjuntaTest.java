package org.example.contas;

import org.example.domain.contas.ContaConjunta;
import org.example.domain.contas.Conta;
import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.PessoaFisica;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.example.exceptions.ContaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CConjuntaTest {

    private ContaConjunta contaConjunta;

    @BeforeEach
    void setUp() {
        // Create a new ContaConjunta instance for each test
        PessoaFisica titular = new ClientePF("Titular", "123.456.789-00", EstadoCivil.SOLTEIRO, "Teste Banco", 5768, 12347890);
        PessoaFisica participante = new ClientePF("Participante", "123.456.789-00", EstadoCivil.CASADO, "Teste Banco", 5768, 12347890);
        contaConjunta = new ContaConjunta(titular, participante, 1000.0, 1234, 5678);
    }

    @Test
    void testGetNumParticipantes() {
        assertEquals(2, contaConjunta.getNumParticipantes(), "Number of participants should be 2");
    }

    @Test
    void testToString() {
        String expectedToString = "Ag.: 1234 - CC: 5678\nSaldo: R$ 1000.0";
        assertEquals(expectedToString, contaConjunta.toString(), "ToString should return the expected format");
    }

    @Test
    void testRealizarDeposito() {
        double saldoBefore = contaConjunta.getSaldo();
        double depositAmount = 500.0;
        contaConjunta.realizarDeposito(depositAmount, true);

        assertEquals(saldoBefore + depositAmount, contaConjunta.getSaldo(), 0.01, "Deposit should increase the balance");
    }

    @Test
    void testRealizarSaque() throws ContaException {
        double saldoBefore = contaConjunta.getSaldo();
        double withdrawAmount = 200.0;
        contaConjunta.realizarSaque(withdrawAmount);

        assertEquals(saldoBefore - withdrawAmount, contaConjunta.getSaldo(), 0.01, "Withdraw should decrease the balance");
    }

}
