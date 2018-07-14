package com.github.kyriosdata.exemplo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}

