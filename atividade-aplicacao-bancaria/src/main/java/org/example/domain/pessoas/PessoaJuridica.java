package org.example.domain.pessoas;

public class PessoaJuridica extends Pessoa {

    String empresa;
    String cnpj;

    public PessoaJuridica(String idPessoa, String empresa, String cnpj) {
        super(idPessoa);
        this.cnpj = cnpj;
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Reescrevendo o método toString() para exibir as informações corretamente ao usuário no resultado dos métodos
    @Override
    public String toString() {
        return "Nome da empresa: " + getEmpresa() + " - CNPJ: " + getCnpj();
    }

}
