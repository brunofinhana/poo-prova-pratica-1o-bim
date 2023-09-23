package org.example.pessoas;

import org.example.domain.pessoas.PessoaJuridica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaJuridicaTest {

    private PessoaJuridica pessoaJuridica;

    @BeforeEach
    public void setUp() {
        // Initialize a new PessoaJuridica object before each test
        pessoaJuridica = new PessoaJuridica("12345", "Teste Empresa", "12345678901234");
    }

    @Test
    public void testGetEmpresa() {
        assertEquals("Teste Empresa", pessoaJuridica.getEmpresa());
    }

    @Test
    public void testSetEmpresa() {
        pessoaJuridica.setEmpresa("Nova Empresa");
        assertEquals("Nova Empresa", pessoaJuridica.getEmpresa());
    }

    @Test
    public void testGetCnpj() {
        assertEquals("12345678901234", pessoaJuridica.getCnpj());
    }

    @Test
    public void testSetCnpj() {
        pessoaJuridica.setCnpj("98765432109876");
        assertEquals("98765432109876", pessoaJuridica.getCnpj());
    }

    @Test
    public void testToString() {
        assertEquals("Nome da empresa: Teste Empresa - CNPJ: 12345678901234", pessoaJuridica.toString());
    }

    @Test
    public void testToStringAfterSetters() {
        pessoaJuridica.setEmpresa("Nova Empresa");
        pessoaJuridica.setCnpj("98765432109876");
        assertEquals("Nome da empresa: Nova Empresa - CNPJ: 98765432109876", pessoaJuridica.toString());
    }
}
