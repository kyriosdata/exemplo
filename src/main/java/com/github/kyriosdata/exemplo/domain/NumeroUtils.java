/**
 * Copyright (c) 2019
 * Fábrica de Software - Instituto de Informática
 * Fábio Nogueira de Lucena
 */

package com.github.kyriosdata.exemplo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementa conversão de valor inteiro em representação textual
 * (por extenso).
 */
public final class NumeroUtils {

    /**
     * Valor empregado em várias operações para obtenção de dezenas,
     * dentre outras.
     */
    private static final int CEM = 100;

    /**
     * Limite a partir do qual tem-se regras genéricas para produção da
     * representação textual correspondente.
     */
    private static final int LIMITE_DEZENAS = 19;

    /**
     * Texto correspondente a centenas onde o índice de valor 1 identifica
     * "cento", 2 identifica "duzentos" e assim por diante. Apenas os valores
     * de 1 até 9, inclusive, são utilizados.
     */
    private static final String[] CENTENAS = {
            "", "cento", "duzentos", "trezentos",
            "quatrocentes", "quinhentos", "seiscentos", "setecentos",
            "oitocentos", "novecentos"
    };

    /**
     * Unidades no singular em potências de 1.000. O índice 1 identifica
     * "mil", 2 identifica "milhão", 3 identifica "bilhão" e 4 identifica
     * "trilhão".
     */
    private static String[] SINGULAR = {
            "", "mil", "milhão", "bilhão", "trilhão"
    };

    /**
     * O mesmo que o parâmetro {@code #SINGULAR}, exceto que a representação
     * das unidades segue no plural.
     */
    private static String[] PLURAL = {
            "", "mil", "milhões", "bilhões", "trilhões"
    };

    /**
     * Representação textual das dezenas. Para o índice 2, primeiro índice
     * válido, tem-se "vinte", para 3 tem-se "trinta" e assim sucessivamente,
     * até o 9 para "noventa".
     */
    private static String[] DEZENAS = {"", "", "vinte", "trinta",
            "quarenta", "cinquenta", "sessenta", "setenta",
            "oitenta", "noventa"
    };

    /**
     * Representação textual de todos os numerais menores que vinte e maiores
     * que 0. O índice 1 identifica "um", o índice 2 identifica "dois" e
     * assim sucessivamente. Ou seja, o índice remete ao texto correspondente
     * ao valor do próprio índice.
     */
    private static String[] MENOR_QUE_VINTE = {
            "", "um", "dois", "três", "quatro", "cinco",
            "seis", "sete", "oito", "nove", "dez", "onze",
            "doze", "treze", "catorze", "quinze", "dezesseis",
            "dezessete", "dezoito", "dezenove"
    };

    /**
     * Evita criação desnecessária de instância.
     */
    private NumeroUtils() {
    }

    /**
     * Produz a sequência de caracteres correspondente ao valor fornecido, ou
     * o que é denominado de valor por extenso. Por exemplo, se o valor 10 é
     * fornecido, então a resposta é "dez".
     *
     * <p>O valor 1.000 produz apenas a sequência "mil".
     * Adicionalmente, 1.001.000 e outros similares, também evitam a
     * expressão "um mil", neste caso, a saída é "um milhão e mil".</p>
     *
     * <p>O separador padrão é ",", exceto para o último separador, por
     * exemplo, "um milhão, mil e um" é a sequência para 1.001.001. </p>
     *
     * @param valor O valor.
     * @return Representação por extenso (textual) do valor fornecido.
     * @throws IllegalArgumentException Se um valor negativo é fornecido.
     */
    public static String porExtenso(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("valor deve ser positivo");
        }

        if (valor == 0) {
            return "zero";
        }

