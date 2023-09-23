package org.example.domain.contas;

import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.PessoaFisica;

public class ContaConjunta extends Conta {
    private Integer numParticipantes = 2;

    public ContaConjunta(PessoaFisica titular, PessoaFisica participante, Double saldo, Integer agencia, Integer conta) {
        super((ClientePF) titular, saldo, agencia, conta);
    }

    // Getters e setters
    public Integer getNumParticipantes() {
        return numParticipantes;
    }
    public void setNumParticipantes(Integer numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Ag.: " + getAgencia() + " - CC: " + getConta() + "\nSaldo: R$ " + getSaldo();
    }

}
