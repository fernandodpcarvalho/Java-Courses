package fernando.estudos.alura.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fernando.estudos.alura.model.Produto;

public class Sistema {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		
		fabrica.setValidating(true);
		fabrica.setNamespaceAware(true);
		fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		Document doc = builder.parse("src/vendas.xml");
		
		//Para pegar um atributo
		Element venda = doc.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		// **//
		NodeList formasDePagamento = doc.getElementsByTagName("xsd:formaDePagamento");
		Element fdp = (Element) formasDePagamento.item(0);
		String formaDePagamento = fdp.getTextContent();
		System.out.println(formaDePagamento);
		// ***//
		NodeList nprodutos = doc.getElementsByTagName("xsd:nome");
		for (int i = 0; i < nprodutos.getLength(); i++) {
			Element np = (Element) nprodutos.item(i);
			System.out.println(np.getTextContent());
		}
		// **//
		NodeList produtos = doc.getElementsByTagName("xsd:produto");
		for (int i = 0; i < produtos.getLength(); i++) {
			Element produto = (Element) produtos.item(i);
			String np = produto.getElementsByTagName("xsd:nome").item(0).getTextContent();
			Double preco = Double.parseDouble(produto.getElementsByTagName("xsd:preco").item(0).getTextContent());
			Produto prod = new Produto(np, preco);
			System.out.println(prod+"\nmoeda: "+moeda+"\n");
		}

	}
}
