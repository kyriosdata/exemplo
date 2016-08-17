package com.github.kyriosdata.exemplo;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CalendarioTest {

    @Test(expected = IllegalArgumentException.class)
    public void diaMenorQueUmInvalido() {
        Calendario.diaDaSemana(0, 8, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void diaMaiorQue31Invalido() {
        Calendario.diaDaSemana(32, 8, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mesMenorQueUmInvalido() {
        Calendario.diaDaSemana(1, 0, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mesMaiorQue12Invalido() {
        Calendario.diaDaSemana(1, 13, 2016);
    }

    @Test(expected = IllegalArgumentException.class)
    public void anoMenorQue1753Invalido() {
        Calendario.diaDaSemana(31, 12, 1752);
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
    public void apenasParaAgradarJacocoTool100PorCentoCobertura() {
        new Calendario();
    }
}

