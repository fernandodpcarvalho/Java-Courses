# Java IO

https://medium.com/@antonio.gabriel/java-io-java-nio-e-nio-2-quando-utilizar-8c900b1c57a1
https://www.baeldung.com/java-io
https://www.baeldung.com/java-io-vs-nio
https://www.baeldung.com/java-nio-2-path
https://gist.github.com/cesarvasconcelos/e18b378bcb6a881635c6ac4ac3b3168a

java.io
Primeira, mais simples.
Bloqueante. Ao realizar um i/o, a thread atual precisa esperar a operação concluir para continuar sua execução. 
Usa fluxos(streams). 
Recomendada para apps simples com pouco I/O. 

java.nio, java.nio.channels e java.nio.charset
JDK 1.4. 
Complementa a .io
Mais complexa.
Melhor desempenho.
Não bloqueante. Pode gerenciar várias operações de I/O em uma única thread.
Não trabalha com fluxos, e sim Buffers e Channels.
Recomendada para aplicações com requisitos de desempenho e escalabilidade e muitas operações de IO e multithreading. 

java.nio.file e java.nio.file.attribute
JDK 1.7
Extensão da java.nio.
Simplificou o uso. 
Suporte completo à manipulação de arquivos e diretórios, centralizados na classe Files e na interface Path.
Lib mais indicada atualmente.
