/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo;

import java.time.LocalDate;

/**
 * Implementação do cálculo de dia da semana.
 *
 * <p>Algoritmo correspondente obtido de
 * LARSEN, K. S. Computing the Day of the week,
 * Dr. Dobb´s Journal, april, 1995.
 *
 * <p>Convém ressaltar a existência da classe
 * {@link java.time.LocalDate} e, em particular,
 * do método {@link LocalDate#getDayOfWeek()},
 * que oferece funcionalidade similar.
 *
 */
public class Calendario
{
    /**
     * Obtém dia da semana para a data.
     * @param d O dia da data. Valor entre 1 e 31, inclusive.
     * @param m O mês da data. Valor entre 1 e 12, inclusive.
     * @param a O ano da data. Valor maior que 1752.
     *
     * @return O dia da semana correspondente à data. O valor 0 para
     * segunda-feira, 1 para terça-feira, 2 para quarta-feira e
     * assim sucessivamente.
     *
     * @throws IllegalArgumentException Se o dia for inválido (menor que um
     * ou maior que 31), o mês for inválido (menor que 1 ou maior que 12)
     * ou o ano for menor que 1753.
     */
    public static int diaDaSemana(int d, int m, int a) {
        if (d < 1 || d > 31) {
            throw new IllegalArgumentException("dia inválido");
        }

        if (m < 1 || m > 12) {
            throw new IllegalArgumentException("mês inválido");
        }

        if (a < 1753) {
            throw new IllegalArgumentException("ano inválido");
        }

        if (m == 1 || m == 2) {
            m = m + 12;
            a = a - 1;
        }

        int s = d + 2 * m + 3 * (m + 1) / 5 + a + a / 4 - a / 100 + a / 400;

        return s % 7;
    }
}