package org.example.domain.contas;

import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.ClientePJ;
import org.example.domain.pessoas.PessoaFisica;

public class ContaCorrente extends Conta {

    public ContaCorrente(ClientePF titular, ClientePJ titularPJ, Double saldo, Integer agencia, Integer conta) {
        super(titular, saldo, agencia, conta);
    }

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Ag.: " + getAgencia() + " - CC: " + getConta() + "\nSaldo: R$ " + getSaldo();
    }

    // --------------------------------------------

    // Financiamento
    public Double realizarFinanciamento(Double valor, Integer periodoEmDias) {
        // Lógica: (valor * taxaDeJuroPorDia) * periodoEmDias

        Double taxaDeJuroPorDia = 0.03;
        double valorAPagar = 0d;

        if(getSaldo() <= 0 || valor > getSaldo()) {
            System.out.println("Saldo insuficiente");
        } else if(valor <= 0) {
            System.out.println("O valor precisa ser maior do que R$0.00");
        } else {
            valorAPagar = (valor * taxaDeJuroPorDia) * periodoEmDias;
            setSaldo(getSaldo() - valor);
            System.out.println(
                    "Financiamento de -R$ " + valor +
                    " com total a pagar de -R$ " + (valor + valorAPagar) +
                    " em " + periodoEmDias + " dias," +
                    " realizado com sucesso!"
            );
            System.out.println("Saldo atual: R$ " + getSaldo() + "\n");
            gravarTransacao("Financiamento de -R$ " + valor + " com total a pagar de -R$ " + (valor + valorAPagar) + " em " + periodoEmDias + " dias");
        }
        return valorAPagar;
    }

}
