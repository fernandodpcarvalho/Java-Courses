package br.com.caelum.comportamentais.strategy.java8;

import java.math.BigDecimal;
import java.util.function.UnaryOperator;

public interface Discounter2 extends UnaryOperator<BigDecimal> {
    default Discounter2 combine(Discounter2 after) {
        return value -> after.apply(this.apply(value));
    }
}