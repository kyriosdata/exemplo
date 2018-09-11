[![Build Status](https://travis-ci.com/kyriosdata/exemplo.svg?branch=develop)](https://travis-ci.com/kyriosdata/exemplo)
[![SonarCloud Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.kyriosdata%3Aexemplo%3Adevelop&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.kyriosdata%3Aexemplo%3Adevelop)
[![Known Vulnerabilities](https://snyk.io/test/github/kyriosdata/exemplo/develop/badge.svg)](https://snyk.io/org/kyriosdata/project/8f1cd845-b6ed-4559-95a4-1375feb3c548)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.kyriosdata/exemplo/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.kyriosdata/exemplo)

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
a definição das variáveis de ambiente **JAVA_HOME** e **M2_HOME**. No Windows certifique-se de que as variáveis não foram definidas com o valor correspondente entre aspas.


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
- `mvn package`<br>
gera arquivo _Exemplo.jar_ no diretório _target_. Observe que
o arquivo gerado não é executável.

- `mvn package -P executavel-dir`<br>
gera _Exemplo.jar_, executável, mas dependente do diretório _jars_,
 também criado no diretório _target_. Para executar basta o comando
 `java -jar target/Exemplo.jar`. Observe que se o diretório _jars_ for
 removido, então este comando falha. Por último, o diretório _jars_ deve
 ser depositado no mesmo diretório do arquivo _Exemplo.jar_. 

- `mvn package -P executavel-unico`<br>
 gera jar executável em um único arquivo, _target/Exemplo-unico.jar_, 
 suficiente para ser transferido e executado. Para executá-lo basta o
 comando `java -jar Exemplo-unico.jar`.  
 

## Executando a aplicação
- `mvn exec:java -Dexec.mainClass="com.github.kyriosdata.exemplo.ProgramaCalendario"`<br>
executa a classe indicada (método _main_). Depende de `mvn compile`


## Documentação

- `mvn javadoc:javadoc`<br>
produz documentação do projeto depositada em 
_target/site/apidocs/index.html_. Este comando está configurado para 
o JDK 9.

## Análise estática
Trata-se da análise do código sem que seja executado. Esta análise produz 
uma "noção de quão bom" está o código e, em consequência, permite orientar
eventuais ações de melhoria do código. Fique atento, "sair bem" na análise
estática não significa que "agrada usuários". 

Todas estas análises devem ser realizadas em todos os projetos? Não! 
Aquelas relevantes para um dado projeto deverão ser
configuradas em conformidade com o contexto em questão. 
  
- **Checkstyle**
  - `mvn checkstyle:checkstyle`<br>
  gera análise de estilo em _target/site/checkstyle.html_
  
  - `mvn checkstyle:check`<br>
  faz com que o _build_ falhe se pelo menos
um estilo é violado

- **Dependency Check**
  - `mvn verify`<br>
  análise de vulnerabilidades depositadas em 
  _target/dependency-check-report.html_. A primeira execução é relativamente
  "longa", esteja preparado para esperar...
  
- **JavaNCSS**
  - `mvn javancss:check`<br>
  verifica limites de complexidade ciclomática (CC) e de linhas
  de código sem comentário (NCSS). Este comando depende da compilação
prévia, ou seja _mvn compile_

  - `mvn javancss:report`<br>
  gera relatório em _target/site/javancss.html_ e 
também depende de compilação prévia, ou seja, _mvn compile_

- **JDepend**
  - `mvn jdepend:generate`<br>
  gera relatório em _target/site/jdepend-report.html_
  
- **PMD**
  - `mvn pmd:pmd`<br>
  gera relatório em _target/site/pmd.html_
  
  - `mvn pmd:check`<br>
  falha se pelo menos uma regra é violada

- **Spotbugs**
  - `mvn spotbugs:spotbugs`<br>
  detecção de bugs
   - `mvn spotbugs:check`<br>
   apenas verifica se há erros
  - `mvn spotbugs:gui`<br>
  abre GUI para exibir bugs após _mvn spotbugs:spotbugs_
  
- **Spotbugs** (security)
  - `mvn spotbugs:spotbugs -P security`<br>
  detecção de bugs
   - `mvn spotbugs:check -P security`<br>
   apenas verifica se há erros
  - `mvn spotbugs:gui -P security`<br>
  abre GUI para exibir bugs após _mvn spotbugs:spotbugs_

- **Snyk**

  - `mvn snyk:test -P security`<br>
  análise de vulnerabilidade. Depende do valor da propriedade _snyk.token_. 
  Por conveniência, pode ser fornecido via linha de comandos, 
  **-Dsnyk.token=API-TOKEN**, ou definido no arquivo 
  _HOME/.m2/settings.xml_. Neste último caso, tal arquivo deve conter 
  algo similar ao conteúdo abaixo:
  ```xml
  <settings>
  <profiles>
    <profile>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
            <snyk.token>API-TOKEN AQUI</snyk.token>
        </properties>
    </profile>
  </profiles>
  </settings>
  ```

  
  - `mvn snyk:monitor -P security`<br>
  Disponibiliza relatório em snyk.io (atualiza _badge_)

## Relatório do projeto
- `mvn site` (gera documentação do projeto, além de análises estáticas em
_target/site/index.html_

## Disponibilizando biblioteca no repositório Maven Central
A boa notícia é que este _pom.xml_ está devidamente configurado para
publicação no Maven Central, contudo, depende de outras ações e da 
configuração do arquivo _HOMEDIR/.m2/settings.xml_.

- **Nexus Staging Maven Plugin**
  - `mvn deploy -P deploy`<br>

## Outros recursos
- `mvn help:effective-pom`<br>
exibe POM de fato empregado

- `mvn help:describe -Dcmd=clean`<br>
exibe detalhes da fase _clean_

## Integração contínua
Notou os emblemas (_badges_) no início da página? Todo _commit_ na presente 
página automaticamente irá realizar uma série de operações, como compilação,
execução dos testes de unidade e várias análises estáticas. O resultado 
geral é imediatamente acessível por meio dos emblemas (clique neles), 
onde detalhes são disponibilizados nas páginas correspondentes. 
Observe que isso se transforma em um significativo **instrumento
de visibilidade do projeto**.

Para projetos _open source_ os serviços oferecidos são gratuitos. Seguem aqui os
merecidos agradecimentos a:
- https://travis-ci.com
- https://sonarcloud.io
- https://snyk.io

A lista acima não tem a pretensão de ser exclusiva. Abaixo seguem outros serviços:
- https://www.codacy.com/
- https://codescene.io/
- https://codecov.io/
- http://circleci.com/


## TODO
- (TBD) Acrescentar API para acesso à função via HTTP?

[![](https://codescene.io/projects/1157/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1157/jobs/latest-successful/results)
