package org.example.domain.contas;

import org.example.domain.pessoas.ClientePF;

public class ContaPoupanca extends Conta {

    private Double depositoInicial;
    private Double valorMinimoDeposito = 50d;

    public ContaPoupanca(ClientePF titular, Double saldo, Integer agencia, Integer conta, Double depositoInicial) {
        super(titular, saldo, agencia, conta);
        this.depositoInicial = depositoInicial;
    }

    // Getters e setters
    public Double getDepositoInicial() {
        return depositoInicial;
    }

    public void setDepositoInicial(Double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }

    public Double getValorMinimoDeposito() {
        return valorMinimoDeposito;
    }

    public void setValorMinimoDeposito(Double valorMinimoDeposito) {
        this.valorMinimoDeposito = valorMinimoDeposito;
    }

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Ag.: " + getAgencia() + " - CC: " + getConta() + "\nSaldo: R$ " + getSaldo();
    }

    // Métodos próprios da classe

    // Realizar aplicaçação
    public Double realizarAplicacao(Double valor) {
        Double taxaDeJuroPorDia = 0.03;
        Integer periodoEmDias = 30;
        double valorGerado = 0d;

        if(getSaldo() <= 0 || valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else if(valor <= 0) {
            System.out.println("O valor precisa ser maior do que R$0.00");
        } else {
            valorGerado = (valor * taxaDeJuroPorDia) * periodoEmDias;
            setSaldo(getSaldo() - valor);
            System.out.println(
                    "Aplicação de -R$ " + valor +
                            " realizado com sucesso!" +
                            " A previsão do valor a receber é de +R$ " + (valor + valorGerado) +
                            " em " + periodoEmDias + " dias"
            );
            System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            gravarTransacao("Aplicação de -R$ " + valor + " com total a receber de +R$ " + (valor + valorGerado) + " em " + periodoEmDias + " dias");
        }
        return valorGerado;
    }

    // Realizar Saque
    @Override
    public Double realizarDeposito(Double valor, Boolean mostrarMensagem) {
        if(valor > 0) {
            Double rendimento = (getSaldo() + valor) * 0.001;
            setSaldo(getSaldo() + valor + rendimento);
            if(mostrarMensagem) {
                System.out.println("Depósito de +R$ " + valor + " realizado com sucesso! Seu dinheiro já está rendendo!");
                System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            }
            gravarTransacao("Depósito: +R$ " + valor + " com rendimento +R$ " + rendimento);
        } else {
            System.out.println("Desculpe, não foi possível realizar a transação. Valor de depósito não autorizado.");
        }
        return getSaldo();
    }

}