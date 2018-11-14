/*
 * Copyright (c) 2016.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarioTest {

    @Test
    public void diaMenorQueUmInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Calendario.diaDaSemana(0, 8, 2016));
    }

    @Test
    public void diaMaiorQue31Invalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Calendario.diaDaSemana(32, 8, 2016));
    }

    @Test

    public void mesMenorQueUmInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Calendario.diaDaSemana(1, 0, 2016));
    }

    @Test
    public void mesMaiorQue12Invalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Calendario.diaDaSemana(1, 13, 2016));
    }

    @Test
    public void anoMenorQue1753Invalido() {
        assertThrows(IllegalArgumentException.class,
                () -> Calendario.diaDaSemana(31, 12, 1752));
    }

    @Test
    public void anoIgualAoLimiteInferior() {
        assertEquals(0, Calendario.diaDaSemana(31, 12, 1753));
    }

    @Test
    public void umDiaArbitrarioObtidoDeCalendario() {
        assertEquals(2, Calendario.diaDaSemana(17, 8, 2016));
    }

    @Test
    public void umAnoBissexto() {
        assertEquals(0, Calendario.diaDaSemana(29, 2, 2016));
    }

    @Test
    public void dataInvalidaAnoNaoBissextoNaoVerificaData() {
        assertEquals(6, Calendario.diaDaSemana(29, 2, 2015));
    }

    @Test
    public void umDiaDistanteParaOsHumanos() {
        int diaDaSemana = LocalDate.of(5000, 1, 1).getDayOfWeek().ordinal();
        assertEquals(diaDaSemana, Calendario.diaDaSemana(1, 1, 5000));
    }

    @Test
    public void nomesDiasDaSemana() {
        assertEquals(7, Calendario.semana.length);
        assertEquals("segunda-feira", Calendario.semana[0]);
        assertEquals("terça-feira", Calendario.semana[1]);
        assertEquals("quarta-feira", Calendario.semana[2]);
        assertEquals("quinta-feira", Calendario.semana[3]);
        assertEquals("sexta-feira", Calendario.semana[4]);
        assertEquals("sábado", Calendario.semana[5]);
        assertEquals("domingo", Calendario.semana[6]);
    }

    @Test
    public void diaDaSemanaDeHoje() {
        String hojeStr = Calendario.diaDaSemanaParaHoje();

        // Primeiro dia da semana é domingo, valor 0.
        LocalDate hoje = LocalDate.now();
        int diaDaSemanaJava = hoje.getDayOfWeek().getValue();

        // Ajustando para padrão adotado em Calendario
        int ajustado = (diaDaSemanaJava + 6) % 7;

        assertTrue(hojeStr.contains(Calendario.semana[ajustado]));
    }

    @Test
    public void coberturaCemPorCento() {
        assertNotNull(new Calendario());
    }
}


