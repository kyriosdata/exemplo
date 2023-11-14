/*
 * Copyright (c) 2022.
 * Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.kyriosdata.exemplo.application.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicação que expõe serviços REST.
 *
 */
@SpringBootApplication
public class Application {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args Ignorados. Não são usados.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
