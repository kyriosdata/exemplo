/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo;

/**
 * Implementação do cálculo de dia da semana.
 *
 * <p>Algoritmo correspondente obtido de
 * LARSEN, K. S. Computing the Day of the week,
 * Dr. Dobb´s Journal, april, 1995.
 *
 */
public final class Calendario {

    /**
     * Maior valor para um dia.
     */
    public static final int MAIOR_DIA = 31;

    /**
     * Valor correspondente ao mês de janeiro.
     */
    public static final int JANEIRO = 1;

    /**
     * Valor correspondente ao mês de fevereiro.
     */
    public static final int FEVEREIRO = 2;

    /**
     * Valor correspondente ao mês de dezembro.
     */
    public static final int DEZEMBRO = 12;

    /**
     * Total de dias em uma semana.
     */
    public static final int DIAS_DA_SEMANA = 7;

    /**
     * Ano de referência para o calendário gregoriano?!
     */
    public static final int CALENDARIO_GREGORIANO = 1753;

    /**
     * Classe contendo apenas operações "static".
     * Evita que instância seja criada desnecessariamente.
     */
    private Calendario() {
        // Segue recomendação de Checkstyle.
    }

    /**
     * Obtém dia da semana para a data.
     * @param dia O dia da data. Valor entre 1 e 31, inclusive.
     * @param mes O mês da data. Valor entre 1 e 12, inclusive.
     * @param ano O ano da data. Valor maior que 1752.
     *
     * @return O dia da semana correspondente à data. O valor 0 para
     * segunda-feira, 1 para terça-feira, 2 para quarta-feira e
     * assim sucessivamente.
     *
     * @throws IllegalArgumentException Se o dia for inválido (menor que um
     * ou maior que 31), o mês for inválido (menor que 1 ou maior que 12)
     * ou o ano for menor que 1753.
     */
    public static int diaDaSemana(final int dia, final int mes, final int ano) {
        int m = mes;
        int a = ano;

        if (dia < 1 || dia > MAIOR_DIA) {
            throw new IllegalArgumentException("dia inválido");
        }

        if (mes < 1 || mes > DEZEMBRO) {
            throw new IllegalArgumentException("mês inválido");
        }

        if (ano < CALENDARIO_GREGORIANO) {
            throw new IllegalArgumentException("ano inválido");
        }

        if (mes == JANEIRO || mes == FEVEREIRO) {
            m = m + DEZEMBRO;
            a = a - 1;
        }

        int s = dia + 2 * m + 3 * (m + 1) / 5 + a + a / 4 - a / 100 + a / 400;

        return s % DIAS_DA_SEMANA;
    }
}
