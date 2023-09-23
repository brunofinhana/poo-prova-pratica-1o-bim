package org.example.domain.contas;

import org.example.domain.pessoas.ClientePF;

public class ContaSalario extends Conta {

    public ContaSalario(ClientePF titular, Double saldo, Integer agencia, Integer conta, String empresa) {
        super(titular, saldo, agencia, conta);
        this.empresa = empresa;
    }

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Ag.: " + getAgencia() + " - CC: " + getConta() + "\nSaldo: R$ " + getSaldo();
    }

    private String empresa;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}
