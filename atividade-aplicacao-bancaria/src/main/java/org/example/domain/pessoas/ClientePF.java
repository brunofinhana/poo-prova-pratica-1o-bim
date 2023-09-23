package org.example.domain.pessoas;

import org.example.domain.contas.ContaCorrente;
import org.example.domain.pessoas.enums.EstadoCivil;

public class ClientePF extends PessoaFisica {

    private String nomeBanco;
    private Integer agencia;
    private Integer conta;

    public ClientePF(String idPessoa, String cpf, EstadoCivil estadoCivil, String nomeBanco, Integer agencia, Integer conta) {
        super(idPessoa, cpf, estadoCivil);
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
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

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Banco: " + getNomeBanco() + ", Ag." + getAgencia() + " - CC: " + getConta();
    }
}
