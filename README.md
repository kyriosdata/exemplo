[![Build Status](https://travis-ci.com/kyriosdata/exemplo.svg?branch=develop)](https://travis-ci.com/kyriosdata/exemplo)
[![SonarCloud Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.kyriosdata%3Aexemplo%3Adevelop&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.kyriosdata%3Aexemplo%3Adevelop)

# exemplo
Projeto de referência básico em Java. Inicie por aqui.


## Compilação e execução
- `mvn clean` (remove código gerado, derivado dos fontes)
- `mvn compile` (compila o projeto com código gerado no diretório 'target')
- `mvn exec:java -Dexec.mainClass="com.github.kyriosdata.exemplo.ProgramaCalendario"` (executa a classe indicada, primeiro execute `mvn compile`)

## Empacotando o projeto
- `mvn package` (gera jar file com código compilado e recursos do projeto)
- `mvn package -P executavel-dir` (gera jar executável, mas que depende do diretório 'jars', ambos disponíveis em 'target')
- `mvn package -P executavel-unico` (gera jar executável em um único arquivo, disonível em _target_)

## Execução
Observe que a execução dos dois últimos comandos _mvn_ acima resulta em um arquivo Jar
que pode ser executado pelo comando `java -jar target/Exemplo.jar` ou
`java -jar target/Exemplo-unico.jar`. Neste último caso, você precisa apenas do arquivo `Exemplo-unico.jar` e, no caso anterior, além do arquivo `Exemplo.jar` também é preciso o diretório `jars`. Em tempo, tanto o arquivo Jar quanto o diretório 'jars' são gerados
no diretório **target**.

## Documentação
- `mvn javadoc:javadoc` (produz páginas HTML correspondentes à documentação do projeto, o arquivo de entrada é depositado em `target/site/apidocs/index.html`)

## Testes (e cobertura)
- `mvn test` (executa testes)
- `mvn package -P cobertura` (executação de testes e relatório de cobertura, `target/site/jacoco/index.html`)

## Análise estática
- `mvn javancss:check` (verifica limites CC e NCSS)
- `mvn javancss:report` (gera relatório)
- `mvn spotbugs:spotbugs` (detecção de bugs)
- `mvn spotbugs:check` (apenas verifica se há erros)
- `mvn spotbugs:gui` (abre GUI para exibir bugs após spotbugs:spotbugs)
- `mvn findbugs:findbugs` (detecção de bugs)
- `mvn findbugs:gui` (exibir resultado de detecção de bugs)
- `mvn site` (gera documentação do projeto, além de análises estáticas)

## Outros recursos
- `mvn help:effective-pom` (exibe POM de fato empregado)

[![](https://codescene.io/projects/1157/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1157/jobs/latest-successful/results)
