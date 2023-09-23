package org.example.domain.pessoas;

public abstract class Pessoa {

    private String idPessoa;

    public Pessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getIdPessoa() {
        return idPessoa;
    }
    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

}
