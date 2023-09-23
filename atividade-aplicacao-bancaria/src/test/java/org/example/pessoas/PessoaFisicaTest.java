package org.example.pessoas;

import org.example.domain.pessoas.PessoaFisica;
import org.example.domain.pessoas.enums.EstadoCivil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaFisicaTest {

    private PessoaFisica pessoaFisica;

    @BeforeEach
    public void setUp() {
        pessoaFisica = new PessoaFisica("12345", "12345678901", EstadoCivil.SOLTEIRO);
    }

    @Test
    public void testGetCpf() {
        assertEquals("12345678901", pessoaFisica.getCpf());
    }

    @Test
    public void testSetCpf() {
        pessoaFisica.setCpf("98765432109");
        assertEquals("98765432109", pessoaFisica.getCpf());
    }

    @Test
    public void testGetEstadoCivil() {
        assertEquals(EstadoCivil.SOLTEIRO, pessoaFisica.getEstadoCivil());
    }

    @Test
    public void testSetEstadoCivil() {
        pessoaFisica.setEstadoCivil(EstadoCivil.CASADO);
        assertEquals(EstadoCivil.CASADO, pessoaFisica.getEstadoCivil());
    }
}
