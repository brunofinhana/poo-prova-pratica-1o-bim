package org.example.domain;

import org.example.domain.contas.Conta;
import org.example.domain.contas.ContaConjunta;
import org.example.domain.contas.ContaCorrente;
import org.example.domain.contas.ContaPoupanca;
import org.example.domain.contas.ContaSalario;
import org.example.domain.pessoas.ClientePF;
import org.example.domain.pessoas.ClientePJ;
import org.example.domain.pessoas.PessoaFisica;
import org.example.domain.pessoas.PessoaJuridica;
import org.example.domain.contas.enums.TiposContaPF;
import org.example.domain.contas.enums.TiposContaPJ;

import java.util.Random;

public class Banco {

    // Atributos da classe
    private String nomeBanco;
    private Integer agencia;

    // Construtor
    public Banco(String nomeBanco, Integer agencia) {
        this.nomeBanco = nomeBanco;
        this.agencia = agencia;
    }

    // Getters e setters
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

    public Conta abrirContaPF(
            PessoaFisica pessoaFisica,
            PessoaFisica participante,
            String nomeBanco,
            Integer agencia,
            TiposContaPF tiposContaPF,
            Double depositoInicial
    ) {
        // NUMERO DE CONTA: Gerando um numero aleatorio como numero de conta
        Random objAleatorio = new Random();
        Integer numeroConta = objAleatorio.nextInt(9000) + 1000;

        // NOVO CLIENTE PF: Criando um novo cliente de Pessoa Fisica
        ClientePF titular = new ClientePF(
                pessoaFisica.getIdPessoa(),
                pessoaFisica.getCpf(),
                pessoaFisica.getEstadoCivil(),
                nomeBanco,
                agencia,
                numeroConta
        );

        // CRIANDO CONTA: Criando uma nova conta a partir de um tipo especifico
        Conta novaConta = null;
        switch (tiposContaPF) {

        case CONTA_POUPANCA:
            if(depositoInicial >= 50) {
                ContaPoupanca novaCP = new ContaPoupanca(
                    titular,
                    0d,
                    getAgencia(),
                    numeroConta,
                    depositoInicial
                );
                novaCP.setSaldo(depositoInicial);
                System.out.println("Conta Poupanca criada com sucesso!");
                System.out.println("Titular: " + titular.getIdPessoa());
                novaConta = novaCP;
            } else {
                System.out.println("Depósito inicial insuficiente. O valor mínimo é R$ 50.0.");
            }
            break;

        case CONTA_CONJUNTA:
            ContaConjunta novaCC2 = new ContaConjunta(
                    titular,
                    participante,
                    0d,
                    getAgencia(),
                    numeroConta
            );
            novaCC2.setSaldo(depositoInicial);
            System.out.println("Conta Conjunta criada com sucesso!");
            System.out.println("Titulares: " + titular.getIdPessoa() + ", " + participante.getIdPessoa());
            novaConta = novaCC2;
            break;

            default:
                ContaCorrente novaCC;
                novaCC = new ContaCorrente(
                        titular,
                        null,
                        0d,
                        getAgencia(),
                        numeroConta
                );
                novaCC.setSaldo(depositoInicial);
                System.out.println("Conta Corrente criada com sucesso!");
                System.out.println("Titular: " + titular.getIdPessoa());
                novaConta = novaCC;
        }
        return novaConta;
    }

//    ==========================================================================================

    public Conta abrirContaPJ(
            PessoaJuridica pessoaJuridica,
            PessoaFisica pessoaFisica,
            String nomeBanco,
            Integer agencia,
            TiposContaPJ tiposContaPJ,
            Double depositoInicial,
            String empresa
    ) {

        Random objAleatorio = new Random();
        Integer numeroConta = objAleatorio.nextInt(9000) + 1000;

        ClientePJ titular = new ClientePJ(
                pessoaJuridica.getIdPessoa(),
                pessoaJuridica.getCnpj(),
                nomeBanco,
                agencia,
                numeroConta,
                empresa
        );

        ClientePF titularPF = new ClientePF(
                pessoaFisica.getIdPessoa(),
                pessoaFisica.getCpf(),
                pessoaFisica.getEstadoCivil(),
                nomeBanco,
                agencia,
                numeroConta
        );

        // Create a new account
        Conta novaConta = null;

        switch (tiposContaPJ) {
            case CONTA_CORRENTE:
                ContaCorrente novaCC = new ContaCorrente(
                        null,
                        titular,
                        0d,
                        getAgencia(),
                        numeroConta
                );
                novaCC.setSaldo(depositoInicial);
                System.out.println("Conta Corrente para Pessoa Jurídica criada com sucesso!");
                System.out.println("Titular: " + titular.getIdPessoa());
                novaConta = novaCC;
                break;

            case CONTA_SALARIO:
                ContaSalario novaCS = new ContaSalario(
                        titularPF,
                        0d,
                        getAgencia(),
                        numeroConta,
                        "Nome da Empresa" // Replace with the actual company name
                );
                novaCS.setSaldo(depositoInicial);
                System.out.println("Conta Salário para Pessoa Jurídica criada com sucesso!");
                System.out.println("Empresa: " + titular.getIdPessoa());
                System.out.println("Titular: " + titularPF.getIdPessoa());
                novaConta = novaCS;
                break;

            default:
                System.out.println("Tipo de conta para Pessoa Jurídica inválido.");
        }

        return novaConta;
    }

}