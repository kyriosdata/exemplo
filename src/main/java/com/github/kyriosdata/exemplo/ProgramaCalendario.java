/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo;

import java.time.LocalDate;

/**
 * Programa que ilustra a obtenção do dia da semana
 * para uma data específica.
 *
 */
public final class ProgramaCalendario {

    /**
     * Restringe criação de instância.
     */
    private ProgramaCalendario() {
        // Apenas evita criação de instância.
    }

    /**
     * Ponto de entrada da aplicação. Apenas para ilustra chamada de método.
     *
     * @param args Ignorados.
     */
    public static void main(final String[] args) {

        LocalDate hoje = LocalDate.now();
        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        int diaDaSemana = Calendario.diaDaSemana(dia, mes, ano);

        System.out.println("Hoje é " + diaDaSemana);
    }
}
