package fernando.estudos.alura.stax;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import fernando.estudos.alura.model.Produto;

public class LeitorXmlStax {
	public static void main(String[] args) throws FactoryConfigurationError, Exception {

        InputStream arquivo = new FileInputStream("src/vendas.xml");

        XMLEventReader eventos = XMLInputFactory.newInstance().createXMLEventReader(arquivo);

        List<Produto> produtos = new ArrayList<>();

        while(eventos.hasNext()){
            XMLEvent event = eventos.nextEvent();

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
                Produto produto = ProcessaProduto(eventos);
                produtos.add(produto);
            }
        }

        System.out.println(produtos);

}

private static Produto ProcessaProduto(XMLEventReader eventos) throws Exception {

    Produto produto = new Produto();

        while(eventos.hasNext()) {
            XMLEvent event = eventos.nextEvent();
            if(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
                break;
            }

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
                event = eventos.nextEvent();
                String nome = event.asCharacters().getData();
                produto.setNome(nome);
            }

            if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
                event = eventos.nextEvent();
                Double preco = Double.parseDouble(event.asCharacters().getData());
                produto.setPreco(preco);
            }

        }

        return produto;
}

}
