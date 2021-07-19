#!/usr/bin/env bash

##Compilar com classpath
javac -d bin/ -cp bin \
src/br/com/alura/modelo/dominio/Categoria.java \
src/br/com/alura/modelo/dominio/Livro.java \
src/br/com/alura/modelo/dominio/NotaFiscal.java \
src/br/com/alura/http/dao/LivroDAO.java \
src/br/com/alura/nf/servico/NotaFiscalServico.java \
src/br/com/alura/nf/subscriber/NotaFiscalSubscriber.java \
src/br/com/alura/nf/util/NotaFiscalUtil.java \
src/br/com/alura/Principal.java

