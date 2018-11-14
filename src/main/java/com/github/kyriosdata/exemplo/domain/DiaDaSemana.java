/*
 * Copyright (c) 2018.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo.domain;

import java.time.LocalDate;

/**
 * Reúne uma data e o dia da semana correspondente.
 * Criada exclusivamente para ilustrar a resposta via RESTFul API.
 */
public class DiaDaSemana {

    private final LocalDate data;
    private final String diaDaSemana;

    public DiaDaSemana(LocalDate data, String diaDaSemana) {
        this.data = data;
        this.diaDaSemana = diaDaSemana;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }
}
