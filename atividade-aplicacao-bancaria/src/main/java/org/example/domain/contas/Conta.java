package org.example.domain.contas;

import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.PessoaFisica;
import org.example.exceptions.ContaException;
import org.example.services.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements OperacoesBasicas {

    private PessoaFisica titular;
    private Double saldo;
    private Integer agencia;
    private Integer conta;
    private List<String> transacoes;

    // ==============================================================
    // Construtor
    // [ADICIONAR PARÂMETRO DE TITULAR (PESSOA)]
    public Conta(ClientePF titular, Double saldo, Integer agencia, Integer conta) {
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
        this.conta = conta;
        this.transacoes = new ArrayList<>();
    }

    // ==============================================================
    // Getters e Setters
    public PessoaFisica getTitular() { return titular; }
    public PessoaFisica setTitular(PessoaFisica titular) {
        return this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getAgencia() {
        return agencia;
    }
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }
    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public void gravarTransacao(String transacao) {
        transacoes.add(transacao);
    }

    // ==============================================================
    // Outros métodos

    // Depósito
    @Override
    public Double realizarDeposito(Double valor, Boolean mostrarMensagem) throws ContaException {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            if(mostrarMensagem) {
                System.out.println("Depósito de +R$ " + valor + " realizado com sucesso!");
                System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            }
            gravarTransacao("Depósito: +R$ " + valor);
        } else {
            throw new ContaException("Valor de depósito insuficiente. Não foi possível realizar a transação.");
//            System.out.println("Desculpe, não foi possível realizar a transação. Valor de depósito não autorizado.");
        }
        return getSaldo();
    }

    // Saque
    @Override
    public Double realizarSaque(Double valor) throws ContaException {
        if(getSaldo() > 0 && valor >= 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de -R$ " + valor + " realizado com sucesso!");
            System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            gravarTransacao("Saque: -R$ " + valor);
        } else {
            throw new ContaException("Não há saldo suficiente. Não foi possível realizar a transação.");
        }
        return getSaldo();
    }

    // Transferência
    @Override
    public Double realizarTransferencia(Double valor, Conta contaDestino) throws ContaException {
        if(getSaldo() <= 0 || valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else if(valor <= 0) {
            System.out.println("O valor precisa ser maior do que R$0.00");
        } else {
            setSaldo(getSaldo() - valor);
            contaDestino.realizarDeposito(valor, false);
//            System.out.println(contaDestino.realizarDeposito(valor) + " Valor recebido na conta: " + contaDestino.getConta());
            System.out.println("Transferência de -R$ " + valor + " para " + contaDestino + " realizado com sucesso!");
            System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            gravarTransacao("Transferência para " + contaDestino + " de -R$ " + valor);
        }
        return getSaldo();
    }

    // Pagamento
    @Override
    public Double realizarPagamento(Double valor, String cobrador) {
        if(getSaldo() <= 0 || valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else if(valor <= 0) {
            System.out.println("O valor precisa ser maior do que R$0.00");
        } else {
            setSaldo(getSaldo() - valor);
            System.out.println("Pagamento de -R$ " + valor + " para " + cobrador + " realizado com sucesso!");
            System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            gravarTransacao("Pagamento para " + cobrador + " de -R$ " + valor);
        }
        return getSaldo();
    }

    // Imprimr extrato
    @Override
    public String gerarExtrato() {
        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato da Conta").append("\n");
        extrato.append("Conta: ").append(getConta()).append("\n");
        extrato.append("Agência: ").append(getAgencia()).append("\n");

        extrato.append("------------------------------------------------\n");
        extrato.append("\n");

        extrato.append("Suas últimas transações:\n");
        extrato.append("\n");
        // Lista de transações
        for (String transacao : transacoes) {
            extrato.append(transacao).append("\n");
        }

        extrato.append("\n");
        extrato.append("------------------------------------------------\n");

        extrato.append("Saldo atual: R$ ").append(getSaldo()).append("\n");
        return extrato.toString();
    }

}
