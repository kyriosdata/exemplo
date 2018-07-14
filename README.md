[![Build Status](https://travis-ci.com/kyriosdata/exemplo.svg?branch=develop)](https://travis-ci.com/kyriosdata/exemplo)
[![SonarCloud Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.kyriosdata%3Aexemplo%3Adevelop&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.kyriosdata%3Aexemplo%3Adevelop)

# exemplo
Projeto de referência básico em Java. Inicie por aqui.

## Vamos verificar se está instalado?
- `mvn --version` (você deverá ver a indicação da versão do Maven instalada e
a versão do JDK, dentre outras)


## Compilação e execução
- `mvn clean` (remove diretório 'target')
- `mvn compile` (compila o projeto, deposita resultados no diretório 'target')
- `mvn exec:java -Dexec.mainClass="com.github.kyriosdata.exemplo.ProgramaCalendario"` 
(executa a classe indicada, primeiro execute `mvn compile`)

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
- `mvn javadoc:javadoc` (produz páginas HTML correspondentes à documentação 
do projeto, o arquivo de entrada é depositado em 
`target/site/apidocs/index.html`)

## Testes (e cobertura)
- `mvn test` (executa testes)
- `mvn package -P cobertura` (executação de testes e gera relatório de 
cobertura em `target/site/jacoco/index.html`)

## Análise estática
- **JavaNCSS**
  - `mvn javancss:check` (verifica limites CC e NCSS, depende da compilação
prévia, ou seja _mvn compile_)
  - `mvn javancss:report` (gera relatório em 'target/site/javancss.html' e 
também depende de compilação prévia, ou seja, _mvn compile_)
- **JDepend**
  - `mvn jdepend:generate` (gera relatório em 'target/site/jdepend-report.html')
- **Spotbugs**
  - `mvn spotbugs:spotbugs` (detecção de bugs)
   - `mvn spotbugs:check` (apenas verifica se há erros)
  - `mvn spotbugs:gui` (abre GUI para exibir bugs após spotbugs:spotbugs)
- **Checkstyle**
  - `mvn checkstyle:checkstyle` (gera análise de estilo em 
 'target/site/checkstyle.html')
  - `mvn checkstyle:check` (faz com que o _build_ falhe se pelo menos
um estilo é violado)
- **PMD**
  - `mvn pmd:pmd` (gera relatório em 'target/site/pmd.html')
  - `mvn pmd:check` (falha se pelo menos uma regra é violada)

## Relatório do projeto
- `mvn site` (gera documentação do projeto, além de análises estáticas em
'target/site/index.html')

## Outros recursos
- `mvn help:effective-pom` (exibe POM de fato empregado)
- `mvn help:describe -Dcmd=clean` (exibe detalhes da fase 'clean')

[![](https://codescene.io/projects/1157/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1157/jobs/latest-successful/results)
