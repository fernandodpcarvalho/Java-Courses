package br.com.caelum.estoque.ws;

import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoque{

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/estoquews?wsdl");
        QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWSService");

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR);;

        ListaItens lista = cliente.todosOsItens((Filtros) Arrays.<Filtro>asList(filtro));

        for (Item item : lista.item) {
            System.out.println(item.getNome());
        }
    }
}
