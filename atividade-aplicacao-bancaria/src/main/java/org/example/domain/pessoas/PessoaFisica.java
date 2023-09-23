package org.example.domain.pessoas;

import org.example.domain.pessoas.enums.EstadoCivil;
public class PessoaFisica extends Pessoa {

    private String cpf;
    private EstadoCivil estadoCivil;

    // Construtor
    public PessoaFisica(String idPessoa, String cpf, EstadoCivil estadoCivil) {
        super(idPessoa);
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    // Reescrevendo o método toString() para exibir as informações corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "CPF: " + getCpf() + " - Estado Civil: " + getEstadoCivil();
    }

}