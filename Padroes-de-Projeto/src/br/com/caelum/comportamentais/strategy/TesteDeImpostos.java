package br.com.caelum.comportamentais.strategy;

public class TesteDeImpostos {

    public static void main(String[] args) {
        Imposto iss = new ISS();
        Imposto icms = new ICMS();

        Orcamento orcamento1 = new Orcamento(500.0);
        Orcamento orcamento2 = new Orcamento(700.0);

    CalculadorDeImpostos calculador = new CalculadorDeImpostos();

    // Calculando o ISS
    calculador.realizaCalculo(orcamento1, iss);
    calculador.realizaCalculo(orcamento2, iss);

    // Calculando o ICMS        
    calculador.realizaCalculo(orcamento1, icms);
    calculador.realizaCalculo(orcamento2, icms);
    }
}
