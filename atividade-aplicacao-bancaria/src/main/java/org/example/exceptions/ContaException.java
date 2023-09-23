package org.example.exceptions;

public class ContaException extends Exception {

    public ContaException(String mensagemErro) {
        super(mensagemErro);
    }

    // ==========================================================================
    // DEPÓSITO
    // ==========================================================================

    // Valor depositado é <= 0
    public void depositoValor0() {
        System.out.println("Erro: " + getMessage());
    }

    // ==========================================================================
    // SAQUE
    // ==========================================================================

    // Saldo é <= 0
    public void saqueValor0() {
        System.out.println("Erro: " + getMessage());
    }

}
