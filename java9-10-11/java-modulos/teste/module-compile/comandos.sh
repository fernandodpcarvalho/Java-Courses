#!/usr/bin/env bash

javac -d mods --module-source-path src/ src/br.com.teste/br/com/teste/Teste.java

java --module-path mods -m br.com.teste/br.com.teste.Teste
