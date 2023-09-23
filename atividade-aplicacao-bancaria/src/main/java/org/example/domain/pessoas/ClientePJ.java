package org.example.domain.pessoas;

import org.example.domain.pessoas.enums.EstadoCivil;

public class ClientePJ extends PessoaJuridica {

    private String nomeBanco;
    private Integer agencia;
    private Integer conta;
    private String empresa;

    public ClientePJ(
            String idPessoa,
            String cnpj,
            String nomeBanco,
            Integer agencia,
            Integer conta,
            String empresa
    ) {
        super(idPessoa, cnpj, empresa);
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
        this.conta = conta;
        this.empresa = empresa;
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

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    // Reescrevendo o método toString() para exibir as informações da conta corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Nome do banco: " + getNomeBanco() + "\nNome da empresa: " + getEmpresa() + ", Ag.: " + getAgencia() + " - CC: " + getConta();
    }

}
