[![Build Status](https://travis-ci.com/kyriosdata/exemplo.svg?branch=develop)](https://travis-ci.com/kyriosdata/exemplo)
[![SonarCloud Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.kyriosdata%3Aexemplo%3Adevelop&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.kyriosdata%3Aexemplo%3Adevelop)

# Escopo e objetivo
Projeto de referência básico em Java contendo uma biblioteca e uma aplicação. 
A biblioteca contém um único método que determina o dia da semana de uma 
dada data, e pode ser publicada no repositório Maven Central, do qual pode
ser reutilizada por outros projetos. A aplicação exibe o dia da semana da 
data em que é executado.

> _O objetivo é ilustrar uma possível organização de código em Java usando
Maven e "boas práticas" para inspirar projetos "reais"_.

## Requisitos são atendidos?
- `mvn --version`<br>
você deverá ver a indicação da versão do Maven instalada e
a versão do JDK, dentre outras. Observe que o JDK é obrigatório, assim como
a definição da variável **JAVA_HOME**)


## Limpar, compilar, executar testes de unidade e cobertura
- `mvn clean`<br>
remove diretório _target_

- `mvn compile`<br>
compila o projeto, deposita resultados no diretório _target_

- `mvn test`<br>
executa testes de unidade

- `mvn package -P cobertura`<br>
executa testes de unidade e produz relatório de 
cobertura em _target/site/jacoco/index.html_

## Empacotando o projeto
- `mvn package` (gera jar file com código compilado e recursos do projeto)
- `mvn package -P executavel-dir` (gera jar executável, mas que depende do 
diretório 'jars', ambos disponíveis em 'target')
- `mvn package -P executavel-unico` (gera jar executável em um único arquivo, 
disponível em _target_)

## Executando a aplicação
- `mvn exec:java -Dexec.mainClass="com.github.kyriosdata.exemplo.ProgramaCalendario"` 
(executa a classe indicada, primeiro execute `mvn compile`)

Observe que a execução dos dois últimos comandos _mvn_ acima resulta em um 
arquivo Jar
que pode ser executado pelo comando `java -jar target/Exemplo.jar` ou
`java -jar target/Exemplo-unico.jar`. Neste último caso, você precisa apenas 
do arquivo `Exemplo-unico.jar` e, no caso anterior, além do 
arquivo `Exemplo.jar` também é preciso o diretório `jars`. Em tempo, tanto 
o arquivo Jar quanto o diretório 'jars' são gerados
no diretório **target**.

## Documentação
- `mvn javadoc:javadoc` (produz páginas HTML correspondentes à documentação 
do projeto, o arquivo de entrada é depositado em 
`target/site/apidocs/index.html`)

## Análise estática
- **Dependency Check**
  - `mvn verify` (análise de vulnerabilidades em 
  'target/dependency-check-report.html')
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

## TODO
- Acrescentar outros tipos de testes (e não apenas os testes de unidade)
- Disponibilizar biblioteca (jar) em Maven Central.
- Aplicação e biblioteca deveriam ser módulos?
- Acrescentar API para acesso à função via HTTP?

[![](https://codescene.io/projects/1157/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1157/jobs/latest-successful/results)
