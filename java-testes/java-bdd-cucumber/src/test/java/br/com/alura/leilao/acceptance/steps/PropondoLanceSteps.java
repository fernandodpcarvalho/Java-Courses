package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLanceSteps {

    private Leilao leilao;
    private Lance lance;
    private List<Lance> lances;

    @Before
    public void setup() {
        this.lances = new ArrayList<>();
        this.leilao = new Leilao("Tablet XPTO");
    }

    @Dado("um lance valido")
    public void um_lance_valido() {
        lance = new Lance(
                new Usuario("fulano"),
                BigDecimal.TEN
        );
    }

    @Quando("propoe ao leilao")
    public void propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

    //    @Dado("^um lance de (\\d+[.]\\d\\d?) reais do usuario (\\w+)$")
    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
        lances.add(new Lance(
                new Usuario(nomeUsuario),
                new BigDecimal(valor)
        ));
    }

    @Quando("propoe os varios lances ao leilao")
    public void propoe_os_varios_lances_ao_leilao() {
        lances.forEach(lance -> leilao.propoe(lance));
    }

    @Entao("os lances são aceitos")
    public void os_lances_são_aceitos() {
        Assert.assertEquals(this.lances.size(), leilao.getLances().size());
        Assert.assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lances.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Dado("um lance invalido de {double} reais e do usuario {string}")
    public void um_lance_de_reais(Double valor, String nomeUsuario) {
        System.out.println(valor + " - " + nomeUsuario);
        lance = new Lance(
                new Usuario("fulano"),
                new BigDecimal(valor));
    }

    @Entao("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assert.assertEquals(0, leilao.getLances().size());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();
        valores.forEach(mapa -> {
            String valor = mapa.get("valor");
            String nome = mapa.get("nomeusuario");
            lances.add(new Lance(new Usuario(nome), new BigDecimal(valor)));
        });
    }

    @Entao("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(this.lances.get(0).getValor(), leilao.getLances().get(0).getValor());
    }
}
