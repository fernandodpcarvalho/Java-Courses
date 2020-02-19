package fernando.estudos.alura.sax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeitorXmlSax {
	
	public static void main(String[] args) throws SAXException, IOException {
		
		XMLReader reader = XMLReaderFactory.createXMLReader();
		
		ProdutosHandler handler = new ProdutosHandler();
		reader.setContentHandler(handler);
		
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		reader.parse(is);
		
		System.out.println(handler.getProdutos());
		
	}
}
