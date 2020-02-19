package fernando.estudos.alura.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fernando.estudos.alura.model.Produto;

public class LeitorXmlDom {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//Método DOM para leitura de XML. Rápido, mas coloca todo o arquivo na memória.
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		
		NodeList produtos = document.getElementsByTagName("produto");
		
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			
			String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
			double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
			Produto prod = new Produto(nome,preco);
			System.out.println(prod);
		}		
		
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		}
}