        return concatenaTrechos(grupos(valor), ", ").trim();
    }

    /**
     * Concatena os trechos fornecidos usando o separador fornecido. Exceto
     * para a última concatenação o separador usado é " e ".
     *
     * @param trechos   Os trechos a serem concatenados.
     * @param separador O separador para unir os trechos, exceto o último,
     *                  que é concatenado aos demais por " e ".
     * @return A concatenação dos trechos fornecidos usando o separador entre
     * eles, exceto o último (que faz uso de " e ").
     */
    static String concatenaTrechos(List<String> trechos, String separador) {
        final String ultimo = trechos.remove(trechos.size() - 1);
        final String prefixo = trechos.stream()
                .collect(Collectors.joining(separador));
        return prefixo.isEmpty() ? ultimo : prefixo + " e " + ultimo;
    }

    /**
     * Retorna a a própria sequência fornecida ou a sequência "mil", caso
     * aquela fornecida seja "um mil".
     *
     * @param trecho Sequência a ser avaliada.
     * @return A própria sequência fornecida se for diferente de "um mil" ou,
     * caso contrário, a sequência "mil".
     */
    static String seUmMilTroquePorMil(final String trecho) {
        return "um mil".equals(trecho) ? "mil" : trecho;
    }

    /**
     * Produz sequências de texto correspondentes ao valor fornecido.
     * Por exemplo, para o valor 34 há uma única sequência, "trinta e quatro".
     * Por outro lado, para o valor 1001 tem-se duas sequências, "mil" e a
     * sequência "um".
     *
     * @param valor O valor.
     *
     * @return As sequências correspondentes ao valor fornecido.
     */
    private static List<String> grupos(final int valor) {
        List<String> strs = new ArrayList<>();

        for (int posicao = totalDeGrupos(valor) - 1; posicao >= 0; posicao--) {
            int grupo = extraiGrupo(valor, posicao);
            if (grupo != 0) {
                strs.add(seUmMilTroquePorMil(grupoToString(grupo, posicao)));
            }
        }

        return strs;
    }

    /**
     * Produz a sequência correspondente a um trecho de três dígitos em uma
     * determinada posição do valor fornecido.
     *
     * @param valor O valor.
     *
     * @param posicao A posição para a qual a sequência será produzida. As
     *                posições são numeradas a partir de zero, do grupo de
     *                três dígitos menos significativos para aqueles mais
     *                significativos. Por exemplo, para um número menor que
     *                mil, a única posição disponível é a zero. Para o número
     *                8.000, por exemplo, temos duas posições, 0
     *                correspondente ao trecho de três dígitos que é zero, e
     *                a posição 1 cuja sequência de três dígitos é o valor 8.
     *
     * @return Sequência textual correspondente ao trecho de três dígitos do
     * valor fornecido na posição indicada.
     */
    static String grupoToString(final int valor, final int posicao) {
        return tresDigitos(valor) + " " + unidade(valor, posicao);
    }

    /**
     * Produz texto correspondente à potência de 1000 para o valor e a
     * posição fornecidos. Observe que se a potência é 2 o retorno é "milhão"
     * ou "milhões", dependendo do valor fornecido, ou seja, o texto é
     * compatível em número com o valor fornecido.
     *
     * @param valor O valor.
     *
     * @param posicao A posição do grupo de interesse no valor cuja potência,
     *               unidade, é desejada.
     *
     * @return A sequência "mil" se a posição é 1, "milhão" ou "milhões" se a
     * posição é 2, "bilhão" ou "bilhões" se a posição é 3 e assim por diante.
     * Observe que a versão no singular ou plural depende do valor fornecido.
     * Ou seja, se o valor é 9, então a unidade será "milhões", "bilhões" e
     * assim por diante, conforme a posição fornecida.
     */
    static String unidade(final int valor, final int posicao) {
        final String[] numero = valor == 1 ? SINGULAR : PLURAL;
        return posicao == 0 ? "" : numero[posicao];
    }

    /**
     * Produz sequência textual correspondente ao grupo de três dígitos
     * fornecido.
     *
     * @param cdu Valor de três dígitos (centena, dezena e unidade) cuja
     *            representação textual deve ser produzida.
     *
     * @return Sequência textual correspondente ao valor de três dígitos
     * fornecido. Por exemplo, para o valor 234 a sequência produzida é
     * "duzentos e trinta e quatro".
     *
     * @see #doisDigitos(int)
     * @see #umDigito(int)
     */
    private static String tresDigitos(final int cdu) {
        if (cdu > CEM) {
            final int du = cdu % CEM;
            final String fmt = du == 0 ? "%s" : "%s e %s";
            return String.format(fmt, CENTENAS[cdu / CEM], doisDigitos(du));
        }

        if (cdu < CEM) {
            return doisDigitos(cdu);
        }

        return "cem";
    }

    /**
     * Produz sequência textual correspondente ao valor inteiro de dois
     * dígitos (dezena e unidade) fornecido.
     *
     * @param du O valor de dois dígitos.
     *
     * @return A representação textual do valor inteiro de dois dígitos
     * fornecido.
     *
     * @see #tresDigitos(int)
     * @see #umDigito(int)
     */
    private static String doisDigitos(final int du) {
        if (du > LIMITE_DEZENAS) {
            return DEZENAS[du / 10] + umDigito(du % 10);
        }

        return MENOR_QUE_VINTE[du];
    }

    /**
     * Representação textual da parte da unidade fornecida de um valor.
     *
     * @param unidade A unidade (parte de uma valor).
     *
     * @return A representação textual da unidade de um dado valor. Por
     * exemplo, se a unidade é zero, a sequência vazia é fornecida. Se for 1,
     * então a sequência é " e um". Se 8 a sequência retornada é
     * " e oito".
     *
     * @see #tresDigitos(int)
     * @see #doisDigitos(int)
     */
    private static String umDigito(final int unidade) {
        return unidade == 0 ? "" : " e " + MENOR_QUE_VINTE[unidade];
    }

    /**
     * Obtém o número correspondente aos três dígitos na posição indicada no
     * valor fornecido. Por exemplo, para o valor 2345 tem-se dois grupos,
     * nas posições 0 e 1, respectivamente os números 345 e 2.
     *
     * @param valor O valor.
     * @param posicao A posição do grupo de três dígitos cujo número
     *                correspondente deve ser retornado.
     *
     * @return O número de três dígitos na posição indicada no valor
     * fornecido. Uma posição inexistente no valor produz como resultado o
     * valor zero.
     *
     * @see #totalDeGrupos(int)
     * @see #totalDeDigitos(int)
     */
    static int extraiGrupo(int valor, int posicao) {
        return (valor / (int) Math.pow(1000, posicao)) % 1000;
    }

    /**
     * Total de dígitos do valor fornecido. Por exemplo, o valor 1 possui um
     * único dígito, enquanto 234 possui 3 dígitos.
     *
     * @param valor O valor.
     *
     * @return O total de dígitos do valor.
     *
     * @see #totalDeGrupos(int)
     * @see #extraiGrupo(int, int)
     */
    static int totalDeDigitos(final int valor) {
        return (int) (Math.log10(valor) + 1);
    }

    /**
     * Total de grupos do valor fornecido. Um grupo é o nome dado ao
     * agrupamento de três dígitos em que o valor é dividido. Em geral estes
     * grupos são separados entre eles por um ".". Por exemplo, 1.000 tem 2
     * grupos, enquanto 1000345 possui 3 grupos.
     *
     * @param valor O valor.
     *
     * @return Total de grupos de três dígitos do valor fornecido.
     *
     * @see #totalDeDigitos(int)
     * @see #extraiGrupo(int, int)
     */
    static int totalDeGrupos(final int valor) {
        int totalDigitos = totalDeDigitos(valor);
        return (int) (Math.ceil(totalDigitos / 3.0));
    }
}
