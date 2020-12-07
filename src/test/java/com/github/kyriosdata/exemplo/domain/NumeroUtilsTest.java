/**
 * Copyright (c) 2019
 * Fábrica de Software - Instituto de Informática
 * Fábio Nogueira de Lucena
 */

package com.github.kyriosdata.exemplo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumeroUtilsTest {

    @Test
    void valorNegativoGeraExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumeroUtils.porExtenso(-1);
        });
    }

    @Test
    void zero() {
        assertEquals("zero", NumeroUtils.porExtenso(0));
        assertEquals("três", NumeroUtils.porExtenso(3));
        assertEquals("nove", NumeroUtils.porExtenso(9));
        assertEquals("dez", NumeroUtils.porExtenso(10));
        assertEquals("dezoito", NumeroUtils.porExtenso(18));
        assertEquals("dezenove", NumeroUtils.porExtenso(19));
    }

    @Test
    void maiorQueDezenoveMenorQueCem() {
        assertEquals("vinte", NumeroUtils.porExtenso(20));
        assertEquals("vinte e um", NumeroUtils.porExtenso(21));
        assertEquals("vinte e nove", NumeroUtils.porExtenso(29));

        assertEquals("trinta", NumeroUtils.porExtenso(30));
        assertEquals("trinta e oito", NumeroUtils.porExtenso(38));

        assertEquals("quarenta e dois", NumeroUtils.porExtenso(42));
        assertEquals("cinquenta e seis", NumeroUtils.porExtenso(56));
        assertEquals("sessenta e três", NumeroUtils.porExtenso(63));
        assertEquals("setenta e quatro", NumeroUtils.porExtenso(74));
        assertEquals("oitenta e cinco", NumeroUtils.porExtenso(85));
        assertEquals("noventa e sete", NumeroUtils.porExtenso(97));
    }

    @Test
    void cem() {
        assertEquals("cem", NumeroUtils.porExtenso(100));
    }

    @Test
    void maiorQueCemMenorQueMil() {
        assertEquals("cento e um", NumeroUtils.porExtenso(101));
        assertEquals("duzentos", NumeroUtils.porExtenso(200));
        assertEquals("duzentos e um", NumeroUtils.porExtenso(201));
        assertEquals("trezentos e três", NumeroUtils.porExtenso(303));
        assertEquals("quinhentos e cinquenta e oito", NumeroUtils.porExtenso(558));
        assertEquals("novecentos e nove", NumeroUtils.porExtenso(909));
    }

    @Test
    void casosSuiGeneris() {
        assertEquals("mil", NumeroUtils.porExtenso(1000));
        assertEquals("um milhão e mil", NumeroUtils.porExtenso(1_001_000));
    }

    @Test
    void multiplosDeMil() {
        assertEquals("um milhão", NumeroUtils.porExtenso(1_000_000));
        assertEquals("dois milhões", NumeroUtils.porExtenso(2_000_000));
        assertEquals("dois bilhões", NumeroUtils.porExtenso(2_000_000_000));

        assertEquals("dois bilhões, cento e um milhões, nove mil e dois",
                NumeroUtils.porExtenso(2_101_009_002));
    }

    @Test
    void variosBlocos() {
        assertEquals("mil e um", NumeroUtils.porExtenso(1001));
        assertEquals("mil e cem", NumeroUtils.porExtenso(1100));
    }

    @Test
    void recuperacaoCorretaDeGrupo() {
        assertEquals(0, NumeroUtils.extraiGrupo(0, 0));
        assertEquals(0, NumeroUtils.extraiGrupo(0, 1));

        assertEquals(999, NumeroUtils.extraiGrupo(999, 0));
        assertEquals(0, NumeroUtils.extraiGrupo(999, 1));

        assertEquals(0, NumeroUtils.extraiGrupo(1000, 0));
        assertEquals(1, NumeroUtils.extraiGrupo(1000, 1));
        assertEquals(0, NumeroUtils.extraiGrupo(1000, 2));
    }

    @Test
    void totalDeDigitos() {
        assertEquals(1, NumeroUtils.totalDeDigitos(1));
        assertEquals(2, NumeroUtils.totalDeDigitos(11));
        assertEquals(3, NumeroUtils.totalDeDigitos(999));
        assertEquals(4, NumeroUtils.totalDeDigitos(1999));
        assertEquals(5, NumeroUtils.totalDeDigitos(55555));
    }

    @Test
    void totalDeGrupos() {
        assertEquals(1, NumeroUtils.totalDeGrupos(1));
        assertEquals(1, NumeroUtils.totalDeGrupos(11));
        assertEquals(1, NumeroUtils.totalDeGrupos(999));
        assertEquals(2, NumeroUtils.totalDeGrupos(1999));
        assertEquals(2, NumeroUtils.totalDeGrupos(9999));
        assertEquals(2, NumeroUtils.totalDeGrupos(10_000));
        assertEquals(2, NumeroUtils.totalDeGrupos(90_000));
        assertEquals(2, NumeroUtils.totalDeGrupos(999_000));
        assertEquals(3, NumeroUtils.totalDeGrupos(1_000_000));
    }

}
