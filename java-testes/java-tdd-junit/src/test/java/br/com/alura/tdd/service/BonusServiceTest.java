package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusNaoPermitidoParaSalarioMaiorQueDezMil() {
//        BigDecimal bonus = service.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal("25000")));
//        assertEquals(BigDecimal.ZERO, bonus);

        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal("25000"))));

        try {
            service.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal("25000")));
            fail("Não lançou a exception esperada!");
        } catch (Exception e) {
            assertEquals("Funcionario com salário maior que R$10.000 não pode receber bonus.", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Fernando", LocalDate.now(), new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.0"), bonus);
    }

}