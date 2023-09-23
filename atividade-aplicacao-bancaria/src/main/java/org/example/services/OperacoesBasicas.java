package org.example.services;

import org.example.domain.contas.Conta;
import org.example.exceptions.ContaException;

public interface OperacoesBasicas {

    public Double realizarDeposito(Double valor, Boolean mostrarMensagem) throws ContaException;
    public Double realizarSaque(Double valor) throws ContaException;
    public Double realizarTransferencia(Double valor, Conta contaDestino) throws ContaException;
    public Double realizarPagamento(Double valor, String cobrador);
    public String gerarExtrato();

}
