#!/usr/bin/env bash

##Compilar com module path
##javac -d mods/br.com.alura --module-path mods \
javac -d mods --module-source-path src/ \
src/br.com.alura/br/com/alura/modelo/dominio/Categoria.java \
src/br.com.alura/br/com/alura/modelo/dominio/Livro.java \
src/br.com.alura/br/com/alura/modelo/dominio/NotaFiscal.java \
src/br.com.alura/br/com/alura/http/dao/LivroDAO.java \
src/br.com.alura/br/com/alura/nf/servico/NotaFiscalServico.java \
src/br.com.alura/br/com/alura/nf/subscriber/NotaFiscalSubscriber.java \
src/br.com.alura/br/com/alura/nf/util/NotaFiscalUtil.java \
src/br.com.alura/br/com/alura/Principal.java

