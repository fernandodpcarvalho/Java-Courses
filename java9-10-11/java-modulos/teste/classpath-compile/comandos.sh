#!/usr/bin/env bash

javac -d bin/ -cp bin src/br/com/teste/Teste.java

java -cp bin/ br.com.teste.Teste
