# exemplo
Projeto de referência básico em Java. Inicie por aqui.


## Compilação e execução
- `mvn clean` (remove código gerado, derivado dos fontes)
- `mvn compile` (compila o projeto)
- `mvn exec:java -Dexec.mainClass="com.github.kyriosdata.exemplo.ProgramaCalendario` (executa a classe indicada)

## Empacotando o projeto
- `mvn package` (gera jar file com código compilado e recursos do projeto)
- `mvn package -P executavel-dir` (gera jar executável, mas que depende do diretório 'jars', ambos disponíveis em 'target')
- `mvn package -P executavel-unico` (gera jar executávem em um único arquivo, disonível em 'target')

Observe que ao executar uma das duas últimas opções acima, pode-se executar o programa gerado por meio do comando `java -jar target/Exemplo.jar` ou
`java -jar target/Exemplo-unico.jar`. Neste último caso, você precisa apenas do arquivo `Exemplo-unico.jar` e, no caso anterior, além do arquivo `Exemplo.jar` também é preciso o diretório `jars`.

## Documentação
- `mvn javadoc:javadoc` (geração de documentação)
- `mvn test` (executa testes)
- `mvn package -P cobertura` (executação de testes e relatório de cobertura)
do programa)
- `java -jar exemplo-1.0.0.jar` (executa o programa, alternativa para o comando acima. O diretório "jar", conforme configurado no pom.xml deve acompanhar exemplo-1.0.0.jar).
- `mvn javancss:check` (verifica se limites são observados e gera erro se não são)
- `mvn javancss:report` (gera relatório)
- `mvn site` (gera documentação do projeto, além de análises estáticas)

## Outros recursos
- `mvn help:effective-pom` (exibe POM de fato empregado)

[![](https://codescene.io/projects/1157/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1157/jobs/latest-successful/results)
