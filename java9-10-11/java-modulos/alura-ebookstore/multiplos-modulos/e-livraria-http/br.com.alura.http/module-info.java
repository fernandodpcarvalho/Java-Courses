module br.com.alura.http {
	exports br.com.alura.http.dao;
	requires transitive br.com.alura.modelo;
	requires java.net.http;
}